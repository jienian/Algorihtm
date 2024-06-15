# final是一个限定符，用于声明不可变的变量、不可覆盖的方法和不可继承的类。
```java
    public static final int MAX_SIZE = 100;

```



# finally是一个代码块，保证无论有无异常，都会执行的代码段，用于资源清理。
```java
try {
} catch (Exception e) {
    //....
} finally {
    System.out.println("finally is code, try and catch..");
}
```



# finalize是一个方法，用于在对象被垃圾回收前执行清理资源的操作，但通常不推荐使用，因为它可能导致资源回收不及时。

```java
    protected void  finalize() throws Throwable {
        // 关闭文件，清理资源...
    }


```