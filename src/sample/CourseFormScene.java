package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CourseFormScene extends Application {
    Courses Course1 = new Courses("1001", "Object Oriented Programming", 3);
    Courses Course2 = new Courses("1002", "Object Oriented Programming LAB", 1);
    Courses Course3 = new Courses("1003", "Digital Logic Design", 3);
    Courses Course4 = new Courses("1004", "Digital Logic Design LAB", 1);
    Courses Course5 = new Courses("1005", "Statistics", 3);
    Courses Course6 = new Courses("1006", "Oral Communication and Presentation Skills", 3);
    Courses Course7 = new Courses("1007", "Design and Creativity", 3);
    Student student1;
    ArrayList<Student> students;
    CourseFormScene(Student student1 , ArrayList<Student> students){
        this.student1 = student1;
        this.students = students;
    }
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        GridPane grid4 = new GridPane();
        grid4.setAlignment(Pos.CENTER);
        grid4.setHgap(10);
        grid4.setVgap(10);
        grid4.setPadding(new Insets(25, 25, 25, 25));


        Scene Courses = new Scene(grid4, 900, 600);
        Text Courseinfotitle = new Text("Course Form");
        Courseinfotitle.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
        grid4.setAlignment(Pos.TOP_CENTER);
        grid4.add(Courseinfotitle, 0, 0, 2, 1);

        Text Instructions = new Text("Select the courses that The student would like to opt for  :");
        grid4.add(Instructions, 0, 1);

        RadioButton OOP = new RadioButton("Object Oriented Programming");
        RadioButton OOPLAB = new RadioButton("Object Oriented Programming LAB");
        RadioButton OCPS = new RadioButton("Oral Communication and Presentaion Skills");
        RadioButton DLD = new RadioButton("Digital Logic Design");
        RadioButton DLDLAB = new RadioButton("Digital Logic Design LAB");
        RadioButton STATS = new RadioButton("Statistics");
        RadioButton DC = new RadioButton("Design and Creativity");

        grid4.add(OOP, 0, 2);
        grid4.add(OOPLAB, 2, 2);
        grid4.add(OCPS, 0, 3);
        grid4.add(DLD, 2, 3);
        grid4.add(DLDLAB, 0, 4);
        grid4.add(STATS, 2, 4);
        grid4.add(DC, 0, 5);

        Button CourseSubmit = new Button("Submit");
        HBox hbCourseSubmit = new HBox(10);
        hbCourseSubmit.setAlignment(Pos.BOTTOM_RIGHT);
        hbCourseSubmit.getChildren().add(CourseSubmit);
        grid4.add(CourseSubmit, 2, 7);


        CourseSubmit.setOnAction(e ->
        {
            if (OOP.isSelected()) {
                student1.setCourse1(Course1);
            }

            if (OOPLAB.isSelected()) {
                student1.setCourse2(Course2);
            }

            if (DLD.isSelected()) {
                student1.setCourse3(Course3);
            }

            if (DLDLAB.isSelected()) {
                student1.setCourse4(Course4);
            }
            if (STATS.isSelected()) {
                student1.setCourse5(Course5);
            }

            if (OCPS.isSelected()) {
                student1.setCourse6(Course6);
            }

            if (DC.isSelected()) {
                student1.setCourse7(Course7);
            }
            try {
                FileOutputStream fop = new FileOutputStream("C:/Users/hp/Desktop/OOP PROJECT/src/sample/object.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fop);
                students.add(student1);
                oos.writeObject(students);

            } catch (Exception ex) {
                System.out.println(ex);
            }

            Menu menu = new Menu();
            menu.start(primaryStage);
        });

        primaryStage.setScene(Courses);
    }
}