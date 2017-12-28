import org.apache.commons.codec.binary.Hex;

import javax.crypto.*;

public class CipherDemo
{
    public static void main(String[] args) throws Exception
    {
        SecretKey key = KeyGenerator.getInstance("AES")
                .generateKey();

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding ");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] bytes = cipher.doFinal("plain".getBytes());
        System.out.println(Hex.encodeHexString(bytes));
        System.out.println(Hex.encodeHexString(cipher.getIV()));
    }
}
