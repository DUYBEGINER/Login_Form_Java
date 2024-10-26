/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Constant.CommonConstant;

import java.sql.*;

import static java.sql.DriverManager.*;

/**
 *
 * @author Admin
 */
public class Connect_to_DB {
    
    
    public static boolean register(String username, String password){
        try{
            if(!checkUser(username)){
                Connection connection = getConnection(CommonConstant.DB_URL, CommonConstant.DB_USERNAME, CommonConstant.DB_PASSWORD);
                PreparedStatement insertUsers = connection.prepareStatement(
                        "INSERT INTO " + CommonConstant.DB_TABLE_NAME + " (username, password)" + " VALUES (?, ?)"
                );
                insertUsers.setString(1, username);
                insertUsers.setString(2, password);
                insertUsers.executeUpdate();
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static boolean validateLogin(String username, String password){
        try{
            Connection connection = getConnection(CommonConstant.DB_URL, CommonConstant.DB_USERNAME, CommonConstant.DB_PASSWORD);
            PreparedStatement validUser = connection.prepareStatement(
                    "SELECT * FROM " + CommonConstant.DB_TABLE_NAME + " WHERE username = ? AND password = ?"
            );
            validUser.setString(1, username);
            validUser.setString(2, password);
            ResultSet resultSet = validUser.executeQuery();
            if (!resultSet.isBeforeFirst()){
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }



    public static boolean checkUser(String username){
        try{
            Connection connection = getConnection(CommonConstant.DB_URL, CommonConstant.DB_USERNAME, CommonConstant.DB_PASSWORD);
            PreparedStatement checkUserExists = connection.prepareStatement(
                    "SELECT * FROM " + CommonConstant.DB_TABLE_NAME + " WHERE username = ?"
            );
            checkUserExists.setString(1, username);
            ResultSet rs = checkUserExists.executeQuery();
            if (!rs.isBeforeFirst()){
                return false;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return true;
    }
}
