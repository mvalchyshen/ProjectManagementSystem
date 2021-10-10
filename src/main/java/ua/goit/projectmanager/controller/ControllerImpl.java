package ua.goit.projectmanager.controller;

import ua.goit.projectmanager.service.handler.CommandHandler;
import ua.goit.projectmanager.util.DataBaseConnection;
import ua.goit.projectmanager.view.View;
import ua.goit.projectmanager.view.commands.BaseCommand;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ControllerImpl implements Controller {

    private View view;
    private List<BaseCommand> commands;
    private List<String> tables;
    private CommandHandler commandHandler;

    public ControllerImpl() {
        view = View.of();
        commands = new ArrayList<>();
        tables = getTablesFromDB();
        commandHandler = CommandHandler.of();
    }

    private List<String> getTablesFromDB() {
        List<String> tableList = new ArrayList<>();
        try(DataBaseConnection dataBaseConnection = DataBaseConnection.getInstance()) {
            Connection connection = dataBaseConnection.getConnection();
            DatabaseMetaData metaData = connection.getMetaData();
            String[] types = {"TABLE"};
            //Retrieving the columns in the database
            ResultSet tables = metaData.getTables(null, null, "%", types);
            while (tables.next()) {
                tableList.add(tables.getString(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tableList;
    }

    @Override
    public void run() {
        view.write("WELCOME TO CONSOLE DATABASE_APP");
        try{
            executeCommands();
        } catch (Exception e) {
            System.exit(0);
        }
    }

    private void executeCommands() {
        while (true) {
            view.write("PLEASE, CHOOSE COMMAND YOU WANT TO RUN :");
            commands.forEach(System.out::println);
            String command = view.read();
            System.out.println("CHOOSE ENTITY YOU WANT TO" + command);
            tables.forEach(System.out::println);
            String table = view.read();
            commandHandler.handle(command,table);
        }
    }
}
