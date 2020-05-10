package sample;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.*;
import javafx.*;

public class Main extends Application {
    String retrieved_password;
    String retrieved_username;

    String correct_password = "Ali";
    String correct_username = "Abdullah";
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Szabist Hospital Programme");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 550, 600);
        scene.setFill(Color.BLACK);
        primaryStage.setScene(scene);
        Text scenetitle = new Text("Welcome to SZABIST Hospital Management");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        Button btn1 = new Button("Change Page");
        HBox hBtn = new HBox(10);
        hBtn.setAlignment(Pos.BASELINE_CENTER);
        hBtn.getChildren().add(btn1);
        grid.add(hBtn, 0, 4);


        btn.setOnAction(e ->
                {

                    if(grid.getChildren().size() == 7 ){
                        grid.getChildren().remove(6);
                    }
                    else{}
                    retrieved_username =  userTextField.getText();
                    retrieved_password = pwBox.getText();
                    System.out.println(retrieved_password + retrieved_username);

                    if (retrieved_username.equals(correct_username) && retrieved_password.equals(correct_password)){
                        Text displaymsg = new Text("The username and password are correct");
                        grid.add(displaymsg, 0,5);
                    }
                    else {
                        Text displaymsg = new Text("The username and password are not correct");
                        grid.add(displaymsg, 0, 5);

                    }

                }


        );






        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(25, 25, 25, 25));

        Scene scene2 = new Scene(grid2, 600, 600);
        Text scene2title = new Text("Disease Visualizer");
        scene2title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scene2title.setTextAlignment(TextAlignment.CENTER);
        grid2.add(scene2title, 0, 0,1,1);

        ImageView PakistanMap = new ImageView();
        Image image1 = new Image(Main.class.getResourceAsStream("MAP.png"));
        PakistanMap.setImage(image1);
        grid2.add(PakistanMap,0,1);
        btn1.setOnAction(e ->
        {
            primaryStage.setScene(scene2);

        });
        primaryStage.show();
    }
}