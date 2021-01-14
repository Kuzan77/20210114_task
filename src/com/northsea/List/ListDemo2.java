package com.northsea.List;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * List集合的特点
 *      有序: 存储和取出元素顺序一致
 *      可重复: 存储的元素可以重复
 *      允许添加空值
 */
public class ListDemo2 {
    @Test
    public void ListDemo2() {
        // 创建集合对象
        List list = new ArrayList();

        // 创建字符串并添加字符串
        list.add("hello");
        list.add("world");
        list.add("java");
        list.add("java");
        list.add(null);

        // 遍历集合
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String s = (String) it.next();
            System.out.println(s);
        }
    }
}
