/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package View;
import model.current_User;
/**
 *
 * @author Admin
 */
public class AppLaucher {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI_Login().setVisible(true);

//                System.out.println(Connect_to_DB.checkUser("user1"));

            }
        });
    }
}
