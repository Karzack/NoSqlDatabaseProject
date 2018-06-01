package orderwindow;

import database.dao.ClubMemberDAO;
import database.dao.OrderDAO;
import database.dao.ProductDAO;
import database.dao.StockDAO;
import database.model.*;
import database.model.product.Ingredient;
import database.model.product.IngredientItem;
import database.model.product.Product;
import database.model.product.ProductPrice;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Callback;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Ola Dahl
 */
public class OrderController {


    @FXML
    private ComboBox<Product> productCombo;

    @FXML
    private ComboBox<IngredientItem> alternativesCombo;

    @FXML
    private ListView<String> orderListView;

    @FXML
    private CheckBox vanillaAddonCheckbox;

    @FXML
    private CheckBox caramelAddonCheckbox;

    @FXML
    private CheckBox creamAddonCheckbox;

    @FXML
    private Label totalPriceLabel;

    private JFrame frame;


    private final int LOCATION_SWEDEN = 1;
    private final int LOCATION_USA = 2;
    private final int CURRENT_LOCATION;

    public enum PriceOperation {
        ADD,
        SUBTRACT
    }

    private List<Product> orderItems = new ArrayList<>();
    private List<List<Stock>> stockItems = new ArrayList<>();

    private ObservableList<String> listViewItems;
    private ObservableList<IngredientItem> alternativeItems;

    private Product selectedProduct;
    private ClubMember clubMember;
    private IngredientItem selectedAlternative;
    private IngredientItem vanillaAddon;
    private IngredientItem caramelAddon;
    private IngredientItem irishCreamAddon;

    private double totalPrice = 0;
    private int memberEligibleOrders;
    private final Employee employee;
    private final Location currentLocation;

    public OrderController(Employee employee, Location currentLocation) {
        this.employee = employee;
        this.currentLocation = currentLocation;
        CURRENT_LOCATION = currentLocation.getLanguage().equals("Swedish") ? LOCATION_SWEDEN : LOCATION_USA;
    }

    /**
     * Called when the window is showing
     */
    @FXML
    private void initialize() {
        initGUIData();
        initGUIPresentation();
        initListeners();
    }

    /**
     * Get products and sets the data to gui
     */
    private void initGUIData() {
        productCombo.setItems(FXCollections.observableArrayList(ProductDAO.getProducts()));

        alternativeItems = FXCollections.observableArrayList();
        alternativesCombo.setItems(alternativeItems);

        listViewItems = FXCollections.observableArrayList();
        orderListView.setItems(listViewItems);
    }

    /**
     * Sets interface to the correct language
     */
    private void initGUIPresentation() {
        this.productCombo.setCellFactory(
                new Callback<ListView<Product>, ListCell<Product>>() {
                    @Override
                    public ListCell<Product> call(ListView<Product> param) {
                        return new ListCell<Product>() {
                            @Override
                            protected void updateItem(Product item, boolean empty) {
                                super.updateItem(item, empty);
                                if (item != null) {
                                    switch (CURRENT_LOCATION) {
                                        case LOCATION_SWEDEN:
                                            setText(item.getName().getSwedish());
                                            break;
                                        case LOCATION_USA:
                                            setText(item.getName().getEnglish());
                                    }
                                }
                            }
                        };
                    }
                }
        );
    }

    /**
     * Inits listeners to select correct entries
     */
    private void initListeners() {
        this.productCombo.valueProperty().addListener((observable, oldValue, product) -> {
            if (product.getAlternatives().isEmpty()) {
                alternativesCombo.setDisable(true);
            } else {
                alternativesCombo.setDisable(false);
                alternativeItems.setAll(product.getAlternatives());
            }

            alternativesCombo.setValue(null);
            selectedAlternative = null;
            selectedProduct = product;
        });

        alternativesCombo.valueProperty().addListener((obs, old, selectedAlternative) ->
                this.selectedAlternative = selectedAlternative);

        vanillaAddonCheckbox.selectedProperty()
                .addListener((observable, oldValue, isChecked) ->
                        vanillaAddon = isChecked ? new IngredientItem(new Ingredient("Vanilla", Unit.LITRE), 0.1) : null);

        caramelAddonCheckbox.selectedProperty()
                .addListener(((observable, oldValue, isChecked) ->
                        caramelAddon = isChecked ? new IngredientItem(new Ingredient("Caramel", Unit.LITRE), 0.1) : null));

        creamAddonCheckbox.selectedProperty()
                .addListener(((observable, oldValue, isChecked) ->
                        irishCreamAddon = isChecked ? new IngredientItem(new Ingredient("Irish Cream", Unit.LITRE), 0.1) : null));

    }


    public void handleOnClickAdmin() {

    }

    public void handleOnClickLogout() {
        for (List<Stock> list : stockItems) {
            for (Stock stock : list) {
                System.out.println(stock);
            }
            System.out.println();
        }
    }

    /**
     * Fetches a clubMember with the supplied SSN
     */
    public void handleMemberTextField(ActionEvent actionEvent) {
        TextField membersField = (TextField) actionEvent.getSource();
        ClubMember member = ClubMemberDAO.getMember(membersField.getCharacters().toString());
        if (member != null) {
            this.clubMember = member;
            createAlertDialog("Success", "Found clubMember " + member.getName());
            memberEligibleOrders = ClubMemberDAO.getNumberOfEligibleOrders(member.getSSN());
        } else {
            this.clubMember = null;
            createAlertDialog("Error", "Member was not found");
        }
    }

    /**
     * Adds a product to orderItems and to stockItems.
     * Also updates the gui.
     */
    public void handleOnClickAdd() {
        if (selectedProduct != null) {

            listViewItems.add(
                    CURRENT_LOCATION == LOCATION_SWEDEN ?
                            selectedProduct.getName().getSwedish() :
                            selectedProduct.getName().getEnglish()
            );

            orderItems.add(selectedProduct);
            updateStockItems();
            updateMemberEligibleOrders(PriceOperation.ADD, selectedProduct);
            updatePrice(PriceOperation.ADD, selectedProduct.getPrice());
        }
    }

    /**
     * Removes an item from orderItems and stockItems.
     * Also updates the gui.
     */
    public void handleOnClickRemoveItem() {
        int selectedIndex = this.orderListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            updatePrice(PriceOperation.SUBTRACT, orderItems.get(selectedIndex).getPrice());

            updateMemberEligibleOrders(PriceOperation.SUBTRACT, orderItems.get(selectedIndex));
            listViewItems.remove(selectedIndex);
            orderItems.remove(selectedIndex);
            stockItems.remove(selectedIndex);
        }
    }

    public void handleOnClickCancel() {
        listViewItems.clear();
        orderItems.clear();
        stockItems.clear();
    }

    public void handleOnClickConfirm(ActionEvent actionEvent) {
        Order order = new Order(
                employee.getId(),
                clubMember != null ? clubMember.getId() : null,
                currentLocation.getId(),
                new Date(),
                totalPrice,
                orderItems
        );

        if (clubMember != null) {
            ClubMemberDAO.updateMemberOrders(clubMember.getSSN(), order);
        }

        OrderDAO.insertOrder(order);
        StockDAO.updateStockQuantity(stockItems);

        listViewItems.clear();
        orderItems.clear();
        stockItems.clear();
    }


    private void updateStockItems() {
        List<Stock> items = new ArrayList<>();
        selectedProduct.getMandatoryIngredients().forEach(item -> items.add(getStockFromIngredientItem(item)));
        if (selectedAlternative != null) items.add(getStockFromIngredientItem(selectedAlternative));
        if (vanillaAddon != null) items.add(getStockFromIngredientItem(vanillaAddon));
        if (caramelAddon != null) items.add(getStockFromIngredientItem(caramelAddon));
        if (irishCreamAddon != null) items.add(getStockFromIngredientItem(irishCreamAddon));

        stockItems.add(items);
    }

    private Stock getStockFromIngredientItem(IngredientItem item) {
        return new Stock(
                currentLocation.getId(),
                item.getIngredient(),
                item.getQuantity()
        );
    }

    /**
     * Updates the price depending on localization and clubMember benefits.
     *
     * @param operation Addition or subtraction.
     * @param price     The base price for the product.
     */
    private void updatePrice(PriceOperation operation, ProductPrice price) {
        switch (operation) {
            case ADD:
                switch (CURRENT_LOCATION) {
                    case LOCATION_SWEDEN:
                        totalPrice += calculatePrice(price.getSEK());
                        totalPriceLabel.setText("Total price: SEK " + totalPrice);
                        break;
                    case LOCATION_USA:
                        totalPrice += calculatePrice(price.getUSD());
                        totalPriceLabel.setText("Total price USD " + totalPrice);
                        break;
                }
                break;
            case SUBTRACT:
                switch (CURRENT_LOCATION) {
                    case LOCATION_SWEDEN:
                        totalPrice -= calculatePrice(price.getSEK());
                        totalPriceLabel.setText("Total price: SEK " + totalPrice);
                        break;
                    case LOCATION_USA:
                        totalPrice -= calculatePrice(price.getUSD());
                        totalPriceLabel.setText("Total price USD " + totalPrice);
                        break;
                }
                break;
        }
    }

    /**
     * Calculates the price based on clubMember benefits (and later order history).
     */
    private double calculatePrice(double price) {
        if (clubMember != null) {
            if (memberEligibleOrders % 10 == 0) {
                return 0;
            }
            if (clubMember.getHasBenefits())
                return price - 0.10 * price;
        }
        return price;
    }

    private void updateMemberEligibleOrders(PriceOperation operation, Product product) {
        if (clubMember != null) {
            if (!(product.getName().getEnglish().equals("Whole Bean Coffee"))) {
                switch (operation) {
                    case ADD:
                        memberEligibleOrders++;
                        break;
                    case SUBTRACT:
                        memberEligibleOrders--;
                        break;
                }
            }
        }
    }

    private void createAlertDialog(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);

        alert.showAndWait();
    }
}
