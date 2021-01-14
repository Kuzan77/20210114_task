package com.northsea.Exception;
// 总结:
//
// 方法重写的时候，如果父类没有抛出任何异常，那么子类只可以抛出运行时异常，不可以抛出编译时异常。
//
// 如果父类的方法抛出了一个异常，那么子类在方法重写的时候不能抛出比被重写方法申明更加宽泛的编译时异常。
//
// 子类重写方法的时候可以随时抛出运行时异常，包括空指针异常，数组越界异常等。
public class Zi extends Fu{
    @Override
    public void show() throws ArithmeticException {

    }

    @Override
    public void method() {
        // String s = "2014-11-20";
        // SimpleDateFormat sdf = new SimpleDateFormat();
        // Date d = sdf.parse(s);
        // System.out.println(d);
    }
}
