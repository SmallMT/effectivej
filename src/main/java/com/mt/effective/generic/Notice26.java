package com.mt.effective.generic;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author mt
 * 第26条 优先考虑泛型
 * 一个目的就是为了客户端使用泛型代码更加方便
 * 容器可以存储不同类型的对象,但是一般而言,我们更希望一个容器只存放某个类型的对象
 *
 */
public class Notice26 {
    public static void main(String[] args) {
        SimpleStack ss = new SimpleStack();
        ss.push(1);
        ss.push(2);
        // 不使用泛型则客户端取出数据时需要手动强转
        int top = (int) ss.pop();

        GenericSimpleStack1<Integer> gss1 = new GenericSimpleStack1<>();
        gss1.push(1);
        gss1.push(2);
        // 客户端不必进行手动类型转换
        Integer top1 = gss1.pop();

        GenericSimpleStack12<String> gss2 = new GenericSimpleStack12<>();
        gss2.push("1");
        gss2.push("2");
        // 客户端不必进行手动类型转换
        String top2 = gss2.pop();
    }
}

class SimpleStack {

    private Object[] elements;

    private int size;

    private static final int DEFAULT_CAPACITY = 16;

    public SimpleStack() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(Object o) {
        ensureCapacity();
        elements[size++] = o;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object o = elements[--size];
        elements[size] = null;
        return o;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, (size >> 1) + 1);
        }
    }
}

class GenericSimpleStack1<E> {

    private final int DEFAULT_CAPACITY = 16;

    private E[] elements;

    private int size;

    @SuppressWarnings("unchecked")
    public GenericSimpleStack1() {
        // 无法创建泛型数组,有两种解决方案
        // 1.使用创建一个Object[]然后强转为E[]
        // 在取元素时,就不需要在进行类型转换
//        elements = new E[DEFAULT_CAPACITY];
        // 在你能确保的情况下消除警告
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(E e) {
        // .....
    }
    public E pop() {
        // 自动类型转换
        return elements[size--];
    }
}

class GenericSimpleStack12<E> {
    private final int DEFAULT_CAPACITY = 16;

    private Object[] elements;

    private int size;

    public GenericSimpleStack12() {
        // 无法创建泛型数组,有两种解决方案
        // 2.使用创建一个Object[],然后在取元素时进行手动单个对象类型转换
        // ArrayList即采取这种方式
//        elements = new E[DEFAULT_CAPACITY];
        // 在你能确保的情况下消除警告
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void push(E e) {
        // .....
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        // 手动进行类型转换
        return (E) elements[size--];
    }
}
