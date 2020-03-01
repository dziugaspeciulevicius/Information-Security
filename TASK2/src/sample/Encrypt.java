package sample;

import java.io.*;
import java.net.URL;
import java.security.*;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import org.apache.commons.codec.binary.Base64;



public class Encrypt {

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private Button encryptButton;
    @FXML private TextArea outputArea;
    @FXML private TextField plaintextInput;
    @FXML private TextField keyInput;


    public void encryptAction(ActionEvent event) throws Exception {

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
