import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BoardSolver extends Application {
    BoardFileReader rf = new BoardFileReader();

    @Override
    public void start(Stage primaryStage) {
        AStarAlgorithm as = new AStarAlgorithm();
        ArrayList<ArrayList<String>> board;
        as.aStar();
        board = as.board;
        int height = board.size();
        int width = board.get(0).size();
        Group root = new Group();
        Scene scene = new Scene(root, width * 20, height * 20, Color.LIGHTBLUE);

        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.get(i).size(); j++) {
                Rectangle r = new Rectangle(j * 20, i * 20, 20, 20);
                Circle c = new Circle();
                c.setCenterX(j * 20 + 9);
                c.setCenterY(i * 20 + 9);
                c.setRadius(4);

                //Set mountain nodes
                if (board.get(i).get(j).split("")[0].equals("m")) {
                    r.setFill(Color.GREY);
                    r.setStroke(Color.BLACK);
                    r.setStrokeWidth(1);
                    root.getChildren().addAll(r);
                    if (board.get(i).get(j).length() > 1) {
                        if (board.get(i).get(j).split("")[1].equals("P")) {
                            c.setFill(Color.YELLOW);
                        } else if (board.get(i).get(j).split("")[1].equals("V")) {
                            c.setFill(Color.TRANSPARENT);
                        } else if (board.get(i).get(j).split("")[1].equals("N")) {
                            c.setFill(Color.TRANSPARENT);
                        }
                        root.getChildren().addAll(c);
                    }
                }

                //set water nodes
                else if (board.get(i).get(j).split("")[0].equals("w")) {
                    r.setFill(Color.BLUE);
                    r.setStroke(Color.BLACK);
                    r.setStrokeWidth(1);
                    root.getChildren().addAll(r);
                    if (board.get(i).get(j).length() > 1) {
                        if (board.get(i).get(j).split("")[1].equals("P")) {
                            c.setFill(Color.YELLOW);
                        } else if (board.get(i).get(j).split("")[1].equals("V")) {
                            c.setFill(Color.TRANSPARENT);
                        } else if (board.get(i).get(j).split("")[1].equals("N")) {
                            c.setFill(Color.TRANSPARENT);
                        }
                        root.getChildren().addAll(c);
                    }

                //set road nodes
                } else if (board.get(i).get(j).split("")[0].equals("r")) {
                    r.setFill(Color.SANDYBROWN);
                    r.setStroke(Color.BLACK);
                    r.setStrokeWidth(1);
                    root.getChildren().addAll(r);
                    if (board.get(i).get(j).length() > 1) {
                        if (board.get(i).get(j).split("")[1].equals("P")) {
                            c.setFill(Color.YELLOW);
                        } else if (board.get(i).get(j).split("")[1].equals("V")) {
                            c.setFill(Color.TRANSPARENT);
                        } else if (board.get(i).get(j).split("")[1].equals("N")) {
                            c.setFill(Color.TRANSPARENT);
                        }
                        root.getChildren().addAll(c);
                    }

                //set grassnodes
                } else if (board.get(i).get(j).split("")[0].equals("g")) {
                    r.setFill(Color.LIGHTGREEN);
                    r.setStroke(Color.BLACK);
                    r.setStrokeWidth(1);
                    root.getChildren().addAll(r);
                    if (board.get(i).get(j).length() > 1) {
                        if (board.get(i).get(j).split("")[1].equals("P")) {
                            c.setFill(Color.YELLOW);
                        } else if (board.get(i).get(j).split("")[1].equals("V")) {
                            c.setFill(Color.TRANSPARENT);
                        } else if (board.get(i).get(j).split("")[1].equals("N")) {
                            c.setFill(Color.TRANSPARENT);
                        }
                        root.getChildren().addAll(c);
                    }


                //set forest nodes
                } else if (board.get(i).get(j).split("")[0].equals("f")) {
                    r.setFill(Color.DARKGREEN);
                    r.setStroke(Color.BLACK);
                    r.setStrokeWidth(1);
                    root.getChildren().addAll(r);
                    if (board.get(i).get(j).length() > 1) {
                        if (board.get(i).get(j).split("")[1].equals("P")) {
                            c.setFill(Color.YELLOW);
                        } else if (board.get(i).get(j).split("")[1].equals("V")) {
                            c.setFill(Color.TRANSPARENT);
                        } else if (board.get(i).get(j).split("")[1].equals("N")) {
                            c.setFill(Color.TRANSPARENT);
                        }
                        root.getChildren().addAll(c);
                    }

                //set other nodes
                } else if (board.get(i).get(j).split("")[0].equals(".")) {
                    r.setFill(Color.WHITE);
                    r.setStroke(Color.BLACK);
                    r.setStrokeWidth(1);
                    root.getChildren().addAll(r);
                    if (board.get(i).get(j).length() > 1) {
                        if (board.get(i).get(j).split("")[1].equals("P")) {
                            c.setFill(Color.YELLOW);
                        } else if (board.get(i).get(j).split("")[1].equals("V")) {
                            c.setFill(Color.TRANSPARENT);
                        } else if (board.get(i).get(j).split("")[1].equals("N")) {
                            c.setFill(Color.TRANSPARENT);
                        }
                        root.getChildren().addAll(c);
                    }

                } else if (board.get(i).get(j).split("")[0].equals("#")) {
                    r.setFill(Color.LIGHTGRAY);
                    r.setStroke(Color.BLACK);
                    r.setStrokeWidth(1);
                    root.getChildren().addAll(r);

                //set start node
                } else if (board.get(i).get(j).equals("A")) {
                    Text t = new Text(j * 20 + 5, i * 20 + 15, "A");
                    r.setFill(Color.SANDYBROWN);
                    r.setStroke(Color.SANDYBROWN);
                    r.setStrokeWidth(1);
                    root.getChildren().addAll(r, t);

                //set end node
                } else if (board.get(i).get(j).equals("B")) {
                    Text t = new Text(j * 20 + 5, i * 20 + 15, "B");
                    r.setFill(Color.YELLOWGREEN);
                    r.setStroke(Color.BLACK);
                    r.setStrokeWidth(1);
                    root.getChildren().addAll(r, t);
                }
            }
        }
        primaryStage.setTitle("Shortest Path");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}