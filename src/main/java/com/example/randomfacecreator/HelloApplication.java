package com.example.randomfacecreator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class HelloApplication extends Application {
    static int width = 600;
    static int height = 600;
    static Canvas canvas = new Canvas(width, height);
    static GraphicsContext gc = canvas.getGraphicsContext2D();


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        Group root = new Group();
        Scene scene = new Scene(root, width, height);
        stage.setTitle("Face");
        stage.setScene(scene);

        gc.clearRect(0, 0, width, height);
        root.getChildren().add(canvas);

        drawPrimitiveFace();


        stage.show();

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.4), event -> {
            gc.clearRect(0, 0, width, height);
            drawPrimitiveFace();
        }));
        timeline.setCycleCount(360);
        timeline.play();

    }


    public static void drawPrimitiveFace() {

        //baggrundsfarve (en rektangel der fylder hele canvas)
        gc.setFill(Color.PINK);
        gc.fillRect(0, 0, 600, 600);

        drawEars(50, 10);
        drawShape(300, 300);
        drawMouth(100);
        drawEyes(20, 5);
        drawNose(20);
        drawGlasses();
        drawEyeBrows(40, 10);
        drawHappyOrSad();
    }


    //ansigtets ører
    public static void drawEars(int earSize, int earChanal) {
        Random random = new Random();

        int maxEarSize = random.nextInt(100);
        int minEarSize = random.nextInt(50);
        int randomEarSize = maxEarSize - minEarSize;


        gc.setFill(Color.ORANGE);
        gc.fillOval(150, 200, earSize, randomEarSize);
        gc.fillOval(width - 200, 200, earSize, randomEarSize);
        gc.setFill(Color.BLACK);

    }

    //skal ansigtet være happy eller sad
    public static void drawHappyOrSad() {

        Random random = new Random();
        int randomSadOrHappyFace = random.nextInt(2);

        if (randomSadOrHappyFace == 2) {

        } else if (randomSadOrHappyFace == 1){

            gc.setFill(Color.BLUE);
            int startYValueForTearsLeft = 230;
            for (int i = startYValueForTearsLeft; i < 600; i = i + 25)
                gc.fillOval(220, i, 5, 10);

            int startYValueForTearsRight = 230;
            for (int i = startYValueForTearsRight; i < 600; i = i + 25)
                gc.fillOval(375, i, 5, 10);
        }
    }

    //formen på ansigtet
    public static void drawShape(int widhtDiameter, int hightDiameter) {
        Random random = new Random();
        int biggestFaceShape = random.nextInt(125);
        int randomFaceShape = biggestFaceShape + 300;

        gc.setFill(Color.ORANGE);
        gc.fillOval(150, 150, widhtDiameter, randomFaceShape);
    }

    //munden
    public static void drawMouth(int mouthSize) {
        Random random = new Random();
        int biggestMountShape = random.nextInt(100);
        int smallestMountShape = 75;
        int randomMountshape = biggestMountShape + smallestMountShape;

        int randomMouthColor = random.nextInt(5);

        if (randomMouthColor == 1){
            gc.setFill(Color.RED);
        } else if (randomMouthColor == 2){
            gc.setFill(Color.BLACK);
        } else if (randomMouthColor == 3){
            gc.setFill(Color.GREEN);
        } else  if (randomMouthColor == 4){
            gc.setFill(Color.BLUE);
        } else {
            gc.setFill(Color.PINK);
        }

        gc.fillOval(250, 325, randomMountshape, 30);

    }

    //vælge hvilken form næsen skal have og hvilken størelse
    public static void drawNose(int noseSize) {
        Random random = new Random();
        int biggestNoseSize = random.nextInt(30);
        int smallestNoseSize = 20;
        int randomNoseSize = smallestNoseSize + biggestNoseSize;

        int randomNoseShape = random.nextInt(3);

        if (randomNoseShape ==1) {
            gc.fillRect(290, 270, randomNoseSize, randomNoseSize);
        } else if (randomNoseShape == 2) {
            gc.fillRoundRect(290,270,noseSize,randomNoseSize,10,10);
        } else {
            gc.fillOval(290, 270,noseSize,randomNoseSize);
        }

    }

    //Vælg hvilken strørelse øjnene skal have og hvilken farve
                public static void drawEyes(int eyesSize, int pupilSize) {
        Random random = new Random();
        int biggestEyeSize = random.nextInt(15);
        int lowestEyeSize = 20;
        int randomEyeSize = biggestEyeSize + lowestEyeSize;

        int randomEyeColor = random.nextInt(5);

        if (randomEyeColor == 1){
            gc.setFill(Color.RED);
        } else if (randomEyeColor == 2){
            gc.setFill(Color.BLACK);
        } else if (randomEyeColor == 3){
            gc.setFill(Color.GREEN);
        } else  if (randomEyeColor == 4){
            gc.setFill(Color.BLUE);
        } else {
            gc.setFill(Color.PINK);
        }

        gc.fillOval(220, 220, randomEyeSize, randomEyeSize);

        gc.fillOval(360, 220, randomEyeSize, randomEyeSize);

            gc.setFill(Color.BLACK);
            gc.fillOval(227, 227, pupilSize, pupilSize);
            gc.setFill(Color.BLACK);
            gc.fillOval(367, 227, pupilSize, pupilSize);

    }

    //Vælg hvilken farve øjenbrynene skal være (mellem sort og hvid)
    public static void drawEyeBrows(int widthDiameter, int hightDiameter) {

        Random random = new Random();
        int randomEyeBrowsColor = random.nextInt(2);

        if (randomEyeBrowsColor == 1){
            gc.setFill(Color.RED);
        } else if (randomEyeBrowsColor == 2){
            gc.setFill(Color.BLACK);
        } else if (randomEyeBrowsColor == 3){
            gc.setFill(Color.GREEN);
        } else  if (randomEyeBrowsColor == 4){
            gc.setFill(Color.BLUE);
        } else {
            gc.setFill(Color.PINK);
        }
        gc.fillOval(210, 190, widthDiameter, hightDiameter);
        gc.fillOval(350, 190, widthDiameter, hightDiameter);
    }

    //Vælg om der skal være briller
    public static void drawGlasses() {

        Random random = new Random();
        int randomGlassesOnFace = random.nextInt(2);

        if (randomGlassesOnFace == 1){

        } else {

            gc.setLineWidth(5);

            gc.strokeOval(206, 206, 50, 50);
            gc.strokeOval(346, 206, 50, 50);

            gc.strokeLine(185, 206, 206, 225);

            gc.strokeLine(255, 225, 346, 225);

            gc.strokeLine(417, 206, 396, 225);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}