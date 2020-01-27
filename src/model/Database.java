package model;

/**
 * this is database class
 * this class includes all needed functions
 * for create and handle our database
 */

import com.sun.org.apache.xpath.internal.functions.FuncFalse;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Database {
    private  Connection connect = null;
    private  Statement statement = null;
    private  ResultSet resultSet = null;
    private  PreparedStatement preparedStatement = null;
    private  String url = "jdbc:mysql://localhost:3306/db_project_management";
    private  String user = "root", pass = "";



    // connect to our database
    public void connectToDatabase() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(url, user, pass);
            statement = connect.createStatement();
            // System.out.println("connected");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // create all tables
    public void createTables() throws Exception {
        //connect to database
        connectToDatabase();

        //create user table sql query
        String sql = "CREATE TABLE User " +
                "(user_id INTEGER not NULL AUTO_INCREMENT, " +
                " username VARCHAR(30) not NULL , " +
                " password VARCHAR(30) not NULL , " +
                " email VARCHAR(30) not NULL , " +
                " phoneNumber VARCHAR (30) not NULL , " +
                " bio VARCHAR(2000) DEFAULT NULL , " +
                " PRIMARY KEY ( user_id ))";
        //resultSet = statement.executeQuery( sql);
        statement.executeUpdate( sql);

        //create project table sql query
        sql = "CREATE TABLE Project " +
                "(project_id INTEGER not NULL AUTO_INCREMENT, " +
                " project_name VARCHAR(100) NOT NULL , " +
                " project_description VARCHAR(2000) NOT NULL , " +
                " manager_id INTEGER NOT NULL , " +
                " PRIMARY KEY ( project_id ) , " +
                " FOREIGN KEY ( manager_id ) REFERENCES User( user_id ))";

        statement.executeUpdate( sql);

        //create team table sql query
        sql = "CREATE TABLE Team " +
                "(team_id INTEGER not NULL AUTO_INCREMENT, " +
                " team_name VARCHAR(100) NOT NULL , " +
                " project_id INTEGER not null, " +
                " FOREIGN KEY ( project_id ) REFERENCES Project( project_id ) ," +
                " PRIMARY KEY ( team_id ))";

        statement.executeUpdate( sql);

        //create user_team table sql query that show us which user is in which team
        sql = "CREATE TABLE User_Team " +
                "(team_id INTEGER not NULL ," +
                " user_id INTEGER not NULL , " +
                " FOREIGN KEY ( team_id ) REFERENCES Team( team_id ) ," +
                " FOREIGN KEY ( user_id ) REFERENCES User( user_id ) ," +
                " PRIMARY KEY ( team_id , user_id ))";

        statement.executeUpdate( sql);

        //create Task table sql query
        sql = "CREATE TABLE Task " +
                "(task_id INTEGER not NULL AUTO_INCREMENT, " +
                " task_name VARCHAR(100) NOT NULL , " +
                " task_description VARCHAR(2000) not NULL , " +
                " startTime VARCHAR(20)  , " +
                " endTime VARCHAr(20) , " +
                " assignedTeamMember_id INTEGER not null, " +
                " assignedTeam_id INTEGER not NULL, " +
                " percentage INT(3) DEFAULT 0, " +
                " FOREIGN KEY ( assignedTeamMember_id ) REFERENCES User( user_id ) ," +
                " FOREIGN KEY ( assignedTeam_id ) REFERENCES Team( team_id ) ," +
                " PRIMARY KEY ( task_id ))";

        statement.executeUpdate( sql);

        //create comment table sql query
        sql = "CREATE TABLE Comment " +
                "(comment_id INTEGER not NULL AUTO_INCREMENT, " +
                " text VARCHAR(2000) NOT NULL , " +
                " user_id INTEGER not null, " +
                " task_id INTEGER not null, " +
                " FOREIGN KEY ( user_id ) REFERENCES User( user_id ) ," +
                " FOREIGN KEY ( task_id ) REFERENCES Task( task_id ) ," +
                " PRIMARY KEY ( comment_id ))";

        statement.executeUpdate( sql);

        //create task dependecy table that show us dependency between tasks
        sql = "CREATE TABLE TaskDependency " +
                "(task_id INTEGER not NULL, " +
                " reference INTEGER not NULL, " +
                " FOREIGN KEY ( task_id ) REFERENCES Task( task_id ) ," +
                " FOREIGN KEY ( reference ) REFERENCES Task( task_id ) ," +
                " PRIMARY KEY ( task_id , reference ))";

        statement.executeUpdate( sql);

        close();
    }

    //************************************Insert
    /**
     * insert into User table
     * @param username
     * @param password
     * @param email
     * @param phoneNumber
     * @throws Exception
     */
    public void insertIntoUser(String username ,String password ,String email ,String phoneNumber) throws Exception {
        connectToDatabase();

        preparedStatement = connect.prepareStatement("insert into  User values (DEFAULT , ?, ? ,? ,? ,?)");

        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, phoneNumber);
        preparedStatement.setString(5, null);



        preparedStatement.executeUpdate();

        //close database connection
        close();
    }

    /**
     * insert into Project table
     * @param project_name
     * @param project_description
     * @param manager_id
     * @throws Exception
     */
    public void insertIntoProject(String project_name ,String project_description ,int manager_id) throws Exception {
        connectToDatabase();
        preparedStatement = connect.prepareStatement("insert into  Project values (default, ?, ? ,? )");

        preparedStatement.setString(1, project_name);
        preparedStatement.setString(2, project_description);
        preparedStatement.setInt(3, manager_id);


        preparedStatement.executeUpdate();
        //close database connection
        close();
    }

    /**
     * insert into Team table
     * @param team_name
     * @param project_id
     * @throws Exception
     */
    public void insertIntoTeam(String team_name ,int project_id) throws Exception {
        connectToDatabase();
        preparedStatement = connect.prepareStatement("insert into  Team values (default, ?, ?)");

        preparedStatement.setString(1, team_name);
        preparedStatement.setInt(2, project_id);


        preparedStatement.executeUpdate();
        //close database connection
        close();
    }

    /**
     * insert into Task table
     * @param task_name
     * @param task_description
     * @param startTime
     * @param endTime
     * @param assignedTeamMember_id
     * @param assignedTeam_id
     * @throws Exception
     */
    public void insertIntoTask(String task_name ,String task_description ,String startTime ,String endTime
            ,int assignedTeamMember_id ,int assignedTeam_id) throws Exception {
        //open connection
        connectToDatabase();
        preparedStatement = connect.prepareStatement("insert into  Task values (default, ?, ? ,? ,? ,? ,? , DEFAULT)");

        preparedStatement.setString(1, task_name);
        preparedStatement.setString(2, task_description);
        preparedStatement.setString(3, startTime);
        preparedStatement.setString(4, endTime);
        preparedStatement.setInt(5, assignedTeamMember_id);
        preparedStatement.setInt(6, assignedTeam_id);

        preparedStatement.executeUpdate();
        //close database connection
        close();
    }

    /**
     * insert into Comment table
     * @param text
     * @param user_id
     * @param task_id
     * @throws Exception
     */
    public void insertIntoComment(String text ,int user_id ,int task_id) throws Exception {
        //open connection
        connectToDatabase();
        preparedStatement = connect.prepareStatement("insert into  Comment values (default, ?, ? ,?)");

        preparedStatement.setString(1, text);
        preparedStatement.setInt(2, user_id);
        preparedStatement.setInt(3, task_id);

        preparedStatement.executeUpdate();
        //close database connection
        close();
    }

    /**
     * insert into User_Team table
     * @param user_id
     * @param team_id
     * @throws Exception
     */
    public void insertIntoUser_Team(int user_id ,int team_id) throws Exception {
        connectToDatabase();
        preparedStatement = connect.prepareStatement("insert into  User_Team values (? ,?)");

        preparedStatement.setInt(1, user_id);
        preparedStatement.setInt(2, team_id);

        preparedStatement.executeUpdate();
        //close database connection
        close();
    }

    /**
     * insert into TaskDependency table
     * @param task_id1
     * @param task_id2
     * @throws Exception
     */
    public void insertIntoTaskDependency(int task_id1 ,int task_id2) throws Exception {
        //open connection
        connectToDatabase();
        preparedStatement = connect.prepareStatement("insert into  TaskDependency values (?, ?)");

        //task1 is depend on task2
        preparedStatement.setInt(1, task_id1);
        preparedStatement.setInt(2, task_id2);

        preparedStatement.executeUpdate();
        //close database connection
        close();
    }


    //************************************update queries
    /**
     * update percentage of task
     * @param task_id
     * @param percentage
     * @throws Exception
     */
    public void updatePercentageOfTask(int task_id ,int percentage) throws Exception {
        //open connection
        connectToDatabase();
        //update percentage query with task id
        String sql = "UPDATE Task SET percentage ='" + percentage + "'WHERE task_id =" + task_id;
        statement.executeUpdate( sql);

        //close database connection
        close();
    }

    /**
     * update profile(bio)
     * @param user_id
     * @param bio
     * @throws Exception
     */
    public void updateBioOfUser(int user_id , String bio) throws Exception {
        //update bio query with user id
        connectToDatabase();
        String sql = "UPDATE User SET bio ='" + bio + "'WHERE user_id =" + user_id;
        statement.executeUpdate( sql);

        //close database connection
        close();
    }

    /**
     * update Task table assign to a team
     * @param task_id
     * @param team_id
     * @throws Exception
     */
    public void updateTaskAssignToTeam(int task_id ,int team_id) throws Exception {
        //update bio query with user id
        connectToDatabase();
        String sql = "UPDATE Task SET assignedTeam_id ='" + team_id + "'WHERE task_id =" + task_id;
        statement.executeUpdate( sql);

        //close database connection
        close();


    }

    /**
     * update Task table assign to a team member
     * @param task_id
     * @param user_id
     * @throws Exception
     */
    public void updateTaskAssignToTeamMember(int task_id ,int user_id) throws Exception {
        //update bio query with user id
        connectToDatabase();
        String sql = "UPDATE Task SET assignedTeamMember_id ='" + user_id + "'WHERE task_id =" + task_id;
        statement.executeUpdate( sql);

        //close database connection
        close();
    }
    //************************************select queries
    /**
     * this function check user validation for login
     * and return TRUE if that is valid else return false
     * @param username  entered by user as username
     * @param password entered by user as password
     */
    public boolean checkUserValidation(String username , String password) throws Exception {
        //if user exist and pass is correct res -> TRUE else -> FALSE
        Boolean res = false;
        //open connection
        connectToDatabase();

        String sql = "SELECT username, password  FROM User ";
        ResultSet rs = statement.executeQuery(sql);
        //Extract data from result set
        while (rs.next()) {
            //Retrieve by column name
            String user = rs.getString(1);
            String pass = rs.getString(2);

            //check with every row
            if(user.equals(username) && pass.equals(password))
            {
                res = true;
                break;
            }
        }
        //close database connection
        close();
        return res;
    }

    /**
     * check that user is manager or not
     * @param project_id
     * @param user_id
     * @return
     * @throws Exception
     */
    public boolean userIsManager(int project_id , int user_id) throws Exception {
        boolean res = false;
        connectToDatabase();

        //select projects that user is project manager
        //select projects that user is a team member
        String sql = "SELECT manager_id FROM Project WHERE project_id = "+ project_id;

        ResultSet rs = statement.executeQuery( sql);
        //Extract data from result set
        while(rs.next()){
            //Retrieve by column name
            int manager_id  = rs.getInt("manager_id");
            if(manager_id == user_id)
            {
                res = true;
                break;
            }
        }
        //close database connection
        close();
        return res;
    }

    /**
     * select all projects that user is joined
     * @param us_id
     * @throws Exception
     */
    public void selectAllproject(int us_id) throws Exception {
        connectToDatabase();

        //select projects that user is project manager
        //select projects that user is a team member
        String sql = "SELECT project_id , project_name, project_description FROM Project WHERE manager_id ='"+ us_id +"' " +
                "UNION " +
                "SELECT p.project_id , p.project_name, p.project_description FROM team t ,User_team ut ,Project p" +
                " WHERE t.team_id = ut.team_id and p.project_id = t.project_id and ut.user_id =" + us_id;

        ResultSet rs = statement.executeQuery( sql);
        //Extract data from result set
        while(rs.next()){
            //Retrieve by column name
            int project_id  = rs.getInt("project_id");
            String project_name = rs.getString("project_name");
            String project_description = rs.getString("project_description");

            //Display values
            System.out.print(", id: " + project_id);
            System.out.print(", name: " + project_name);
            System.out.println(", description: " + project_description);
        }
        //close database connection
        close();
    }

    /**
     * select all the tasks of a project with id =  project_id
     * @param project_id
     * @throws Exception
     */
    public void selectAllTasks(int project_id) throws Exception {
        connectToDatabase();

        //select all the tasks of a project with id =  project_id
        String sql = "SELECT * FROM Task task , Team team WHERE task.assignedTeam_id = team.team_id and project_id ="+ project_id;

        ResultSet rs = statement.executeQuery( sql);
        //Extract data from result set
        while(rs.next()){
            //Retrieve by column name
            int task_id  = rs.getInt(1);
            String task_name = rs.getString(2);
            String task_description = rs.getString(3);
            String startTime = rs.getString(4);
            DateTimeFormatter formater1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime startdatetime = LocalDateTime.parse(startTime,formater1);
            String endTime = rs.getString(5);
            LocalDateTime enddatetime = LocalDateTime.parse(endTime,formater1);

            int assignedTeamMember_id  = rs.getInt(6);
            int assignedTeam_id  = rs.getInt(7);


            //Display values
            System.out.print(", task_id: " + task_id);
            System.out.print(", task_name: " + task_name);
            System.out.print(", task_description: " + task_description);
            System.out.print(", startTime: " + startdatetime);
            System.out.println();
            System.out.println(startdatetime.getYear());
            System.out.println(startdatetime.getMonthValue());
            System.out.println(startdatetime.getDayOfMonth());
            System.out.println(startdatetime.getHour());
            System.out.println(startdatetime.getMinute());
            System.out.println(startdatetime.getSecond());
            System.out.println();
            System.out.println(", endTime: " + enddatetime);
            System.out.println(enddatetime.getYear());
            System.out.println(enddatetime.getMonthValue());
            System.out.println(enddatetime.getDayOfMonth());
            System.out.println(enddatetime.getHour());
            System.out.println(enddatetime.getMinute());
            System.out.println(enddatetime.getSecond());
            System.out.print(", assignedTeamMember_id: " + assignedTeamMember_id);
            System.out.println(", assignedTeam_id: " + assignedTeam_id);
        }
        //close database connection
        close();
    }



    /**
     * select "to do" tasks of a project with id =  project_id with
     * @param project_id
     * @throws Exception
     */
    public void selectToDoTasks(int project_id) throws Exception {
        connectToDatabase();

        //select all the tasks of a project with id =  project_id
        String sql = "SELECT * FROM Task task , Team team WHERE task.assignedTeam_id = team.team_id and" +
                " task.percentage  = 0 and project_id ="+ project_id;

        ResultSet rs = statement.executeQuery( sql);
        //Extract data from result set
        while(rs.next()){
            //Retrieve by column name
            int task_id  = rs.getInt(1);
            String task_name = rs.getString(2);
            String task_description = rs.getString(3);
            String startTime = rs.getString(4);
            String endTime = rs.getString(5);
            int assignedTeamMember_id  = rs.getInt(6);
            int assignedTeam_id  = rs.getInt(7);


            //Display values
            System.out.print(", task_id: " + task_id);
            System.out.print(", task_name: " + task_name);
            System.out.print(", task_description: " + task_description);
            System.out.print(", startTime: " + startTime);
            System.out.print(", endTime: " + endTime);
            System.out.print(", assignedTeamMember_id: " + assignedTeamMember_id);
            System.out.println(", assignedTeam_id: " + assignedTeam_id);
        }
        //close database connection
        close();
    }
    /**
     * select "Doing" tasks of a project with id =  project_id with
     * @param project_id
     * @throws Exception
     */
    public void selectDoingTasks(int project_id) throws Exception {
        connectToDatabase();

        //select all the tasks of a project with id =  project_id
        String sql = "SELECT * FROM Task task , Team team WHERE task.assignedTeam_id = team.team_id and" +
                " task.percentage  <> 0 and task.percentage <> 100 and project_id ="+ project_id;

        ResultSet rs = statement.executeQuery( sql);
        //Extract data from result set
        while(rs.next()){
            //Retrieve by column name
            int task_id  = rs.getInt(1);
            String task_name = rs.getString(2);
            String task_description = rs.getString(3);
            String startTime = rs.getString(4);
            String endTime = rs.getString(5);
            int assignedTeamMember_id  = rs.getInt(6);
            int assignedTeam_id  = rs.getInt(7);


            //Display values
            System.out.print(", task_id: " + task_id);
            System.out.print(", task_name: " + task_name);
            System.out.print(", task_description: " + task_description);
            System.out.print(", startTime: " + startTime);
            System.out.print(", endTime: " + endTime);
            System.out.print(", assignedTeamMember_id: " + assignedTeamMember_id);
            System.out.println(", assignedTeam_id: " + assignedTeam_id);
        }
        //close database connection
        close();
    }

    /**
     * select "Done" tasks of a project with id =  project_id with
     * @param project_id
     * @throws Exception
     */
    public void selectDoneTasks(int project_id) throws Exception {
        connectToDatabase();

        //select all the tasks of a project with id =  project_id
        String sql = "SELECT * FROM Task task , Team team WHERE task.assignedTeam_id = team.team_id and" +
                " task.percentage  = 100 and project_id ="+ project_id;

        ResultSet rs = statement.executeQuery( sql);
        //Extract data from result set
        while(rs.next()){
            //Retrieve by column name
            int task_id  = rs.getInt(1);
            String task_name = rs.getString(2);
            String task_description = rs.getString(3);
            String startTime = rs.getString(4);
            String endTime = rs.getString(5);
            int assignedTeamMember_id  = rs.getInt(6);
            int assignedTeam_id  = rs.getInt(7);


            //Display values
            System.out.print(", task_id: " + task_id);
            System.out.print(", task_name: " + task_name);
            System.out.print(", task_description: " + task_description);
            System.out.print(", startTime: " + startTime);
            System.out.print(", endTime: " + endTime);
            System.out.print(", assignedTeamMember_id: " + assignedTeamMember_id);
            System.out.println(", assignedTeam_id: " + assignedTeam_id);
        }
        //close database connection
        close();
    }

    /**
     * select all comment of task with task_id
     * @param task_id
     * @throws Exception
     */
    public void selectComments(int task_id) throws Exception {
        connectToDatabase();

        //select all the comments of a task with id =  task_id
        String sql = "SELECT * FROM Comment WHERE task_id =" + task_id;

        ResultSet rs = statement.executeQuery( sql);
        //Extract data from result set
        while(rs.next()){
            //Retrieve by column name
            int comment_id  = rs.getInt(1);
            String text = rs.getString(2);
            int user_id  = rs.getInt(3);

            //Display values
            System.out.print(", comment_id: " + comment_id);
            System.out.print(", text: " + text);
            System.out.println(", user_id: " + user_id);
        }
        //close database connection
        close();
    }

    /**
     * select all teamms of project with project_id
     * @param project_id
     * @throws Exception
     */
    public void selectTeams(int project_id) throws Exception {
        connectToDatabase();

        //select all the comments of a task with id =  task_id
        String sql = "SELECT * FROM Team WHERE project_id =" + project_id;


        ResultSet rs = statement.executeQuery( sql);
        //Extract data from result set
        while(rs.next()){
            //Retrieve by column name
            int team_id  = rs.getInt(1);
            String team_name = rs.getString(2);

            //Display values
            System.out.print(", team_id: " + team_id);
            System.out.println(", team_name: " + team_name);
        }
        //close database connection
        close();
    }
    /**
     * select users of project with project_id
     * @param project_id
     * @throws Exception
     */
    public void selectUserOfproject(int project_id) throws Exception {
        connectToDatabase();

        //select all the comments of a task with id =  task_id
        String sql =   "SELECT u.user_id ,u.username ,u.password ,u.email ,u.phoneNumber ,u.bio FROM team t ,User_team ut , User u,Project p" +
                " WHERE t.team_id = ut.team_id and p.project_id = t.project_id and ut.user_id = u.user_id and p.project_id =" + project_id;

        ResultSet rs = statement.executeQuery( sql);
        //Extract data from result set
        while(rs.next()){
            //Retrieve by column name
            int user_id  = rs.getInt(1);
            String username = rs.getString(2);
            String password = rs.getString(3);
            String email = rs.getString(4);
            String phoneNumber = rs.getString(5);
            String bio = rs.getString(6);


            //Display values
            System.out.print(", user_id: " + user_id);
            System.out.print(", username: " + username);
            System.out.print(", password: " + password);
            System.out.print(", email: " + email);
            System.out.print(", phoneNumber: " + phoneNumber);
            System.out.println(", bio: " + bio);

        }
        //close database connection
        close();
    }

    /**
     * select users of team with team_id (team members)
     * @param team_id
     * @throws Exception
     */
    public void selectUserOfTeam(int team_id) throws Exception {
        connectToDatabase();

        //select all the comments of a task with id =  task_id
        String sql =   "SELECT u.user_id ,u.username ,u.password ,u.email ,u.phoneNumber ,u.bio FROM User_team ut , User u" +
                " WHERE ut.user_id = u.user_id and ut.team_id =" + team_id;

        ResultSet rs = statement.executeQuery( sql);
        //Extract data from result set
        while(rs.next()){
            //Retrieve by column name
            int user_id  = rs.getInt(1);
            String username = rs.getString(2);
            String password = rs.getString(3);
            String email = rs.getString(4);
            String phoneNumber = rs.getString(5);
            String bio = rs.getString(6);

            //Display values
            System.out.print(", user_id: " + user_id);
            System.out.print(", username: " + username);
            System.out.print(", password: " + password);
            System.out.print(", email: " + email);
            System.out.print(", phoneNumber: " + phoneNumber);
            System.out.println(", bio: " + bio);

        }
        //close database connection
        close();
    }

    /**
     * select manager of project details with project_id
     * @param project_id
     * @return
     * @throws Exception
     */
    public void selectManagerOfProject(int project_id) throws Exception {
        connectToDatabase();

        //select projects that user is project manager
        //select projects that user is a team member
        String sql =   "SELECT u.user_id ,u.username ,u.password ,u.email ,u.phoneNumber ,u.bio FROM Project p , User u" +
                " WHERE u.user_id = p.manager_id and p.project_id =" + project_id;

        ResultSet rs = statement.executeQuery( sql);
        //Extract data from result set
        while(rs.next()){
            //Retrieve by column name
            int user_id  = rs.getInt(1);
            String username = rs.getString(2);
            String password = rs.getString(3);
            String email = rs.getString(4);
            String phoneNumber = rs.getString(5);
            String bio = rs.getString(6);

            //Display values
            System.out.print(", user_id: " + user_id);
            System.out.print(", username: " + username);
            System.out.print(", password: " + password);
            System.out.print(", email: " + email);
            System.out.print(", phoneNumber: " + phoneNumber);
            System.out.println(", bio: " + bio);
        }
        //close database connection
        close();
    }

    //close database connection
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}
