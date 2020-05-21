package sample;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

public class Controller {

    @FXML private TextArea messageField;
    @FXML private TextArea outputField;

    DSA DSA = new DSA();

    public void sendAction()
            throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        String message = messageField.getText();
//        sample.DSA.hashText(message);
        DSA.generateKeys();
        DSA.getSignature(message);
        outputField.appendText(new String (DSA.signature, StandardCharsets.UTF_8) + "\n");
    }

    public void verifyAction() throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        String message = messageField.getText();

        if (DSA.getVerified(message, DSA.signature)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("The signature is verified.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("The signature is not verified");
            alert.setContentText("Please try sending a message and verify it again.");
            alert.showAndWait();
        }
    }

    public void clearAction() {
        messageField.clear();
        outputField.clear();
    }
}
