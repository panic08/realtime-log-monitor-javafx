package ru.panic;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class RealTimeFileReader extends Application {
    @Override
    public void start(Stage primaryStage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select .txt file");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Txt files", "*.txt"));

        File selectedFile = fileChooser.showOpenDialog(primaryStage);
        if (selectedFile == null) {
            return;
        }

        Path path = selectedFile.toPath();
        if (!Files.exists(path) || !Files.isRegularFile(path)) {
            return;
        }

        System.out.println("Reading a file in real time...");
        new Thread(() -> {
            watchFileInRealTime(path);
        }).start();
    }

    private void watchFileInRealTime(Path path) {
        try {
            long lastPosition = 0;

            while (true) {
                long fileSize = Files.size(path);
                if (fileSize > lastPosition) {
                    try (RandomAccessFile file = new RandomAccessFile(path.toFile(), "r");
                         BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path.toFile()), StandardCharsets.UTF_8))) {
                        file.seek(lastPosition);
                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);
                        }
                        lastPosition = file.length();
                    }
                }

                Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
