# java安全领域共分为4个部分
- JCA   java加密体系结构 <br>
        JCA提供基本的加密框架，如证书、数字签名、消息摘要和密钥对产生器
- JCE   java加密扩展包 <br>
        JCE 在JCA的基础上作了扩展。有关JCE的实现主要在javax.crypto包(jce.jar)
- JSSE  java安全套接字扩展包 <br>
        JSS提供了基于SSL的加密功能(jsse.jar)
- JAAS  java鉴别与安全服务 <br>
        JAAS 提供了在Java平台上进行用户身份鉴别的功能。如提供一个符合标准安全机制的登录模块。

JCA和JCE是java平台提供的用于安全和加密服务的两组API。它们并不执行任何算法，只是连接应用和实际算法实现程序的一组接口。
软件开发商可以根据JCE接口将各种算法实现后，打包成一个Provider，动态地加载到Java运行环境中。 <br>
根据美国出口限制规定，JCA可出口，但是JCE对部分国家限制出口。 <br>
安全提供者是承担特定安全机制实现的第三方。提供安全提供者的公司有Sun、Bouncy Castle等。 <br>

# java.security 包

## Provider类
[ProviderList](./src/main/java/ProviderList.java) <br>
Provider类实现了java安全性的一部分或全部
security.provider 位于文件 %JDK_HOME%/jre/lib/security/java.security

## Security类
管理java程序所用到的提供者类。Security类是一个终态类。方法均为静态方法。<br>

- 添加提供者 <br>
public static int addProvider(Provider provider) <br>
    Security.addProvider(new BouncyCastleProvider());

- 移除提供者 <br>
public static synchronized void removeProvider(String name)

- 获取提供者 <br>
public static Provider getProvider(String name)

- 设置/读取java.security属性 <br>
public static void setProperty(String key, String datum) <br>
public static String getProperty(String key)

- 获取指定加密服务所对应的可用算法或类型名称 <br>
public static Set<String> getAlgorithms(String serviceName)

## MessageDigest 类
[示例](./src/main/java/MessageDigestDemo.java) <br>
实现消息摘要算法

- 获取实例 <br>
Java 8 支持 MD2 MD5 SHA-1(SHA) SHA-224 SHA-256 SHA384 SHA-512消息摘要算法，算法名不区分大小写 
[Algorithm Name](https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#MessageDigest "Algorithm Name") <br>
public static MessageDigest getInstance(String algorithm) <br>
public static MessageDigest getInstance(String algorithm, String provider) <br>
public static MessageDigest getInstance(String algorithm, Provider provider) <br>

- 更新摘要信息 <br>
public void update(***)

- 完成摘要操作 <br>
public byte[] digest(***)

- 重置 <br>
public void reset()

- 返回以字节为单位的摘要长度 <br>
public final int getDigestLength()

### DigestInputStream/DigestOutputStream 类
以MessageDigest为核心的消息摘要流实现

## Key 接口
[示例](./src/main/java/KeyDemo.java) <br>
密钥具有三个特征
- 算法 <br>
public String getAlgorithm();
- 编码形式 <br>
public byte[] getEncoded();
- 格式 <br>
public String getFormat();

SecretKey PublicKey PrivateKey三大接口继承于Key接口

### AlgorithmParameters AlgorithmParameterGenerator 类
AlgorithmParameters是一个引擎类，提供密码参数的不透明表示，在这种表示中，不可以直接访问各参数，只能得到与参数相关联的算法名及该参数集的某类编码。 <br>
AlgorithmParameterGenerator也是一个引擎类，用于生成某个特定算法中使用的参数集合。 <br>
使用Java提供的加密组件时，很少会用到这两个类，当对算法的参数要求极为严格的情况下才会考虑使用这种方式。

### KeyPair KeyPairGenerator 类
KeyPair 非对称密钥的扩展。 <br>
KeyPairGenerator KeyPair的生成类 <br>

- 获取KeyPairGenerator实例
public static KeyPairGenerator getInstance(String algorithm)

- 生成KeyPair
public KeyPair generateKeyPair()

### KeyFactory SecurityKeyFactory 类
KeyFactory 非对称密钥工厂类 <br>
SecurityKeyFactory 对称密钥工厂类 <br>

### KeyStore 类
用于管理密钥和证书的存储。是一个引擎类，提供一些接口来访问和修改密钥仓库中的信息。

- 获取实例 <br>
Java 8 支持 [KeyStore Types](https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#KeyStore) <br>
public static KeyStore getInstance(String type)

- 加载/存储密钥库 <br>
public final void load(InputStream stream, char[] password) <br>
public final void store(OutputStream stream, char[] password)

- 读取密钥/证书 <br>
public final Key getKey(String alias, char[] password) <br>
public final Certificate getCertificate(String alias)

## SecureRandom 类
强加密随机数生成器(Random Number Generator FNG) <br>

- 获取实例
public SecureRandom() 构造一个实现默认随机算法的对象 <br>
public SecureRandom(byte seed[]) 在给定种子的情况下，构造一个实现默认随机算法的对象 <br>

指定算法名称获得对象 <br>
Java 8 支持 NativePRNG NativePRNGBlocking NativePRNGNonBlocking PKCS11 SHA1PRNG(默认) Windows-PRNG
[Algorithm Name](https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#SecureRandom) <br>
public static SecureRandom getInstance(String algorithm) 

## Signature 类
[示例](./src/main/java/SignatureDemo.java) <br>
用于生成和验证签名，同样是一个引擎类

- 获取实例 <br>
Java 8 支持 [Signature Algorithms](https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#Signature) <br>
public static Signature getInstance(String algorithm)

使用Signature对象签名数据或验证数据包括三个阶段

- 初始化 <br>
初始化签署签名的私钥 <br>
public final void initSign(PrivateKey privateKey) <br>
初始化验证签名的公钥 <br>
public final void initVerify(PublicKey publicKey) <br>
public final void initVerify(Certificate certificate)

- 更新 <br>
更新要签名/验证的数据 <br>
public final void update(***)

- 签署或验证所有数据 <br>
public final byte[] sign() <br>
public final boolean verify(byte[] signature)

### SignedObject 类
用来创建实际运行时对象的类。签名对象是对原始对象的“深层复制”。

- 构造对象 <br>
public SignedObject(Serializable object, PrivateKey signingKey, Signature signingEngine)

- 获取已签名对象 <br>
public Object getObject()

- 在已签名对象上按字节数组的形式获取签名 <br>
public byte[] getSignature()

- 验证 <br>
public boolean verify(PublicKey verificationKey, Signature verificationEngine)

### Timestamp 类
数字时间戳 包括时间戳以及有关生成和签署时间戳的Timestamping Authority(TSA)的信息
 
### CodeSigner 类
代码签名

# javax.crypto 包
使用强度较高的加密算法需要替换%JAVA_HOME%/lib/security/中的文件
[JCE Unlimited](http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html)

## Mac 类
安全消息摘要/消息认证码 <br>

- 获取实例 <br>
[Mac Algorithms](https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#Mac) <br>
public static final Mac getInstance(String algorithm)

- 初始化 <br>
public final void init(Key key) SecretKey

- 更新 <br>
public final void update(***)

- 完成摘要操作 <br>
public final void doFinal(***)

## Key

### KeyGenerator SecretKeyFactory 类

- 获取实例 <br>
Java 8 [KeyGenerator Algorithms](https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#KeyGenerator) <br>
public static final KeyGenerator getInstance(String algorithm)

- 初始化 <br>
与算法无关的初始化 <br>
public final void init(int keySize) <br>
特定算法的初始化 <br>
public final void init(AlgorithmParameterSpec parameterSpec)

- 生成密钥 <br>
public final SecretKey generateKey()

### KeyAgreement 类
密钥协定类，在DH算法中使用

## Cipher 类
[示例](./src/main/java/CipherDemo.java) <br>
提供加密解密功能，构成JCE框架的核心

- 获取实例 <br>
[Cipher Algorithm Names](https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#Cipher) <br>
transformation 的格式是 "算法/工作模式/填充模式"
public static final Cipher getInstance(String transformation)

- 初始化 <br>
    public static final int ENCRYPT_MODE = 1; <br>
    public static final int DECRYPT_MODE = 2; <br>
public final void init(int mode, Key key); <br>
public final void init(int mode, Certificate certificate)

- 更新 <br>
public final byte[] update(***)

- 结束 <br>
public final byte[] doFinal(***)

- 密钥的包装与解包 <br>
初始化模式<br>
    public static final int WRAP_MODE = 3; <br>
    public static final int UNWRAP_MODE = 4;
包装 <br>
public final byte[] wrap(Key key)
解包
wrappedKeyType
    public static final int PUBLIC_KEY = 1; <br>
    public static final int PRIVATE_KEY = 2; <br>
    public static final int SECRET_KEY = 3; <br>
public final Key unwrap(byte[] wrappedKey, String wrappedKeyAlgorithm, int wrappedKeyType)

### CipherInputStream CipherOutputStream 类

### SealedObject 类
用加密算法创建对象并保护其机密性

# java.security.spec javax.crypto.spec 包
提供密钥规范和算法参数规范类的接口。获得密钥规范后，我们将有机会还原密钥对象。

## KeySpec AlgorithmParameterSpec 接口
空接口，仅用于将所有参数规范分组，并为其提供类型安全
