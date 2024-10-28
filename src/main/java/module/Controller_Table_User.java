package module;

import Constant.CommonConstant;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

public class Controller_Table_User {


    public static DefaultTableModel getNewTable(String user, String password, DefaultTableModel model) {
        int rowCount = model.getRowCount();
        model.addRow(new Object[]{rowCount+1,user,password});
        return model;
    }



    public static DefaultTableModel getTableUser() {
        String column [] = {"Id","User","Password"};
        DefaultTableModel model = new DefaultTableModel(null,column);
        try{
            Connection connection = getConnection(CommonConstant.DB_URL, CommonConstant.DB_USERNAME, CommonConstant.DB_PASSWORD);
            String query = "SELECT * FROM login_user.users";
            try {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(query);
                while (rs.next()) {
                    String id = rs.getString("user_id");
                    String user = rs.getString("username");
                    String password = rs.getString("password");
                    model.addRow(new Object[]{id, user, password});
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch(Exception e)
        {
            e.printStackTrace();
        }
        return model;
    }

}
