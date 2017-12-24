import org.apache.commons.codec.binary.Base64;

import javax.crypto.*;
import java.security.*;

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
    }
}
