package view;


import model.*;

import java.time.LocalDateTime;

public class GUI {
    public static void main(String[] args) {
//        Login login = new Login();

//        Database database = new Database();
//        try {
//database.selectUser("amir");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        try {
            TestDatabase t = new TestDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
