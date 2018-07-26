package com.mt.effective.exception;

import java.util.*;

/**
 * @author mt
 * 第61条 抛出与抽象相对应的异常(很抽象的表述)
 *   问题在于高层中捕获到底层异常,可能这个异常在高层中与当前执行
 * 的任务没有明显的关系,这种情况让人不知所措.
 *   更高层的实现应该捕获底层的异常,同时抛出可以按照高层抽象进行
 * 解释的异常,这种做法被称为异常转译(exception translation)
 * talk is cheap,show me the code
 */
public class Notice61 {

//    exception translation
//    try {
//      use lower-level abstraction to do our bidding
//      ...
//    }catch(LowerLevelException e){
//      throw new HighLevelException();
//    }

    public static void main(String[] args) {
        Datas datas = new Datas(5);
        try {
            //have no this element
            datas.get(6);
        }catch (NoSuchElementException e) {
            //这里捕获到了NoSuchElementException异常,
            //异常信息为  数据没有这个元素
            //如果这里不对异常进行处理,就抛给高层来处理(比如说调用这个方法的地方)
            //但是高层对这个异常可能并不清楚到底是什么情况,(是元素根本不存在,
            // 还是我访问的下标越界)所以一种
            //好的处理办法就是异常转译
            //高层得到这个异常,就明确了问题所在.
            //异常转译也不能随意转译,必须是导致问题的异常转译
            //例如说这里明明是因为数组越界异常,我就是要抛出IOException
            //结果高层真的就认为了问题所在就是IO异常
            //异常转译的精髓就在于让高层明确的知道到底是因为什么而发生了异常

            //一种特殊的异常转译叫异常链,就是将底层的异常信息传递给高层
            //如果底层的异常信息对高层处理异常很有帮助的话,使用异常链就很合适
            throw new ArrayIndexOutOfBoundsException();
//            throw (ArrayIndexOutOfBoundsException)new ArrayIndexOutOfBoundsException().initCause(e);
        }
    }
}

class Datas{

    public int[] datas;
    private int size;
    public Datas(int size){
        this.size = size;
        datas = new int[size];
        Random random = new Random(47);
        for (int i = 0; i < size; i++) {
            datas[i] = random.nextInt(10);
        }
    }

    public Integer get(int index){
        if (index >= size) {
            throw new NoSuchElementException("数据没有这个元素");
        }
        return datas[index];
    }

}

