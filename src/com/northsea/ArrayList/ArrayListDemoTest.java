package com.northsea.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 键盘录入多个数据，以0结束，要求在控制台输出这多个数据中的最大值
 *
 * 分析：
 * 		A:创建键盘录入数据对象
 * 		B:键盘录入多个数据,不确定数量，所以用集合存储
 * 		C:以0结束,这个简单，只要键盘录入的数据是0，停止录入
 * 		D:把集合转成数组
 * 		E:对数组排序
 * 		F:获取该数组中的最大索引的值
 */
public class ArrayListDemoTest {
    public static void main(String[] args) {
        // 创建键盘录入数据对象
        Scanner sc = new Scanner(System.in);

        // 创建一个存储数据的集合
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        while (true) {
            System.out.println("请输入数值: ");
            int number = sc.nextInt();
            if (number != 0) {
                // 将数值添加到集合中
                arrayList.add(number);
            }else {
                break;
            }
        }
        // System.out.println(arrayList);

        // 把集合转换成数组
        // Object[] toArray():把集合转成数组，可以实现集合的遍历
        Object[] obj = arrayList.toArray();

        // 对数组排序
        // public static void sort(Object[] a)
        Arrays.sort(obj);

        // 遍历数组并获取数组中的最大索引值
        for (int i = 0; i < obj.length; i++) {
            System.out.println(obj[i]);
            if (i == obj.length - 1) {
                int maxNumber = (int)obj[i];
                System.out.println("最大值为:" + maxNumber);
            }
        }
    }
}
