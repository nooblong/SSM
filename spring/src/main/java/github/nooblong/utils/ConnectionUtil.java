package github.nooblong.utils;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Service("connectionUtil")
public class ConnectionUtil {

    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    @Resource(name = "dataSource")
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection(){
        //先从tl上获取
        Connection connection = tl.get();
        if (connection == null){
            try {
                connection = dataSource.getConnection();
                tl.set(connection);
                return connection;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return connection;
    }

    public void removeConnection(){
        tl.remove();
    }
}
