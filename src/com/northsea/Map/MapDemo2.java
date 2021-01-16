package com.northsea.Map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapDemo2 {
    /**
     * equals(Object o) 返回值类型：boolean
     * 判断两个集合是否一样
     */
    @Test
    public void MapDemo() {
        // 创建Map集合对象
        Map map = new HashMap();

        // V put(K key, V value)
        // 添加数据
        map.put("中国", "上海");
        map.put("美国", "旧金山");
        map.put("英国", "伦敦");

        Map map2 = new HashMap();
        map2.put("中国", "上海");
        map2.put("美国", "旧金山");
        map2.put("英国", "伦敦");

        System.out.println(map.equals(map2));
        System.out.println("---------------------------");
    }

    /**
     * hashCode() 返回值类型：int
     * 计算hash值
     */
    @Test
    public void MapDemo2() {
        // 创建Map集合对象
        Map map = new HashMap();

        // V put(K key, V value)
        // 添加数据
        map.put("中国", "上海");
        map.put("美国", "旧金山");
        map.put("英国", "伦敦");

        int i = map.hashCode();
        System.out.println(i);
    }
}
