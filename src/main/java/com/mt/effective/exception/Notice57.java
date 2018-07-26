package com.mt.effective.exception;

/**
 * @author mt
 * 第57条 只针对异常情况才使用异常
 *   异常是为了在异常情况下使用才设计的,不要将它们用于普遍的控制流
 */
public class Notice57 {

    public static void main(String[] args) {
        //例如一下的代码  试图使用抛出异常的形式来阻止无限迭代
        //这似乎也可以达到目的甚至有人认为这可以优化java性能
        //首先这并不能优化java性能其次还有可能得到意外的结果
        int[] arrs = {2,3,5,1,6,2,9};
        try{
            int i = 0;
            while (true) {
                //如果这里是复杂操作,例如调用了某个方法对数组进行操作,抛出了
                //ArrayIndexOutOfBoundsException则在未完成迭代之前程序就结束了
                System.out.println(arrs[i++]);
                f();
            }
        }catch (ArrayIndexOutOfBoundsException e) {
            //do nothing
        }

    }

    public static void f() {
        throw new ArrayIndexOutOfBoundsException();
    }
}
