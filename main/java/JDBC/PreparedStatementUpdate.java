package JDBC;

import Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

/*
Utilise PreparedStatement to implement mysql actions.
 */
public class PreparedStatementUpdate {

    // Universal actions
    public void update(String sql,Object ...args){ // The number in placeholders of sql is equal to the length of transformable parameter.
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 1st. Connnet to database
            conn = JDBCUtils.getConnection();
            // 2nd. Pre-compile sql statement, return to the stances of PreparedStatement.
            ps = conn.prepareStatement(sql);
            // 3rd. Populate placeholders
            for(int i = 0;i < args.length;i++){
                ps.setObject(i + 1, args[i]);    // Watch out parameter statement.
            }
            // 4th. Execute the process
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            // 5th. Resource closure
            JDBCUtils.closeResource(conn, ps);
        }
    }
}
