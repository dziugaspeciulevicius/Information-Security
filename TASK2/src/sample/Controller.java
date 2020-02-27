package sample;

import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Window;

public class Controller {

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private Button chooseFile;
    @FXML private Button encryptButton;
    @FXML private TextArea outputArea;
    @FXML private TextArea plaintextInput;
    @FXML private TextArea keyInput;
    @FXML private TextField chosenFileField;
    @FXML private Button decryptButton;


    public void Encrypt(javafx.event.ActionEvent event) {

    }

    public void OpenFileChooser(javafx.event.ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose a text file with cipher text");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("TXT", "*.txt")
        );
        Window stage = null;
        File file = fileChooser.showOpenDialog(null);


        if(file != null) {
            System.out.println("Path: " + file.getAbsolutePath());
            chosenFileField.setText(file.getName() + " is chosen!");
        }
    }

    public void Decrypt(javafx.event.ActionEvent event) {

    }
}
