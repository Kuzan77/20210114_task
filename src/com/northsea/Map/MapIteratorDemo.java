package com.northsea.Map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
// 由于在map集合中，无法直接实现迭代器的实例化，如下提供了一种迭代器在map集合的使用方法。
//        1.在map中虽然不能直接实例化迭代器，但map集合提供了keySet（）方法和value（）方法，可以通过先将键值输出
//              到一个集合，可以是list集合或者map集合。
//        2.通过键的集合就可以直接实例化迭代器。
//        3.在进行迭代操作时，可以通过get（）方法，找出每个键对应的值，输出即可。
public class MapIteratorDemo {

    @Test
    public void MapIteratorDemo() {
        // 创建Map集合对象
        Map map = new HashMap();

        // 添加数据
        map.put("山东", "济南");
        map.put("广东", "广州");
        map.put("江苏", "南京");
        System.out.println(map);

        // 遍历Map集合，取得map的key集合
        Set keySet = map.keySet();
        Iterator it = keySet.iterator();
        while (it.hasNext()){
            Object key = it.next();
            Object value = map.get(key);
            System.out.println(key +"---"+value);
        }
    }

    /**
     * Map集合存储自定义对象并遍历
     */
    @Test
    public void MapIteratorDemo2() {
        // 创建Map集合对象
        Map map = new HashMap();

        // 创建学生对象
        Student s1 = new Student("J1001", "科比");
        Student s2 = new Student("J1002", "艾弗森");
        Student s3 = new Student("J1003", "麦迪");
        Student s4 = new Student("J1004", "卡特");

        // 将学生对象添加到Map集合中
        map.put(s1, "洛杉矶");
        map.put(s2, "费城");
        map.put(s3, "休斯顿");
        map.put(s4, "多伦多");

        Set keySet = map.keySet();
        Iterator it = keySet.iterator();
        while (it.hasNext()){
            Student key = (Student) it.next();
            String value =(String) map.get(key);
            System.out.println(key.getId() +"---"+key.getName()+"---"+value);
        }
    }
}
