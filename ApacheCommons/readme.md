
[所有组件列表](http://commons.apache.org/)

# codec 概述
通用编解码算法 <br>
[示例](./src/main/java/Codec.java)

- org.apache.commons.codec 定义了一些编码转换的接口
- org.apache.commons.codec.binary 完成编码转换实现，如Base64、二进制，十六进制和字符集编码
- org.apache.commons.codec.digest 该包仅有一个类DigestUtils，是对原生消息摘要实现的改进。
- org.apache.commons.codec.language 完成语言和语音编码器的实现
- org.apache.commons.codec.net 完成网络相关的编码和解码，如url编码/解码

## Bas64

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

## Hex
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

## DigestUtils

- md5 <br>
public static byte[] md5(final InputStream data) <br>
public static byte[] md5(final String data) <br>
public static String md5Hex(final InputStream data)<br>
public static String md5Hex(final byte[] data) <br>
public static String md5Hex(final String data)

- sha sha 256 sha384 sha512

# CLI 命令行参数解析器
[示例](./src/main/java/Cli.java)

# IO 工具包

## FileDeleteStrategy 删除文件

- 使用普通删除策略 <br>
FileDeleteStrategy strategy = FileDeleteStrategy.NORMAL;

- 使用强制删除策略 <br>
FileDeleteStrategy strategy = FileDeleteStrategy.FORCE;

- 删除文件 <br>
删除失败抛出异常 <br>
public void delete(final File fileToDelete) throws IOException <br>
删除失败返回false <br>
public boolean deleteQuietly(final File fileToDelete)

## FileUtils 类
文件操作工具包 简化 文件读写删除复制等操作

## IOUtils 类
简化IO操作

# Lang 
[示例](./src/main/java/Lang.java)
Lang为java.lang API提供了大量的辅助工具，特别是String操作方法，基本数值方法，对象反射，并发性，创建和序列化以及系统属性。

## ArrayUtils 数组工具
提供了对基本类型（例如int）、包装类型（例如Integer）和其他引用类型数组的支持。
该类尝试优雅地处理null值。如果数组为null，并不会抛出异常。如果数组中某个元素为null，才会抛出异常。

实现了对数组的 增删查改等

## RandomStringUtils 生成随机字符串

## SerializationUtils 序列化与反序列化

## Fraction 分数
继承了Number类，提供精确存储分数的功能。提供了分数运算的方法。

- 获取实例 <br>
public static Fraction getFraction(double value) <br>
public static Fraction getFraction(String str) <br>
private Fraction(final int numerator, final int denominator) <br>
public static Fraction getFraction(***) <br>
最简分数
public static Fraction getReducedFraction(int numerator, int denominator) <br>

- 获取分子分母等 <br>
public int get***()

- 约分 <br>
public Fraction reduce()

- 基本操作
    - public Fraction add(final Fraction fraction)
    - public Fraction subtract(final Fraction fraction)
    - public Fraction multiplyBy(final Fraction fraction)
    - public Fraction divideBy(final Fraction fraction)
    - public Fraction invert()
    - public Fraction pow(final int power)

# Math
在得到一组简单的统计学变量时，可以使用描述统计学对其进行初步分析,为下一步分析提供理论依据。
Commons Math组件的DescriptiveStatistics类提供了相关方法。

## DescriptiveStatistics 统计计算
DescriptiveStatistics类管理单变量的数据集并基于该数据集进行统计计算。windowSize属性用来设置数据集的大小，默认情况下是不限制数据集大小的。
由于该类会保存所有的数据，所以对于数据量比较大的统计运算，推荐使用SummaryStatistics类。

常用方法

增加元素 <br>
public void addValue(double v)

获得第index个元素 <br>
public double getElement(int index)

几何平均数   getGeometricMean() <br>
峰度         getKurtosis() <br>
最大值       getMax() <br>
最小值       getMin() <br>
算数平均数   getMean() <br>
元素个数     getN() <br>
p分位数      getPercentile(double p) <br>
偏度         getSkewness() <br>
标准差       getStandardDeviation() <br>
和           getSum() <br>
平方和       getSumsq() <br>
方差         getVariance() <br>

## Frequency 简单的直方图
简单的直方图

方法

addValue(v)        使v的频数加1
getCount(v)        v的频数
getCumFreq(v)      v的累计频数
getPct(v)          v的频数百分比
getCumPct(v)       v的累计频数百分比

## SimpleRegression 一元线性回归计算
对于给定的平面上的点集，如果其分布形状类似于直线，则可以进行一元线性回归分析。 <br>
SimpleRegression 使用最小二乘法求解y = intercept + slope * x。

## RealMatrix 实数矩阵
矩阵是线性代数的基础，其常用运算包括矩阵的加法、减法、乘法、转置等。Commons Math组件的RealMatrix接口定义了这些方法。

## Complex 复数 
由于负数不能开平方等原因，对实数集进行了扩展，引入了虚数的概念，两者并称为复数。Commons Math组件的Complex类定义了复数运算的方法。

## TDistributionImpl T 分布常用计算
正态分布是统计学中重要的分布，但是由于数据的方差不易计算，实际应用中更倾向使用T分布。Commons Math组件的TDistributionImpl类定义了T分布常用计算方法。
