package GUI_COMPONENTS;

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
import java.util.ArrayList;

public class ViewStudents extends Application  {
    ArrayList<Student> students;
    int counter=0;
    int rowcounter=2;
    ViewStudents( ArrayList<Student> students){
        this.students = students;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        GridPane grid3 = new GridPane();
        grid3.setAlignment(Pos.CENTER);
        grid3.setHgap(10);
        grid3.setVgap(10);
        grid3.setPadding(new Insets(25, 25, 25, 25));

        Scene ViewStudents = new Scene(grid3, 1400, 800);
        Text Viewtitle = new Text("Students Database");
        Viewtitle.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
        Viewtitle.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Viewtitle, 3, 0, 1, 1);

        Text ID = new Text("Student's ID");
        ID.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        ID.setTextAlignment(TextAlignment.CENTER);
        grid3.add(ID, 0, 1);

        Text Name = new Text("Student's Name");
        Name.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        Name.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Name, 1, 1);

        Text Gender = new Text("Student's Gender");
        Gender.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        Gender.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Gender, 2, 1);

        Text Age = new Text("Student's Age");
        Age.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        Age.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Age, 3, 1);


        Text Semester = new Text("Student's Semester");
        Semester.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        Semester.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Semester, 4, 1);

        Text Programme = new Text("Student's Programme");
        Programme.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        Programme.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Programme, 5, 1);

        Text Coursesopted = new Text("Student's Courses");
        Coursesopted.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        Coursesopted.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Coursesopted, 6, 1);



        Button Back1 = new Button("Back");
        HBox Backbtn1 = new HBox(10);
        Backbtn1.setAlignment(Pos.CENTER);
        Backbtn1.getChildren().add(Back1);
        Back1.setOnAction(e -> {
            StudentMenu studentMenu = new StudentMenu();
            studentMenu.start(primaryStage);
                }
        );

        grid3.add(Backbtn1, 1, 23);


            try {
                FileInputStream fis = new FileInputStream("C:/Users/hp/Desktop/OOP PROJECT/src/Classes/Students.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
                students = (ArrayList<Student>)ois.readObject();

                Text[] fields = new Text[100];
                for (int i = 0; i < students.size(); i++) {
                    fields[counter] = new Text(String.valueOf(students.get(i).getID()));
                    grid3.add(fields[counter], 0, ++rowcounter);
                    counter++;
                    fields[counter] = new Text(students.get(i).getName());
                    grid3.add(fields[counter], 1, rowcounter);
                    counter++;
                    fields[counter] = new Text(students.get(i).getGender());
                    grid3.add(fields[counter], 2, rowcounter);
                    counter++;
                    fields[counter] = new Text(String.valueOf(students.get(i).getAge()));
                    grid3.add(fields[counter], 3, rowcounter);
                    counter++;
                    fields[counter] = new Text(students.get(i).getProgramme());
                    grid3.add(fields[counter], 4, rowcounter);
                    counter++;
                    fields[counter] = new Text(students.get(i).getSemester());
                    grid3.add(fields[counter], 5, rowcounter);
                    counter++;
                    for (int j=0 ; j<students.get(i).getCourses().length; j++){
                        if (students.get(i).getCourses()[j] != null) {
                            fields[counter] = new Text(students.get(i).getCourses()[j].getCourse_Name());
                            grid3.add(fields[counter], 6, rowcounter++);
                            counter++;
                        }
                    } }

            } catch (Exception exep) {
                System.out.println(exep);
            }

    primaryStage.setScene(ViewStudents);
    }
}