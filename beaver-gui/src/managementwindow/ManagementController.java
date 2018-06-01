package managementwindow;

import database.dao.*;
import database.model.*;
import database.model.product.Ingredient;
import database.model.product.IngredientItem;
import database.model.product.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManagementController {

    private Employee employee;
    private final Location currentLocation;
    @FXML
    private ComboBox<Employee> employeeCombo;

    @FXML
    private ComboBox<ClubMember> customerCombo;

    @FXML
    private ListView<Ingredient> productListView;

    @FXML
    private Button updateEmployeebtn;

    @FXML
    private Button updateCustomerbtn;

    @FXML
    private Button commentbtn;

    @FXML
    private Button getCommentbtn;
    @FXML
    private ComboBox<Product> productReportCombo;

    @FXML
    private ComboBox<Ingredient> ingredientCombo;

    @FXML
    private TextField txtAmount;

    @FXML
    private Button updateStockbtn;

    private JFrame frame;


    private final int LOCATION_SWEDEN = 1;
    private final int LOCATION_USA = 2;
    private final int CURRENT_LOCATION;

    public enum UpdateOperation {
        ADD,
        SUBTRACT
    }

    private List<List<IngredientItem>> stockItems = new ArrayList<>();
    //private ObservableList<IngredientItem> stockList = (ObservableList<IngredientItem>) new ArrayList<IngredientItem>();
    private List<Employee> employeesList = new ArrayList<>();
    private List<ClubMember> customersList = new ArrayList<>();
    private List<Product> productReportList = new ArrayList<>();

    private Product selectedProduct;
    private IngredientItem selectedIngredientItem;
    private ClubMember selectedClubMember;
    private Employee selectedEmployee;
    private int startDate;
    private int endDate;



    public ManagementController(Employee employee, Location currentLocation) {
        this.employee = employee;

        this.currentLocation = currentLocation;
        CURRENT_LOCATION = currentLocation.getLanguage().equals("Swedish") ? LOCATION_SWEDEN : LOCATION_USA;
    }

    @FXML
    private void initialize() {
        initGUIData();
        initGUIPresentation();
        initListeners();
    }

    private void initListeners() {
        this.productReportCombo.valueProperty().addListener((observable, oldValue,product)->{
            selectedProduct = product;
        });
        this.customerCombo.valueProperty().addListener(((observable, oldValue, customer) -> {
            selectedClubMember = customer;
        }));
        this.employeeCombo.valueProperty().addListener(((observable, oldValue, employee) -> {
            selectedEmployee = employee;
        }));
    }

    private void initGUIPresentation() {

    }

    private void initGUIData() {
        productReportCombo.setItems(FXCollections.observableArrayList(ProductDAO.getProducts()));
        employeeCombo.setItems(FXCollections.observableArrayList(EmployeeDAO.getEmployees()));
        customerCombo.setItems(FXCollections.observableArrayList(ClubMemberDAO.getAllMembers()));
        productListView.setItems(FXCollections.observableArrayList());
    }

    public void handleOnClickReport(){
        if (selectedProduct!=null){
            List<Order> report = ReportDAO.getReport(selectedProduct, currentLocation.getName());
            String reportString = "Report for "+ selectedProduct.getName() +": \n";
            if(report.size()>0) {
                for (Order order : report) {
                    reportString += "Order id: " + order.getId() + "\n" +
                            "Customer nr: " + order.getClubMemberId() + "\n" +
                            "Employee served: " + order.getEmployeeId() + "\n" +
                            "Items: \n";
                    for (Product product : order.getOrderItems()
                            ) {
                        reportString += product.getName().getSwedish() + "\n";

                    }
                    reportString += "Total cost: " + order.getTotalPrice() + " SEK \n \n";

                }
            }else{
                reportString += "No reports for this item!";
            }
            JOptionPane.showMessageDialog(null,reportString);
        }else{
            List<Order> report = ReportDAO.getReport();
            String reportString = "Report: \n";
            for (Order order: report){
                reportString += "Order id: " +order.getId() + "\n" +
                        "Customer nr: " + order.getClubMemberId() + "\n"+
                        "Employee served: " + order.getEmployeeId() + "\n" +
                        "Items: \n";
                for (Product product: order.getOrderItems()
                     ) {
                    reportString += product.getName().getSwedish() + "\n";

                }
                reportString += "Total cost: " + order.getTotalPrice() + " SEK \n \n";

            }
            JOptionPane.showMessageDialog(null,reportString);
        }
    }
    public void handleUpdateStock(){
    }

    public void handleOnClickComment(){
        if (selectedEmployee != null) {
            String commentText = JOptionPane.showInputDialog("Add Comment for this employee:");
            Comment comment = new Comment(employee, selectedEmployee,commentText,new Date());
            CommentDAO.addComment(comment);
        }
    }
    public void handleOnClickGetComment(){
        if(selectedEmployee!=null){
            String commentString = "Comments for: " + selectedEmployee.getName() + "\n";
            List<Comment> list = CommentDAO.getComment(selectedEmployee);
            for(Comment comment : list){

                commentString += "On date " + comment.getEntryDate() + " \n " + comment.getIssuer().getName() + " wrote: \n" +
                        comment.getComment() + "\n \n";
            }
            JOptionPane.showMessageDialog(null, commentString);
        }
    }
}
