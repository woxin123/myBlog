import com.sun.org.apache.xpath.internal.SourceTree;

public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println("��ǰ�����������" + classLoader);
        System.out.println("��ǰ��������ĸ��ࣺ" + classLoader.getParent());
        System.out.println("��ǰ��������ĸ���ĸ��ࣺ" + classLoader.getParent().getParent());
    }
}