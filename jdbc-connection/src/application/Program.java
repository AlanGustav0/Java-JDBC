package application;

import db.Database;

import java.sql.Connection;

public class Program {

    public static void main(String[] args){


        Connection connection = Database.getConnection();
        Database.closeConnection();
    }
}
