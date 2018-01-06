
import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.ECGenParameterSpec;

public class EccDemo
{
    public static void main(String[] args) throws Exception
    {
        Security.addProvider(new BouncyCastleProvider());

        // KeyPairGenerator
        ECGenParameterSpec parameterSpec = new ECGenParameterSpec("prime256v1");
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("ECIES");
        keyPairGenerator.initialize(parameterSpec);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        System.out.println(Base64.encodeBase64String(publicKey.getEncoded()));
        System.out.println(Base64.encodeBase64String(privateKey.getEncoded()));

        // cipher

        // get cipher instance
        Cipher cipher = Cipher.getInstance("ECIES");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        // encrypt
        byte[] bytes = cipher.doFinal("ECC".getBytes());
        System.out.println(Base64.encodeBase64String(bytes));

        // decrypt
        cipher = Cipher.getInstance("ECIES");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        bytes = cipher.doFinal(bytes);
        System.out.println(new String(bytes));

        // Signature
        Signature signature = Signature.getInstance("ECDSA");
        signature.initSign(privateKey);
        signature.update("ECC".getBytes());
        bytes = signature.sign();
        System.out.println(Base64.encodeBase64String(bytes));
    }
}
