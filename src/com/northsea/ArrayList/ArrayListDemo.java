package com.northsea.ArrayList;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;


/*
 * List特点：
 * 		ArrayList:
 * 			底层数据结构是数组，查询快，增删慢
 * 			线程不安全，效率高
 * 		Vector:
 * 			底层数据结构是数组，查询快，增删慢
 * 			线程安全，效率低
 * 		LinkedList:
 * 			 底层数据结构是链表，查询慢，增删快
 * 			线程不安全，效率高
 *
 * 案例：
 * 		使用List的任何子类存储字符串或者存储自定义对象并遍历。
 *
 * ArrayList的使用。
 *
 */
public class ArrayListDemo {
    /**
     *  存储字符串并遍历
     */
    @Test
    public void ArrayListDemo() {
        // 创建集合对象
        ArrayList<String> array = new ArrayList<>();
        // 创建元素对象，并添加
        array.add("hello");
        array.add("world");
        array.add("java");

        // 使用迭代器遍历
        Iterator it = array.iterator();
        while (it.hasNext()) {
            String s = (String) it.next();
            System.out.println(s);
        }

        // 使用增强for循环遍历
//        for (String c : array) {
//            System.out.println(c);
//        }
    }

    /**
     * 存储自定义对象并遍历
     */
    @Test
    public void ArrayListDemo2() {
        // 创建集合对象
        ArrayList<Student> array = new ArrayList<>();
        // 创建学生对象
        Student student1 = new Student("J10001", "张三");
        Student student2 = new Student("J10002", "李四");
        Student student3 = new Student("J10003", "王五");
        Student student4 = new Student("J10004", "马六");

        // 把学生对象添加到集合
        array.add(student1);
        array.add(student2);
        array.add(student3);
        array.add(student4);

        // 使用迭代器遍历
        Iterator it = array.iterator();
        while (it.hasNext()) {
            Student s = (Student) it.next();
            System.out.println("学号:" + s.getNumber() + "  姓名:" +s.getName());
        }

        // 使用增强for循环遍历
        for (Student s : array) {
            System.out.println("学号:" + s.getNumber() + "  姓名:" +s.getName());
        }
    }
}
