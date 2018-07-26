package com.mt.effective.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mt
 * 第62条  没个方法抛出的异常都要有文档
 *   始终要单独生命每一个受检异常,并利用Javadoc的@throws标记
 * 准确记录下抛出每个异常的条件
 *   不要为运行时异常使用throws声明抛出
 */
public class Notice62 {
    public static void main(String[] args) {
        Notice62Data datas = new Notice62Data();
        try {
            datas.addInteger(1);
            datas.addInteger(0);
        }catch (ZeroCanNotBeAcceptException e) {
            e.printStackTrace();
        }
    }
}

class Notice62Data{
    private List<Integer> datas = new ArrayList<Integer>();

    /**
     * 单独的为每一个受检查异常使用throws声明抛出,并使用javadoc文档
     * 说明具体的抛出该异常的原因
     * @param data
     * @throws ZeroCanNotBeAcceptException 当被插入的元素为0时,会
     *      抛出该异常
     */
    public void addInteger(int data) throws ZeroCanNotBeAcceptException{
        if (data == 0) {
            throw new ZeroCanNotBeAcceptException("0不能被添加进来");
        }
        datas.add(data);
    }

    /**
     * 不要写成这种形式
     * public Integer get(int index) throws ArrayIndexOutOfBoundsException{...}
     * 运行时异常 不要使用throws声明抛出
     * @param index
     * @return
     */
    public Integer get(int index) {
        return datas.get(index);
    }
}

class ZeroCanNotBeAcceptException extends Exception{
    public ZeroCanNotBeAcceptException(){
        super();
    }
    public ZeroCanNotBeAcceptException(String msg){
        super(msg);
    }
}


