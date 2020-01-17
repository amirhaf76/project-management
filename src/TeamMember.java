public class TeamMember extends User {

    private int teamMemberId;

    public TeamMember(int teamMemberId, String username, String password, String email, String phoneNumber) {
        super(username, password, email, phoneNumber);
        this.teamMemberId = teamMemberId;
    }

    public void setPercentageOnTask(Task task, int percentage) {
        task.setPercentage(percentage);
    }

    public int getTeamMemberId() {
        return teamMemberId;
    }
}
