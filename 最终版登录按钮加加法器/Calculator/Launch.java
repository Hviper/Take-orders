package Calculator;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class Launch extends Application {

    public static void main(String[] args) {
        Application.launch(Launch.class,args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Label l_name = new Label();
        l_name.setText("Account");
        Label l_password = new Label("password");
        TextField t_name = new TextField();
        PasswordField p_password = new PasswordField();

        Button login = new Button("Landing");
        Button clear = new Button("reset");



        //网格布局
        GridPane gr = new GridPane();
        gr.setStyle("-fx-background-color: deepskyblue");
        gr.add(l_name,0,0);
        gr.add(t_name,1,0);
        gr.add(l_password,0,1);
        gr.add(p_password,1,1);
        gr.add(clear,0,2);
        gr.add(login,1,2);
        //全部居中
        gr.setAlignment(Pos.CENTER);
        //水平间距
        gr.setHgap(5);
        //垂直间距
        gr.setVgap(15);
        //设置登录左边外边距
        GridPane.setMargin(login,new Insets(0,0,0,120));
        Scene s= new Scene(gr);
        primaryStage.setScene(s);
        primaryStage.setTitle("Landing");
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.setResizable(false);
        primaryStage.show();



        //重置按钮点击事件
        clear.setOnAction(e->{
            t_name.setText("");
            p_password.setText("");
        });
        //登录按钮点击事件
        login.setOnAction(e->{
            String name = t_name.getText();
            String pasword = p_password.getText();
            if("admin".equals(name)&&"admin".equals(pasword)){
                System.out.println("Landing success");
                //关闭当前场景,并开启应用管理的场景
                primaryStage.close();
                Main ac = new Main();
                //开启新场景
                try {
                    ac.start(primaryStage);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }else{
                System.out.println("Landing Fail");
            }

        });


    }

}

