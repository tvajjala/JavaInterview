package oca.chapter1;

/**
 * 
 * @author tvajjala
 * @version 1.0
 */
/**
 * Non - Access Modifier synchronized : This constraint is used to protect the integrity of data that might be accessed and changed by multiple threads
 * concurrently. You can’t mark classes, interfaces, or variables with this modifier.
 * 
 * native : A native method calls and makes use of libraries and methods implemented in other programming languages such as C or C++. You can’t mark classes,
 * interfaces, or variables with this modifier.
 * 
 * transient : A transient variable isn’t serialized when the corresponding object is serialized. The transient modifier can’t be applied to classes,
 * interfaces, or methods.
 * 
 * volatile : A volatile variable’s value can be safely modified by different threads. Classes, interfaces, and methods cannot use this modifier.
 * 
 * strictfp : Classes, interfaces, and methods defined using this keyword ensure that calculations using floating-point numbers are identical on all platforms.
 * This modifier can’t be used with variables.
 * 
 * IN SCOPE FOR EXAM abstract :
 * 
 * final :
 * 
 * static :
 * 
 */
public class NonAccess {

    final int SIZE;

    {
        // perform some logic before assigning to final

        SIZE = 100;
    }

    static int a = count();

    static int count() {
        return 4;
    }

    public synchronized void mySync() {
        age = 5;
    }

    public native void myNative();

    transient String name;
    volatile int age;

    static double notStrictFP(double a) {
        return (a / 2) * 2;
    }

    static strictfp double strictFP(double a) {
        return (a / 2) * 2;
    }

    public static void main(String[] args) {
        double d = Double.MAX_VALUE;
        Dear dear=new Dear();
        dear.name="TR";
        System.out.println(dear.name);

        System.out.println(notStrictFP(d));
        System.out.println(strictFP(d));

        // NonAccess access=new NonAccess();
        // access.myNative();

    }
}
class Dear{
    String name;
}