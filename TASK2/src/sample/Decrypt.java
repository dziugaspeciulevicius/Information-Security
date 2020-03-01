package sample;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileOutputStream;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;

public class Decrypt {

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private Button chooseFile;
    @FXML private TextArea outputArea;
    @FXML private TextField chosenFileField;
    @FXML private Button decryptButton;


    public void decryptAction(javafx.event.ActionEvent event) {

    }

    public void openFileChooser(javafx.event.ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose a text file with cipher text");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("TXT", "*.txt")
        );
        File file = fileChooser.showOpenDialog(null);

        if(file != null) {
            System.out.println("Path: " + file.getAbsolutePath());
            chosenFileField.setText(file.getName() + " is chosen!");
        }
    }

    public void openEncryptWindow(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent encryptWindow =  FXMLLoader.load(getClass().getResource("encrypt.fxml"));
        Scene encryptWindow_scene = new Scene(encryptWindow);
        Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(encryptWindow_scene);
        app_stage.show();
    }
}
