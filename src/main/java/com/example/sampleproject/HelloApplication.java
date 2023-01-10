package com.example.sampleproject;

import com.almasb.fxgl.logging.FileOutput;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import  java.sql.*;
import java.sql.DatabaseMetaData;

import java.sql.SQLException;
import java.sql.DriverManager;

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
        container.setPadding(new Insets(0,0,10,30));
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
                container.setPadding(new Insets(0,0,10,30));
                group1.getChildren().add(container);


                HBox header=new HBox();
                Label headertitle=new Label("Login");
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


//

                            String sql = "SELECT password,username FROM user WHERE email ='"+un+"';";
                            System.out.println(sql);
                            PreparedStatement ps=con.prepareStatement(sql);
                            ResultSet resultSet=ps.executeQuery();

                            while (resultSet.next()){

                                    passw=resultSet.getString("password");
                                    boolean check=pw.equals(passw);
                                    if(check){
                                        System.out.println("login successfully");
                                        System.out.println("name:"+resultSet.getString("username"));
                                        System.out.println("password:"+resultSet.getString("password"));
                                        String name=resultSet.getString("username");
                                        username.setText("");
                                        passwordField.setText("");
                                         Stage stage1 = new Stage();
                                        handlefile(stage1,name);
                                        stage.close();

                                    }
                                    else
                                        System.out.println("password incorrect");

                            }



                        }catch (ClassNotFoundException F){
                            System.out.println(F);
                        }
                        catch (SQLException E){
                            System.out.println(E);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                save.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        stage.close();
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
                        String select = "Select * from user";
                        ResultSet rt = st.executeQuery(select);
                        String sql = "INSERT INTO user(username,email,password) VALUES (?,?,?)";
                        PreparedStatement pstatement = con.prepareStatement(sql);

                        pstatement.setString(1, un);
                        pstatement.setString(2, em);
                        pstatement.setString(3, pw);
                        String name=username.getText();
                        int i = pstatement.executeUpdate();
                        if (i == 1) {
                            System.out.println("Student registered.");
                            Stage stage1 = new Stage();
                            handlefile(stage1,name);
                            stage.close();

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
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }else
                    System.out.println("password don't match");

            }
        });

    }
public void handlefile(Stage stage,String name) throws IOException{
    Group group1=new Group();
    Scene Texteditor=new Scene(group1);
    stage.setScene(Texteditor);
    stage.setTitle("Login");
    stage.setHeight(500);
    stage.setWidth(400);
    stage.show();
    VBox container=new VBox();
    container.setSpacing(4);
    group1.getChildren().add(container);
    HBox nav=new HBox();
    Menu menu=new Menu("File");
    MenuItem m1=new MenuItem("open");
    MenuItem m2=new MenuItem("save");
    MenuItem m3=new MenuItem("saveAs");
    menu.getItems().add(m1);
    menu.getItems().add(m2);
    menu.getItems().add(m3);
    Menu menu1=new Menu("Directory");
    MenuItem m11=new MenuItem("Open Directory");
    MenuItem m22=new MenuItem("Transverse Directory");
    MenuItem m33=new MenuItem("Check IsFile || IsDirectory");
    menu1.getItems().add(m11);
    menu1.getItems().add(m22);
    menu1.getItems().add(m33);
    Menu menu2=new Menu("Student Information");
    MenuItem m111=new MenuItem("Register student");
    MenuItem m222=new MenuItem("All Students");
    MenuItem m333=new MenuItem("Single Student information");
    menu2.getItems().add(m111);
    menu2.getItems().add(m222);
    menu2.getItems().add(m333);
    MenuBar menuBar1=new MenuBar();
    menuBar1.getMenus().add(menu);
    menuBar1.getMenus().add(menu1);
    menuBar1.getMenus().add(menu2);
    Menu log=new Menu("Logout");
    MenuItem logut=new MenuItem("logout");
    log.getItems().add(logut);
    MenuBar menuBar2=new MenuBar();
    menuBar2.getMenus().add(log);
     nav.getChildren().add(menuBar1);
     nav.getChildren().add(menuBar2);
     nav.setSpacing(80);
     container.getChildren().add(nav);
     logut.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {

             Stage stage1=new Stage();
             try {

                 start(stage1);

             } catch (IOException e) {
                 throw new RuntimeException(e);
             }
             stage.close();
         }
     });
     m1.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             open(stage1);
             stage.close();


         }
     });
    m2.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            Stage stage1=new Stage();
            save(stage1);
            stage.close();


        }
    });
    m3.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            Stage stage1=new Stage();
            saveAS(stage1);
            stage.close();


        }
    });
    m11.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            Stage stage1=new Stage();
            openDirectory(stage1);
            stage.close();


        }
    });
    m22.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            Stage stage1=new Stage();
            transverse(stage1);
            stage.close();


        }
    });
    m33.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            Stage stage1=new Stage();
            ChecKFileDirectory(stage1);
            stage.close();


        }
    });
    m111.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            Stage stage1=new Stage();
            StudentRegisteration(stage1);
            stage.close();


        }
    });
    m222.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            Stage stage1=new Stage();
            displayallstudent(stage1);
            stage.close();


        }
    });
    m333.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            Stage stage1=new Stage();
            displaysinglestudent(stage1);
            stage.close();


        }
    });



    HBox header=new HBox();
    Label headertitle=new Label("Welcome:"+name);
    headertitle.setPadding(new Insets(150,100,10,80));

    headertitle.setTextFill(Color.web("#0076a3"));
    headertitle.setStyle("-fx-font-size:20px");
    header.setAlignment(Pos.CENTER);
    header.getChildren().add(headertitle);
    container.getChildren().add(header);





}
 public void open(Stage stage){
     Group group1=new Group();
     Scene Texteditor=new Scene(group1);
     stage.setScene(Texteditor);
     stage.setTitle("OPen File");
     stage.setHeight(500);
     stage.setWidth(400);
     stage.show();
     VBox container=new VBox();
     container.setSpacing(4);
     group1.getChildren().add(container);
     HBox nav=new HBox();
     Menu menu=new Menu("File");
     MenuItem m1=new MenuItem("open");
     MenuItem m2=new MenuItem("save");
     MenuItem m3=new MenuItem("saveAs");
     menu.getItems().add(m1);
     menu.getItems().add(m2);
     menu.getItems().add(m3);
     Menu menu1=new Menu("Directory");
     MenuItem m11=new MenuItem("Open Directory");
     MenuItem m22=new MenuItem("Transverse Directory");
     MenuItem m33=new MenuItem("Check IsFile || IsDirectory");
     menu1.getItems().add(m11);
     menu1.getItems().add(m22);
     menu1.getItems().add(m33);
     Menu menu2=new Menu("Student Information");
     MenuItem m111=new MenuItem("Register student");
     MenuItem m222=new MenuItem("All Students");
     MenuItem m333=new MenuItem("Single Student information");
     menu2.getItems().add(m111);
     menu2.getItems().add(m222);
     menu2.getItems().add(m333);
     MenuBar menuBar1=new MenuBar();
     menuBar1.getMenus().add(menu);
     menuBar1.getMenus().add(menu1);
     menuBar1.getMenus().add(menu2);
     Menu log=new Menu("Logout");
     MenuItem logut=new MenuItem("logout");
     log.getItems().add(logut);
     MenuBar menuBar2=new MenuBar();
     menuBar2.getMenus().add(log);
     nav.getChildren().add(menuBar1);
     nav.getChildren().add(menuBar2);
     nav.setSpacing(80);
     container.getChildren().add(nav);
     logut.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {

             Stage stage1=new Stage();
             try {

                 start(stage1);

             } catch (IOException e) {
                 throw new RuntimeException(e);
             }
             stage.close();
         }
     });
     m1.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             open(stage1);
             stage.close();


         }
     });
     m2.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             save(stage1);
             stage.close();


         }
     });
     m3.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             saveAS(stage1);
             stage.close();


         }
     });
     m11.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             openDirectory(stage1);
             stage.close();


         }
     });
     m22.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             transverse(stage1);
             stage.close();


         }
     });
     m33.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             ChecKFileDirectory(stage1);
             stage.close();


         }
     });
     m111.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             StudentRegisteration(stage1);
             stage.close();


         }
     });
     m222.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             displayallstudent(stage1);
             stage.close();


         }
     });
     m333.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             displaysinglestudent(stage1);
             stage.close();


         }
     });
     HBox header=new HBox();
     Button button=new Button("open file");
    button.setPadding(new Insets(150,100,10,80));

     button.setTextFill(Color.web("#0076a3"));
     button.setStyle("-fx-font-size:20px");
     header.setAlignment(Pos.CENTER);
     header.getChildren().add(button);
     container.getChildren().add(header);


   button.setOnAction(new EventHandler<ActionEvent>() {
       @Override
       public void handle(ActionEvent actionEvent) {

               FileChooser fileChooser=new FileChooser();
               FileChooser.ExtensionFilter extensionFilter=new FileChooser.ExtensionFilter("TXT file(*.txt)","*.txt");
               fileChooser.getExtensionFilters().add(extensionFilter);
               File file=fileChooser.showOpenDialog(stage);
               if(file.isFile()){
                   try {
                       FileInputStream fileInputStream=new FileInputStream(file);
                       BufferedInputStream bin =new BufferedInputStream(fileInputStream);

                       byte[] contents = new byte[1024];
                       int bytesRead = 0;
                       String content;
                       while ((bytesRead = bin.read(contents)) != -1) {
                           content = new String(contents, 0, bytesRead);
                           HBox header=new HBox();
                           Label headertitle=new Label(content+"\n");
                           headertitle.setPadding(new Insets(10,100,10,50));

                           headertitle.setTextFill(Color.web("#0076a3"));
                           headertitle.setStyle("-fx-font-size:20px");
                           header.setAlignment(Pos.CENTER);
                           header.getChildren().add(headertitle);
                           container.getChildren().add(header);
                           System.out.print(content);
                           bin.close();
                           fileInputStream.close();
                       }
                   } catch (FileNotFoundException e) {
                       System.out.println("File not found" + e);
                   } catch (IOException e) {
                       System.out.println("Exception while reading the file " + e);
                   }

               }

       }
   });

 }
 public void save(Stage stage){
     Group group1=new Group();
     Scene Texteditor=new Scene(group1);
     stage.setScene(Texteditor);
     stage.setTitle("Save File");
     stage.setHeight(500);
     stage.setWidth(400);
     stage.show();
     VBox container=new VBox();
     container.setSpacing(4);
     group1.getChildren().add(container);
     HBox nav=new HBox();
     Menu menu=new Menu("File");
     MenuItem m1=new MenuItem("open");
     MenuItem m2=new MenuItem("save");
     MenuItem m3=new MenuItem("saveAs");
     menu.getItems().add(m1);
     menu.getItems().add(m2);
     menu.getItems().add(m3);
     Menu menu1=new Menu("Directory");
     MenuItem m11=new MenuItem("Open Directory");
     MenuItem m22=new MenuItem("Transverse Directory");
     MenuItem m33=new MenuItem("Check IsFile || IsDirectory");
     menu1.getItems().add(m11);
     menu1.getItems().add(m22);
     menu1.getItems().add(m33);
     Menu menu2=new Menu("Student Information");
     MenuItem m111=new MenuItem("Register student");
     MenuItem m222=new MenuItem("All Students");
     MenuItem m333=new MenuItem("Single Student information");
     menu2.getItems().add(m111);
     menu2.getItems().add(m222);
     menu2.getItems().add(m333);
     MenuBar menuBar1=new MenuBar();
     menuBar1.getMenus().add(menu);
     menuBar1.getMenus().add(menu1);
     menuBar1.getMenus().add(menu2);
     Menu log=new Menu("Logout");
     MenuItem logut=new MenuItem("logout");
     log.getItems().add(logut);
     MenuBar menuBar2=new MenuBar();
     menuBar2.getMenus().add(log);
     nav.getChildren().add(menuBar1);
     nav.getChildren().add(menuBar2);
     nav.setSpacing(80);
     container.getChildren().add(nav);
     logut.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {

             Stage stage1=new Stage();
             try {

                 start(stage1);

             } catch (IOException e) {
                 throw new RuntimeException(e);
             }
             stage.close();
         }
     });
     m1.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             open(stage1);
             stage.close();


         }
     });
     m2.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             save(stage1);
             stage.close();


         }
     });
     m3.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             saveAS(stage1);
             stage.close();


         }
     });
     m11.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             openDirectory(stage1);
             stage.close();


         }
     });
     m22.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             transverse(stage1);
             stage.close();


         }
     });
     m33.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             ChecKFileDirectory(stage1);
             stage.close();


         }
     });
     m111.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             StudentRegisteration(stage1);
             stage.close();


         }
     });
     m222.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             displayallstudent(stage1);
             stage.close();


         }
     });
     m333.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             displaysinglestudent(stage1);
             stage.close();


         }
     });
     HBox header=new HBox();
     Label headertitle=new Label("Write paragraph why you are here!!");
     headertitle.setPadding(new Insets(20,100,10,50));
     headertitle.setTextFill(Color.web("#0076a3"));
     headertitle.setStyle("-fx-font-size:20px");
     header.setAlignment(Pos.CENTER);
     header.getChildren().add(headertitle);
     container.getChildren().add(header);
     HBox paragraphbox=new HBox();
     TextArea paragraph=new TextArea();
     paragraph.setMaxHeight(300);
     paragraph.setMaxWidth(398);
     paragraphbox.getChildren().add(paragraph);
     container.getChildren().add(paragraphbox);
     HBox btn=new HBox();
     Button save=new Button("save");
     btn.getChildren().add(save);
     btn.setAlignment(Pos.CENTER);
     btn.setPadding(new Insets(5,0,0,250));
     container.getChildren().add(btn);
     save.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             try{
                 String data=paragraph.getText();
                 FileChooser fileChooser=new FileChooser();
                 FileChooser.ExtensionFilter extensionFilter=new FileChooser.ExtensionFilter("TXT file(*.txt","*.txt");

                 fileChooser.getExtensionFilters().add(extensionFilter);
                 File file=fileChooser.showSaveDialog(stage);
                 OutputStream output  = new FileOutputStream(file);
                 Writer outputStreamWriter = new OutputStreamWriter(output, "utf-8");
                 outputStreamWriter.write(data);
                 outputStreamWriter.close();

             }
             catch (FileNotFoundException F)
             {
                 System.out.println(F);
             }catch (IOException E){
                 System.out.println(E);
             }
         }
     });


 }
 public void saveAS(Stage stage){
     Group group1=new Group();
     Scene Texteditor=new Scene(group1);
     stage.setScene(Texteditor);
     stage.setTitle("Login");
     stage.setHeight(500);
     stage.setWidth(400);
     stage.show();
     VBox container=new VBox();
     container.setSpacing(4);
     group1.getChildren().add(container);
     HBox nav=new HBox();
     Menu menu=new Menu("File");
     MenuItem m1=new MenuItem("open");
     MenuItem m2=new MenuItem("save");
     MenuItem m3=new MenuItem("saveAs");
     menu.getItems().add(m1);
     menu.getItems().add(m2);
     menu.getItems().add(m3);
     Menu menu1=new Menu("Directory");
     MenuItem m11=new MenuItem("Open Directory");
     MenuItem m22=new MenuItem("Transverse Directory");
     MenuItem m33=new MenuItem("Check IsFile || IsDirectory");
     menu1.getItems().add(m11);
     menu1.getItems().add(m22);
     menu1.getItems().add(m33);
     Menu menu2=new Menu("Student Information");
     MenuItem m111=new MenuItem("Register student");
     MenuItem m222=new MenuItem("All Students");
     MenuItem m333=new MenuItem("Single Student information");
     menu2.getItems().add(m111);
     menu2.getItems().add(m222);
     menu2.getItems().add(m333);
     MenuBar menuBar1=new MenuBar();
     menuBar1.getMenus().add(menu);
     menuBar1.getMenus().add(menu1);
     menuBar1.getMenus().add(menu2);
     Menu log=new Menu("Logout");
     MenuItem logut=new MenuItem("logout");
     log.getItems().add(logut);
     MenuBar menuBar2=new MenuBar();
     menuBar2.getMenus().add(log);
     nav.getChildren().add(menuBar1);
     nav.getChildren().add(menuBar2);
     nav.setSpacing(80);
     container.getChildren().add(nav);
     logut.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {

             Stage stage1=new Stage();
             try {

                 start(stage1);

             } catch (IOException e) {
                 throw new RuntimeException(e);
             }
             stage.close();
         }
     });
     m1.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             open(stage1);
             stage.close();


         }
     });
     m2.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             save(stage1);
             stage.close();


         }
     });
     m3.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             saveAS(stage1);
             stage.close();


         }
     });
     m11.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             openDirectory(stage1);
             stage.close();


         }
     });
     m22.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             transverse(stage1);
             stage.close();


         }
     });
     m33.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             ChecKFileDirectory(stage1);
             stage.close();


         }
     });
     m111.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             StudentRegisteration(stage1);
             stage.close();


         }
     });
     m222.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             displayallstudent(stage1);
             stage.close();


         }
     });
     m333.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             displaysinglestudent(stage1);
             stage.close();


         }
     });
 }
 public void openDirectory(Stage stage){
     Group group1=new Group();
     Scene Texteditor=new Scene(group1);
     stage.setScene(Texteditor);
     stage.setTitle("Open Directory");
     stage.setHeight(500);
     stage.setWidth(400);
     stage.show();
     VBox container=new VBox();
     container.setSpacing(4);
     group1.getChildren().add(container);
     HBox nav=new HBox();
     Menu menu=new Menu("File");
     MenuItem m1=new MenuItem("open");
     MenuItem m2=new MenuItem("save");
     MenuItem m3=new MenuItem("saveAs");
     menu.getItems().add(m1);
     menu.getItems().add(m2);
     menu.getItems().add(m3);
     Menu menu1=new Menu("Directory");
     MenuItem m11=new MenuItem("Open Directory");
     MenuItem m22=new MenuItem("Transverse Directory");
     MenuItem m33=new MenuItem("Check IsFile || IsDirectory");
     menu1.getItems().add(m11);
     menu1.getItems().add(m22);
     menu1.getItems().add(m33);
     Menu menu2=new Menu("Student Information");
     MenuItem m111=new MenuItem("Register student");
     MenuItem m222=new MenuItem("All Students");
     MenuItem m333=new MenuItem("Single Student information");
     menu2.getItems().add(m111);
     menu2.getItems().add(m222);
     menu2.getItems().add(m333);
     MenuBar menuBar1=new MenuBar();
     menuBar1.getMenus().add(menu);
     menuBar1.getMenus().add(menu1);
     menuBar1.getMenus().add(menu2);
     Menu log=new Menu("Logout");
     MenuItem logut=new MenuItem("logout");
     log.getItems().add(logut);
     MenuBar menuBar2=new MenuBar();
     menuBar2.getMenus().add(log);
     nav.getChildren().add(menuBar1);
     nav.getChildren().add(menuBar2);
     nav.setSpacing(80);
     container.getChildren().add(nav);
     logut.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {

             Stage stage1=new Stage();
             try {

                 start(stage1);

             } catch (IOException e) {
                 throw new RuntimeException(e);
             }
             stage.close();
         }
     });
     m1.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             open(stage1);
             stage.close();


         }
     });
     m2.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             save(stage1);
             stage.close();


         }
     });
     m3.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             saveAS(stage1);
             stage.close();


         }
     });
     m11.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             openDirectory(stage1);
             stage.close();


         }
     });
     m22.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             transverse(stage1);
             stage.close();


         }
     });
     m33.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             ChecKFileDirectory(stage1);
             stage.close();


         }
     });
     m111.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             StudentRegisteration(stage1);
             stage.close();


         }
     });
     m222.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             displayallstudent(stage1);
             stage.close();


         }
     });
     m333.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             displaysinglestudent(stage1);
             stage.close();


         }
     });


     HBox header=new HBox();
     Button button=new Button("open Directory");
     button.setPadding(new Insets(150,100,10,100));

     button.setTextFill(Color.web("#0076a3"));
     button.setStyle("-fx-font-size:20px"+
     "-fx-background-color:red");
     header.setAlignment(Pos.CENTER);
     header.getChildren().add(button);
     container.getChildren().add(header);


     button.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             DirectoryChooser directoryChooser=new DirectoryChooser();
             File file=directoryChooser.showDialog(stage);
             if(file.isDirectory()){

                    File[] files=file.listFiles();

                        for (File f : files) {
                            String data = f.getName();
                            System.out.println(f.getName());
                            HBox header = new HBox();
                            Label headertitle = new Label(data+"\n");
                            headertitle.setPadding(new Insets(10, 100, 10, 50));
                            headertitle.setTextFill(Color.web("#0076a3"));
                            headertitle.setStyle("-fx-font-size:20px");
                            header.setAlignment(Pos.CENTER);
                            header.getChildren().add(headertitle);
                            container.getChildren().add(header);
                    }
             }
             else {
                 HBox header = new HBox();
                 Label headertitle = new Label("Isn't Directory!!!");
                 headertitle.setPadding(new Insets(10, 100, 10, 50));

                 headertitle.setTextFill(Color.web("#0076a3"));
                 headertitle.setStyle("-fx-font-size:20px");
                 header.setAlignment(Pos.CENTER);
                 header.getChildren().add(headertitle);
                 container.getChildren().add(header);
             }


         }
     });



 }
 public void transverse(Stage stage){
     Group group1=new Group();
     Scene Texteditor=new Scene(group1);
     stage.setScene(Texteditor);
     stage.setTitle("Transverse");
     stage.setHeight(500);
     stage.setWidth(400);
     stage.show();
     VBox container=new VBox();
     container.setSpacing(4);
     group1.getChildren().add(container);
     HBox nav=new HBox();
     Menu menu=new Menu("File");
     MenuItem m1=new MenuItem("open");
     MenuItem m2=new MenuItem("save");
     MenuItem m3=new MenuItem("saveAs");
     menu.getItems().add(m1);
     menu.getItems().add(m2);
     menu.getItems().add(m3);
     Menu menu1=new Menu("Directory");
     MenuItem m11=new MenuItem("Open Directory");
     MenuItem m22=new MenuItem("Transverse Directory");
     MenuItem m33=new MenuItem("Check IsFile || IsDirectory");
     menu1.getItems().add(m11);
     menu1.getItems().add(m22);
     menu1.getItems().add(m33);
     Menu menu2=new Menu("Student Information");
     MenuItem m111=new MenuItem("Register student");
     MenuItem m222=new MenuItem("All Students");
     MenuItem m333=new MenuItem("Single Student information");
     menu2.getItems().add(m111);
     menu2.getItems().add(m222);
     menu2.getItems().add(m333);
     MenuBar menuBar1=new MenuBar();
     menuBar1.getMenus().add(menu);
     menuBar1.getMenus().add(menu1);
     menuBar1.getMenus().add(menu2);
     Menu log=new Menu("Logout");
     MenuItem logut=new MenuItem("logout");
     log.getItems().add(logut);
     MenuBar menuBar2=new MenuBar();
     menuBar2.getMenus().add(log);
     nav.getChildren().add(menuBar1);
     nav.getChildren().add(menuBar2);
     nav.setSpacing(80);
     container.getChildren().add(nav);
     logut.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {

             Stage stage1=new Stage();
             try {

                 start(stage1);

             } catch (IOException e) {
                 throw new RuntimeException(e);
             }
             stage.close();
         }
     });
     m1.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             open(stage1);
             stage.close();


         }
     });
     m2.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             save(stage1);
             stage.close();


         }
     });
     m3.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             saveAS(stage1);
             stage.close();


         }
     });
     m11.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             openDirectory(stage1);
             stage.close();


         }
     });
     m22.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             transverse(stage1);
             stage.close();


         }
     });
     m33.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             ChecKFileDirectory(stage1);
             stage.close();


         }
     });
     m111.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             StudentRegisteration(stage1);
             stage.close();


         }
     });
     m222.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             displayallstudent(stage1);
             stage.close();


         }
     });
     m333.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             displaysinglestudent(stage1);
             stage.close();


         }
     });
     HBox header=new HBox();
     Button button=new Button("Transverse Directory");
     button.setPadding(new Insets(150,100,10,100));

     button.setTextFill(Color.web("#0076a3"));
     button.setStyle("-fx-font-size:20px"+
             "-fx-background-color:red");
     header.setAlignment(Pos.CENTER);
     header.getChildren().add(button);
     container.getChildren().add(header);


     button.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             DirectoryChooser directoryChooser=new DirectoryChooser();
             File file=directoryChooser.showDialog(stage);
             if(file.isDirectory()){

                 File[] files=file.listFiles();

                 for (File f : files) {
                     String data = f.getName();
                     System.out.println(f.getName());
                     HBox header = new HBox();
                     Label headertitle = new Label(data+"\n");
                     headertitle.setPadding(new Insets(10, 100, 10, 50));
                     headertitle.setTextFill(Color.web("#0076a3"));
                     headertitle.setStyle("-fx-font-size:20px");
                     header.setAlignment(Pos.CENTER);
                     header.getChildren().add(headertitle);
                     container.getChildren().add(header);
                     if(f.isDirectory()) {
                         File[] files1 = f.listFiles();
                         for (File f2 : files1) {

                             String data2 = f2.getName();
                             System.out.println(f.getName());
                             HBox header1 = new HBox();
                             Label headertitle1 = new Label("\n"+data2);
                             headertitle.setPadding(new Insets(10, 100, 10, 0));
                             headertitle.setTextFill(Color.web("#0076a3"));
                             headertitle.setStyle("-fx-font-size:20px");
                             header.setAlignment(Pos.CENTER);
                             header.getChildren().add(headertitle1);
                             container.getChildren().add(header1);
                             try {
                                 String path = f2.getPath();
                                 File file1 = new File(path);
                                 if (file1.isFile()) {
                                     FileInputStream inputStream = new FileInputStream(file1);
                                     BufferedInputStream bin = new BufferedInputStream(inputStream);
                                     byte[] contents = new byte[1024];
                                     int bytesRead = 0;
                                     String content;
                                     while ((bytesRead = bin.read(contents)) != -1) {
                                         content = new String(contents, 0, bytesRead);
                                         HBox header2 = new HBox();
                                         Label headertitle2 = new Label( "\n"+content);
                                         headertitle.setPadding(new Insets(10, 100, 10, 0));
                                         headertitle.setTextFill(Color.web("#0076a3"));
                                         headertitle.setStyle("-fx-font-size:20px");
                                         header.setAlignment(Pos.CENTER);
                                         header.getChildren().add(headertitle2);
                                         container.getChildren().add(header2);
                                         System.out.print(content);
                                         bin.close();
                                         inputStream.close();
                                     }
                                 }

                             } catch (FileNotFoundException F) {
                                 System.out.println(F);
                             } catch (IOException E) {
                                 System.out.println(E);
                             }
                         }
                     }
                     else{
                         System.out.println("no other directory");
                     }


                 }



             }
             else {
                 HBox header = new HBox();
                 Label headertitle = new Label("Isn't Directory!!!");
                 headertitle.setPadding(new Insets(10, 100, 10, 50));

                 headertitle.setTextFill(Color.web("#0076a3"));
                 headertitle.setStyle("-fx-font-size:20px");
                 header.setAlignment(Pos.CENTER);
                 header.getChildren().add(headertitle);
                 container.getChildren().add(header);
             }


         }
     });


 }
 public void ChecKFileDirectory(Stage stage){
     Group group1=new Group();
     Scene Texteditor=new Scene(group1);
     stage.setScene(Texteditor);
     stage.setTitle("Check IsFile || IsDirectory");
     stage.setHeight(500);
     stage.setWidth(400);
     stage.show();
     VBox container=new VBox();
     container.setSpacing(4);
     group1.getChildren().add(container);
     HBox nav=new HBox();
     Menu menu=new Menu("File");
     MenuItem m1=new MenuItem("open");
     MenuItem m2=new MenuItem("save");
     MenuItem m3=new MenuItem("saveAs");
     menu.getItems().add(m1);
     menu.getItems().add(m2);
     menu.getItems().add(m3);
     Menu menu1=new Menu("Directory");
     MenuItem m11=new MenuItem("Open Directory");
     MenuItem m22=new MenuItem("Transverse Directory");
     MenuItem m33=new MenuItem("Check IsFile || IsDirectory");
     menu1.getItems().add(m11);
     menu1.getItems().add(m22);
     menu1.getItems().add(m33);
     Menu menu2=new Menu("Student Information");
     MenuItem m111=new MenuItem("Register student");
     MenuItem m222=new MenuItem("All Students");
     MenuItem m333=new MenuItem("Single Student information");
     menu2.getItems().add(m111);
     menu2.getItems().add(m222);
     menu2.getItems().add(m333);
     MenuBar menuBar1=new MenuBar();
     menuBar1.getMenus().add(menu);
     menuBar1.getMenus().add(menu1);
     menuBar1.getMenus().add(menu2);
     Menu log=new Menu("Logout");
     MenuItem logut=new MenuItem("logout");
     log.getItems().add(logut);
     MenuBar menuBar2=new MenuBar();
     menuBar2.getMenus().add(log);
     nav.getChildren().add(menuBar1);
     nav.getChildren().add(menuBar2);
     nav.setSpacing(80);
     container.getChildren().add(nav);
     logut.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {

             Stage stage1=new Stage();
             try {

                 start(stage1);

             } catch (IOException e) {
                 throw new RuntimeException(e);
             }
             stage.close();
         }
     });
     m1.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             open(stage1);
             stage.close();


         }
     });
     m2.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             save(stage1);
             stage.close();


         }
     });
     m3.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             saveAS(stage1);
             stage.close();


         }
     });
     m11.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             openDirectory(stage1);
             stage.close();


         }
     });
     m22.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             transverse(stage1);
             stage.close();


         }
     });
     m33.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             ChecKFileDirectory(stage1);
             stage.close();


         }
     });
     m111.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             StudentRegisteration(stage1);
             stage.close();


         }
     });
     m222.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             displayallstudent(stage1);
             stage.close();


         }
     });
     m333.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             Stage stage1=new Stage();
             displaysinglestudent(stage1);
             stage.close();


         }
     });

     HBox header=new HBox();
     Button button=new Button("Check Directory || File");
     button.setPadding(new Insets(150,100,10,100));

     button.setTextFill(Color.web("#0076a3"));
     button.setStyle("-fx-font-size:20px"+
             "-fx-background-color:red");
     header.setAlignment(Pos.CENTER);
     header.getChildren().add(button);
     container.getChildren().add(header);


     button.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent actionEvent) {
             DirectoryChooser directoryChooser=new DirectoryChooser();
             FileChooser fileChooser=new FileChooser();
             File file1=directoryChooser.showDialog(stage);
             File file2=fileChooser.showOpenDialog(stage);
             if(file1.isDirectory()){
                 HBox header = new HBox();
                 Label headertitle = new Label("Is Directory!!!");
                 headertitle.setPadding(new Insets(10, 100, 10, 50));

                 headertitle.setTextFill(Color.web("#0076a3"));
                 headertitle.setStyle("-fx-font-size:20px");
                 header.setAlignment(Pos.CENTER);
                 header.getChildren().add(headertitle);
                 container.getChildren().add(header);


             } else if (file2.isFile()) {

                 HBox header = new HBox();
                 Label headertitle = new Label("Is File!!!");
                 headertitle.setPadding(new Insets(10, 100, 10, 50));

                 headertitle.setTextFill(Color.web("#0076a3"));
                 headertitle.setStyle("-fx-font-size:20px");
                 header.setAlignment(Pos.CENTER);
                 header.getChildren().add(headertitle);
                 container.getChildren().add(header);

             } else {
                 HBox header = new HBox();
                 Label headertitle = new Label("unknown!!!");
                 headertitle.setPadding(new Insets(10, 100, 10, 50));

                 headertitle.setTextFill(Color.web("#0076a3"));
                 headertitle.setStyle("-fx-font-size:20px");
                 header.setAlignment(Pos.CENTER);
                 header.getChildren().add(headertitle);
                 container.getChildren().add(header);
             }



         }
     });


 }
    public void StudentRegisteration(Stage stage){
        Group group1=new Group();
        Scene Texteditor=new Scene(group1);
        stage.setScene(Texteditor);
        stage.setTitle("Register student");
        stage.setHeight(500);
        stage.setWidth(400);
        stage.show();
        VBox container=new VBox();
        container.setSpacing(4);
        group1.getChildren().add(container);
        HBox nav=new HBox();
        Menu menu=new Menu("File");
        MenuItem m1=new MenuItem("open");
        MenuItem m2=new MenuItem("save");
        MenuItem m3=new MenuItem("saveAs");
        menu.getItems().add(m1);
        menu.getItems().add(m2);
        menu.getItems().add(m3);
        Menu menu1=new Menu("Directory");
        MenuItem m11=new MenuItem("Open Directory");
        MenuItem m22=new MenuItem("Transverse Directory");
        MenuItem m33=new MenuItem("Check IsFile || IsDirectory");
        menu1.getItems().add(m11);
        menu1.getItems().add(m22);
        menu1.getItems().add(m33);
        Menu menu2=new Menu("Student Information");
        MenuItem m111=new MenuItem("Register student");
        MenuItem m222=new MenuItem("All Students");
        MenuItem m333=new MenuItem("Single Student information");
        menu2.getItems().add(m111);
        menu2.getItems().add(m222);
        menu2.getItems().add(m333);
        MenuBar menuBar1=new MenuBar();
        menuBar1.getMenus().add(menu);
        menuBar1.getMenus().add(menu1);
        menuBar1.getMenus().add(menu2);
        Menu log=new Menu("Logout");
        MenuItem logut=new MenuItem("logout");
        log.getItems().add(logut);
        MenuBar menuBar2=new MenuBar();
        menuBar2.getMenus().add(log);
        nav.getChildren().add(menuBar1);
        nav.getChildren().add(menuBar2);
        nav.setSpacing(80);
        container.getChildren().add(nav);
        logut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                Stage stage1=new Stage();
                try {

                    start(stage1);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                stage.close();
            }
        });
        m1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage1=new Stage();
                open(stage1);
                stage.close();


            }
        });
        m2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage1=new Stage();
                save(stage1);
                stage.close();


            }
        });
        m3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage1=new Stage();
                saveAS(stage1);
                stage.close();


            }
        });
        m11.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage1=new Stage();
                openDirectory(stage1);
                stage.close();


            }
        });
        m22.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage1=new Stage();
                transverse(stage1);
                stage.close();


            }
        });
        m33.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage1=new Stage();
                ChecKFileDirectory(stage1);
                stage.close();


            }
        });
        m111.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage1=new Stage();
                StudentRegisteration(stage1);
                stage.close();


            }
        });
        m222.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage1=new Stage();
                displayallstudent(stage1);
                stage.close();


            }
        });
        m333.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage1=new Stage();
                displaysinglestudent(stage1);
                stage.close();


            }
        });
        GridPane gridPane=new GridPane();
         gridPane.setAlignment(Pos.CENTER);
//         gridPane.setPadding(new Insets(50));
        gridPane.setHgap(-200);
        gridPane.setVgap(5);

        container.getChildren().add(gridPane);

        HBox header=new HBox();
        Label headertitle=new Label("Register student");
        headertitle.setPadding(new Insets(30,100,10,60));

        headertitle.setTextFill(Color.web("#0076a3"));
        headertitle.setStyle("-fx-font-size:20px");
        header.setAlignment(Pos.CENTER);
        header.getChildren().add(headertitle);
      gridPane.add(headertitle,0,0);



        Label User=new Label("First Name");
        TextField firstname=new TextField();

         gridPane.add(User,0,1);
         gridPane.add(firstname,1,1);


        Label last=new Label("Last name");
        TextField lastname=new TextField();
        gridPane.add(last,0,2);
        gridPane.add(lastname,1,2);




        Label Gender=new Label("Gender");
        TextField sex=new TextField();
        gridPane.add(Gender,0,3);
        gridPane.add(sex,1,3);





        Label Field=new Label("Department");
        TextField field=new TextField();
       gridPane.add(Field,0,4);
       gridPane.add(field,1,4);



        Label Year=new Label("Year");
        TextField year=new TextField();
        gridPane.add(Year,0,5);
        gridPane.add(year,1,5);



        Label ID=new Label("id");
        TextField id=new TextField();
        gridPane.add(ID,0,6);
        gridPane.add(id,1,6);



        HBox btn=new HBox();
        Button save=new Button("Save");
        save.setStyle("-fx-color:#0076a3");
        Button Login=new Button("cancel");
        btn.getChildren().add(save);
        btn.getChildren().add(Login);
        btn.setAlignment(Pos.CENTER);
        btn.setSpacing(5);
        btn.setPadding(new Insets(5,0,0,150));
        container.getChildren().add(btn);

        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {


                    Connection con = null;
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        String url = "jdbc:mysql://localhost:3306/java_tuto";
                        String user = "natnaeln4d";
                        String pwd = "natty@123";
                        String fn=firstname.getText();
                        String ln=lastname.getText();
                        String s=sex.getText();
                        String f=field.getText();
                        String y=year.getText();
                        String i1=id.getText();
                        con = DriverManager.getConnection(url, user, pwd);
                        System.out.println(
                                "Connection Established successfully");
                        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        String select = "Select * from user";
                        ResultSet rt = st.executeQuery(select);
                        String sql = "INSERT INTO students(firstname,lastname,sex,field,year,id) VALUES (?,?,?,?,?,?)";
                        PreparedStatement pstatement = con.prepareStatement(sql);

                        pstatement.setString(1, fn);
                        pstatement.setString(2, ln);
                        pstatement.setString(3, s);
                        pstatement.setString(4,f);
                        pstatement.setString(5,y);
                        pstatement.setString(6,i1);


                        int i = pstatement.executeUpdate();
                        if (i == 1) {
                            System.out.println("Student registered.");
                            HBox header = new HBox();
                            Label headertitle = new Label("Student registered!!");
                            headertitle.setPadding(new Insets(10, 100, 10, 50));

                            headertitle.setTextFill(Color.web("#0076a3"));
                            headertitle.setStyle("-fx-font-size:20px");
                            header.setAlignment(Pos.CENTER);
                            header.getChildren().add(headertitle);
                            container.getChildren().add(header);


                        } else
                            System.out.println("Student registration failed");

                        rt.close();


                    } catch (SQLException F) {
                        System.out.println(F);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }



        });


    }
    public void displayallstudent(Stage stage){
        Group group1=new Group();
        Scene Texteditor=new Scene(group1);
        stage.setScene(Texteditor);
        stage.setTitle("Login");
        stage.setHeight(600);
        stage.setWidth(480);
        stage.show();
        VBox container=new VBox();
        container.setSpacing(4);
        group1.getChildren().add(container);
        HBox nav=new HBox();
        Menu menu=new Menu("File");
        MenuItem m1=new MenuItem("open");
        MenuItem m2=new MenuItem("save");
        MenuItem m3=new MenuItem("saveAs");
        menu.getItems().add(m1);
        menu.getItems().add(m2);
        menu.getItems().add(m3);
        Menu menu1=new Menu("Directory");
        MenuItem m11=new MenuItem("Open Directory");
        MenuItem m22=new MenuItem("Transverse Directory");
        MenuItem m33=new MenuItem("Check IsFile || IsDirectory");
        menu1.getItems().add(m11);
        menu1.getItems().add(m22);
        menu1.getItems().add(m33);
        Menu menu2=new Menu("Student Information");
        MenuItem m111=new MenuItem("Register student");
        MenuItem m222=new MenuItem("All Students");
        MenuItem m333=new MenuItem("Single Student information");
        menu2.getItems().add(m111);
        menu2.getItems().add(m222);
        menu2.getItems().add(m333);
        MenuBar menuBar1=new MenuBar();
        menuBar1.getMenus().add(menu);
        menuBar1.getMenus().add(menu1);
        menuBar1.getMenus().add(menu2);
        Menu log=new Menu("Logout");
        MenuItem logut=new MenuItem("logout");
        log.getItems().add(logut);
        MenuBar menuBar2=new MenuBar();
        menuBar2.getMenus().add(log);
        nav.getChildren().add(menuBar1);
        nav.getChildren().add(menuBar2);
        nav.setSpacing(148);
        container.getChildren().add(nav);
        logut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                Stage stage1=new Stage();
                try {

                    start(stage1);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                stage.close();
            }
        });
        m1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage1=new Stage();
                open(stage1);
                stage.close();


            }
        });
        m2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage1=new Stage();
                save(stage1);
                stage.close();


            }
        });
        m3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage1=new Stage();
                saveAS(stage1);
                stage.close();


            }
        });
        m11.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage1=new Stage();
                openDirectory(stage1);
                stage.close();


            }
        });
        m22.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage1=new Stage();
                transverse(stage1);
                stage.close();


            }
        });
        m33.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage1=new Stage();
                ChecKFileDirectory(stage1);
                stage.close();


            }
        });
        m111.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage1=new Stage();
                StudentRegisteration(stage1);
                stage.close();


            }
        });
        m222.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage1=new Stage();
                displayallstudent(stage1);
                stage.close();


            }
        });
        m333.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage1=new Stage();
                displaysinglestudent(stage1);
                stage.close();


            }
        });

        GridPane gridPane=new GridPane();
        gridPane.setAlignment(Pos.CENTER);
//         gridPane.setPadding(new Insets(50));
        gridPane.setHgap(-200);
        gridPane.setVgap(5);

        container.getChildren().add(gridPane);

        HBox header=new HBox();
        Label headertitle=new Label("Students");
        headertitle.setPadding(new Insets(30,100,10,60));



        headertitle.setTextFill(Color.web("#0076a3"));
        headertitle.setStyle("-fx-font-size:20px");
        header.setAlignment(Pos.CENTER);
        header.getChildren().add(headertitle);
        gridPane.add(headertitle,0,0);

//        TableView tableView=new TableView<>();
//        tableView.setEditable(true);
//        TableColumn ID = new TableColumn("ID");
//        TableColumn firstNameCol = new TableColumn("First Name");
//        TableColumn lastNameCol = new TableColumn("Last Name");
//        TableColumn Gender = new TableColumn("Sex");
//        TableColumn field= new TableColumn("Department");
//        TableColumn Year = new TableColumn("Year");
//        tableView.getColumns().addAll(ID,firstNameCol,lastNameCol,Gender,field,Year);

         GridPane gridPane1=new GridPane();
         container.getChildren().add(gridPane1);

         HBox tableView=new HBox();
         Label ID=new Label("Id");
        ID.setTextFill(new LinearGradient(
                0, 0, 1, 1, true,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("#81c483")),
                new Stop(1, Color.web("#fcc200")))
        );
         Label FirstName=new Label("First Name");
         FirstName.setTextFill(new LinearGradient(
                 0, 0, 1, 1, true,
                 CycleMethod.NO_CYCLE,
                 new Stop(0, Color.web("#81c483")),
                 new Stop(1, Color.web("#fcc200")))
         );
         Label LastName=new Label("Last Name");
         LastName.setTextFill(new LinearGradient(
                 0, 0, 1, 1, true,
                 CycleMethod.NO_CYCLE,
                 new Stop(0, Color.web("#81c483")),
                 new Stop(1, Color.web("#fcc200")))
         );
        Label Gender=new Label("Sex");
        Gender.setTextFill(new LinearGradient(
                0, 0, 1, 1, true,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("#81c483")),
                new Stop(1, Color.web("#fcc200")))
        );
        Label Field=new Label("Department");
        Field.setTextFill(new LinearGradient(
                0, 0, 1, 1, true,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("#81c483")),
                new Stop(1, Color.web("#fcc200")))
        );
        Label Year=new Label("Year");
        Year.setTextFill(new LinearGradient(
                0, 0, 1, 1, true,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("#81c483")),
                new Stop(1, Color.web("#fcc200")))
        );

        tableView.getChildren().add(ID);
        tableView.getChildren().add(FirstName);
        tableView.getChildren().add(LastName);
        tableView.getChildren().add(Gender);
        tableView.getChildren().add(Field);
        tableView.getChildren().add(Year);
        tableView.setPadding(new Insets(10));
        tableView.setSpacing(40);
        tableView.setStyle("-fx-background-color:grey;");
        gridPane1.add(tableView,0,0);



        try {
            Connection con=null;
            forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/java_tuto";
            String user = "natnaeln4d";
            String pwd = "natty@123";
            con=DriverManager.getConnection(url,user,pwd);
            Statement statement=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql="select * from Students";
            ResultSet rt=statement.executeQuery(sql);
            while (rt.next()){
            String id=rt.getString("id");
            String firstname=rt.getString("firstname");
            String lastname=rt.getString("lastname");
            String sex=rt.getString("sex");
            String field1=rt.getString("field");
            String year=rt.getString("year");
                HBox tableView1=new HBox();

                Label ID1=new Label(id);
                Label FirstName1=new Label(firstname);
                Label LastName1=new Label(lastname);
                Label Gender1=new Label(sex);
                Label Field1=new Label(field1);
                Label Year1=new Label(year);
                tableView1.getChildren().add(ID1);
                tableView1.getChildren().add(FirstName1);
                tableView1.getChildren().add(LastName1);
                tableView1.getChildren().add(Gender1);
                tableView1.getChildren().add(Field1);
                tableView1.getChildren().add(Year1);
                tableView1.setPadding(new Insets(10));
                tableView1.setSpacing(40);
              container.getChildren().add(tableView1);






            }

        }catch (SQLException e){
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        container.getChildren().add(tableView);


    }
    public void displaysinglestudent(Stage stage){
        Group group1=new Group();
        Scene Texteditor=new Scene(group1);
        stage.setScene(Texteditor);
        stage.setTitle("Login");
        stage.setHeight(500);
        stage.setWidth(400);
        stage.show();
        VBox container=new VBox();
        container.setSpacing(4);
        group1.getChildren().add(container);
        HBox nav=new HBox();
        Menu menu=new Menu("File");
        MenuItem m1=new MenuItem("open");
        MenuItem m2=new MenuItem("save");
        MenuItem m3=new MenuItem("saveAs");
        menu.getItems().add(m1);
        menu.getItems().add(m2);
        menu.getItems().add(m3);
        Menu menu1=new Menu("Directory");
        MenuItem m11=new MenuItem("Open Directory");
        MenuItem m22=new MenuItem("Transverse Directory");
        MenuItem m33=new MenuItem("Check IsFile || IsDirectory");
        menu1.getItems().add(m11);
        menu1.getItems().add(m22);
        menu1.getItems().add(m33);
        Menu menu2=new Menu("Student Information");
        MenuItem m111=new MenuItem("Register student");
        MenuItem m222=new MenuItem("All Students");
        MenuItem m333=new MenuItem("Single Student information");
        menu2.getItems().add(m111);
        menu2.getItems().add(m222);
        menu2.getItems().add(m333);
        MenuBar menuBar1=new MenuBar();
        menuBar1.getMenus().add(menu);
        menuBar1.getMenus().add(menu1);
        menuBar1.getMenus().add(menu2);
        Menu log=new Menu("Logout");
        MenuItem logut=new MenuItem("logout");
        log.getItems().add(logut);
        MenuBar menuBar2=new MenuBar();
        menuBar2.getMenus().add(log);
        nav.getChildren().add(menuBar1);
        nav.getChildren().add(menuBar2);
        nav.setSpacing(80);
        container.getChildren().add(nav);
        logut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                Stage stage1=new Stage();
                try {

                    start(stage1);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                stage.close();
            }
        });
        m1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage1=new Stage();
                open(stage1);
                stage.close();


            }
        });
        m2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage1=new Stage();
                save(stage1);
                stage.close();


            }
        });
        m3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage1=new Stage();
                saveAS(stage1);
                stage.close();


            }
        });
        m11.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage1=new Stage();
                openDirectory(stage1);
                stage.close();


            }
        });
        m22.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage1=new Stage();
                transverse(stage1);
                stage.close();


            }
        });
        m33.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage1=new Stage();
                ChecKFileDirectory(stage1);
                stage.close();


            }
        });
        m111.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage1=new Stage();
                StudentRegisteration(stage1);
                stage.close();


            }
        });
        m222.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage1=new Stage();
                displayallstudent(stage1);
                stage.close();


            }
        });
        m333.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage1=new Stage();
                displaysinglestudent(stage1);
                stage.close();


            }
        });

    }

    public static void main(String[] args) {
        launch();
    }
}
