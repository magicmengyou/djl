package www.model.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

public class DataSourceUtil {
    // 声明连接池对象
    private static DruidDataSource ds;
    static{
        InputStreamReader is = new InputStreamReader(
                Objects.requireNonNull(DataSourceUtil.class.getClassLoader().getResourceAsStream("datasource.properties"))
        );
        Properties properties = new Properties();
        try {
            properties.load(is);
            ds = (DruidDataSource)DruidDataSourceFactory.createDataSource(properties);
            System.out.println("德鲁伊="+ds);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 获取连接通道
    public static Connection getConnection(){
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(getConnection());
//        long start = System.currentTimeMillis();
//        for(int i=1;i<=10000;i++){
//            Connection conn = DbUtil.getConnection();
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            Connection conn = DataSourceUtil.getConnection();

//            if(conn!=null){
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        long end = System.currentTimeMillis();
//        //  共用67958毫秒
//        // 共用940毫秒
//        System.out.println("共用"+(end-start)+"毫秒");
    }
}
