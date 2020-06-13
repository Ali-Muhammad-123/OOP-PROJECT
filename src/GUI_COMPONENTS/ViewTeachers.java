package GUI_COMPONENTS;

import Classes.Lab_instructor;
import Classes.Teacher;
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
import java.util.ArrayList;

public class ViewTeachers extends Application  {
    ArrayList<Teacher> teachers;
    int counter=0;
    int rowcounter=2;
    ArrayList<Lab_instructor> lab_instructors;

    ViewTeachers( ArrayList<Teacher> teachers ,ArrayList<Lab_instructor> lab_instructors){
        this.teachers = teachers;
        this.lab_instructors  =lab_instructors;
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
        Text Viewtitle = new Text("Teachers Database");
        Viewtitle.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
        Viewtitle.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Viewtitle, 3, 0, 1, 1);

        Text ID = new Text("Teacher's ID");
        ID.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        ID.setTextAlignment(TextAlignment.CENTER);
        grid3.add(ID, 0, 1);

        Text Name = new Text("Teacher's Name");
        Name.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        Name.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Name, 1, 1);

        Text Gender = new Text("Teacher's Gender");
        Gender.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        Gender.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Gender, 2, 1);

        Text Age = new Text("Teacher's Age");
        Age.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        Age.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Age, 3, 1);


        Text Semester = new Text("Teacher's Qualification");
        Semester.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        Semester.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Semester, 4, 1);


        Text Coursesopted = new Text("Teacher's Courses");
        Coursesopted.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        Coursesopted.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Coursesopted, 5, 1);



        Button Back1 = new Button("Back");
        HBox Backbtn1 = new HBox(10);
        Backbtn1.setAlignment(Pos.CENTER);
        Backbtn1.getChildren().add(Back1);
        Back1.setOnAction(e ->
        { TeacherMenu teacherMenu = new TeacherMenu();
            teacherMenu.start(primaryStage);
        });

        grid3.add(Backbtn1, 1, 23);

            try {
                FileInputStream fis = new FileInputStream("C:/Users/hp/Desktop/OOP PROJECT/src/Classes/Teachers.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
                teachers = (ArrayList<Teacher>)ois.readObject();

                Text[] fields = new Text[100];
                for (int i = 0; i < teachers.size(); i++) {
                    fields[counter] = new Text(String.valueOf(teachers.get(i).getID()));
                    grid3.add(fields[counter], 0, ++rowcounter);
                    counter++;
                    fields[counter] = new Text(teachers.get(i).getName());
                    grid3.add(fields[counter], 1, rowcounter);
                    counter++;
                    fields[counter] = new Text(teachers.get(i).getGender());
                    grid3.add(fields[counter], 2, rowcounter);
                    counter++;
                    fields[counter] = new Text(String.valueOf(teachers.get(i).getAge()));
                    grid3.add(fields[counter], 3, rowcounter);
                    counter++;
                    fields[counter] = new Text(teachers.get(i).getQualification());
                    grid3.add(fields[counter], 4, rowcounter);
                    counter++;
                    for (int j=0 ; j<teachers.get(i).getCourses().length; j++){
                        if (teachers.get(i).getCourses()[j] != null) {
                            fields[counter] = new Text(teachers.get(i).getCourses()[j].getCourse_Name());
                            grid3.add(fields[counter], 6, rowcounter++);
                            counter++;
                        }
                    } }

            } catch (Exception exep) {
                System.out.println(exep);
            }


        try {
            FileInputStream fis = new FileInputStream("C:/Users/hp/Desktop/OOP PROJECT/src/Classes/Lab_Instructors.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            lab_instructors = (ArrayList<Lab_instructor>)ois.readObject();

            Text[] fields = new Text[100];
            for (int i = 0; i < lab_instructors.size(); i++) {
                fields[counter] = new Text(String.valueOf(lab_instructors.get(i).getID()));
                grid3.add(fields[counter], 0, ++rowcounter);
                counter++;
                fields[counter] = new Text(lab_instructors.get(i).getName());
                grid3.add(fields[counter], 1, rowcounter);
                counter++;
                fields[counter] = new Text(lab_instructors.get(i).getGender());
                grid3.add(fields[counter], 2, rowcounter);
                counter++;
                fields[counter] = new Text(String.valueOf(lab_instructors.get(i).getAge()));
                grid3.add(fields[counter], 3, rowcounter);
                counter++;
                fields[counter] = new Text(lab_instructors.get(i).getQualification());
                grid3.add(fields[counter], 4, rowcounter);
                counter++;
                for (int j=0 ; j<lab_instructors.get(i).getCourses().length; j++){
                    if (lab_instructors.get(i).getCourses()[j] != null) {
                        fields[counter] = new Text(lab_instructors.get(i).getCourses()[j].getCourse_Name());
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