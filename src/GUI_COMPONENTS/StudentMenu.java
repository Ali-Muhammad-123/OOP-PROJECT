package GUI_COMPONENTS;

import LinkedList.SinglyList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import Classes.Student;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class StudentMenu extends Application {
    SinglyList students = new SinglyList();
    Student student1;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {


        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(25, 25, 25, 25));

        Scene StudentMenu = new Scene(grid2, 600, 550);
        Text MenuTitle = new Text("Student Menu");
        MenuTitle.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
        MenuTitle.setTextAlignment(TextAlignment.CENTER);
        grid2.add(MenuTitle, 0, 0, 2, 1);

        Button Menu1 = new Button("Register New Student");
        HBox MenuBtn1 = new HBox(10);
        MenuBtn1.setAlignment(Pos.CENTER);
        MenuBtn1.getChildren().add(Menu1);
        grid2.add(MenuBtn1, 0, 1);

        Button Menu2 = new Button("View Student's info");
        HBox MenuBtn2 = new HBox(10);
        MenuBtn2.setAlignment(Pos.CENTER);
        MenuBtn2.getChildren().add(Menu2);
        grid2.add(MenuBtn2, 1, 1);

        Button Menu3 = new Button("Generate Fees");
        HBox MenuBtn3 = new HBox(10);
        MenuBtn3.setAlignment(Pos.CENTER);
        MenuBtn3.getChildren().add(Menu3);
        grid2.add(MenuBtn3, 0, 2 );

        Button Menu4 = new Button("Remove Student");
        HBox MenuBtn4 = new HBox(10);
        MenuBtn4.setAlignment(Pos.CENTER);
        MenuBtn4.getChildren().add(Menu4);
        grid2.add(MenuBtn4, 1, 2);


        Button Back = new Button("Back");
        HBox Backbtn = new HBox(10);
        Backbtn.setAlignment(Pos.CENTER);
        Backbtn.getChildren().add(Back);
        grid2.add(Backbtn, 0, 3 , 2 ,2);

        Back.setOnAction(e ->
        { MainMenuScene mainMenuScene = new MainMenuScene();
            mainMenuScene.start(primaryStage);
        });


        Menu1.setOnAction(e ->{
            StudentFormScene studentformscene = new StudentFormScene(student1,students);
            studentformscene.start(primaryStage);
        });
        Menu2.setOnAction(e ->{
            ViewStudents viewstudents = new ViewStudents(students);
            viewstudents.start(primaryStage);

        });
        Menu3.setOnAction(e ->{
            StudentFeeScene studentFeeScene = new StudentFeeScene(students);
            studentFeeScene.start(primaryStage);

        });

        Menu4.setOnAction(e ->{
            DeleteStudents deleteStudents = new DeleteStudents(students);
            deleteStudents.start(primaryStage);

        });

        try {
            FileInputStream fis = new FileInputStream("C:/Users/hp/Desktop/DSA LAB PROJECT/src/Classes/Students.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (SinglyList)ois.readObject();
        }
        catch (Exception ex){
            System.out.println(ex);
        }

        primaryStage.setScene(StudentMenu);
    }
}