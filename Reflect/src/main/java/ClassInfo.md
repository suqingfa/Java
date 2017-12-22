# 类加载器
    - Class cl=A.class; JVM将使用类A的类装载器,将类A装入内存(前提是:类A还没有装入内存),不对类A做类的初始化工作.返回类A的Class的对象
    - Class cl=对象引用o.getClass();返回引用o运行时真正所指的对象(因为:儿子对象的引用可能会赋给父对象的引用变量中)所属的类的Class的对象 
    - Class.forName("类名"); .装入类A,并做类的初始化
    
    Class.getResourceAsStream() 会指定要加载的资源路径与当前类所在包的路径一致。

# Class.getXXX()/Class.getDeclaredXXX
    getXXX 获取当前类的所有public的XXX，包括父类实现的申明的
    getDeclaredXXX 获取当前类实现的申明的所有XXX, 不包括父类的