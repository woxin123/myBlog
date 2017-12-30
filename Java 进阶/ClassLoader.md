## 类加载器
类的加载器是将编译生成的.class文件加载到内存中，并生成与之对应的java.lang.Class对象.
### 1. 类加载器的简介
类加载器负责加载所有的类，系统为所有被载入内存（也就是被加载）的类生成一个java.lang.Class实例，一个类一旦被加载之后就不会再次被加载。当然在这里使用权限定类名，也就是包名和类名作为一个类的唯一标识。在源文档中权限定类名被称作binary name。

在JVM启动时会形成由3个类组成的初始类加载结构：
+ Bootstarp ClassLoader:根类加载器。
+ Extension ClassLoader:扩展的类加载器。
+ System ClassLoader:系统类加载器。

Bootstarp意为引导，所以Bootstarp ClassLoader也被称为引导类加载器。由它来加载Java的核心类。
根类加载器非常特殊，它不是java.lang.ClassLoader的子类，它是由C++语言编写，JVM自身实现的。它加载的是JRE/lib目录下的核心库类。
Extension ClassLoader扩展类加载器，它负责加载扩展目录中的jar包。扩展目录是JRE/lib/etc或者由java.ext.dirs属性指定的目录。在Java9之前它所对应的类是ExtClassLoader，但是在Java9中出现了一个PlatformClassLoader类，在下面的程序中可以看到。
System ClassLoader系统类加载器，它是由Sun的AppClassLoader实现的，所以也称为应用类加载器。它负责在JVM启动时加载java -classpath、java.class.path系统属性或者系统环境变量CLASSPATH所指的Jar包和类路径所指的目录下的类库加载到内存中。
这三个类加载器之前的关系是，根加载器Bootstarp ClassLoader是扩展类加载器ExtClassLoader的父类，而ExtClassLoader是AppClassloader的父类。
下面的这个程序可以验证。
```java
public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println("当前的类加载器：" + classLoader);
        System.out.println("当前类加载器的父类：" + classLoader.getParent());
        System.out.println("当前类加载器的父类的父类：" + classLoader.getParent().getParent());
    }
}
/**
 * Java9输出结果为：
 * 当前的类加载器：jdk.internal.loader.ClassLoaders$AppClassLoader@6a6824be
 * 当前类加载器的父类：jdk.internal.loader.ClassLoaders$PlatformClassLoader@77468bd9
 * 当前类加载器的父类的父类：null
 * Java9之前的输出结果为：
 * 当前的类加载器：loader:sun.misc.Launcher$AppClassLoader@18b4aac2
 * 当前类加载器的父类：loadersun.misc.Launcher$ExtClassLoader@1d44bcfa
 * 当前类加载器的父类的父类：null
 */
```
从上面的程序中我们看出当前的ClassLoader是AppClassLoader，父是PlatformClassLoader，当然在Java9之前是ExtClassLoader，由于当前类加载器的祖父类根类加载器是由C++编写的，所以获取不到。

### 2.类加载器的加载机制
类加载器的加载机制有如下3中：
+ 全盘负责
+ 父类委托，又称双亲委派
+ 缓存机制
全盘负责：全盘负责就是着当一个类加载器加载一个类时，该类所有的依赖和其他引用的Class均有该类负责加载，除非显示的指定使用其它类加载器。
父类委托：父类委托是指先委托父类加载器去寻找目标类，只有父类找不到时，才从自己的路径下加载。
缓存机制：缓存机制是所有被加载过的类都会被缓存，当程序需要某个类是会先从缓存中找，如果找不到，才会去加载。
一般的NoSuchMethodError就是由于父类委托机制导致的，加入在类路径中放有多个不同版本的jar包，那么由于是父类委托，所以会从其中一个中加载该类，那么有可能需要加载的类是另外一个版本包下的，而另一版本包下的该类，没有那个方法，就会出现NoSuchMethodError。