package JDBC;

import Utils.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class Select {
    public <T> List<T> getForList(Class<T> clazz, String sql, Object... args){    //For reflection
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
            // Get metadata for the result set: ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            // Get the number of columns in a result set from ResultSetMetaData
            int columnCount = rsmd.getColumnCount();
            // create arraylist objects
            ArrayList<T> list = new ArrayList<T>();
            while (rs.next()) {
                T t = clazz.newInstance();
                // Processing each column in a row of data in the result set: Assign a value to the specified attribute of the 't' object
                for (int i = 0; i < columnCount; i++) {
                    // Get the column values
                    Object columValue = rs.getObject(i + 1);
                    // Get each columns' name
                    // String columnName = rsmd.getColumnName(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    // Assign the columnName attribute of the t object to the columValue：Reflection
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columValue);
                }
                list.add(t);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }
}
