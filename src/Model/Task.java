package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Task {

    private static int baseTaskId = 1;

    private final int id;
    private int percentage = 0;

    private String name;

    private final ArrayList<TaskComment> comments = new ArrayList<>();
    private final ArrayList<TeamMember> teamMembers = new ArrayList<>();

    private LocalDateTime start;
    private LocalDateTime end;

    public Task(String name, LocalDateTime start, LocalDateTime end) {
        this.id = baseTaskId;
        this.name = name;
        this.end = end;
        this.start = start;

        baseTaskId++;
    }

    public int getId() {
        return id;
    }

    public int getPercentage() {
        return percentage;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public ArrayList<TaskComment> getComments() {
        return comments;
    }

    public ArrayList<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    public void setPercentage(int percentage) {
        if ( percentage >= 0 && percentage <= 100)
            this.percentage = percentage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public static int getBaseTaskId() {
        return baseTaskId;
    }

    public static void setBaseTaskId(int baseTaskId) {
        Task.baseTaskId = baseTaskId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
