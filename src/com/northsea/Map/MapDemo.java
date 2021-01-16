package com.northsea.Map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Map集合: 是非线性数据结构的主要实现，用来存放一组键-值型数据
 * Interface Map<K,V>
 * 参数类型
 * K -钥匙的Map保持型
 * V -映射的值的类型
 *
 * 常用方法:
 * V put(K key, V value)
 * 将指定的值与此映射中的指定键关联（可选操作）。
 *
 * V get(Object key)
 * 返回指定的键映射的值，或 null如果这个Map不包含的键映射。
 *
 * V remove(Object key)
 * 如果存在（可选操作），则从该Map中移除一个键的映射。
 *
 * default boolean remove(Object key, Object value)
 * 仅当它当前映射到指定的值时，为指定的键移除条目。
 *
 * default V replace(K key, V value)
 * 仅当它当前映射到某一值时，替换指定的键的条目
 *
 * default boolean replace(K key, V oldValue, V newValue)
 * 仅当当前映射到指定的值时，替换指定的键的条目。
 *
 * boolean containsKey(Object key)
 * 返回 true如果这Map包含一个指定的键映射
 *
 * boolean containsValue(Object value)
 * 返回 true如果映射到指定的值的一个或多个键。
 *
 * int size()
 * 返回这个映射中的键值映射的数目
 *
 * void clear()
 * 从这个映射中移除所有的映射（可选操作）。
 *
 * boolean isEmpty()
 * 返回 true如果这个Map不包含键值的映射。
 *
 * Set<K> keySet()
 * 返回一个 Set的关键视图包含在这个Map。
 *
 * Collection<V> values()
 * 返回一个 Collection视图的值包含在这个Map
 *
 */
public class MapDemo {
    @Test
    public void MapDemo() {
        // 创建Map集合对象
        Map map = new HashMap();

        // V put(K key, V value)
        // 将指定的值与此映射中的指定键关联（可选操作）
        // key不能重复，但value可以重复
        map.put("张三", 15);
        map.put("李四", 19);
        map.put("王五", 20);
        System.out.println(map);
        System.out.println("---------------------------");

        // Set<K> keySet()
        // 返回一个 Set的关键视图包含在这个Map。
        System.out.println(map.keySet());

        // Collection<V> values()
        // 返回一个 Collection视图的值包含在这个Map
        System.out.println(map.values());

        // V get(Object key)
        // 返回指定的键映射的值，或 null如果这个Map不包含的键映射
        System.out.println(map.get("张三"));
        System.out.println("---------------------------");

        // V remove(Object key)
        // 如果存在（可选操作），则从该Map中移除一个键的映射
        // map.remove("王五");
        // System.out.println(map);
        // System.out.println("---------------------------");

        // default boolean remove(Object key, Object value)
        // 仅当它当前映射到指定的值时，为指定的键移除条目
        // System.out.println(map.remove("张三", 16));     // false
        // System.out.println(map.remove("张三", 15));     // true

        // default V replace(K key, V value)
        // 仅当它当前映射到某一值时，替换指定的键的条目
        map.replace("张三", 18);

        // default boolean replace(K key, V oldValue, V newValue)
        // 仅当当前映射到指定的值时，替换指定的键的条目
        map.replace("李四", 19, 20);
        System.out.println(map);
        System.out.println("---------------------------");

        // boolean containsKey(Object key)
        // 返回 true如果这Map包含一个指定的键映射
        System.out.println(map.containsKey("张三"));

        // boolean containsValue(Object value)
        // 返回 true如果映射到指定的值的一个或多个键。
        System.out.println(map.containsValue(20));

        // int size()
        // 返回这个映射中的键值映射的数目(集合的大小)
        System.out.println(map.size());

        // void clear()
        // 从这个映射中移除所有的映射（可选操作）。
        map.clear();

        // boolean isEmpty()
        // 返回 true如果这个Map不包含键值的映射。
        System.out.println(map.isEmpty());      // 在存在映射的情况下使用了clear()方法后, 返回true

    }
}
