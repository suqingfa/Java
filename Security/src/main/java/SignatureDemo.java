import org.apache.commons.codec.binary.Base64;

import java.security.*;

public class SignatureDemo
{
    public static void main(String[] args) throws Exception
    {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
        PrivateKey privateKey = keyPairGenerator.generateKeyPair()
                .getPrivate();

        Signature signature = Signature.getInstance("SHA256withDSA");
        signature.initSign(privateKey);

        signature.update("signature".getBytes());

        System.out.println(Base64.encodeBase64String(signature.sign()));
    }
}
