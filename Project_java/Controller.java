package project_Java;

import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import sun.rmi.runtime.Log;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    public ImageView rope;
    public AnchorPane backrope;
    public static AnchorPane back;

    private double xOffset, yOffset, BEFORE, AFTER;
    private static Stage stage;
    private boolean isRunning;

    static class Loog {
        static void e(String str1, String str2) {
            System.err.println(str1 + " " + str2);
        }
    }

    public static void blink(StackPane root) {
        new Thread(() -> {
            while (true) {
                root.setStyle("-fx-background-color:#f03232");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                root.setStyle("-fx-background-color:purple");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                root.setStyle("-fx-background-color:green");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void rotation(ImageView imageView) {
        new Thread(() -> {
            for (int i = 0; ; i += 90) {
                imageView.setRotate(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }).start();
    }

    public static void crowdEffect(ImageView imageView) {
        new Thread(() -> {
            while (true) {
                for (int i = 0; i < 90; i++) {
                    imageView.setTranslateY(i);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }
                }
                for (int j = 90; j > 0; j--) {
                    imageView.setTranslateY(-j);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();
    }


    class Player {
        ImageView rope;

        Player(ImageView rope) {
            this.rope = rope;
        }

        void play(int value) {
            Loog.e("Media", "실행됨");
            rope.setVisible(false);
            Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
            Stage stage = new Stage();
            StackPane root = new StackPane();
            StackPane back = new StackPane();
            Scene scene = new Scene(root, javafx.scene.paint.Color.TRANSPARENT);

            ArrayList<Image> images = new ArrayList<>();
            ArrayList<ImageView> imageView = new ArrayList<>();

            String path;
            Media media;
            MediaPlayer mp;

            int imageCount = 6;

            switch (value) {
                case 1:
                    images.add(new Image("project_Java/source/shark.gif"));
                    images.add(new Image("project_Java/source/giphy.gif"));
                    images.add(new Image("project_Java/source/Garfield.gif"));
                    images.add(new Image("project_Java/source/crowd.png"));
                    images.add(new Image("project_Java/source/fishDancer.gif"));
                    images.add(new Image("project_Java/source/fishDancer.gif"));
                    break;

                case 2:
                    images.add(new Image("project_Java/source/shark.gif"));
                    images.add(new Image("project_Java/source/giphy.gif"));
                    images.add(new Image("project_Java/source/Garfield.gif"));
                    images.add(new Image("project_Java/source/crowd.png"));
                    images.add(new Image("project_Java/source/fishDancer.gif"));
                    images.add(new Image("project_Java/source/fishDancer.gif"));
                    break;
                case 3:
                    images.add(new Image("project_Java/source/shark.gif"));
                    images.add(new Image("project_Java/source/giphy.gif"));
                    images.add(new Image("project_Java/source/Garfield.gif"));
                    images.add(new Image("project_Java/source/crowd.png"));
                    images.add(new Image("project_Java/source/fishDancer.gif"));
                    images.add(new Image("project_Java/source/fishDancer.gif"));
                    break;
                case 4:
                    images.add(new Image("project_Java/source/shark.gif"));
                    images.add(new Image("project_Java/source/giphy.gif"));
                    images.add(new Image("project_Java/source/Garfield.gif"));
                    images.add(new Image("project_Java/source/crowd.png"));
                    images.add(new Image("project_Java/source/fishDancer.gif"));
                    images.add(new Image("project_Java/source/fishDancer.gif"));
                    break;
                case 5:
                    images.add(new Image("project_Java/source/shark.gif"));
                    images.add(new Image("project_Java/source/giphy.gif"));
                    images.add(new Image("project_Java/source/Garfield.gif"));
                    images.add(new Image("project_Java/source/crowd.png"));
                    images.add(new Image("project_Java/source/fishDancer.gif"));
                    images.add(new Image("project_Java/source/fishDancer.gif"));
                    break;
                case 6:
                    images.add(new Image("project_Java/source/shark.gif"));
                    images.add(new Image("project_Java/source/giphy.gif"));
                    images.add(new Image("project_Java/source/Garfield.gif"));
                    images.add(new Image("project_Java/source/crowd.png"));
                    images.add(new Image("project_Java/source/fishDancer.gif"));
                    images.add(new Image("project_Java/source/fishDancer.gif"));
                    break;
                default:
                    images.add(new Image("project_Java/source/shark.gif"));
                    images.add(new Image("project_Java/source/giphy.gif"));
                    images.add(new Image("project_Java/source/Garfield.gif"));
                    images.add(new Image("project_Java/source/crowd.png"));
                    images.add(new Image("project_Java/source/fishDancer.gif"));
                    images.add(new Image("project_Java/source/fishDancer.gif"));
            }

            for (int i = 0; i < imageCount; i++)
                imageView.add(new ImageView(images.get(i)));

            switch (value) {
                case 0:
                    path = "src/project_Java/source/bgm1.mp3";
                case 1:
                    path = "src/project_Java/source/bgm1.mp3";
                    break;
                case 2:
                    path = "src/project_Java/source/bgm1.mp3";
                    break;
                case 3:
                    path = "src/project_Java/source/bgm1.mp3";
                    break;
                case 4:
                    path = "src/project_Java/source/bgm1.mp3";
                    break;
                case 5:
                    path = "src/project_Java/source/bgm1.mp3";
                    break;
                default:
                    path = "src/project_Java/source/bgm1.mp3";
            }

            media = (new Media(new File(path).toURI().toString()));
            mp = (new MediaPlayer(media));

            for (int i = 0; i < imageCount; i++)
                root.getChildren().add(imageView.get(i));

            stage.setFullScreenExitKeyCombination(new KeyCombination() {
                @Override
                public boolean match(KeyEvent event) {
                    return false;
                }
            });
            root.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    stage.hide();
                    mp.stop();
                    rope.setVisible(true);
                    back.setTranslateY(-80);
                    isRunning = false;
                }
            });

            for (int i = 0; i < imageCount; i++) {
                imageView.get(i).setPreserveRatio(true);
            }

            imageView.get(3).setStyle("-fx-background-color:transparent");
            imageView.get(3).setFitWidth(res.getWidth());
            imageView.get(3).setTranslateY(-900);

            imageView.get(0).setStyle("-fx-background-color:transparent");
            imageView.get(0).setFitHeight(500);
            imageView.get(0).setTranslateX(-450);
            imageView.get(0).setTranslateY(200);

            back.setPrefSize(res.getWidth(), res.getHeight());
            back.setOpacity(0.5f);

            root.setMaxSize(res.getWidth(), res.getHeight());
            root.setStyle("-fx-background-color:transparent");
            root.getChildren().add(0, back);

            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setWidth(res.width);
            stage.setHeight(res.height);
            stage.setScene(scene);
            stage.setAlwaysOnTop(true);

            crowdEffect(imageView.get(3));
            blink(back);
            mp.play();
            stage.show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image img = new Image("project_Java/img/rope.png");
        rope.setImage(img);
        rope.setTranslateY(-80);

        back = backrope;

        rope.setOnMouseDragged(event -> {
            double x;
            double y;
            x = event.getScreenX();
            y = event.getScreenY();
            Loog.e("Log :", x + " " + y);
//                stage.setX(x + xOffset);
            stage.setY(y + yOffset);
            AFTER = y;
            if (!isRunning) {
                if (AFTER - BEFORE > 300) {
                    Player mPlayer = new Player(rope);
                    mPlayer.play(0);
                    isRunning=true;
                }
            }
        });
        rope.setOnMousePressed(event -> {
            stage = (Stage) rope.getScene().getWindow();
//                xOffset = stage.getX() - event.getScreenX();
            yOffset = stage.getY() - event.getScreenY();
            BEFORE = event.getScreenY();
        });
        rope.setOnMouseReleased(event -> {
            stage.setX(0);
            stage.setY(-550);
            back.setTranslateY(-80);
        });
        rope.setOnMouseEntered(event -> {

        });
        rope.setOnMouseExited(event -> {

        });
    }
}
