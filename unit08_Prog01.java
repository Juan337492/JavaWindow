import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
* Class: CIST 2371 Introduction to Java
* Term: Fall 2018
* Instructor: 
Stevie Prettyman
* Description: Solution to Unit 08 Program 1
* Due: 12/07/2018
8
* @author Juan Rodriguez
* @version 1.0
*
* By
turning in this code, I Pledge:
*  1. That I have completed the programming assignment independently.
*  2. I have not copied the code from a student or any source.
*  3. I have not given my code to any student.
*
*/

public class Unit08_Prog01 extends Application  {

	Stage window;
    RadioButton button;
    RadioButton button2;
    RadioButton button3;
    RadioButton button4;
    RadioButton button5;
    Text textFX;
    Button buttonLeft;
    Button buttonRight;
    
	public static void main(String[] args) {
		launch(args);
	
	}
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle(" Unit08_Prog01");
       buttonLeft = new Button(" <= ");
       buttonRight = new Button(" => ");
       
       button = new RadioButton("Red");
       button2 = new RadioButton("Yellow");
       button3 = new RadioButton("White");
       button4 = new RadioButton("Orange");
       button5 = new RadioButton("Green");
       // White button will be selected 
       button3.setSelected(true);
 
       // Only one button will be selected 
       ToggleGroup group = new ToggleGroup();
       button.setToggleGroup(group);
       button2.setToggleGroup(group);
       button3.setToggleGroup(group);
       button4.setToggleGroup(group);
       button5.setToggleGroup(group);
      
       // Set text "Programming is fun" and set X - Y 
       textFX = new Text(400,400,"Programming is fun");
       textFX.setStyle("-fx-font-size: 40px;");     
       textFX.setTranslateY(100);
       
      
       double left = 80;
       textFX.setTranslateX(left);
       
       double right = 80;
       textFX.setTranslateX(right);
       // Button moves X left or right 
       buttonLeft.setOnAction(e -> left(textFX, left));
      
       buttonRight.setOnAction(e -> right(textFX , right));
  
       
       // Layout 
       HBox layoutXY = new HBox(10);
       HBox layout = new HBox(20);
       VBox textLayout = new VBox();
       
       //On click it will change color of background behind text
       button.setOnAction(e -> setStyle(textLayout) );
       button2.setOnAction(e -> setStyle2(textLayout) );
       button3.setOnAction(e -> setStyle3(textLayout) );
       button4.setOnAction(e -> setStyle4(textLayout) );
       button5.setOnAction(e -> setStyle5(textLayout) );

    
        layoutXY.getChildren().addAll(buttonLeft, buttonRight);
        layout.getChildren().addAll(button,button2,button3,button4,button5);
        layout.setAlignment(Pos.TOP_CENTER);
        layoutXY.setAlignment(Pos.BOTTOM_CENTER);
        textLayout.getChildren().add(textFX);
        
         
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(layout);
        borderPane.setCenter(textLayout); 
        borderPane.setBottom(layoutXY);
        
        Scene scene = new Scene(borderPane , 500, 500);
        
        
        window.setScene(scene);
        window.show();
    }
    // Change background color starts here
	public void setStyle(Node textLayout) {
	textLayout.setStyle("-fx-background-color: red");
	}
	public void setStyle2(Node textLayout) {
		textLayout.setStyle("-fx-background-color: yellow");
	}
	public void setStyle3(Node textLayout) {
		textLayout.setStyle("-fx-background-color: white");
	}
	public void setStyle4(Node textLayout) {
		textLayout.setStyle("-fx-background-color: orange");
	}
	public void setStyle5(Node textLayout) {
		textLayout.setStyle("-fx-background-color: green");
	}
	// Buttons that moves text left or right starts here 
//left button
	public void left(Node textFX, double left) {
		left = textFX.getTranslateX();
		if (left < 1410 & left > 0 ) {
			double leftX = left - 5;
		textFX.setTranslateX(leftX);
		}
	}
// right button 
	public void right(Node textFX, double right) {
			right = textFX.getTranslateX();
			if (right > 0 & right < 1400 ) {
				double rightX = right + 5;
			textFX.setTranslateX(rightX);
			}

	}
}
