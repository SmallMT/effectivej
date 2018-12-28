package com.mt.effective.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mt
 * 第23条 请不要在新代码中使用原生类型
 * 原生态类型即不带任何实际类型参数的泛型名称 例如 List<E>相对应的原生态类型是List
 *
 * 原生态List 与 List<?> 区别
 *  原生态List:你可以将任何元素放入原生态List中
 *      raw list中可以放入任意类型的元素
 *  无限制通配符类型: 你不能将任何元素(除了null)放入 List<?> 中
 *      ? 表示 List中只能存放某一种类型的元素,但是这个类型我不知道
 *      为了不破坏集合的类型约束条件, List<?> 不允许放入任何元素(除了null)
 * 不使用泛型的两个例外(都源于泛型在运行时都会被擦除的事实)
 *  1.在类文字(class literal)中必须使用原生态类型
 *      List.class
 *      数组类型和基本类型都是合法的
 *      例如 String[].class int.class
 *      但是 List<String>.class 是不合法的
 *  2. 在与instanceof操作相关的时候使用原生态类型
 *      boolean isList = var instanceof List
 * 总之
 *  使用原生态类型会在运行时导致异常,不要在新代码中使用原生态类型
 *  原生态类型只是为了与引入泛型之前的代码进行兼容和互用而提供的
 *  Set<Object>是个参数化类型,表示可以包含任何对象一个集合
 *  Set<?>是一个通配符类型,表示只能包含某种未知对象类型的一个集合,这种集合
 *      不允许放入任何元素(除了null)
 *  Set是原生类型集合,它已经脱离了泛型系统
 *  前两个使用是安全的,最后一个使用是不安全的
 *
 */
public class Notice23 {

    private static void subtyping() {
        List raw = new ArrayList();
        List<String> strList = new ArrayList<>();
        List<Object> objList = new ArrayList<>();
        // ok List<String> 是 List 的子类
        raw = strList;
        // can't compile 虽然String 是Object 的子类,但是
        // List<String> 并不是 List<Object>的子类
        // objList = strList;
    }


    public static void main(String[] args) {
        // 泛型的精髓就是将异常(错误)从运行时期提前到编译时期
        List<String> strList = new ArrayList<>(10);
        // 程序是可以编译的,因为unsafeAdd接受原生态List
        unsafeAdd(strList, new Integer(10));
        // 但是在获取数据时就会抛出异常(ClassCastException)
        String s = strList.get(0);
        // 无限制通配符
        List<?> temp = new ArrayList<>(10);
        // 不能将任何(除了null之外)的元素放入List<?> 中
        // temp.add(1);
        temp.add(null);
    }


    /**
     * 如果使用原生态类型例如List,就会失去类型安全性,但是如果使用参数化类型
     * 例如List<String>则不会
     * @param list
     * @param o
     */
    public static void unsafeAdd(List list, Object o) {
        list.add(o);
    }


}
