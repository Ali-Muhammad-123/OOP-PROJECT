package GUI_COMPONENTS;

import Classes.Lab_instructor;
import Classes.Teacher;
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
import Classes.Courses;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CourseFormScene3 extends Application {

    Lab_instructor lab_instructor;
    ArrayList<Lab_instructor> lab_instructors;


    CourseFormScene3(Lab_instructor lab_instructor, ArrayList<Lab_instructor> lab_instructors){
        this.lab_instructor = lab_instructor;
        this.lab_instructors = lab_instructors;
    }


    public static void main(String[] args) {
        launch(args);
    }



    public void start(Stage primaryStage) {
        Courses courses[] = new Courses[7];
        courses[0] = new Courses("1001", "Object Oriented Programming", 3);
        courses[1] = new Courses("1002", "Object Oriented Programming LAB", 1);
        courses[2] = new Courses("1003", "Digital Logic Design", 3);
        courses[3] = new Courses("1004", "Digital Logic Design LAB", 1);
        courses[4] = new Courses("1005", "Statistics", 3);
        courses[5] = new Courses("1006", "Oral Communication and Presentation Skills", 3);
        courses[6] = new Courses("1007", "Design and Creativity", 3);
        Courses[] SelectedCourses = new Courses[7];

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

        Text Instructions = new Text("Select the courses that The Lab instructor would would be teaching (max 1)  :");
        grid4.add(Instructions, 0, 1);

        RadioButton[] coursebuttons = new RadioButton[7];
        coursebuttons[0] = new RadioButton("Object Oriented Programming");
        coursebuttons[1] = new RadioButton("Object Oriented Programming LAB");
        coursebuttons[2] = new RadioButton("Digital Logic Design");
        coursebuttons[3] = new RadioButton("Digital Logic Design LAB");
        coursebuttons[4] = new RadioButton("Statistics");
        coursebuttons[5] = new RadioButton("Oral Communication and Presentation Skills");
        coursebuttons[6] = new RadioButton("Design and Creativity");

        grid4.add(coursebuttons[0], 0, 2);
        grid4.add(coursebuttons[1], 2, 2);
        grid4.add(coursebuttons[2], 0, 3);
        grid4.add(coursebuttons[3], 2, 3);
        grid4.add(coursebuttons[4], 0, 4);
        grid4.add(coursebuttons[5], 2, 4);
        grid4.add(coursebuttons[6], 0, 5);

        Button CourseSubmit = new Button("Submit");
        HBox hbCourseSubmit = new HBox(10);
        hbCourseSubmit.setAlignment(Pos.BOTTOM_RIGHT);
        hbCourseSubmit.getChildren().add(CourseSubmit);
        grid4.add(CourseSubmit, 2, 7);


        CourseSubmit.setOnAction(e ->
        {
            for (int i=0 ; i<7 ; i++){
                if (coursebuttons[i].isSelected()){
                    SelectedCourses[i] = courses[i];
                }
            }
            try{
                lab_instructor.Assign_Courses(SelectedCourses);}
            catch (Exception ex){
                throw ex;
            }
            try{
                FileOutputStream fop = new FileOutputStream("C:/Users/hp/Desktop/OOP PROJECT/src/Classes/Lab_Instructors.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fop);
                lab_instructors.add(lab_instructor);
                oos.writeObject(lab_instructors);

            } catch (Exception ex) {
                System.out.println(ex);
            }

            TeacherMenu teacherMenu = new TeacherMenu();
            teacherMenu.start(primaryStage);
        });

        primaryStage.setScene(Courses);
    }
}