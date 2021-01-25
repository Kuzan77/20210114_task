package com.northsea.jdbc.dbutils;
import com.northsea.jdbc.util.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.SQLException;

/**
 * @author ：mmzs
 * @date ：Created in 2021/1/24 21:13
 *
 * DBUtils 主要类
 * ⚫ DbUtils：都是静态方法，一系列的 close()方法；
 * ⚫ QueryRunner：
 * ➢ update()：执行 insert、update、delete；
 * ➢ query()：执行 select 语句；
 * ➢ batch()：执行批处理。
 */
public class QueryRunnerDemo {
    @Test
    public void fun1() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "insert into user values(?,?,?)";
        qr.update(JdbcUtils.getConnection(), sql, "u2", "LiSi", "123456");
    }
}
