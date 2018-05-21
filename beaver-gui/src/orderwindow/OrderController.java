package orderwindow;

import GUI.AddCustomer;
import database.dao.ClubMemberDAO;
import database.dao.OrderDAO;
import database.dao.ProductDAO;
import database.model.ClubMember;
import database.model.Order;
import database.model.Unit;
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
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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

    private int location = LOCATION_USA;

    public enum PriceOperation {
        ADD,
        SUBTRACT
    }

    private List<Product> orderItems = new ArrayList<>();
    private List<List<IngredientItem>> stockItems = new ArrayList<>();

    private ObservableList<String> listViewItems;
    private ObservableList<IngredientItem> alternativeItems;

    private Product selectedProduct;
    private ClubMember member;
    private IngredientItem selectedAlternative;
    private IngredientItem vanillaAddon;
    private IngredientItem caramelAddon;
    private IngredientItem irishCreamAddon;

    private double totalPrice = 0;
    private String test;
    /**
     * Called when the window is showing
     */
    @FXML
    private void initialize() {
        frame = new JFrame();
        System.out.println(test);
        initGUIData();
        initGUIPresentation();
        initListeners();
    }

    public void setEmployee(String test) {
        this.test = test;
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
                                    switch (location) {
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

    public void handleOnClickAddCustomer() {
        EventQueue.invokeLater(()->{
            frame.add(new AddCustomer(500,400));
            frame.pack();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        });
    }

    public void handleOnClickAdmin() {

    }

    public void handleOnClickLogout() {

    }

    /**
     * Fetches a member with the supplied SSN
     */
    public void handleMemberTextField(ActionEvent actionEvent) {
        TextField membersField = (TextField) actionEvent.getSource();
        ClubMember member = ClubMemberDAO.getMember(membersField.getCharacters().toString());
        if (member != null) {
            this.member = member;
            createAlertDialog("Success", "Found member " + member.getName());
        } else {
            this.member = null;
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
                    location == LOCATION_SWEDEN ?
                            selectedProduct.getName().getSwedish() :
                            selectedProduct.getName().getEnglish()
            );

            stockItems.add(getSelectedIngredients());
            orderItems.add(selectedProduct);

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

            listViewItems.remove(selectedIndex);
            orderItems.remove(selectedIndex);
            stockItems.remove(selectedIndex);
        }
    }

    public void handleOnClickCancel() {
        List<Order> orders = OrderDAO.getOrders();

        for (Order order : orders) System.out.println(order);
    }

    public void handleOnClickConfirm(ActionEvent actionEvent) {
        Order order = new Order(
                null,
                member != null ? member.getId() : null,
                null,
                new Date(),
                totalPrice,
                orderItems
        );

        OrderDAO.insertOrder(order);
    }

    /**
     * Returns the selected ingredients
     */
    private List<IngredientItem> getSelectedIngredients() {
        List<IngredientItem> items = new ArrayList<>(selectedProduct.getMandatoryIngredients());
        if (selectedAlternative != null) items.add(selectedAlternative);
        if (vanillaAddon != null) items.add(vanillaAddon);
        if (caramelAddon != null) items.add(caramelAddon);
        if (irishCreamAddon != null) items.add(irishCreamAddon);

        return items;
    }

    /**
     * Updates the price depending on localization and member benefits.
     *
     * @param operation Addition or subtraction.
     * @param price     The base price for the product.
     */
    private void updatePrice(PriceOperation operation, ProductPrice price) {
        switch (operation) {
            case ADD:
                switch (location) {
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
                switch (location) {
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
     * Calculates the price based on member benefits (and later order history).
     */
    private double calculatePrice(double price) {
        if (member != null)
            if (member.getHasBenefits())
                return price - 0.10 * price;
        return price;
    }

    private void createAlertDialog(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);

        alert.showAndWait();
    }
}
