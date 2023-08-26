package JDBC;

import Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

/*
 * 使用PreparedStatement实现对数据表的增删改操作
 *
 */
public class PreparedStatementUpdate {

    //通用的增删改操作
    public void update(String sql,Object ...args){ //sql中占位符的个数与可变形参的长度相同！
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.获取数据库的连接
            conn = JDBCUtils.getConnection();
            //2.预编译sql语句，返回PreparedStatement的实例
            ps = conn.prepareStatement(sql);
            //3.填充占位符
            for(int i = 0;i < args.length;i++){
                ps.setObject(i + 1, args[i]);//小心参数声明错误！！
            }
            //4.执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //5.资源的关闭
            JDBCUtils.closeResource(conn, ps);
        }
    }
}
