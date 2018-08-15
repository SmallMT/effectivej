package com.mt.effective.classandinterface;

import java.io.File;

/**
 * @author mt 2018.8.7
 * 第13条
 * 使类和成员的可访问性最小
 * 就是说要尽可能的实现封装,因为良好的封装可以更好的解耦
 * 这条主要是为了解耦
 * 总而言之,你应该始终尽可能地降低可访问性.你在仔细地设计了
 * 一个最小的公有API之后,应该防止把任何散乱的类,接口和成员变量
 * 变成API的一部分.除了公有静态final域的特殊情形之外,共有类
 * 都不应该包含共有域.并且要确保公有静态final域所引用的对象
 * 都是不可变的(这一点其实很难保证)
 */
public class Notice13 {

    public static void main(String[] args) {

    }

    //很多方法都设计成这个样子例如对外提供一个文件上传的方法
    //upFile()
    //例如java.util.Random中nextInt()方法点击查看nextInt()源码
    //发现nextInt()方法调用了本类中的protected int next()方法

    public void upFile(File file){
        //调用private修饰的up()方法来完成文件上传功能
        up(file);
    }

    private void up(File file){
        //do something about upload
    }
}
