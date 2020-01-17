import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private String username = "user#1";
    private String email = "user_1@email.com";
    private String password = "password#1";
    private String phoneNumber = "###-1";

    private User user = new User(username, password, email, phoneNumber);
    @Test
    void getUsername() {
        assertEquals(username, user.getUsername());
    }

    @Test
    void getPassword() {
        assertEquals(password, user.getPassword());
    }

    @Test
    void getEmail() {
        assertEquals(email, user.getEmail());
    }

    @Test
    void getPhoneNumber() {
        assertEquals(phoneNumber, user.getPhoneNumber());
    }

    @Test
    void getJoinedProjects() {

    }

    @Test
    void addNewProject() {
    }

    @Test
    void removeProject() {
    }

    @Test
    void equals() {
    }

//    @Test
//    void hashCode() {
//    }
//
//    @Test
//    void toString() {
//    }
}