package module;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class addUser {

    public static DefaultTableModel getNewModel(String user, String password, DefaultTableModel model) {
        int rowCount = model.getRowCount();
        model.addRow(new Object[]{rowCount+1,user,password});
        return model;
    }
}
