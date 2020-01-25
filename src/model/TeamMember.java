package model;

import java.util.Objects;

public class TeamMember extends User {

//    private static int baseTeamMemberId = 1;

    private int teamMemberId;

    public TeamMember(User user) {
        super(user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getPhoneNumber()
        );
//        this.teamMemberId = baseTeamMemberId;
//        baseTeamMemberId++;
    }

    // TODO: 1/25/2020 erase
//    public static void setBaseTeamMemberId(int baseTeamMemberId) {
//        TeamMember.baseTeamMemberId = baseTeamMemberId;
//    }
//
//    public static int getBaseTeamMemberId() {
//        return baseTeamMemberId;
//    }


    public int getTeamMemberId() {
        return teamMemberId;
    }

    public void setTeamMemberId(int teamMemberId) {
        this.teamMemberId = teamMemberId;
    }

    public boolean setPercentageOnTask(Task task, int percentage) {
        if ( task.getTeamMembers().contains(this) ) {
            task.setPercentage(percentage);
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TeamMember that = (TeamMember) o;
        return teamMemberId == that.teamMemberId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), teamMemberId);
    }
}
