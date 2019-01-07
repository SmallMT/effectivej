package com.mt.effective.generic;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mt
 * 第27条 优先考虑泛型方法
 * 与第26条类似,使用泛型也是为了客户端程序员使用起来了更为方便和安全
 */
public class Notice27 {

    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>(16);
        Set<String> set2 = new HashSet<>(16);
        // 产生一条不安全的警告
        Set<String> set3 = union1(set1, set2);
        // 不会产生警告,并且客户端调用起来更加安全
        // 调用者将指导,set1, set2 已经返回的set4中所包含的是同一种类型的对象
        Set<String> set4 = union2(set1, set2);

    }

    public static Set union1(Set set1, Set set2) {
        Set set = new HashSet(set1);
        set.addAll(set2);
        return set;
    }

    public static <E> Set<E> union2(Set<E> set1, Set<E> set2) {
        Set<E> set = new HashSet<>(16);
        set.addAll(set2);
        return set;
    }

}
