package com.northsea.List;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * 存储自定义对象并遍历
 */
public class ListStudentDemo {
    @Test
    public void ListStudentDemo() {
        // 创建List集合对象
        List list = new ArrayList();

        // 创建学生对象
        Student student1 = new Student("J10001", "张三");
        Student student2 = new Student("J10002", "李四");
        Student student3 = new Student("J10003", "王五");
        Student student4 = new Student("J10004", "马六");

        // 把学生对象添加到集合
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);

        // 遍历集合
        // Iterator iterator(): 迭代器，集合的专用遍历方式
        Iterator it = list.iterator();
        // hasNext()：如果迭代器中还有元素，则返回true。
        // next()：返回迭代器中的下一个元素
        // remove()：删除迭代器新返回的元素。
        while (it.hasNext()) {
            Student s = (Student) it.next();
            System.out.println("学号:" + s.getNumber() + "  姓名:" +s.getName());
        }
    }
}
