package github.nooblong.utils;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;

@Service("transactionManager")
public class TransactionManager {

    @Resource(name = "connectionUtil")
    private ConnectionUtil connectionUtil;

    public void begin(){
        try {
            connectionUtil.getConnection().setAutoCommit(false);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void commit(){
        try {
            connectionUtil.getConnection().commit();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void rollback(){
        try {
            connectionUtil.getConnection().rollback();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void release(){
        try {
            connectionUtil.getConnection().close();
            connectionUtil.removeConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void setConnectionUtil(ConnectionUtil connectionUtil) {
        this.connectionUtil = connectionUtil;
    }

}
