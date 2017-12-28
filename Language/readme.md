
# String

## String join 效率测试
[示例](./src/main/java/string/StringJoinSpeed.java) <br>
环境 jdk: jdk8 cpu: I7-7700hq <br>
测试结果:

- 连接后字符串长度为 100 时
执行 100000000 连接操作
    - StringBuilder 用时 0.9 s
    - StringBuffer 用时 2.4 s
    - String 用时 2.4 s

- 连接后字符串长度为 100000000 时
    - StringBuilder 用时 0.7 s
    - StringBuffer 用时 0.9 s

- 连接后字符串长度为 100000 时
    - String 用时 2.9 s

## 中文排序 
[示例](./src/main/java/string/ZhSort.java)

# 正则表达式
[示例](./src/main/java/regular/reflect.Main.java)

# net 

## udp
[Receive](./src/main/java/net/udp/Receive.java)
[Send](./src/main/java/net/udp/Send.java)

## tcp
[Server](./src/main/java/net/tcp/Server.java)
[Client](./src/main/java/net/tcp/Client.java)

## web

### url
[示例](./src/main/java/net/web/URLDemo.java)

### urlConnection
[示例](./src/main/java/net/web/URLConnectionDemo.java)

# Reflect 反射

## 通过反射获取类信息
[示例](./src/main/java/reflect/ClassInfo.java)

Class.getXXX()/Class.getDeclaredXXX    
getXXX 获取当前类的所有public的XXX，包括父类实现的申明的    
getDeclaredXXX 获取当前类实现的申明的所有XXX, 不包括父类的    

## 动态代理
[示例](./src/main/java/reflect/DynamicProxy.java)    
使用代理动态实现接口或实现子类

## 测试反射效率
[代码](./src/main/java/reflect/Main.java)    
环境 os:windows10 jdk:jdk8 cpu:7-7700hq    
测试结果 通过 Constructor<Integer>.newInstance(Object ... initargs) 方法创建 Integer.MAX_VALUE 个 Integer 对象大约需要 7s

## 通过反射修改不可修改的数据
[示例](./src/main/java/reflect/Change.java)
