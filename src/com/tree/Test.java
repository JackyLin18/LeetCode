package com.tree;

/**
 * @ClassName Test
 * @Author Jacky
 * @Description
 **/
public class Test {
    public static void main(String[] args) {
        Integer a = new Integer(10);
        Integer b = new Integer(20);
        swap(a,b);
        System.out.println(a+" "+b);
    }

    public static void swap(Integer a,Integer b){
        int temp = a;
        a = b;
        b = temp;
    }
}
