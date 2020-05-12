package sample;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
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

import javax.print.attribute.standard.MediaSize;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    String retrieved_password;
    String retrieved_username;
    String correct_username = "ali";
    String correct_password = "ali";
    int counter=0;
    int rowcounter=2;

    ArrayList<Student> students = new ArrayList<>();
    Student student1;

    Courses Course1 = new Courses("1001","Object Oriented Programming" , 3,"Adeel Karim",28,"PHD",true);
    Courses Course2 = new Courses("1002","Object Oriented Programming LAB" , 1,"Rabia Sameen",25,"PHD",true);
    Courses Course3 = new Courses("1003","Digital Logic Design" , 3,"Khalid Rasheed",29,"PHD",true);
    Courses Course4 = new Courses("1004","Digital Logic Design LAB" , 1,"Mubeen Ahmed",23,"PHD",true);
    Courses Course5 = new Courses("1005","Statistics" , 3,"Aqil Khan",30,"PHD",true);
    Courses Course6 = new Courses("1006","Oral Communication and Presentation Skills" , 3,"Qaiser Hussian",26,"PHD",true);
    Courses Course7 = new Courses("1007","Design and Creativity" , 3,"Faiz Alam",30,"PHD",true);
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {



        primaryStage.setTitle("Szabist Student Management ");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene LoginPage = new Scene(grid, 550, 600);
        LoginPage.setFill(Color.BLACK);
        primaryStage.setScene(LoginPage);
        Text scenetitle = new Text("Welcome to SZABIST Student Management Hub");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("Admin User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Admin Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);
        //--------------------------------------------------------

        GridPane grid4 = new GridPane();
        grid4.setAlignment(Pos.CENTER);
        grid4.setHgap(10);
        grid4.setVgap(10);
        grid4.setPadding(new Insets(25, 25, 25, 25));


        Scene Courses = new Scene(grid4, 700, 600);
        Text Courseinfotitle = new Text("Course Form");
        Courseinfotitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
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

        grid4.add(OOP,0,2);
        grid4.add(OOPLAB,2,2);
        grid4.add(OCPS,0,3);
        grid4.add(DLD,2,3);
        grid4.add(DLDLAB,0,4);
        grid4.add(STATS,2,4);
        grid4.add(DC,1,5);

        Button CourseSubmit = new Button("Submit");
        HBox hbCourseSubmit = new HBox(10);
        hbCourseSubmit.setAlignment(Pos.BOTTOM_RIGHT);
        hbCourseSubmit.getChildren().add(CourseSubmit);
        grid4.add(CourseSubmit, 2, 7);

//        Courses Course1 = new Courses("1001","Object Oriented Programming" , 3,"Adeel Karim",28,"PHD",true);
//        Courses Course2 = new Courses("1002","Object Oriented Programming LAB" , 1,"Rabia Sameen",25,"PHD",true);
//        Courses Course3 = new Courses("1003","Digital Logic Design" , 3,"Khalid Rasheed",29,"PHD",true);
//        Courses Course4 = new Courses("1004","Digital Logic Design LAB" , 1,"Mubeen Ahmed",23,"PHD",true);
//        Courses Course5 = new Courses("1005","Statistics" , 3,"Aqil Khan",30,"PHD",true);
//        Courses Course6 = new Courses("1006","Oral Communication and Presentation Skills" , 3,"Qaiser Hussian",26,"PHD",true);
//        Courses Course7 = new Courses("1007","Design and Creativity" , 3,"Faiz Alam",30,"PHD",true);


        // ----------------------------------------------------


        GridPane grid1 = new GridPane();
        grid1.setAlignment(Pos.CENTER);
        grid1.setHgap(10);
        grid1.setVgap(10);
        grid1.setPadding(new Insets(25, 25, 25, 25));


        Scene studentinfo = new Scene(grid1, 700, 600);
        Text studentinfotitle = new Text("Student Form");
        studentinfotitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid1.setAlignment(Pos.TOP_CENTER);
        grid1.add(studentinfotitle, 0, 0, 2, 1);

        Label student_id = new Label("Student ID:");
        grid1.add(student_id, 0, 1);
        TextField student_idTextField = new TextField();
        grid1.add(student_idTextField, 1, 1);

        Label studentName = new Label("Name:");
        grid1.add(studentName, 0, 2);

        TextField studentNameTextField = new TextField();
        grid1.add(studentNameTextField, 1, 2);

        Label studentSemester = new Label("Semester:");
        grid1.add(studentSemester, 0, 3);
        TextField studentSemesterTextField = new TextField();
        grid1.add(studentSemesterTextField, 1, 3);

        Label studentProgramme = new Label("Programme:");
        grid1.add(studentProgramme, 0, 4);
        TextField studentProgrammeTextField = new TextField();
        grid1.add(studentProgrammeTextField, 1, 4);

        String[] genderchoices = {"Male" , "Female" , "Unspecifed"};
        String[] choice = new String[1];
        ChoiceBox Genderbox = new ChoiceBox(FXCollections.observableArrayList(genderchoices));

        Genderbox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            public void changed(ObservableValue ov, Number value, Number new_value)
            {

                choice[0] = genderchoices[new_value.intValue()];
            }
        });
        Label genderlabel = new Label("Gender:");
        grid1.add(genderlabel, 0, 5);
        grid1.add(Genderbox,1,5);


        Button btn3 = new Button("Submit");
        HBox hbBtn3 = new HBox(10);
        hbBtn3.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn3.getChildren().add(btn3);
        grid1.add(hbBtn3, 2, 7);
        btn3.setOnAction(e ->
                {
                    primaryStage.setScene(Courses);
                    student1 = new Student(studentNameTextField.getText(), Integer.parseInt(student_idTextField.getText()) ,  choice[0]  ,  studentSemesterTextField.getText(),studentProgrammeTextField.getText());

                }
        );

        //-----------------------------------------------------

        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(25, 25, 25, 25));

        Scene Menu = new Scene(grid2, 600, 600);
        Text MenuTitle = new Text("Menu");
        MenuTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        MenuTitle.setTextAlignment(TextAlignment.CENTER);
        grid2.add(MenuTitle, 0, 0,3,1);

        Button Menu1 = new Button("Register New Student");
        HBox MenuBtn1 = new HBox(10);
        MenuBtn1.setAlignment(Pos.CENTER);
        MenuBtn1.getChildren().add(Menu1);
        grid2.add(MenuBtn1, 0, 1);

        Button Menu2 = new Button("View Student's info");
        HBox MenuBtn2 = new HBox(10);
        MenuBtn2.setAlignment(Pos.CENTER);
        MenuBtn2.getChildren().add(Menu2);
        grid2.add(MenuBtn2, 0, 2);

        Button Menu4 = new Button("Show Courses");
        HBox MenuBtn4 = new HBox(10);
        MenuBtn4.setAlignment(Pos.CENTER);
        MenuBtn4.getChildren().add(Menu4);
        grid2.add(MenuBtn4, 0, 3);

        Button Menu3 = new Button("Visualize COVID-19 Cases");
        HBox MenuBtn3 = new HBox(10);
        MenuBtn3.setAlignment(Pos.CENTER);
        MenuBtn3.getChildren().add(Menu3);
        grid2.add(MenuBtn3, 0, 4);

        GridPane grid3 = new GridPane();
        grid3.setAlignment(Pos.CENTER);
        grid3.setHgap(10);
        grid3.setVgap(10);
        grid3.setPadding(new Insets(25, 25, 25, 25));

        Scene ViewStudents = new Scene(grid3, 1200, 800);
        Text Viewtitle = new Text("Students Database");
        Viewtitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        Viewtitle.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Viewtitle, 0, 0,1,1);

        Text ID = new Text("Student's ID");
        ID.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        ID.setTextAlignment(TextAlignment.CENTER);
        grid3.add(ID, 0, 1);

        Text Name = new Text("Student's Name");
        Name.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        Name.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Name, 1, 1);

        Text Gender = new Text("Student's Gender");
        Gender.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        Gender.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Gender, 2, 1);

        Text Semester = new Text("Student's Semester");
        Semester.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        Semester.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Semester, 3, 1);

        Text Programme = new Text("Student's Programme");
        Programme.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        Programme.setTextAlignment(TextAlignment.CENTER);
        grid3.add( Programme, 4, 1);

        Text Coursesopted = new Text("Student's Courses");
        Coursesopted.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        Coursesopted.setTextAlignment(TextAlignment.CENTER);
        grid3.add( Coursesopted, 5, 1);


        Button Back = new Button("Back");
        HBox Backbtn = new HBox(10);
        Backbtn.setAlignment(Pos.CENTER);
        Backbtn.getChildren().add(Back);
        grid1.add(Backbtn, 0, 8);

        Back.setOnAction(e -> primaryStage.setScene(Menu));

        Button Refresh = new Button("Refresh");
        HBox Refreshbtn = new HBox(10);
        Refreshbtn.setAlignment(Pos.CENTER);
        Refreshbtn.getChildren().add(Refresh);
        grid3.add(Refreshbtn, 4, 23);

        Button Back1 = new Button("Back");
        HBox Backbtn1 = new HBox(10);
        Backbtn1.setAlignment(Pos.CENTER);
        Backbtn1.getChildren().add(Back1);
        Back1.setOnAction(e -> primaryStage.setScene(Menu));


        grid3.add(Backbtn1, 1, 23);

        Refresh.setOnAction(e -> {
                    try {
                        FileInputStream fis = new FileInputStream("C:/Users/hp/Desktop/OOP PROJECT/src/sample/object.ser");
                        ObjectInputStream ois = new ObjectInputStream(fis);

                        students = (ArrayList<Student>)ois.readObject();

                        Text[] fields = new Text[100];
                        for (int i = 0; i < students.size(); i++) {
                            fields[counter] = new Text(String.valueOf(students.get(i).getStudent_ID()));
                            grid3.add(fields[counter], 0, rowcounter++);
                            counter++;
                            fields[counter] = new Text(students.get(i).getName());
                            grid3.add(fields[counter], 1, rowcounter);
                            counter++;
                            fields[counter] = new Text(students.get(i).getGender());
                            grid3.add(fields[counter], 2, rowcounter);
                            counter++;
                            fields[counter] = new Text(students.get(i).getProgramme());
                            grid3.add(fields[counter], 3, rowcounter);
                            counter++;
                            fields[counter] = new Text(students.get(i).getSemester());
                            grid3.add(fields[counter], 4, rowcounter);
                            counter++;
                            if (students.get(i).getCourse1() != null){
                            fields[counter] = new Text(students.get(i).getCourse1().getCourse_Name());
                            grid3.add(fields[counter], 5, rowcounter++);
                            counter++;}
                            if (students.get(i).getCourse2() != null){
                                fields[counter] = new Text(students.get(i).getCourse2().getCourse_Name());
                                grid3.add(fields[counter], 5, rowcounter++);
                                counter++;}
                            if (students.get(i).getCourse3() != null){
                                fields[counter] = new Text(students.get(i).getCourse3().getCourse_Name());
                                grid3.add(fields[counter], 5, rowcounter++);
                                counter++;}
                            if (students.get(i).getCourse4() != null){
                                fields[counter] = new Text(students.get(i).getCourse4().getCourse_Name());
                                grid3.add(fields[counter], 5, rowcounter++);
                                counter++;}
                            if (students.get(i).getCourse5() != null){
                                fields[counter] = new Text(students.get(i).getCourse5().getCourse_Name());
                                grid3.add(fields[counter], 5, rowcounter++);
                                counter++;}
                            if (students.get(i).getCourse6() != null){
                                fields[counter] = new Text(students.get(i).getCourse6().getCourse_Name());
                                grid3.add(fields[counter], 5, rowcounter++);
                                counter++;}
                            if (students.get(i).getCourse7() != null){
                                fields[counter] = new Text(students.get(i).getCourse7().getCourse_Name());
                                grid3.add(fields[counter], 5, rowcounter++);

                                counter++;}



                        }
                    } catch (Exception exep) {
                        System.out.println(exep);
                    }
                });

//        ImageView PakistanMap = new ImageView();
//        Image image1 = new Image(Main.class.getResourceAsStream("MAP.png"));
//        PakistanMap.setImage(image1);
//        grid2.add(PakistanMap,0,1,30,30);

        Menu1.setOnAction(e ->{
        primaryStage.setScene(studentinfo);
        });
        Menu2.setOnAction(e ->{
            primaryStage.setScene(ViewStudents);
        });
        Menu3.setOnAction(e ->{
            primaryStage.setScene(studentinfo);
        });
        Menu4.setOnAction(e ->{
            primaryStage.setScene(studentinfo);
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


        CourseSubmit.setOnAction(e ->
                {
                    if (OOP.isSelected()){
                        student1.setCourse1(Course1);
                    }

                    if(OOPLAB.isSelected()){
                        student1.setCourse2(Course2);
                    }

                    if(DLD.isSelected()){
                        student1.setCourse3(Course3);
                    }

                    if(DLDLAB.isSelected()){
                        student1.setCourse4(Course4);
                    }
                    if(STATS.isSelected()){
                        student1.setCourse5(Course5);
                    }

                    if(OCPS.isSelected()){
                        student1.setCourse6(Course6);
                    }

                    if(DC.isSelected()){
                        student1.setCourse6(Course7);
                    }
                    try {
                        FileOutputStream fop=new FileOutputStream("C:/Users/hp/Desktop/OOP PROJECT/src/sample/object.ser");
                        ObjectOutputStream oos=new ObjectOutputStream(fop);
                        students.add(student1);
                        oos.writeObject(students);

                    } catch (Exception ex) {
                        System.out.println(ex);
                    }

                    primaryStage.setScene(Menu);

                }
        );





        primaryStage.show();




    }
}