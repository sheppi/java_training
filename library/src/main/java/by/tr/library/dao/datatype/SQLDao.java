package by.tr.library.dao.datatype;

import java.sql.ResultSet;

/**
 * Created by Kirill_Kaluga on 7/18/2016.
 */
public class SQLDao {

    private String forClass;
    private String connectString;
    private String command;

    public SQLDao(){
        forClass = "";
        connectString = "";
    }

    public String getForClass() {
        return forClass;
    }

    public void setForClass(String forClass) {
        this.forClass = forClass;
    }

    public String getConnectString() {
        return connectString;
    }

    public void setConnectString(String username, String password) {
        this.connectString = connectString;
    }

    public ResultSet execute(){
        
        return null;
    }
}
