package com.northsea.jdbc.dbutils;

import com.northsea.jdbc.pojo.Student;
import com.northsea.jdbc.util.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author ：mmzs
 * @date ：Created in 2021/1/24 21:23
 * QueryRunner 之查询:
 * QueryRunner 的查询方法是：
 * public <T> T query(String sql, ResultSetHandler<T> rh, Object… params)
 * public <T> T query(Connection con, String sql, ResultSetHandler<T> rh, Object… params)
 * query()方法会通过 sql 语句和 params 查询出 ResultSet，然后通过 rh 把 ResultSet 转换成对应的
 * 类型再返回。
 *
 * ResultSetHandler
 * 在执行 select 语句之后得到的是 ResultSet，然后还需要对 ResultSet 进行转换，得到最终的数据。
 * 把 ResultSet 的数据放到一个 List 中，也可能想把数据放到一个 Map 中，或是一个 Bean 中。
 * DBUtils 提供了一个接口 ResultSetHandler，它就是用来 ResultSet 转换成目标类型的工具。可以
 * 自己去实现这个接口，把 ResultSet 转换成想要的类型。
 * DBUtils 提供了很多个 ResultSetHandler 接口的实现，这些实现已经基本够用了，通常不用去实
 * 现 ResultSet 接口。
 * ⚫ MapHandler：单行处理器！把结果集转换成 Map<String,Object>，其中列名为键！
 * ⚫ MapListHandler：多行处理器！把结果集转换成 List<Map<String,Object>>；
 * ⚫ BeanHandler：单行处理器！把结果集转换成 Bean，该处理器需要 Class 参数，即 Bean 的类
 * 型；
 * 22
 * ⚫ BeanListHandler：多行处理器！把结果集转换成 List<Bean>；
 * ⚫ ColumnListHandler：多行单列处理器！把结果集转换成 List<Object>，使用 ColumnListHandler
 * 时需要指定某一列的名称或编号，例如：new ColumListHandler(“name”)表示把 name 列的数
 * 据放到 List 中。
 * ⚫ ScalarHandler：单行单列处理器！把结果集转换成 Object。一般用于聚集查询，例如 select
 * count(*) from tab_student。
 *
 *
 * ArrayHandler：把结果集中的第一行数据转成对象数组。
 * ArrayListHandler：把结果集中的每一行数据都转成一个对象数组，再存放到List中。
 * BeanHandler：将结果集中的第一行数据封装到一个对应的JavaBean实例中。
 * BeanListHandler：将结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到List里。//重点
 * MapHandler：将结果集中的第一行数据封装到一个Map里，key是列名，value就是对应的值。//重点
 * MapListHandler：将结果集中的每一行数据都封装到一个Map里，然后再存放到List
 * ColumnListHandler：将结果集中某一列的数据存放到List中。
 * KeyedHandler(name)：将结果集中的每一行数据都封装到一个Map里(List<Map>)，再把这些map再存到一个map里，其key为指定的列。
 * ScalarHandler:将结果集第一行的某一列放到某个对象中。//重点
 */
public class QueryRunnerDemo2 {

    /**
     * 单行多列
     * MapHandler()
     * 将结果集中的第一行数据封装到一个Map里，key是列名，value就是对应的值。//重点
     */
    @Test
    public void fun1() {
        // 获取连接池数据源
        DataSource ds = JdbcUtils.getDataSource();
        // 创建QueryRunner对象
        QueryRunner qr = new QueryRunner(ds);
        String sql = "select * from user where uid=?";
        Map<String,Object> map = null;
        // 执行, 并把结果集转换成 Map<String,Object>
        try {
            map = qr.query(sql, new MapHandler(), "U_1002");
        } catch (SQLException e) {
            System.out.println("查询失败!!!");
        }
        System.out.println(map);
    }

    /**
     *  多行多列
     *  MapListHandler()
     *  将结果集中的每一行数据都封装到一个Map里，然后再存放到List
     */
    @Test
    public void fun2() {
        DataSource ds = JdbcUtils.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "SELECT * FROM user";
        try {
            List<Map<String, Object>>list = qr.query(sql, new MapListHandler());
            for (Map<String, Object> map : list) {
                System.out.println(map);
            }
        } catch (SQLException se) {
            System.out.println("查询失败!!!");
        }
    }

    // BeanHandler：将结果集中的第一行数据封装到一个对应的JavaBean实例中。
    @Test
    public void fun3() {
        DataSource ds = JdbcUtils.getDataSource();
        QueryRunner qr = new QueryRunner(ds);

        String sql = "SELECT * FROM user where uid = ?";
        try {
            Student stu = qr.query(sql, new BeanHandler<Student>(Student.class), "U_1001");
            System.out.println(stu);
        } catch (SQLException throwables) {
            System.out.println("查询失败!!!");
        }
    }


    // BeanListHandler：将结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到List里。//重点
    @Test
    public void fun4() {
        DataSource ds = JdbcUtils.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "SELECT * FROM user";
        List<Student> list = null;
        try {
            list = qr.query(sql, new BeanListHandler<>(Student.class));
        } catch (SQLException throwables) {
            System.out.println("查询失败");
        }
        for(Student stu : list) {
            System.out.println(stu);
        }
    }


    // ColumnListHandler：将结果集中某一列的数据存放到List中
    @Test
    public void fun5() {
        DataSource ds = JdbcUtils.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "SELECT * FROM user";
        List<Object> list = null;
        try {
            list = qr.query(sql, new ColumnListHandler<>("uid"));
        } catch (SQLException throwables) {
            System.out.println("查询失败");
        }
        for(Object s : list) {
            System.out.println(s);
        }
    }
    // 将结果集第一行的某一列放到某个对象中。//重点
    @Test
    public void fun6() {
        DataSource ds = JdbcUtils.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "SELECT count(*) FROM user";
        Number number = null;
        try {
            number = (Number)qr.query(sql, new ScalarHandler());
        } catch (SQLException throwables) {
            System.out.println("查询失败!!!");
        }
        int cnt = number.intValue();
        System.out.println(cnt);
    }

    /**
     * QueryRunner 之批处理
     * QueryRunner 还提供了批处理方法：batch()。
     * 更新一行记录时需要指定一个 Object[]为参数，如果是批处理，那么就要指定 Object[][]为参数。
     * 即多个 Object[]就是 Object[][]了，其中每个 Object[]对应一行记录：
     */
    @Test
    public void fun10() {
        DataSource ds = JdbcUtils.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "insert into user values(?,?,?)";
        Object[][] params = new Object[10][];  //表示要插入10行记录
        for (int i = 0; i < params.length; i++) {
            params[i] = new Object[]{"S_300" + i, "name" + i, i%2==0?"男":"女"};
        }
        try {
            qr.batch(sql, params);
        } catch (SQLException se) {
            System.out.println("添加失败!!!");
        }
    }
}
