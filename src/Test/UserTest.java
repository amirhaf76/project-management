package Test;

import Model.Manager;
import Model.Project;
import Model.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private String username = "user#1";
    private String email = "user_1@email.com";
    private String password = "password#1";
    private String phoneNumber = "###-1";

    private User user = new User(username, password, email, phoneNumber);
    private ArrayList<Project> projects = new ArrayList<>();
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
        Project[] projects = new Project[2];
        projects[0] = new Project(new Manager(1, user));
        projects[1] = new Project(new Manager(2, user));

        user.getProjects().add(projects[0]);
        user.getProjects().add(projects[1]);

        assertArrayEquals(projects, user.getProjects().toArray());
    }

    @Test
    void equals() {
        User user2 = new User("user#2","password#2",
                "user_2@email.com", "###-2");
        User user3 = new User("user#1","password#3",
                "user_3@email.com", "###-3");

        assertNotEquals(user, user2);
        assertEquals(user, user3);
    }
}