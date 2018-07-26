package com.mt.effective.exception;

/**
 * 第60条  优先使用标志的异常
 *   代码的复用是肯定值得提倡的,异常也不例外.
 *   如果java标准类库中的现有异常能够满足需求的话,就不要再自定义异常了.
 * 优先使用已有的标准异常
 *   主要好处有3个
 *     1. 可以让你的API更加容易学习和使用,因为标准异常是每个程序员
 *   已经熟悉的.(这是最主要的好处)
 *     2. 使得程序的可读性高,因为不会出现明明含义一致但是大多数程序员
 *   不熟悉的异常
 *     3. 异常类越少,意味着内存印迹越小,加载这些类的时间开销就越小
 *   下面列举被复用较多的异常
 *     IllegalArgumentException     非null的参数不正确
 *     IllegalStateException        对于方法调用而言,对象状态不合适
 *     NullPointerException         在禁止使用非null的情况下使用null
 *     IndexOutOfBoundException     下标参数越界
 *
 */
public class Notice60 {

}
