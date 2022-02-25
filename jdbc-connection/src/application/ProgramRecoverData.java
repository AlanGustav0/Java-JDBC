package application;

import db.Database;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ProgramRecoverData {

    public static void main(String[] args) {

        Connection connection; //Realiza a conexão com o banco de dados
        Statement st = null; //Classe necessária para criar declarações para o SQL, ex: select, update...
        ResultSet rs = null; //Possui métodos para recuperar valores de colunas e linhas após a execução de um statment

        //<---RECUPERANDO DADOS
        try {
            connection = Database.getConnection(); //conexão criada
            st = connection.createStatement(); // statment recebe a conexão
            rs = st.executeQuery("select * from department"); //Resultset recebe os dados do statment realizado

            //Percorremos o Resultset para obter os valores
            while (rs.next()) {
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Database.closeResultSet(rs);
            Database.closeStatment((st));
            Database.closeConnection();
        }


    }
}
