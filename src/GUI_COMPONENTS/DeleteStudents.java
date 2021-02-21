package GUI_COMPONENTS;

import LinkedList.SinglyList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Classes.Student;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


public class DeleteStudents extends Application {
    SinglyList<Student> students;
    DeleteStudents(SinglyList<Student> students){
        this.students = students;
    }
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage)  {
        GridPane grid1 = new GridPane();
        grid1.setAlignment(Pos.CENTER);
        grid1.setHgap(10);
        grid1.setVgap(10);
        grid1.setPadding(new Insets(25, 25, 25, 25));


        Scene studentinfo = new Scene(grid1, 700, 600);
        Text studentinfotitle = new Text("Remove Students");
        studentinfotitle.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
        grid1.setAlignment(Pos.TOP_CENTER);
        grid1.add(studentinfotitle, 0, 0, 2, 1);

        Label student_id = new Label("Student ID:");
        grid1.add(student_id, 0, 1);
        TextField student_idTextField = new TextField();
        grid1.add(student_idTextField, 1, 1);


        Button Back = new Button("Back");
        HBox Backbtn = new HBox(10);
        Backbtn.setAlignment(Pos.CENTER);
        Backbtn.getChildren().add(Back);
        grid1.add(Backbtn, 0, 8);

        Back.setOnAction(e ->
        { StudentMenu studentMenu = new StudentMenu();
            studentMenu.start(primaryStage);
        });


        Button btn3 = new Button("Submit");
        HBox hbBtn3 = new HBox(10);
        hbBtn3.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn3.getChildren().add(btn3);
        grid1.add(hbBtn3, 1, 8);
        btn3.setOnAction(e ->
        {
            try{
                students.Delete(Integer.parseInt(student_idTextField.getText()));
            }
            catch (Exception ex){
                throw ex;
            }
            try{
                FileOutputStream fop = new FileOutputStream("C:/Users/hp/Desktop/DSA LAB PROJECT/src/Classes/Students.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fop);
                oos.writeObject(students);

            } catch (Exception ex) {
                System.out.println(ex);
            }

            ViewStudents viewStudents = new ViewStudents(students);
            viewStudents.start(primaryStage);
        } );

        primaryStage.setScene(studentinfo);
    }}
