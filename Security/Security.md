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
