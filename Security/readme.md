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

## EncodedKeySpec 类
[示例](./src/main/java/KeyDemo.java)
用编码格式来表示公钥私钥。

### X509EncodedKeySpec 类
使用X509标准作为规范管理编码

### PKCS8EncodedKeySpec 类
使用PKCS#8标准作为规范管理编码

### SecretKeySpec 类
继承自SecretKey。 根据一个字节数组构造一个SecretKey。

### DESKeySpec 类

# java.security.cert 包
[示例](./src/main/java/CertDemo.java)
提供证书解析和管理、证书撤销列表(CRL)和证书路径的类和接口

## Certificate 类
用于证书管理的抽象类。证书有多种类型，如X509证书、PGP证书和SDSI证书。 <br>

提供三个基本操作

- 返回证书的编码形式 <br>
public abstract byte[] getEncoded()

- 验证证书 <br>
public abstract void verify(PublicKey key) <br>
public abstract void verify(PublicKey key, String sigProvider) <br>

- 从证书中获取公钥 <br>
public abstract PublicKey getPublicKey();

其它操作
- 获取证书类型 X509 PGP SDSI <br>
public final String getType()

## CertificateFactory 类
将证书导入程序中

- 获取实例 <br>
public static final CertificateFactory getInstance(String type)

- 生成证书对象 <br>
public final Certificate generateCertificate(InputStream inStream) 使用输入流初始化证书 <br>
public final Collection<? extends Certificate> generateCertificates(InputStream inStream) 从输入流读取证书集合 <br>

- 生成证书路径对象 <br>
public final CertPath generateCertPath(InputStream inStream) <br>
public final CertPath generateCertPath(InputStream inStream, String encoding) <br>
public final CertPath generateCertPath(List<? extends Certificate> certificates)

- 生成证书撤销列表 <br>
public final CRL generateCRL(InputStream inStream) <br>
public final Collection<? extends CRL> generateCRLs(InputStream inStream) <br>

- 返回支持的证书路径编码列表 <br>
public final Iterator<String> getCertPathEncodings()

## X509Certificate 类
Certificate类的子类

- 验证证书有效期 <br>
public abstract void checkValidity() <br>
public abstract void checkValidity(Date date)

- 获取证书签名 <br>
public abstract byte[] getSignature();

## CRL X509CRL 类
- 检查证书是否在CRL中 <br>
public abstract boolean isRevoked(Certificate cert);

### X509CRLEntry 类
用于撤销X.509证书

## CertPath CertPathBuilder CertPathValidator 类
证书链

# javax.net.ssl 包
[示例](./src/main/java/SslDemo.java) <br>
提供用于安全套接字的类。

## KeyManagerFactory 类
引擎类，用于管理密钥。每个密钥管理器管理特定类型的密钥、由安全套接字所使用的密钥内容。密钥内容是基于KeyStore或特定源。

- 获取实例 <br>
[KeyManagerFactory Algorithms](https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#KeyManagerFactory) <br>
public static final KeyManagerFactory getInstance(String algorithm) <br>
- 获取默认算法名称 <br>
public static final String getDefaultAlgorithm()

- 初始化 <br>
public final void init(KeyStore ks, char[] password) 

- 获取密钥管理器
public final KeyManager[] getKeyManagers()

## TrustManagerFactory 类
管理信任材料的管理器工厂

- 获取实例 <br>
[TrustManagerFactory Algorithms](https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#TrustManagerFactory) <br>
public static final TrustManagerFactory getInstance(String algorithm) <br>
- 获取默认算法名称 <br>
public static final String getDefaultAlgorithm()

- 初始化 <br>
public final void init(KeyStore ks)

- 返回信任管理器 <br>
public final TrustManager[] getTrustManagers()

# CRC32
java.util.zip.CRC32 <br>
update(***) <br>
long getValue()

# PBE Password Based Encryption 基于口令加密
[示例](./src/main/java/PbeDemo.java)

# Java Security
[示例](./src/main/java/JavaSecurity.java)

## SecurityManager 类
SecurityManager在Java语言中的作用就是检查操作是否有权限执行。 <br>
打开SecurityManager -D java.security.manager <br>
获取实例 System.getSecurityManager() <br>
SecurityManager 包含很多check** 方法，分别囊括了文件的读写删除和执行、网络的连接和监听、线程的访问、以及其他包括打印机剪贴板等系统功能。

## AccessController 类
AccessController 是一个无法实例化的类，只包含静态方法 <br>
SecurityManager 的所有 check 方法，都是基于AccessController。 <br>

AccessController组成
- CodeSource <br>
CodeSource就是一个简单的类，用来声明从哪里加载类。

- Permission <br>
Permission类是AccessController处理的基本实体。Permission类本身是抽象的，它的一个实例代表一个具体的权限。
权限有两个作用，一个是允许Java API完成对某些资源的访问。
另一个是可以为自定义权限提供一个范本。权限包含了权限类型、权限名和一组权限操作

- Policy <br>
策略是一组权限的总称，用于确定权限应该用于哪些代码源。
代码源标识了类的来源，权限声明了具体的限制。
策略就是将二者联系起来，策略类Policy主要的方法就是getPermissions(CodeSource)和refresh()方法。 <br>
在JVM中，任何情况下只能安装一个策略类的实例。
安装策略类可以通过Policy.setPolicy()方法来进行，也可以通过java.security文件里的policy.provider=sun.security.provider.PolicyFile来进行。
jdk1.6以后，Policy引入了PolicySpi，后续的扩展基于SPI进行。

- ProtectionDomain <br>
保护域可以理解为代码源和相应权限的一个组合。表示指派给一个代码源的所有权限。
保护域是一个代码源的一组权限，而策略是所有的代码源对应的所有的权限的关系。 <br>
JVM中的每一个类都一定属于且仅属于一个保护域，这由ClassLoader在define class的时候决定。
但不是每个ClassLoader都有相应的保护域，核心Java API的ClassLoader就没有指定保护域，可以理解为属于系统保护域。

AccessController的使用还是重度关联类加载器的。如果都是一个类加载器且都从一个保护域加载类，那么你构造的checkPermission的方法将正常返回。 

AccessController 另一个比较实用的功能是doPrivilege（授权）。
假设一个保护域A有读文件的权限，另一个保护域B没有。
那么通过AccessController.doPrivileged方法，可以将该权限临时授予B保护域的类。
而这种授权是单向的。也就是说，它可以为调用它的代码授权，但是不能为它调用的代码授权。

## ClassLoader
ClassLoader对安全模型有三方面的影响
- 可以结合JVM定义名称空间，以保护Java语言本身安全特性的完整性。
- 在必要时调用SecurityManager保证代码在定义或者访问类时有适当的权限。
- 建立了权限与类对象之间的映射，这样AccessController就知道哪些类拥有哪些权限了。
而这可以绕过建立自定义Policy类，通过自定义ClassLoader并在其中定义类权限而实现。

不同的ClassLoader可以装在相同包名的类，而这时，其实对于每个ClassLoader，有一个自己的名字空间。
为啥这么干？显然啊，就不说包冲突这事了，从安全角度看，你冒名顶替个com.sun.xx咋办？

类加载器是个层次结构，最基础的是系统类加载器，下面有很多子类。加载一个类时，以委托的形式逐层询问，即父类优先加载，不能加载时再由子类加载。

一旦为一个域的类定义类加载器，那么其他域的类加载器的整个链路上不包含对应域，也就隔离了彼此的类加载。

类装载器加载类时要做的
- 询问安全管理器是否允许访问当前处理的类。这一步可选，一般在loadClass()方法开始处实现。对应accessClassInPackage权限。 

- 如果类装载器已经载入了此类，它将寻找以前定义的类对象，并返回该对象。<br>
否则，类装载器将询问其父类，递归查看父类装载器是否知道如何载入此类。
因此总会是系统类加载器最先加载，从而避免了核心Java API中的类被其他自定义的类冒充。

- 询问安全管理器是否允许程序创建当前处理的类。这一步可选，如果实现，则需要在findClass()的开始处完成。
这一步不是在操作开始时完成，而是在询问父类装载器之后进行。这一步对应为defineClassInPackage权限。 

- 向一个字节数组中读入类文件。读取文件以及创建字节数组的方式因类加载器不同而不同。在findClass()中完成。

- 为该类创建合适的保护域。保护域可以来自默认安全模型（即从策略文件中得到），也可以由类加载器扩展。
还有一种方法是可以创建一个代码源对象，并采用其保护域定义。这一步也在findClass()中完成。 

- 在findClass()方法中，通过调用defineClass()方法，可以由字节码构造一个Class对象。
如果使用的是第6步中的代码源，则需要调用getPermissions()方法查找与代码源相关的权限。
defineClass()方法还保证了字节码必须通过字节码校验器的检查。 

- 最后还需要解析该类。即它所直接引用的类也应由当前类加载器找到。
只有直接引用的才算，作为实例变量、方法参数或局部变量来使用的类不算。
这一步在loadClass()中完成。对应上面代码中的resovleClass()。
