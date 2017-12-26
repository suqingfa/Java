
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
