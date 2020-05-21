package sample;

import java.nio.charset.StandardCharsets;
import java.security.*;

/*
https://www.baeldung.com/java-digital-signature
https://www.tutorialspoint.com/java_cryptography/java_cryptography_creating_signature.htm
https://stackoverflow.com/questions/5531455/how-to-hash-some-string-with-sha256-in-java
*/

public class DSA {

    public PrivateKey privateKey;
    public PublicKey publicKey;
    byte[] signature;

    public void generateKeys() throws NoSuchAlgorithmException {

        //Creating keypair generator object
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");

        //Initializing the key pair generator
        keyPairGenerator.initialize(2048);

        //Generate the pair of keys
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        //Getting the public key from the key pair
        publicKey = keyPair.getPublic();

        //Getting the private key from the key pair
        privateKey = keyPair.getPrivate();
    }

    public void getSignature(String message) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {

        hashText(message);

        Signature sign = Signature.getInstance("SHA256withRSA");

        //Initialize the signature
        sign.initSign(privateKey);

        //--The update() method of the Signature class accepts a byte array representing the
        //data to be signed or verified and updates the current object with the data given.
        //--Update the initialized Signature object by passing the data to be signed
        //to the update() method in the form of byte array as shown below.
        byte[] bytes = message.getBytes();

        //Adding data to the signature
        sign.update(bytes);

        //Calculating the signature
        signature = sign.sign();
    }

    public boolean getVerified(String message, byte[] signature)
            throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {

        Signature verificationSignature = Signature.getInstance("SHA256withRSA");

        verificationSignature.initVerify(publicKey);
        byte[] bytes = message.getBytes();

        verificationSignature.update(bytes);

        return verificationSignature.verify(signature); //signature.verify(tampered data)
    }

    public static void hashText(String base) {
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString;
            hexString = new StringBuilder();

            int i = 0;
            while (i < hash.length) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
                i++;
            }
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}