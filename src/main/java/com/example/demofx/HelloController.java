package com.example.demofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HelloController {
    @FXML
    private ImageView image;

    @FXML
    Button btnScene1, btnScene2, btnScene3, btn_save;

    @FXML
    public void SaveToFile(Image image, String name) throws IOException {
        File fileoutput = new File("C:\\Users\\Md. Mirajul Islam\\Desktop\\output"+name+".png");
//        BufferedImage BI = SwingFXUtils.fromFXImage(image, null);
//        ImageIO.write(BI, "png", fileoutput);
    }

    @FXML
    public void btnSave(ActionEvent e) throws IOException {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose an image");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG", "*.png"), new FileChooser.ExtensionFilter("JPEG", "*.jpg"));
        File selectedFile = fileChooser.showOpenDialog(stage);
        Image OriginalPhoto = new Image(selectedFile.toURI().toString());
        image.setImage(OriginalPhoto);


        Image img1 = new Image(selectedFile.toURI().toString(), 300, 300, false, false);
        SaveToFile(img1, "M");


    }


    @FXML
    void showImage(MouseEvent e) {
        image.setVisible(false);
    }

    @FXML
    void handleNext() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view2.fxml"));
        Stage window = (Stage) btnScene1.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }

    @FXML
    void handleNextNext() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view3.fxml"));
        Stage window = (Stage) btnScene3.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }

    @FXML
    void handlePrev() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage window = (Stage) btnScene2.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }
}