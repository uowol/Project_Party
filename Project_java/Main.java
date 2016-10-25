package project_Java;/**
 * Created by Chan_Woo_Kim on 2016-08-17.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setAlwaysOnTop(true);
//        primaryStage.setOpacity(0.5f);
        primaryStage.setX(0);
        primaryStage.setY(-550);

        Pane root = new Pane();
        root.setStyle("-fx-background-color:transparent");
        root.setMinSize(2000,800);

        Label backGround = new Label();
        backGround.setMinSize(2000,55);
        backGround.setTranslateY(500);
        backGround.setStyle("-fx-background-color:white");
        backGround.setOpacity(0.01f);

        Parent rope = FXMLLoader.load(getClass().getResource("Stage.fxml"));
        rope.setTranslateX(1750);
        root.getChildren().addAll(backGround,rope);
        Scene scene = new Scene(root, Color.TRANSPARENT);
        scene.getStylesheets().add("style_for_stage.css");

        backGround.setOnMouseEntered(event -> {
            new Thread(()->{
                for(int i=0;i<=80;i++){
                    rope.setTranslateY(i);
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        });
        backGround.setOnMouseExited(event -> {
//            for(int i = 0;i<=100;i++) {
//                try {
//                    rope.setTranslateY(-i);
//                    Controller.Loog.e("Log",i+"");
//                    Thread.sleep(2);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        });

        primaryStage.setTitle("AppMain");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
