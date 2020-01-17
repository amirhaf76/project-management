import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.LongConsumer;

public class Task {
    private int id;
    private final ArrayList<TaskComment> comments = new ArrayList<>();
    private final ArrayList<TeamMember> teamMembers = new ArrayList<>();

    private LocalDateTime start;
    private LocalDateTime end;

    public Task(int id, LocalDateTime start, LocalDateTime end) {
        this.id = id;
        this.end = end;
        this.start = start;
    }

    public void setPercentage(int percentage) {
        id = percentage;
    }

    public int getId() {
        return id;
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

}
