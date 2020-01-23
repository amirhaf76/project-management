package Test;

import Model.Task;
import Model.TaskComment;
import Model.Team;
import Model.User;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class TaskCommentTest {

    private final User USER1 = new User("user#1",
            "password#1",
            "user_1@email.com",
            "###-1"
    );

    private static User USER2 = new User("user#2",
            "password#2",
            "user_2@email.com",
            "###-2"
    );

    private final String TEST = "Comment#1";

    static {
        TaskComment.setBaseCommentId(1);
    }
    private TaskComment taskComment1 = new TaskComment(USER1, TEST);

    @Test
    void getId() {
        int id = TaskComment.getBaseCommentId();
        TaskComment tc = new TaskComment(USER1, "Comment");
        assertEquals(id, tc.getId());
    }

    @Test
    void getText() {
        assertEquals(TEST, taskComment1.getText());
    }

    @Test
    void getUser() {
        assertEquals(USER1, taskComment1.getUser());
        assertNotEquals(USER2, taskComment1.getUser());
    }

    @Test
    void setText() {
        String newTest = "new Comment";
        taskComment1.setText(newTest);
        assertNotEquals(TEST, taskComment1.getText());
        assertEquals(newTest, taskComment1.getText());
    }

    @Test
    void equal() {
        TaskComment tc = new TaskComment(USER1, TEST);
        assertNotEquals(tc, taskComment1);
    }
}