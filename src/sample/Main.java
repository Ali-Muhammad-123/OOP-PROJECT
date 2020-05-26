package sample;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.*;
public class Main extends Application {

    String retrieved_password;
    String retrieved_username;
    String correct_username = "ali";
    String correct_password = "ali";
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Szabist Student Management ");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene LoginPage = new Scene(grid, 550, 600);
        LoginPage.setFill(Color.BLACK);
        primaryStage.setScene(LoginPage);
        Text scenetitle = new Text("Welcome to SZABIST Student Management Hub");
        scenetitle.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("Admin User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Admin Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);


        btn.setOnAction(e ->
        {
            if(grid.getChildren().size() == 7 ) {
                grid.getChildren().remove(6);
            }
            retrieved_username =  userTextField.getText();
            retrieved_password = pwBox.getText();
            System.out.println(retrieved_password + retrieved_username);

            if (retrieved_username.equals(correct_username) && retrieved_password.equals(correct_password)){
                Text displaymsg = new Text("The username and password are correct");
                Menu menu = new Menu();
                menu.start(primaryStage);
                grid.add(displaymsg, 0,5);

            }
            else {
                Text displaymsg = new Text("The username and password are not correct");
                grid.add(displaymsg, 0, 5);

            }  });

        primaryStage.show();



    }}




