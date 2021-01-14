package com.northsea.Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/*
 * 集合的遍历。是依次获取集合中的每一个元素。
 *
 * Object[] toArray():把集合转成数组，可以实现集合的遍历
 */
public class CollectionDemo3 {
    @Test
    public void CollectionDemo3() {
        // 创建集合对象
        Collection c = new ArrayList();
        // 添加元素
        c.add("hello");  // Object obj = "hello"; 向上转型
        c.add("world");
        c.add("java");

        // 遍历
        // Object[] toArray():把集合转成数组，可以实现集合的遍历
        Object[] obj = c.toArray();
//        System.out.println(obj);
        for (int i = 0; i < obj.length; i++) {
            // System.out.println(obj[i]);
            // 我知道元素是字符串，我在获取到元素的的同时，还想知道元素的长度。
            // System.out.println(objs[x] + "---" + objs[x].length());
            // 上面的实现不了，原因是Object中没有length()方法
            // 我们要想使用字符串的方法，就必须把元素还原成字符串
            // 向下转型
            String s = (String) obj[i];
            System.out.println(s + "---" + s.length());
        }
    }
}
