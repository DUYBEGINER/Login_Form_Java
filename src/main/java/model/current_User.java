package model;

public class current_User {
   private static User user;
   public current_User(User user) {
       this.user = user;
   }
    public static User getUser() {
       return user;
   }

    public static void setUser(User user) {
        current_User.user = user;
    }
}
