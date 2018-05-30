package orderwindow;

import helpers.AddProductsHelper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Ola Dahl
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("order_gui.fxml"));
        primaryStage.setTitle("Beaver Coffee");
        primaryStage.setScene(new Scene(root, 500, 575));
        primaryStage.show();
    }


    public static void main(String[] args) {
//        AddProductsHelper.addProducts();
        launch(args);
    }
}
