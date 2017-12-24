import org.apache.commons.codec.binary.Hex;

import java.security.PublicKey;
import java.security.cert.*;

public class CertDemo
{
    public static void main(String[] args) throws Exception
    {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("x.509");

        // 读取证书
        X509Certificate certificate = (X509Certificate) certificateFactory.generateCertificate(CertDemo.class.getResourceAsStream("certificate.cer"));

        System.out.println(certificate.getType());

        // 验证证书
        // 自签名证书
        certificate.verify(certificate.getPublicKey());

        // 获取证书公钥
        PublicKey publicKey = certificate.getPublicKey();
        System.out.println(Hex.encodeHexString(publicKey.getEncoded()));

        // X509验证证书有效期
        certificate.checkValidity();

        // 证书信息
        System.out.println(certificate.getVersion());
        System.out.println(certificate.getSerialNumber());
        System.out.println(certificate.getBasicConstraints());

        // 证书签名
        System.out.println(Hex.encodeHexString(certificate.getSignature()));
    }
}
