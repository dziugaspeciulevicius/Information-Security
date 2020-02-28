package sample;

import java.io.IOException;
import java.net.URL;
import java.util.Base64;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Encrypt {

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private Button encryptButton;
    @FXML private TextArea outputArea;
    @FXML private TextArea plaintextInput;
    @FXML private TextArea keyInput;


    public void Encrypt(ActionEvent event) {

    }

    public void openDecryptWindow(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent decryptWindow =  FXMLLoader.load(getClass().getResource("decrypt.fxml"));
        Scene decryptWindow_scene = new Scene(decryptWindow);
        Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(decryptWindow_scene);
        app_stage.show();
    }
}
