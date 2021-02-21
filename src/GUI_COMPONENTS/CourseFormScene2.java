package GUI_COMPONENTS;

import Classes.Teacher;
import LinkedList.SinglyList;
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

public class CourseFormScene2 extends Application {

    Teacher teacher;
    SinglyList<Teacher> teachers;


    CourseFormScene2(Teacher teacher, SinglyList<Teacher> teachers){
        this.teacher = teacher;
        this.teachers = teachers;
    }



    public static void main(String[] args) {
        launch(args);
    }



    public void start(Stage primaryStage) {
        Courses courses[] = new Courses[7];
        courses[0] = new Courses("1001", "Data Structures and Algorithims", 3);
        courses[1] = new Courses("1002", "Data Structures and Algorithims LAB", 1);
        courses[2] = new Courses("1003", "Computer Organization and Assembly Language", 3);
        courses[3] = new Courses("1004", "Computer Organization and Assembly Language LAB", 1);
        courses[4] = new Courses("1005", "Multivariate Calculus", 3);
        courses[5] = new Courses("1006", "Professional Practices", 3);
        courses[6] = new Courses("1007", "Discrete Mathematics", 3);
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

        Text Instructions = new Text("Select the courses that The teacher would would be teaching (max 3)  :");
        grid4.add(Instructions, 0, 1);

        RadioButton[] coursebuttons = new RadioButton[7];
        coursebuttons[0] = new RadioButton("Data Structures and Algorithims");
        coursebuttons[1] = new RadioButton("Data Structures and Algorithims LAB");
        coursebuttons[2] = new RadioButton("Computer Organization and Assembly Language");
        coursebuttons[3] = new RadioButton("Computer Organization and Assembly Language LAB");
        coursebuttons[4] = new RadioButton("Multivariate Calculus");
        coursebuttons[5] = new RadioButton("Professional Practices");
        coursebuttons[6] = new RadioButton("Discrete Mathematics");


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
                teacher.Assign_Courses(SelectedCourses);}
            catch (Exception ex){
                throw ex;
            }
            try{
                FileOutputStream fop = new FileOutputStream("C:/Users/hp/Desktop/DSA LAB PROJECT/src/Classes/Teachers.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fop);
                teachers.insertFirst(teacher);
                oos.writeObject(teachers);

            } catch (Exception ex) {
                System.out.println(ex);
            }

            TeacherMenu teacherMenu = new TeacherMenu();
            teacherMenu.start(primaryStage);
        });

        primaryStage.setScene(Courses);
    }
}