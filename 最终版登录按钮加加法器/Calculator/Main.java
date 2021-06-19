package Calculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		// 获取带图片的按钮
		Button bt0 = new Button("", new ImageView(new Image("images/0.png")));
		Button bt1 = new Button("", new ImageView(new Image("images/1.png")));
		Button bt2 = new Button("", new ImageView(new Image("images/2.png")));
		Button bt3 = new Button("", new ImageView(new Image("images/3.png")));
		Button bt4 = new Button("", new ImageView(new Image("images/4.png")));
		Button bt5 = new Button("", new ImageView(new Image("images/5.png")));
		Button bt6 = new Button("", new ImageView(new Image("images/6.png")));
		Button bt7 = new Button("", new ImageView(new Image("images/7.png")));
		Button bt8 = new Button("", new ImageView(new Image("images/8.png")));
		Button bt9 = new Button("", new ImageView(new Image("images/9.png")));
		Button btAdd = new Button("", new ImageView(new Image("images/ADD.png")));
		Button btMinus = new Button("", new ImageView(new Image("images/MINUS.png")));
		Button btMultiply = new Button("", new ImageView(new Image("images/MULTIPLY.png")));
		Button btDivide = new Button("", new ImageView(new Image("images/DIVIDE.png")));
		Button btEqual = new Button("", new ImageView(new Image("images/EQUAL.png")));
		Button btLeft = new Button("", new ImageView(new Image("images/LEFT_PAREN.png")));
		Button btRight = new Button("", new ImageView(new Image("images/RIGHT_PAREN.png")));
		Button btPoint = new Button("", new ImageView(new Image("images/POINT.png")));
		Button btClear = new Button("", new ImageView(new Image("images/CLEAR.png")));
		Button btBack = new Button("", new ImageView(new Image("images/BACK.png")));

		// 因为BorderPane最多只能有三水平行，所以用一个BorderPane作为主面板
		// 再用两个BorderPane嵌入到主面板中，这两个BorderPane正好可以装满所有要用到的子节点

		BorderPane pane = new BorderPane(); // 主面板，用来放pane1，pane2
		BorderPane pane1 = new BorderPane(); // 放琐碎的Node的pane1
		BorderPane pane2 = new BorderPane(); // 放琐碎的Node的pane2
		// Hbox1 Hbox2 Hbox3放到pane1中
		HBox hBox1 = new HBox(5);
		HBox hBox2 = new HBox(5);
		HBox hBox3 = new HBox(5);
		// Hbox4,5,6放到pane2中
		HBox hBox4 = new HBox(5);
		HBox hBox5 = new HBox(5);
		HBox hBox6 = new HBox(5);
		// 显示输入的文本框
		TextField showExpression = new TextField();
		showExpression.setPrefSize(280, 40);
		/*
		 * 下面开始放pane1中的节点，
		 */
		hBox1.getChildren().add(showExpression);
		hBox2.getChildren().addAll(btClear, btBack, btPoint, btDivide);
		hBox3.getChildren().addAll(bt7, bt8, bt9, btMultiply);
		hBox1.setPadding(new Insets(15, 15, 0, 27));
		hBox2.setPadding(new Insets(15, 15, 0, 30));
		hBox3.setPadding(new Insets(15, 15, 5, 30));
		pane1.setTop(hBox1);
		pane1.setCenter(hBox2);
		pane1.setBottom(hBox3);
		// 接着把pane1放到pane的top中
		pane.setTop(pane1);
		/*
		 * 下面开始放pane2中的节点
		 */

		// 运行过程中发现左右括号的图片太小了，不太美观，调整一下
		btLeft.setPadding(new Insets(11, 11, 11, 5));
		btRight.setPadding(new Insets(11, 11, 11, 5));

		hBox4.getChildren().addAll(bt4, bt5, bt6, btMinus);
		hBox5.getChildren().addAll(bt1, bt2, bt3, btAdd);
		hBox6.getChildren().addAll(bt0, btLeft, btRight, btEqual);
		hBox4.setPadding(new Insets(15, 15, 0, 30));
		hBox5.setPadding(new Insets(15, 15, 0, 30));
		hBox6.setPadding(new Insets(15, 15, 10, 30));
		pane2.setTop(hBox4);
		pane2.setCenter(hBox5);
		pane2.setBottom(hBox6);
		// 接着把pane1放到pane的Center中
		pane.setCenter(pane2);



		/*为每一个按钮《添加事件》
		 * 下面开始对每个按钮添加事件
		 * 即bt变量按钮设置一个事件，重写handle逻辑操作代码，获取到对应的值
		 * showExpression.setText(string); 设置值为（字符串）当你点击button2的时候，button2的内容会变成Accepted。到时候调用js引擎对字符串进行eval（）操作
		 *
		 */
		//下面开始对每个按钮添加事件
		bt1.setOnAction(new EventHandler<ActionEvent>() {
			//重写handle方法
			@Override
			public void handle(ActionEvent event) {
				String string = new String(showExpression.getText());
				string += "1";
				showExpression.setText(string);
			}
		});

		bt2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String string = new String(showExpression.getText());
				string += "2";

				showExpression.setText(string);
			}
		});

		bt3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String string = new String(showExpression.getText());
				string += "3";
				showExpression.setText(string);
			}
		});
		bt4.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String string = new String(showExpression.getText());
				string += "4";
				showExpression.setText(string);
			}
		});
		bt5.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String string = new String(showExpression.getText());
				string += "5";
				showExpression.setText(string);
			}
		});

		bt6.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String string = new String(showExpression.getText());
				string += "6";
				showExpression.setText(string);
			}
		});

		bt7.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String string = new String(showExpression.getText());
				string += "7";
				showExpression.setText(string);
			}
		});

		bt8.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String string = new String(showExpression.getText());
				string += "8";
				showExpression.setText(string);
			}
		});

		bt9.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String string = new String(showExpression.getText());
				string += "9";
				showExpression.setText(string);
			}
		});

		bt0.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String string = new String(showExpression.getText());
				string += "0";
				showExpression.setText(string);
			}
		});

		btLeft.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String string = new String(showExpression.getText());
				string += "(";
				showExpression.setText(string);
			}
		});

		btRight.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String string = new String(showExpression.getText());
				string += ")";
				showExpression.setText(string);
			}
		});

		btPoint.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String string = new String(showExpression.getText());
				string += ".";
				showExpression.setText(string);
			}
		});

		btBack.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String string = new String(showExpression.getText());
				string = string.substring(0, string.length() - 1);
				showExpression.setText(string);
			}
		});

		btAdd.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String string = new String(showExpression.getText());
				string += "+";
				showExpression.setText(string);
			}
		});

		btMinus.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String string = new String(showExpression.getText());
				string += "-";
				showExpression.setText(string);
			}
		});

		btMultiply.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String string = new String(showExpression.getText());
				string += "*";
				showExpression.setText(string);
			}
		});

		btDivide.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String string = new String(showExpression.getText());
				string += "/";
				showExpression.setText(string);
			}
		});

		btClear.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				showExpression.setText("");
			}
		});

		/*
		 * 使用JS计算引擎得出结果
		 */

		btEqual.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				ScriptEngineManager manager = new ScriptEngineManager();
				ScriptEngine SE = manager.getEngineByName("js");
				String string = new String(showExpression.getText());
				try {
					String ans = SE.eval(string).toString();
					showExpression.setText(ans);
				} catch (Exception e) {
					// TODO: handle exception
					showExpression.setText("ERROR!");
				}

			}
		});

		Scene scene = new Scene(pane);
		primaryStage.setTitle("Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}
