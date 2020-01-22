package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Task {

    private final int id;
    private int percentage = 0;

    private String name;

    private final ArrayList<TaskComment> comments = new ArrayList<>();
    private final ArrayList<TeamMember> teamMembers = new ArrayList<>();

    private LocalDateTime start;
    private LocalDateTime end;

    public Task(int id, String name, LocalDateTime start, LocalDateTime end) {
        this.id = id;
        this.name = name;
        this.end = end;
        this.start = start;
    }

    public void setPercentage(int percentage) {
        if ( percentage >= 0 && percentage <= 100)
            this.percentage = percentage;
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
