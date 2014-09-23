/**
 * comment1
 */
package oca.chapter1;

import com.trvajjala.core.*;
import static oca.chapter1.MyStatic.getNumber;

/**
 * 
 * @author tvajjala
 * @version 1.0
 */
/*
 * public is an access modifier final is non-access modifier class keyword Basic(name of the class) Runner extends keyword
 */
public class Basic extends Protected {
    JVMHook jvmHook = new JVMHook();

    int c=count;
    public static void main(String[] args) {

        System.out.println(getNumber());
        
        

        Basic basic = new Basic();
        System.out.println(basic.count +basic.c);
        System.out.println(basic.testProtectedMethod());
        
    }
}

interface Two {

}
