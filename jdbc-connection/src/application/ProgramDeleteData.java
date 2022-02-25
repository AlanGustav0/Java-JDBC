package application;

import db.Database;
import db.DbIntegrityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProgramDeleteData {

    public static void main(String[] args) {

        //<--DELETANDO DADOS
        Connection connection = null;
        PreparedStatement st = null;

        try {
            connection = Database.getConnection();
            st = connection.prepareStatement(
                    "delete from department " +
                            "where id = ?"
            );
            st.setInt(1,4);

            int rowsAffected = st.executeUpdate();
            System.out.println(String.format("Done! Rows affected = %d", rowsAffected));

        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        }
    }
}
