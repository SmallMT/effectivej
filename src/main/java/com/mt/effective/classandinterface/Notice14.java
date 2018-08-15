package com.mt.effective.classandinterface;

/**
 * @author mt 2018.8.7
 * 第14条
 * 在共有类中使用访问方法而非共有域
 * 典型的例子就是javabean
 * 还是为了解耦
 * 总之,共有类永远都不应该暴露可变的域
 */
public class Notice14 {

    //共有域
    public int i;
    //私有域但是提供getter setter方法
    private int j;


    public static void main(String[] args) {
        Notice14 notice = new Notice14();
        //如果将域设置成共有域那么在任何地方都可直接访问
        //现在假设有大量的地方直接使用了这些共有域
        //突然有一天发现如果将i设计成String类型会更好一些
        //但是你无法操作,因为之前使用到i的地方太多了,(模块
        // 和模块之间的耦合度太高了)如果需要
        //重构代价太大了
        notice.i = 555;
        notice.i = 789;

        //但是如果同样的需求放在使用getter和setter上就不会有
        //这样的问题,我把j变成String类型,之前需要一个int类型
        //我就可以对getter和setter方法进行修改让它们经过处理返回一个
        //int类型,无需改变之前的代码(降低了耦合度)
        int num = notice.getJ();
    }



    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}
