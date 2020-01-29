package controller;

import model.Database;
import model.User;
import view.*;

public class Controller {
    Database database;

    public Controller() {
        database = new Database();
    }

    public void sendUserDataToDb(String username, String password, String email, String phoneNumber) throws Exception {

        database.insertIntoUser(username, password, email, phoneNumber);
    }

    public void sendProjectDataToDb(String project_name, String project_description, int manager_id) throws Exception {
        database.insertIntoProject(project_name, project_description, manager_id);
    }

    public void sendTeamDataToDb(String team_name, int project_id) throws Exception {
        database.insertIntoTeam(team_name, project_id);
    }

    public void sendTaskDataToDb(String task_name, String task_description, String startTime, String endTime
            , Integer assignedTeamMember_id, Integer assignedTeam_id) throws Exception {
        database.insertIntoTask(task_name, task_description, startTime, endTime, assignedTeamMember_id, assignedTeam_id);
    }

    public void sendPercentageOfTaskToDb(int task_id, int percentage) throws Exception {
        database.updatePercentageOfTask(task_id, percentage);
    }

    public void sendMembershipDataToDb(int user_id, int team_id) throws Exception {
        database.insertIntoUser_Team(user_id, team_id);
    }

    public void sendTaskAssignmentDataToDb(int task_id, int user_id) throws Exception {
        database.updateTaskAssignToTeamMember(task_id, user_id);
    }

    public void fetchTeamMembersFromDb(int project_id) throws Exception {
        ManagementView.setTeamMembers(database.selectUserOfproject(project_id));
    }

    public void fetchTasksFromDb(int project_id) throws Exception {
        ManagementView.setTasks(database.selectAllTasks(project_id));
    }

    public void fetchProjectsFromDb(int us_id) throws Exception {
        ProjectsView.setProjects(database.selectAllproject(us_id));
    }

    public void fetchUserFromDb(String username) throws Exception {
        Login.setUser(database.selectUser(username));
    }

    public void fetchUserFromDbAddUserToTeam(String username) throws Exception {
        AddUserToTeam.setUser(database.selectUser(username));
    }

    public void fetchUserFromDbAssignTask(String username) throws Exception {
        AssignTask.setUser(database.selectUser(username));
    }

    public void fetchUserFromDbCreateProject(String username) throws Exception {
        System.out.println("hhhh");
        User user = database.selectUser(username);
        System.out.println("j");
        CreateProject.setUser(user);
    }

    public boolean checkUserValidation(String username, String password) throws Exception {
        return database.checkUserValidation(username, password);
    }

    public boolean checkUserIsmanager(int project_id, int user_id) throws Exception {
        return database.userIsManager(project_id, user_id);
    }

}
