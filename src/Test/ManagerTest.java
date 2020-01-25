package Test;

import model.Manager;
import model.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



class ManagerTest {

    private static User user1 = new User("user#1",
            "password#1",
            "user_1@email.com",
            "###-1"
    );

    private static User user2 = new User("user#2",
            "password#2",
            "user_2@email.com",
            "###-2"
    );

    @Test
    void equals() {
        int id = Manager.getBaseManagerId();

        Manager manager1 = new Manager(user1);

        // same id
        Manager.setBaseManagerId(id);
        Manager manager2 = new Manager(user2);

        // same user
        Manager manager3 = new Manager(user1);

        // same user and id
        Manager.setBaseManagerId(id);
        Manager manager4 = new Manager(user1);

        // nothing same
        Manager manager5 = new Manager(user2);


        // same id
        assertNotEquals(manager1, manager2);

        // same user
        assertNotEquals(manager1, manager3);

        // nothing same
        assertNotEquals(manager1, manager5);

        // all same
        assertEquals(manager1, manager4);

    }

    @Test
    void getManagerId() {
        int id = Manager.getBaseManagerId();

        Manager manager1 = new Manager(user1);

        assertEquals(id,manager1.getManagerId());
        assertNotEquals(id + 3, manager1.getManagerId());
    }

}