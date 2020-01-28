package model;

import java.util.Objects;

public class TaskComment {

//    private static int baseCommentId = 1;

    private User user;
    private int id;
    private String text;

    public TaskComment(){}

    public TaskComment(User user, String text) {
        this.user = user;
//        this.id = baseCommentId;
        this.text = text;

//        baseCommentId++;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //    public static int getBaseCommentId() {
//        return baseCommentId;
//    }
//
//    public static void setBaseCommentId(int baseCommentId) {
//        TaskComment.baseCommentId = baseCommentId;
//    }

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
