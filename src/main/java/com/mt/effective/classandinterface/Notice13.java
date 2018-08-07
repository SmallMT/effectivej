package com.mt.effective.classandinterface;

import java.io.File;

/**
 * @author mt 2018.8.7
 * 第13条
 * 使类和成员的可访问性最小
 * 就是说要尽可能的实现封装,因为良好的封装可以更好的解耦
 * 这条主要是为了解耦
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
