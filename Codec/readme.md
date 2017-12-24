# 概述
- org.apache.commons.codec 定义了一些编码转换的接口
- org.apache.commons.codec.binary 完成编码转换实现，如Base64、二进制，十六进制和字符集编码
- org.apache.commons.codec.digest 该包仅有一个类DigestUtils，是对原生消息摘要实现的改进。
- org.apache.commons.codec.language 完成语言和语音编码器的实现
- org.apache.commons.codec.net 完成网络相关的编码和解码，如url编码/解码

# Bas64

- 构建 <br>
控制每行字符数，行未符号及是否支持url <br>
public Base64(final int lineLength, final byte[] lineSeparator, final boolean urlSafe)

- 静态方法

以字符数组形式返回base64结果 <br>
public static byte[] encodeBase64(final byte[] binaryData) 

以字符数组形式返回base64结果，每76个字符追加一个回车符 <br>
public static byte[] encodeBase64Chunked(final byte[] binaryData)

以字符串形式返回base64结果，每76个字符追加一个回车符 <br>
public static String encodeBase64String(final byte[] binaryData)

以字符数组形式返回Url base64结果 <br>
public static byte[] encodeBase64URLSafe(final byte[] binaryData)

以字符串形式返回Url base64结果 <br>
public static byte[] encodeBase64URLSafeString(final byte[] binaryData)

### Base64InputStream Base64OutputStream

# Hex
用于十六进制编码/解码

- 编码 <br>
public static char[] encodeHex(final byte[] data) <br>
public static char[] encodeHex(final byte[] data, final boolean toLowerCase) <br>

public static String encodeHexString(final byte[] data) <br>
public static String encodeHexString(final byte[] data, final boolean toLowerCase)

protected static char[] encodeHex(final byte[] data, final char[] toDigits) <br>

- 解码 <br>
public static byte[] decodeHex(final char[] data) <br>
public static byte[] decodeHex(final String data)

# DigestUtils

- md5 <br>
public static byte[] md5(final InputStream data) <br>
public static byte[] md5(final String data) <br>
public static String md5Hex(final InputStream data)<br>
public static String md5Hex(final byte[] data) <br>
public static String md5Hex(final String data)

- sha sha 256 sha384 sha512
