package Model;

import java.util.Objects;

public class TaskComment {

    private final TaskComment taskComment;
    private final int id;
    private String text;

    public TaskComment(TaskComment taskComment, int id, String text) {
        this.taskComment = taskComment;
        this.id = id;
        this.text = text;
    }

    public TaskComment getTaskComment() {
        return taskComment;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
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
                taskComment.equals(that.taskComment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskComment, id);
    }
}
