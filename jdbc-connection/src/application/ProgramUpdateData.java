package application;

import db.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProgramUpdateData {

    public static void main(String[] args) {

        //<--UPDATE CONNECTION
        Connection connection = null;
        PreparedStatement st = null;

        try {
            connection = Database.getConnection();
            st = connection.prepareStatement(
                    "Update seller " +
                            "set BaseSalary = BaseSalary + ? " +
                            "where(DepartmentId = ?)"
            );

            st.setDouble(1, 500.0);
            st.setInt(2, 4);

            int rowsAffected = st.executeUpdate();

            System.out.println(String.format("Done! Rows affected = %d", rowsAffected));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Database.closeStatment(st);
            Database.closeConnection();
        }
    }
}
