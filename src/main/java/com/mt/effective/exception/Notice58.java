package com.mt.effective.exception;


/**
 * @author mt
 * 第58条  对可恢复的情况使用受检查的异常,对编程错误使用运行时异常
 *   如果期望调用者能够适当的恢复异常情况那么请使用受检查的异常例如
 * FileNotFoundException 当调用者获取这个错误的时候常常表示文件路径错误(常见的一种情况)
 * 调用者可以也能够对路径进行恢复(修复)那么请使用受检查异常
 *   不受检查的可抛出结构包括了运行时异常(RuntimeException)和错误
 *   错误往往表示资源不足等使程序无法继续执行的情况,这是几乎被普遍接受
 * 的惯例,最好不要实现任何新的Error子类
 *   运行时异常表示编程错误,大多数的运行时异常表示前提违例,指的是API的调用者
 * 没有遵守API规范建立的约定.例如ArrayIndexOutOfBoundsException,调用
 * 数组的访问,约定了数组的下标值在0到length-1之间,违反了这一个前提则会得到
 * ArrayIndexOutOfBoundsException
 */
public class Notice58 {

    public static void main(String[] args) {

    }

}
