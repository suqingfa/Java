
# java.time  java 8 time 包

## Instant/Duration 时间点/时间差
[示例](./src/main/java/time/InstantDemo.java)

用于 Instant/Duration 的算术运算   
|    方法    | 描述 |   
| ---------- | ---  |   
| plus minus | 在当前 Instant/Duration 加减一个Duration |  
| plusNanos plusMillis plusSeconds |    
| minusNanos minusMillis minusSeconds |     
| plusMinutes plusHours plusDays |  
| minusMinutes minusHours minusDays|    
| multipliedBy dividedBy negated| 返回当前 Duration 缩放后的值   
| isZero isNegative |

## LocalDate/LocalDateTime 本地时间
[示例](./src/main/java/time/LocalDateDemo.java)    
不包含时区信息，不对应精确的时刻。

### 日期调整器
例如 每个月的一个星期天 这样的日期可以通过日期调整器获取。
