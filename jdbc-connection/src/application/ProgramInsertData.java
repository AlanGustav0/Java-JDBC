package application;

import db.Database;

import javax.xml.crypto.Data;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ProgramInsertData {

    public static void main(String[] args) {

        Connection connection = null;

        //<---INSERINDO DADOS
        PreparedStatement pst = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
        ResultSet rs = null;
        try {
            connection = Database.getConnection();

            pst = connection.prepareStatement(
                    "insert into seller (Name,Email,BirthDate,BaseSalary,DepartmentId)" +
                            "values(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS //retorna o valor do id gerado
            );

            //Insere os valores de ? no PreparedStatement
            pst.setString(1, "Carl");
            pst.setString(2, "carl@email.com");
            pst.setDate(3, new java.sql.Date(sdf.parse("22/10/1980").getTime()));
            pst.setDouble(4, 2.500);
            pst.setInt(5, 4);

            int rowsAffected = pst.executeUpdate(); //Executa a operação

            if (rowsAffected > 0) {
                rs = pst.getGeneratedKeys();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println(String.format("Done! id = %d", id));
                }
            } else {
                System.out.println("No rows affected");
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        } finally {
            Database.closeStatment(pst);
            Database.closeConnection();
        }
    }
}
