import org.apache.commons.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.security.SecureRandom;

public class PbeDemo
{
    public static void main(String[] args) throws Exception
    {
        final String algorithm = "PBEWithMD5AndDes";
        String password = "password";

        // 用口令生成密钥
        PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray());
        SecretKey secretKey = SecretKeyFactory.getInstance(algorithm).generateSecret(pbeKeySpec);

        // 盐
        byte[] salt = new SecureRandom().generateSeed(8);
        PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(salt, 100);

        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, pbeParameterSpec);

        System.out.println(Base64.encodeBase64String(cipher.doFinal(algorithm.getBytes())));
    }
}
