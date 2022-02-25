package application;

import db.Database;
import db.DbException;
import db.DbIntegrityException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ProgramTransactions {

    public static void main(String[] args) {
        //<--TRANSAÇÃO DE DADOS
        Connection connection = null;
        Statement st = null;

        try {
            connection = Database.getConnection();
            st = connection.createStatement();

            //Inativa o commit automático no Banco de dados
            connection.setAutoCommit(false); //Não irá confirmar o commit automaticamente, ficando pedente uma confirmação por parte do programador

            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");
//            int x = 1;
//            if (x < 2) {
//                throw new SQLException("Fake error");
//            }
            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");

            //realiza o commit apenas apos o bloco ser executado
            connection.commit();

            System.out.println(String.format("rows1 = %d %nrows2 = %d", rows1, rows2));


        } catch (SQLException e) {
            try {
                connection.rollback();
                throw new DbException("Transaction rolled back! caused by " + e.getMessage());
            } catch (SQLException ex) {
                throw new DbException("Error trying to rollback! Cauded by" + ex.getMessage());
            }
        }
    }
}
