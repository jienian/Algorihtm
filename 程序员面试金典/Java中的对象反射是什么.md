# 如果你手上有一个神奇的工具箱，可以让你在需要的时候随意打开任何一个装有秘密功能的黑盒子，看看里面有什么、它是怎么工作的，甚至还能按自己的意愿改改它的工作方式。在Java中，反射就是这样一种工具。它允许我们在运行时对类进行探查和修改，哪怕我们在编写程序时不知道那些类的具体信息。

```java
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        // 创建一个字符串对象
        String text = "Hello, World!";

        // 获取String类的Class对象
        Class<?> clazz = text.getClass();

        // 探查方法
        Method method = clazz.getMethod("substring", int.class, int.class);
        String result = (String) method.invoke(text, 7, 12);
        System.out.println("Substring result: " + result);

        // 探查并修改字段（此例为说明目的，String类的value字段实际上是private final的）
        Field field = clazz.getDeclaredField("value");
        field.setAccessible(true); // 设置可访问性，允许修改私有字段
        char[] value = (char[]) field.get(text);
        System.out.println("Original value: " + new String(value));

        // 注意：直接修改String对象的内部数组是不安全的，这里仅为示例反射的能力
    }
}

```
