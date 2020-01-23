package Test;

import Model.Manager;
import Model.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;


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
        // managers
        Manager manager1 = new Manager(1, user1);
        Manager manager2 = new Manager(2, user2);
        Manager manager3 = new Manager(3, user1);
        Manager manager4 = new Manager(1, user1);
        Manager manager5 = new Manager(1, user2);


        // same id
        assertNotEquals(manager1, manager5);

        // same user
        assertNotEquals(manager1, manager3);

        // nothing same
        assertNotEquals(manager1, manager2);

        // all same
        assertEquals(manager1, manager4);

    }

    @Test
    void getManagerId() {
        Random random = new Random(400L);
        int id = random.nextInt();

        Manager manager1 = new Manager( id,user1);

        assertEquals(id,manager1.getManagerId());
        assertNotEquals(id + 3, manager1.getManagerId());
    }

}