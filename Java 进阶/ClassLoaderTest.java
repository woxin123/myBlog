import com.sun.org.apache.xpath.internal.SourceTree;

public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println("当前的类加载器：" + classLoader);
        System.out.println("当前类加载器的父类：" + classLoader.getParent());
        System.out.println("当前类加载器的父类的父类：" + classLoader.getParent().getParent());
    }
}