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
    Visualizer visualizer = new Visualizer(53,48,99,76,56);
    Patient patient = new Patient(50,100.0);
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

        Scene LoginPage = new Scene(grid, 550, 600);
        LoginPage.setFill(Color.BLACK);
        primaryStage.setScene(LoginPage);
        Text scenetitle = new Text("Welcome to SZABIST Hospital Management");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 3, 1);

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
        hBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hBtn.getChildren().add(btn1);
        grid.add(hBtn, 0, 4);


        // ----------------------------------------------------


        GridPane grid1 = new GridPane();
        grid1.setAlignment(Pos.CENTER);
        grid1.setHgap(10);
        grid1.setVgap(10);
        grid1.setPadding(new Insets(25, 25, 25, 25));

        Scene patientinfo = new Scene(grid1, 550, 600);
        Text patientinfotitle = new Text("Patient Form");
        patientinfotitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

        grid1.setAlignment(Pos.TOP_CENTER);
        grid1.add(patientinfotitle, 0, 0, 2, 1);

        Label patient_id = new Label("Patient_id:");
        grid1.add(patient_id, 0, 1);
        TextField patient_idTextField = new TextField();
        grid1.add(patient_idTextField, 1, 1);

        Label patientName = new Label("Name:");
        grid1.add(patientName, 0, 2);

        TextField patientNameTextField = new TextField();
        grid1.add(patientNameTextField, 1, 2);

        Label patientAge = new Label("Age:");
        grid1.add(patientAge, 0, 3);
        TextField patientAgeTextField = new TextField();
        grid1.add(patientAgeTextField, 1, 3);

        Label patientArea = new Label("Area:");
        grid1.add(patientArea, 0, 4);
        TextField patientAreaTextField = new TextField();
        grid1.add(patientAreaTextField, 1, 4);




        Button btn3 = new Button("Submit");
        HBox hbBtn3 = new HBox(10);
        hbBtn3.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn3.getChildren().add(btn3);
        grid1.add(hbBtn3, 0, 5);
        btn3.setOnAction(e ->
                {
                    primaryStage.setScene(patientinfo);
                    patient.setPatient_id(Integer.parseInt(patient_idTextField.getText()));
                    patient.getPatient_id();
                    patient.setPatient_name(patientNameTextField.getText());
                    patient.getPatient_name();
                    patient.setPatient_age(Integer.parseInt(patientAgeTextField.getText()));
                    patient.getPatient_age();
                    patient.setArea(patientAreaTextField.getText());
                    patient.getArea();


                }
        );



        //-----------------------------------------------------












        GridPane grid3 = new GridPane();
        grid3.setAlignment(Pos.CENTER);
        grid3.setHgap(10);
        grid3.setVgap(10);
        grid3.setPadding(new Insets(25, 25, 25, 25));

        Scene Menu = new Scene(grid3, 600, 600);
        Text MenuTitle = new Text("Menu");
        MenuTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        MenuTitle.setTextAlignment(TextAlignment.CENTER);
        grid3.add(MenuTitle, 0, 0,3,1);

        Button Menu1 = new Button("Register New Patient");
        HBox MenuBtn1 = new HBox(10);
        MenuBtn1.setAlignment(Pos.CENTER);
        MenuBtn1.getChildren().add(Menu1);
        grid3.add(MenuBtn1, 0, 1);

        Button Menu2 = new Button("View Patient's info");
        HBox MenuBtn2 = new HBox(10);
        MenuBtn2.setAlignment(Pos.CENTER);
        MenuBtn2.getChildren().add(Menu2);
        grid3.add(MenuBtn2, 0, 2);

        Button Menu4 = new Button("Print Bill");
        HBox MenuBtn4 = new HBox(10);
        MenuBtn4.setAlignment(Pos.CENTER);
        MenuBtn4.getChildren().add(Menu4);
        grid3.add(MenuBtn4, 0, 3);

        Button Menu3 = new Button("Visualize COVID-19 Cases");
        HBox MenuBtn3 = new HBox(10);
        MenuBtn3.setAlignment(Pos.CENTER);
        MenuBtn3.getChildren().add(Menu3);
        grid3.add(MenuBtn3, 0, 4);



        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(25, 25, 25, 25));

        Scene Visualizer = new Scene(grid2, 600, 600);
        Text Visualizertitle = new Text("COVID-19 Visualizer");
        Visualizertitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        Visualizertitle.setTextAlignment(TextAlignment.CENTER);
        grid2.add(Visualizertitle, 0, 0,1,1);

        ImageView PakistanMap = new ImageView();
        Image image1 = new Image(Main.class.getResourceAsStream("MAP.png"));
        PakistanMap.setImage(image1);
        grid2.add(PakistanMap,0,1,30,30);

        Text SindhCases = new Text(String.valueOf(visualizer.getCases_in_Sindh()));
        SindhCases.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 20));
        grid2.add(SindhCases,6,30);

        Text PunjabCases = new Text(String.valueOf(visualizer.getCases_in_Punjab()));
        PunjabCases.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 20));
        grid2.add(PunjabCases,10,21);

        Text KPKCases = new Text(String.valueOf(visualizer.getCases_in_KPK()));
        KPKCases.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 20));
        grid2.add(KPKCases,10,10);

        Text BalochistanCases = new Text(String.valueOf(visualizer.getCases_in_Balochistan()));
        BalochistanCases.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 20));
        grid2.add(BalochistanCases,1,25);

        Text KashmirCases = new Text(String.valueOf(visualizer.getCases_in_Kashmir()));
        KashmirCases.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 20));
        grid2.add(KashmirCases,19,10);




        Menu1.setOnAction(e ->{
        primaryStage.setScene(patientinfo);
        });
        Menu2.setOnAction(e ->{
            primaryStage.setScene(patientinfo);
        });
        Menu3.setOnAction(e ->{
            primaryStage.setScene(patientinfo);
        });
        Menu4.setOnAction(e ->{
            primaryStage.setScene(Visualizer);
        });

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
                        primaryStage.setScene(Menu);
                        grid.add(displaymsg, 0,5);

                    }
                    else {
                        Text displaymsg = new Text("The username and password are not correct");
                        grid.add(displaymsg, 0, 5);

                    }  });


        btn1.setOnAction(e ->
        {
            primaryStage.setScene(Visualizer);
        });



        primaryStage.show();




    }
}