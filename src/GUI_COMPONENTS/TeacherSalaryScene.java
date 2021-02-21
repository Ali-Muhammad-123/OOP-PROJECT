package GUI_COMPONENTS;

import Classes.Lab_instructor;
import Classes.Salary;
import Classes.Teacher;


import LinkedList.Node;
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

import java.io.FileInputStream;
import java.io.ObjectInputStream;
public class TeacherSalaryScene extends Application {

    SinglyList<Teacher> teachers;

    SinglyList<Lab_instructor> lab_instructors;
    int counter=0;
    int rowcounter=2;
    Salary salary = new Salary();
    TeacherSalaryScene( SinglyList<Teacher> teachers ,SinglyList<Lab_instructor> lab_instructors){
        this.teachers = teachers;
        this.lab_instructors  =lab_instructors;
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {


        GridPane grid3 = new GridPane();
        grid3.setAlignment(Pos.CENTER);
        grid3.setHgap(10);
        grid3.setVgap(10);
        grid3.setPadding(new Insets(25, 25, 25, 25));

        Scene StudentFeeScene = new Scene(grid3, 1400, 800);
        Text Title = new Text("Students Fees");
        Title.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
        Title.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Title, 3, 0, 1, 1);

        Text ID = new Text("Teacher's ID");
        ID.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        ID.setTextAlignment(TextAlignment.CENTER);
        grid3.add(ID, 0, 1);

        Text Name = new Text("Teacher's Name");
        Name.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        Name.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Name, 1, 1);

        Text Gender = new Text("Teacher's Net Fees");
        Gender.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        Gender.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Gender, 2, 1);

        Text Age = new Text("Teacher's Gross Fees");
        Age.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        Age.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Age, 3, 1);

        Button Back = new Button("Back");
        HBox Backbtn = new HBox(10);
        Backbtn.setAlignment(Pos.CENTER);
        Backbtn.getChildren().add(Back);
        grid3.add(Backbtn, 0, 8);

        Back.setOnAction(e ->
        { TeacherMenu teacherMenu = new TeacherMenu();
            teacherMenu.start(primaryStage);
        });

        try {
            FileInputStream fis = new FileInputStream("C:/Users/hp/Desktop/DSA LAB PROJECT/src/Classes/Lab_Instructors.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            lab_instructors = (SinglyList<Lab_instructor>)ois.readObject();
            lab_instructors.sortList();
            Text[] fields = new Text[100];
            Node<Lab_instructor> node = lab_instructors.getFirst();
            while (node !=null) {
                fields[counter] = new Text(String.valueOf(node.getData().getID()));
                grid3.add(fields[counter], 0, ++rowcounter);
                counter++;
                fields[counter] = new Text(node.getData().getName());
                grid3.add(fields[counter], 1, rowcounter);
                counter++;
                fields[counter] = new Text(String.valueOf(salary.getNet_amount(node.getData())));
                grid3.add(fields[counter], 2, rowcounter);
                counter++;
                fields[counter] = new Text(String.valueOf(salary.getGross_amount(node.getData())));
                grid3.add(fields[counter], 3, rowcounter);
                counter++;
                node = node.next;
            }

        } catch (Exception exep) {
            System.out.println(exep);
        }
        try {
            FileInputStream fis = new FileInputStream("C:/Users/hp/Desktop/DSA LAB PROJECT/src/Classes/Teachers.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            teachers = (SinglyList<Teacher>)ois.readObject();
            teachers.sortList();
            Text[] fields = new Text[100];
            Node<Teacher> node = teachers.getFirst();

            while (node !=null) {
                fields[counter] = new Text(String.valueOf(node.getData().getID()));
                grid3.add(fields[counter], 0, ++rowcounter);
                counter++;
                fields[counter] = new Text(node.getData().getName());
                grid3.add(fields[counter], 1, rowcounter);
                counter++;
                fields[counter] = new Text(String.valueOf(salary.getNet_amount(node.getData())));
                grid3.add(fields[counter], 2, rowcounter);
                counter++;
                fields[counter] = new Text(String.valueOf(salary.getGross_amount(node.getData())));
                grid3.add(fields[counter], 3, rowcounter);
                counter++;
                node = node.next;
            }

        } catch (Exception exep) {
            System.out.println(exep);
        }



        primaryStage.setScene(StudentFeeScene);

    }
}
