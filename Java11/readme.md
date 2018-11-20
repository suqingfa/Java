#JAVA 9

## 集合加强
List/ Set/ Map 都添加了 of 和 copyOf 方法，它们两个都用来创建不可变的集合

## Stream 加强
- 增加单个参数构造方法，可为null
Stream.ofNullable(null).count(); // 0
- 增加 takeWhile 和 dropWhile 方法
- iterate重载

## InputStream 加强
transferTo方法，可以用来将数据直接传输到 OutputStream，这是在处理原始数据流时非常常见的一种用法

## HTTP Client API


# JAVA 10
## 类型推倒
    var i = 10;
    System.out.println(i);
    
    for (var i = 0; i < 100; i++)
    {
        
    }

局部变量类型推断不能用在以下场景
- 类成员变量类型
- 方法返回类型
- Lambda 表达式

# JAVA 11

## String 加强
// 判断字符串是否为空白
" ".isBlank();
// 去除首尾空格
" Javastack ".strip();
// 去除尾部空格 
" Javastack ".stripTrailing();
// 去除首部空格 
" Javastack ".stripLeading();
// 复制字符串
"Java".repeat(3);
// 行数统计
"A\nB\nC".lines().count();

## 一个命令编译运行源代码
java Main.java

