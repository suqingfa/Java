import org.apache.commons.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;

public class KeyDemo
{
    public static void main(String[] args) throws Exception
    {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();

        System.out.println(Base64.encodeBase64String(publicKey.getEncoded()));

        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        SecretKey secretKey = keyGenerator.generateKey();
        System.out.println(Base64.encodeBase64String(secretKey.getEncoded()));

        // X509EncodedKeySpec
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicKey.getEncoded());
        publicKey = KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec);
        System.out.println(Base64.encodeBase64String(publicKey.getEncoded()));

        // SecretKeySpec
        secretKey = new SecretKeySpec(secretKey.getEncoded(), "AES");
        System.out.println(Base64.encodeBase64String(secretKey.getEncoded()));
    }
}
