/*
* A Java GUI Project to Flip End of Characters
* it has two text boxes for original and generated text with two buttons for generate and clear
* if the string length is less than two , generate Incompatible
* if the string's end char same as start char , generate Two's a pair
* in all other cases , replace the starting char with ending char and
* complete the original string as it is
* */

package com.example.FlipEndChars;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    private Group root;
    private Scene scene;
    private final Button[] btn = new Button[2];
    private final TextField[] txt = new TextField[2];
    private final Label[] lbl = new Label[2];
    public void start(Stage stage) {
        sceneDesign();
        stage.setScene(scene);
        stage.setTitle("FlipEndChars");
        stage.show();
    }
    public void labelDesign() {
        lbl[0] = new Label();
        lbl[0].setLayoutX(100);
        lbl[0].setLayoutY(100);
        lbl[0].setText("Enter Any Word : ");
        lbl[0].setFont(Font.font(20));
        lbl[0].setTextFill(Paint.valueOf("gray"));
        lbl[1] = new Label();
        lbl[1].setLayoutX(100);
        lbl[1].setLayoutY(200);
        lbl[1].setText("Flipped String : ");
        lbl[1].setFont(Font.font(20));
        lbl[1].setTextFill(Paint.valueOf("gray"));
    }
    public void textFiledDesign() {
        txt[0] = new TextField();
        txt[0].setLayoutX(100);
        txt[0].setLayoutY(150);
        txt[0].setMinWidth(230);
        txt[0].setMinHeight(30);
        txt[0].setPromptText("Original String");
        txt[0].setStyle("-fx-background-color: #89CFF0; -fx-background-radius: 30; -fx-text-fill: gray;");
        txt[1] = new TextField();
        txt[1].setLayoutX(100);
        txt[1].setLayoutY(250);
        txt[1].setMinWidth(230);
        txt[1].setMinHeight(30);
        txt[1].setPromptText("Modified String");
        txt[1].setStyle("-fx-background-color: #89CFF0; -fx-background-radius: 30; -fx-text-fill: gray;");
    }
    public void buttonDesign() {
        btn[0] = new Button("Generate");
        btn[0].setLayoutX(100);
        btn[0].setLayoutY(350);
        btn[0].setMinHeight(30);
        btn[0].setMinWidth(80);
        btn[0].setTextFill(Paint.valueOf("gray"));
        btn[0].setFont(Font.font(15));
        btn[0].setOnAction(e -> generateAction());
        btn[0].setStyle("-fx-background-radius: 30; -fx-background-color: #89CFF0;");
        btn[1] = new Button("Clear");
        btn[1].setLayoutX(250);
        btn[1].setLayoutY(350);
        btn[1].setMinHeight(30);
        btn[1].setMinWidth(80);
        btn[1].setTextFill(Paint.valueOf("gray"));
        btn[1].setFont(Font.font(15));
        btn[1].setOnAction(e -> clearAction());
        btn[1].setStyle("-fx-background-radius: 30; -fx-background-color: #89CFF0;");
    }
    public void groupDesign() {
        root = new Group();
        root.getChildren().addAll(btn[0], btn[1], txt[0], txt[1], lbl[0], lbl[1]);
    }
    public void sceneDesign() {
        labelDesign();
        textFiledDesign();
        buttonDesign();
        groupDesign();
        scene = new Scene(root, 500, 500);
        scene.setFill(Paint.valueOf("#FFD580"));
    }
    public void generateAction() {
        txt[1].setText(flipEndChars());
    }
    public void clearAction() {
        txt[0].setText("");
        txt[1].setText("");
    }
    public String flipEndChars()
    {
        String stmt = txt[0].getText();
        char []arr=new char[stmt.length()];
        char temp;
        String res;
        if(stmt.length()<2)
        {
            res="Incompatible.";
            return res;
        }
        for(int i =0;i<stmt.length()-1;i++)
        {
            if(stmt.charAt(0)==stmt.charAt(stmt.length()-1))
            {
                res="Two's a pair.";
                return res;
            }
            else
            {
                if(i==0)
                {
                    temp=stmt.charAt(0);
                    arr[0]=stmt.charAt(stmt.length()-1);
                    arr[stmt.length()-1]=temp;
                }
                else
                {
                    arr[i]=stmt.charAt(i);
                }
            }
        }
        res = String.valueOf(arr);
        return res;
    }
    public static void main(String[] args) {
        launch();
    }
}