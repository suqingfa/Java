
## 集合与 steam 的差异
- 流并不存储元素。这些元素可能 存储在底层的集合中或者按需生成。
- 流的操作不会修改其数据源，
- 流的操作是尽可能随性的执行。

操作流的典型流程
- 创建流。
- 指定将初始流转换成其它流中间操作。
- 应用终止操作，从而产生结果。这个操作会强制强制之前的惰性操作。从此之后，这个流就再不能用了。

## 流的创建
[示例](./src/main/java/stream/GetStream.java) <br>
用Collection接口的steam/parallelStream方法将任何集成转换为一个流 <br>
用 Stream.of()/Arrays.stream() 将一个数组转换成流 <br>
用 Stream.generate()/Stream.iterate() 创建无限流 <br>
IntStream,LongStream,DoubleStream 等特殊流 <br>
用它API生成

## 流的中间操作
[示例](./src/main/java/stream/Intermediate.java)

- 常规对象流和基本类型流之间的相互转换 <br>
对象流（regular object stream）的mapToInt(), mapToLong()，mapToDouble() <br>
基本类型流（primitive streams）中的mapToObj() <br>

- filter map slatMap
- limit skip concat
- distinct sorted peek

## 流的终结操作
[示例](./src/main/java/stream/Terminal.java)

### 流的简单终结操作
返回 Optional<T>
- count max min 
- findFirst findAny anyMatch allMatch noneMatch

### 收集结果 
- forEach
- toArray
- collect <br>
    Collector
    - toList
    - toSet
    - toCollection
    - joining
    - summarizingInt/Long/Double 生成对象收集器，用来保存结果个数、总和、平均值、最大/最小值。
    - toMap 
    - groupBy

### reduce
