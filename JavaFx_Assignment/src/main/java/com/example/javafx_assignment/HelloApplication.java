package com.example.javafx_assignment;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class HelloApplication<Stage> extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        // Header Section
        Label headerLabel = new Label("Welcome to the Registration Form");
        headerLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: #FFFFFF; -fx-font-family: 'Arial'; -fx-font-weight: bold;");
        HBox headerBox = new HBox(headerLabel);
        headerBox.setStyle("-fx-background-color: #009688; -fx-padding: 15;");
        headerBox.setAlignment(Pos.CENTER);

        // Form Fields
        Label nameLabel = new Label("Full Name:");
        nameLabel.setStyle("-fx-font-size: 14px; -fx-font-family: 'Arial'; -fx-text-fill: #37474F;");
        TextField nameField = new TextField();
        nameField.setPromptText("Enter your full name");
        nameField.setStyle("-fx-font-size: 14px; -fx-background-color: #FFFFFF;");

        Label parentNameLabel = new Label("Parent's Name:");
        parentNameLabel.setStyle("-fx-font-size: 14px; -fx-font-family: 'Arial'; -fx-text-fill: #37474F;");
        TextField parentNameField = new TextField();
        parentNameField.setPromptText("Enter parent's name");
        parentNameField.setStyle("-fx-font-size: 14px; -fx-background-color: #FFFFFF;");

        Label cityLabel = new Label("City:");
        cityLabel.setStyle("-fx-font-size: 14px; -fx-font-family: 'Arial'; -fx-text-fill: #37474F;");
        ComboBox<String> cityComboBox = new ComboBox<>();
        cityComboBox.getItems().addAll("Karachi", "Lahore", "Islamabad", "Peshawar", "Quetta");
        cityComboBox.setPromptText("Select your city");
        cityComboBox.setStyle("-fx-font-size: 14px; -fx-background-color: #FFFFFF;");

        Label genderLabel = new Label("Gender:");
        genderLabel.setStyle("-fx-font-size: 14px; -fx-font-family: 'Arial'; -fx-text-fill: #37474F;");
        RadioButton maleRadioButton = new RadioButton("Male");
        RadioButton femaleRadioButton = new RadioButton("Female");
        maleRadioButton.setStyle("-fx-font-size: 14px; -fx-font-family: 'Arial';");
        femaleRadioButton.setStyle("-fx-font-size: 14px; -fx-font-family: 'Arial';");
        ToggleGroup genderGroup = new ToggleGroup();
        maleRadioButton.setToggleGroup(genderGroup);
        femaleRadioButton.setToggleGroup(genderGroup);

        HBox genderBox = new HBox(15, maleRadioButton, femaleRadioButton);
        genderBox.setAlignment(Pos.CENTER_LEFT);

        // Image Upload Section
        Label imageLabel = new Label("Upload Picture:");
        imageLabel.setStyle("-fx-font-size: 14px; -fx-font-family: 'Arial'; -fx-text-fill: #37474F;");
        ImageView imageView = new ImageView();
        imageView.setFitWidth(120);
        imageView.setFitHeight(120);
        imageView.setPreserveRatio(true);
        Button uploadImageButton = new Button("Choose File");
        uploadImageButton.setStyle("-fx-background-color: #00796B; -fx-text-fill: white; -fx-font-size: 12px;");
        uploadImageButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", ".png", ".jpg", ".jpeg", ".gif"));
            File selectedFile = fileChooser.showOpenDialog(stage);
            if (selectedFile != null) {
                Image image = new Image(selectedFile.toURI().toString());
                imageView.setImage(image);
            }
        });

        VBox imageBox = new VBox(10, imageLabel, imageView, uploadImageButton);
        imageBox.setAlignment(Pos.CENTER_LEFT);

        // Submit Button
        Button submitButton = new Button("Submit");
        submitButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-background-radius: 20;");
        submitButton.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Submission Confirmation");
            alert.setHeaderText("Data Submitted Successfully!");
            String gender = maleRadioButton.isSelected() ? "Male" : femaleRadioButton.isSelected() ? "Female" : "Not Specified";
            String message = String.format("Name: %s\nParent's Name: %s\nCity: %s\nGender: %s",
                    nameField.getText(),
                    parentNameField.getText(),
                    cityComboBox.getValue(),
                    gender);
            alert.setContentText(message);
            alert.showAndWait();
        });

        // Form Layout
        VBox formLayout = new VBox(15, nameLabel, nameField, parentNameLabel, parentNameField, cityLabel, cityComboBox, genderLabel, genderBox, imageBox, submitButton);
        formLayout.setPadding(new Insets(20));
        formLayout.setAlignment(Pos.TOP_LEFT);

        // Root Layout
        VBox root = new VBox(20, headerBox, formLayout);
        root.setStyle("-fx-background-color: #F5F5F5; -fx-padding: 15;");

        // Scene Setup
        Scene scene = new Scene(root, 600, 650);
        stage.setScene(scene);
        stage.setTitle("Alternate Registration Form");
        stage.show();
    }
}