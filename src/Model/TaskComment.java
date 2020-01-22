package Model;

import java.util.Objects;

public class TaskComment {

    private final User user;
    private final int id;
    private String text;

    public TaskComment(User user, int id, String text) {
        this.user = user;
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public User getUser() {
        return user;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskComment that = (TaskComment) o;
        return id == that.id &&
                user.equals(that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, id);
    }
}
