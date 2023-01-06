package com.example.sampleproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.ObjectInput;
import  java.sql.*;
import java.sql.DatabaseMetaData;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.io.IOException;

import static java.lang.Class.forName;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Group group=new Group();
        Scene scene = new Scene(group);
        stage.setTitle("Sign");
        stage.setHeight(500);
        stage.setWidth(400);
        stage.setScene(scene);
        stage.show();

        VBox container=new VBox();
        container.setSpacing(4);
        group.getChildren().add(container);


        HBox header=new HBox();
        Label headertitle=new Label("sign up");
        headertitle.setPadding(new Insets(100,100,10,150));

        headertitle.setTextFill(Color.web("#0076a3"));
        headertitle.setStyle("-fx-font-size:20px");
        header.setAlignment(Pos.CENTER);
        header.getChildren().add(headertitle);
        container.getChildren().add(header);

        HBox firstInput=new HBox();
        Label User=new Label("user name");
        TextField username=new TextField();
        firstInput.setSpacing(48);
        firstInput.setAlignment(Pos.CENTER);
        firstInput.getChildren().add(User);
        firstInput.getChildren().add(username);
        container.getChildren().add(firstInput);

        HBox threidInput=new HBox();
        Label Email=new Label("Email");
        TextField emailFiled=new TextField();
        threidInput.setAlignment(Pos.CENTER);
        threidInput.getChildren().add(Email);
        threidInput.getChildren().add(emailFiled);
        threidInput.setSpacing(72);
        container.getChildren().add(threidInput);

        HBox secondInput=new HBox();
        Label password=new Label("password");
        PasswordField passwordField=new PasswordField();
        secondInput.setSpacing(48);
        secondInput.setAlignment(Pos.CENTER);
        secondInput.getChildren().add(password);
        secondInput.getChildren().add(passwordField);
        container.getChildren().add(secondInput);

        HBox fourInput=new HBox();
        Label Comfrimpassword=new Label("Confrim password");
        PasswordField compasswordField=new PasswordField();
        fourInput.setSpacing(1);
        fourInput.setAlignment(Pos.CENTER);
        fourInput.getChildren().add(Comfrimpassword);
        fourInput.getChildren().add(compasswordField);
        container.getChildren().add(fourInput);

        HBox btn=new HBox();
        Button save=new Button("Register");
        save.setStyle("-fx-color:#0076a3");
        Button Login=new Button("Login");
        btn.getChildren().add(save);
        btn.getChildren().add(Login);
        btn.setAlignment(Pos.CENTER);
        btn.setSpacing(5);
        btn.setPadding(new Insets(5,0,0,135));
        container.getChildren().add(btn);
        Login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Group group1=new Group();
                Scene loginscene=new Scene(group1);
                stage.setScene(loginscene);
                stage.setTitle("Login");
                stage.setHeight(500);
                stage.setWidth(400);
                stage.show();
                VBox container=new VBox();
                container.setSpacing(4);
                group1.getChildren().add(container);


                HBox header=new HBox();
                Label headertitle=new Label("sign up");
                headertitle.setPadding(new Insets(100,100,10,150));

                headertitle.setTextFill(Color.web("#0076a3"));
                headertitle.setStyle("-fx-font-size:20px");
                header.setAlignment(Pos.CENTER);
                header.getChildren().add(headertitle);
                container.getChildren().add(header);

                HBox firstInput=new HBox();
                Label User=new Label("user name");
                TextField username=new TextField();
                firstInput.setSpacing(8);
                firstInput.setAlignment(Pos.CENTER);
                firstInput.getChildren().add(User);
                firstInput.getChildren().add(username);
                container.getChildren().add(firstInput);

                HBox secondInput=new HBox();
                Label password=new Label("password");
                PasswordField passwordField=new PasswordField();
                secondInput.setSpacing(10);
                secondInput.setAlignment(Pos.CENTER);
                secondInput.getChildren().add(password);
                secondInput.getChildren().add(passwordField);
                container.getChildren().add(secondInput);

                HBox btn=new HBox();
                Button save=new Button("Register");
                Button Login=new Button("Login");
                Login.setStyle("-fx-color:#0076a3");
                btn.getChildren().add(save);
                btn.getChildren().add(Login);
                btn.setAlignment(Pos.CENTER);
                btn.setSpacing(5);
                btn.setPadding(new Insets(5,0,0,100));
                container.getChildren().add(btn);
                Login.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        String un=username.getText();
                        String pw=passwordField.getText();
                        String usern="";
                        String passw="";
                        Connection con=null;
                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            String url="jdbc:mysql://localhost:3306/java_tuto";
                            String user="natnaeln4d";
                            String pwd="natty@123";
                            con = DriverManager.getConnection(url, user, pwd);
                            System.out.println(
                                    "Connection Established successfully");
                            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
//                            String sql="select username from students where=?";
                            String sql = "SELECT password FROM students WHERE name = " + un + ";";
//                            PreparedStatement ps=con.prepareStatement(sql);
//                            ps.setString(1,un);
                            ResultSet resultSet=st.executeQuery(sql);
                            if(resultSet.next()){
                                usern=resultSet.getString("name");
                                passw=resultSet.getString("password");
                                boolean check=passw.equals(pw);
                                if(check){
                                    System.out.println("login successfully"+usern);

                                }
                                else
                                    System.out.println("password incorrect");

                            }
                            else
                                System.out.println("No user");


                        }catch (ClassNotFoundException F){
                            System.out.println(F);
                        }
                        catch (SQLException E){
                            System.out.println(E);
                        }
                    }
                });
                save.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        Stage stage=new Stage();
                        try {
                            start(stage);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });



            }
        });
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String un=username.getText();
                String em=emailFiled.getText();
                String pw=passwordField.getText();
                String cmpw=compasswordField.getText();
                boolean check=pw.equals(cmpw);
                if (check) {
                    Connection con = null;
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        String url = "jdbc:mysql://localhost:3306/java_tuto";
                        String user = "natnaeln4d";
                        String pwd = "natty@123";
                        con = DriverManager.getConnection(url, user, pwd);
                        System.out.println(
                                "Connection Established successfully");
                        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        String select = "Select * from students";
                        ResultSet rt = st.executeQuery(select);
                        String sql = "INSERT INTO students(id, name,email,password) VALUES (?,?,?,?)";
                        PreparedStatement pstatement = con.prepareStatement(sql);
                        pstatement.setInt(1, 8);
                        pstatement.setString(2, un);
                        pstatement.setString(3, em);
                        pstatement.setString(4, pw);
                        int i = pstatement.executeUpdate();
//                    rt.updateInt("1",6);
//                     rt.updateString("2",un);
//                     rt.updateString("3",em);
//                     rt.updateString("4",pw);
//                     rt.insertRow();
                        if (i == 1) {
                            System.out.println("Student registered.");
                        } else
                            System.out.println("Student registration failed");
//
//
//                       while (rt.next()){
//                           System.out.println("name" + rt.getString("username\n"));
//                           System.out.println("email"+rt.getString("email"));
//                       }
//
//
//                    }
//

                        rt.close();

                    } catch (ClassNotFoundException E) {
                        System.out.println(E);
                    } catch (SQLException F) {
                        System.out.println(F);
                    }
                }else
                    System.out.println("password don't match");

            }
        });

    }


    public static void main(String[] args) {
        launch();
    }
}