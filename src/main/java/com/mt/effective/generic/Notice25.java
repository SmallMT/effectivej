package com.mt.effective.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mt
 * 第25条 列表优于数组
 *
 * 1.数组是协变的
 *  如果 B 是 A的子类,那么 B[] 也是 A[] 的子类
 *      例如 String 是 Object的子类,那么 String[]也是Object[]的子类
 * 1.集合不是协变的
 *  Type1 和Type2 无论是什么关系, List[Type1] 和List<Type2> 没有任何的关系
 *  List<Type1> 既不是List<Type2>的子类,也不是List<Type2>的超类
 *
 * 2.数组是可具体化的
 *      数组会在运行时才知道并检查它们的元素类型约束
 * 2.泛型是不可具体化的
 *      泛型在运行是所包含的信息要比在编译时所包含的信息要少
 * 总而言之,数组和泛型有着不同的类型规则,数组是协变且可以具体化的,泛型
 * 是不可变且可以被擦除的.
 * 数组提供运行时的类型安全,但是没有编译时的类型安全.泛型提供编译时的类型
 * 安全,但是在运行时,类型信息丢失.
 * 一般来说,数组和泛型不能很好的混合使用,如果你发现自己混合使用了数组和泛型
 * 并且你得到了编译时的错误或警告,解决办法就是使用列表代替数组
 *
 *
 */
public class Notice25 {

    public static void main(String[] args) {

        List<?>[] xx = new List<?>[2];
        System.out.println(xx.getClass());

        xx[0] = new ArrayList<Integer>(10);
        xx[1] = new ArrayList<String>(10);
        Object[] obj = new Object[2];
        String[] strs = new String[2];
        System.out.println(strs instanceof Object[]);
    }

    public static void covariant() {
        // 数组是协变的
        String[] strArr = new String[2];
        Object[] objArr = new String[2];
        // 运行期间才会检查
        String str = (String) objArr[0];
        // isType is true
        boolean isType = strArr instanceof Object[];

        // 集合是逆变的
        // can not compile
        // List<Object> objList = new ArrayList<String>(10);
        List<Object> objList = new ArrayList<>(10);
        objList.add("xxx");
        objList.add(1L);

        // 泛型将可能
        // 数组会在运行是才会知道并检查所持有的元素类型
        // 泛型只是在编译期间才会强化它们的类型信息,并在运行时期擦除掉类型信息

    }


}
