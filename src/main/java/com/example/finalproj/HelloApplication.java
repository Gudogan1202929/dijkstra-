package com.example.finalproj;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class HelloApplication extends Application {

    public static HashMap<String, Vertex> map = new HashMap<>();

    public static Vertex[] vetixSercle ;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        scene1(stage);
    }

    public void scene1(Stage stage) {

        BorderPane bp = new BorderPane();

        VBox vb = new VBox(20);

        Label lCoinExp = new Label();
        Label l2 = new Label();
        Label lDpTable = new Label();
        Label l4 = new Label();
        Label LabExpeacted = new Label();

        Button Enter = new Button("Read File");
        Enter.setStyle("-fx-background-color: rgb(211, 211, 211);-fx-background-radius: 20;-fx-text-fill: red");
        Enter.setMinHeight(40);
        Enter.setMinWidth(160);

        Button pEXP = new Button("Enter source and direction");
        pEXP.setStyle("-fx-background-color: rgb(211, 211, 211);-fx-background-radius: 20;-fx-text-fill: red");
        pEXP.setMinHeight(40);
        pEXP.setMinWidth(200);

        Button pDpTable = new Button("Exit");
        pDpTable.setStyle("-fx-background-color: rgb(211, 211, 211);-fx-background-radius: 20;-fx-text-fill: red");
        pDpTable.setMinHeight(40);
        pDpTable.setMinWidth(240);

        vb.getChildren().addAll(l4, Enter, l2, pEXP, LabExpeacted, pDpTable, lDpTable, lCoinExp);

        bp.setCenter(vb);
        vb.setAlignment(Pos.CENTER);

        bp.setBackground(new Background(new BackgroundImage(new Image("wh.png"), null, null, null, null)));

        Scene scene1 = new Scene(bp, 850, 420);
        stage.setScene(scene1);
        stage.setTitle("Find way :)");
        stage.show();

        Enter.setOnAction(e -> {
            FileChooser passFileChooser = new FileChooser();
            passFileChooser.setTitle("select Passengers File");
            passFileChooser.setInitialDirectory(new File("."));
            passFileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("All Files", "*"));

            try {
                read(passFileChooser.showOpenDialog(stage));
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        });

        pEXP.setOnAction(e -> {
            try {
                scene2(stage);
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        });

        pDpTable.setOnAction(e -> {
            return;
        });
    }

    public static void read(File file) throws FileNotFoundException {

        Scanner scan = new Scanner(file);

        String line1 = scan.nextLine().trim();
        String[] str = line1.split(",");

        int numberVertex = Integer.parseInt(str[0].trim());
        int numberEdge = Integer.parseInt(str[1].trim());

        vetixSercle = new Vertex[numberVertex];

        for (int i = 0; i < numberVertex; i++) {
            String line2 = scan.nextLine().trim();
            String[] str2 = line2.split(",");
            map.put((str2[0].trim()), new Vertex(str2[0].trim(), Double.parseDouble(str2[1].trim()),Double.parseDouble(str2[2].trim())));
            vetixSercle[i] = new Vertex(str2[0].trim(), Double.parseDouble(str2[1].trim()),Double.parseDouble(str2[2].trim()));
        }

        for (int i = 0; i < numberEdge; i++) {
            String line2 = scan.nextLine().trim();
            String[] str2 = line2.split(",");
            map.get(str2[0].trim()).list.add(map.get(str2[1].trim()));
            System.out.println(str2[0].trim() + " " + str2[1].trim());
        }
    }

    public void scene2(Stage stage) {

        Pane pane = new Pane();

        GridPane gp = new GridPane();
        gp.setVgap(20);
        gp.setHgap(20);

        Label l1 = new Label("Enter source");
        l1.setStyle("-fx-background-color: rgb(211, 211, 211);-fx-background-radius: 20;-fx-text-fill: red");
        l1.setMinHeight(40);
        l1.setMinWidth(90);

        Label l2 = new Label("Enter destination");
        l2.setStyle("-fx-background-color: rgb(211, 211, 211);-fx-background-radius: 20;-fx-text-fill: red");
        l2.setMinHeight(40);
        l2.setMinWidth(90);

        gp.add(l1, 0, 0);
        gp.add(l2, 0, 1);

        ComboBox CM = new ComboBox();

        CM.setStyle("-fx-background-color: rgb(211, 211, 211);-fx-background-radius: 20;-fx-text-fill: red");
        CM.setMinHeight(40);
        CM.setMinWidth(90);

        ArrayList<String> list = new ArrayList<>(map.size());

        for (String key : map.keySet()) {
            list.add(key);
        }

        Collections.sort(list);
        CM.getItems().addAll(list);

        ArrayList<String> list2 = new ArrayList<>(map.size());


        ComboBox CM2 = new ComboBox();
        CM2.setStyle("-fx-background-color: rgb(211, 211, 211);-fx-background-radius: 20;-fx-text-fill: red");
        CM2.setMinHeight(40);
        CM2.setMinWidth(90);
        for (String key : map.keySet()) {
            list2.add(key);
        }

        Collections.sort(list2);
        CM2.getItems().addAll(list2);

        gp.add(CM, 1, 0);
        gp.add(CM2, 1, 1);

        HBox vb0 = new HBox(20);

        Button b01 = new Button("add");
        b01.setStyle("-fx-background-color: rgb(211, 211, 211);-fx-background-radius: 20;-fx-text-fill: red");
        b01.setMinHeight(30);
        b01.setMinWidth(80);

        Button b02 = new Button("back");
        b02.setStyle("-fx-background-color: rgb(211, 211, 211);-fx-background-radius: 20;-fx-text-fill: red");
        b02.setMinHeight(30);
        b02.setMinWidth(80);

        vb0.getChildren().addAll(b01, b02);

        pane.setBackground(new Background(new BackgroundImage(new Image("wh.png"), null, null, null, null)));

        gp.relocate(300, 200);
        vb0.relocate(340, 440);

        pane.getChildren().addAll(gp, vb0);

        Scene scene0 = new Scene(pane, 890, 500);
        stage.setScene(scene0);
        stage.setTitle("Find way :)");
        stage.show();

        b01.setOnAction(e -> {

            for (String key : map.keySet()) {
                map.get(key).setDistance(Double.MAX_VALUE);
                map.get(key).setVisited(false);
                map.get(key).setVertexPath(null);
            }

            Problem.s = "";
            double path = Problem.dijkstra_algorithm(map, (CM.getValue().toString()), CM2.getValue().toString());
            Problem.printPath(map.get(CM2.getValue().toString()));
            scene3(stage);
        });

        b02.setOnAction(e -> {
            scene1(stage);
        });
    }

    public void scene3(Stage stage) {

        Pane pane = new Pane();

        HBox vb0 = new HBox(20);

        Button b01 = new Button("done");
        b01.setStyle("-fx-background-color: rgb(211, 211, 211);-fx-background-radius: 20;-fx-text-fill: red");
        b01.setMinHeight(30);
        b01.setMinWidth(80);

        Button b02 = new Button("back");
        b02.setStyle("-fx-background-color: rgb(211, 211, 211);-fx-background-radius: 20;-fx-text-fill: red");
        b02.setMinHeight(30);
        b02.setMinWidth(80);

        vb0.getChildren().addAll(b01, b02);

        pane.setBackground(new Background(new BackgroundImage(new Image("wh.png"), null, null, null, null)));

        vb0.relocate(500, 550);

        pane.getChildren().addAll(vb0);

        String[] ARR = Problem.s.split(" -> ");

        double x1 = 0;
        double x2 = 0;

        double y1 = 0;
        double y2 = 0;
        Circle c ;

        for (int i =0 ; i < vetixSercle.length ; i++){
            vetixSercle[i].setX((float) CovertX(vetixSercle[i].getX())-37);
            vetixSercle[i].setY((float) CovertY(vetixSercle[i].getY())+90);
             c = new Circle(vetixSercle[i].getX(), vetixSercle[i].getY(), 3);
             c.setFill(Color.RED);
             pane.getChildren().addAll(c);
        }

        for (int i = 0; i < ARR.length - 1; i++) {

            x1 = CovertX(map.get(ARR[i].trim()).getX());
            x2 = CovertX(map.get(ARR[i+1].trim()).getX());

            y1 = CovertY(map.get(ARR[i]).getY());
            y2 = CovertY(map.get(ARR[i+1]).getY());

            Line line = new Line(x1-37,y1+90,x2-37,y2+90);

            line.setStroke(Color.RED);
            line.setStrokeWidth(5);
            pane.getChildren().add(line);
        }

        Scene scene0 = new Scene(pane, 1380, 608);
        stage.setScene(scene0);
        stage.setTitle("Find way :)");
        stage.show();

        b01.setOnAction(e -> {

            String s = "";

            if (Problem.DistancePath == Double.MAX_VALUE) {
                s = ("sorry, there is no way");
            } else if (Problem.DistancePath == -1) {
                s = ("you are in the same place");
            } else {
                s = (Problem.s + "\n" + "Distance: " + Problem.DistancePath + " km");
            }

            TextArea TF = new TextArea();
            TF.setPrefSize(300, 608);
            TF.setStyle("-fx-background-color: rgb(211, 211, 211);-fx-background-radius: 20;-fx-text-fill: red");
            TF.relocate(1080, 0);
            pane.getChildren().add(TF);
            TF.setText(s);
        });

        b02.setOnAction(e -> {
            scene2(stage);
        });
    }

    public double CovertX(double x) {
        return (x+180)* (1080.0/360);
    }

    public double CovertY(double y) {
        return 608-608*(y+90)/180;
    }
}