package model;

import java.sql.*;
public class TestDatabase {
    public  TestDatabase() throws Exception {
        Database database = new Database();
        //create all tables
        database.createTables();
        //test all insertion queries
        database.insertIntoUser("hosein", "123456", "hosein@gmail.com", "09123273259");
        database.insertIntoProject("JDM", "hadafe in proje .......... mibashad", 1);
        database.insertIntoTeam("alpha", 1);
        database.insertIntoUser_Team(1, 1);
        database.insertIntoTask("create database", "database o besaz", "2020-01-01 10:10:10", "2020-01-01 10:10:11", 1, 1);
        database.insertIntoTask("create databaseee", "database o besaz", "2020-01-01 10:10:10", "2020-01-01 10:10:11", 1, 1);
        database.insertIntoComment("hi", 1, 1);
        database.insertIntoTaskDependency(1, 2);

        //login validation test
        System.out.println(database.checkUserValidation("hosein", "123456"));

        //select all project test by user id
        database.selectAllproject(1);

        //test user is manager or not
        System.out.println(database.userIsManager(1, 2));

        //test update bio
        database.updateBioOfUser(1, "salam man hosein am");
        //test update percentage of tasks
        database.updatePercentageOfTask(2, 100);

        //test select tasks
        database.selectAllTasks(1);
        //test select to do tasks
        database.selectToDoTasks(1);
        //test select doing tasks
        database.selectDoingTasks(1);
        //test select done tasks
        database.selectDoneTasks(1);

        //test select comments of task
        database.selectComments(1);
        //test select teams of project
        database.selectTeams(1);
        //test select user of project
        database.selectUserOfproject(1);
        //test select user of team
        database.selectUserOfTeam(1);
        //test select manager of project
        database.selectManagerOfProject(1);
    }
}
