package com.mt.effective.generic;

/**
 * @author mt
 * 第24条 消除非受检警告
 * 如果无法消除警告,同时又可以证明引起警告的代码是类型安全的(只有在这种情况下)
 * 可以使用一个 @SuppressWarnings("unchecked") 注解来禁止这条警告
 * SuppressWarnings可以用在任何粒度的级别中(从单独局部变量声明到整个类中都可以)
 * 永远不要将SuppressWarnings使用在一个类上
 * SuppressWarnings的使用粒度越细越好
 */
public class Notice24 {
}
