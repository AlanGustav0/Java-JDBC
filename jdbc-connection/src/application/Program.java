package application;

import db.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

    public static void main(String[] args){

        Connection connection; //Realiza a conexão com o banco de dados
        Statement st = null; //Classe necessária para criar declarações para o SQL, ex: select, update...
        ResultSet rs = null; //Possui métodos para recuperar valores de colunas e linhas após a execução de um statment

        try{
            connection = Database.getConnection(); //conexão criada
            st = connection.createStatement(); // statment recebe a conexão
            rs = st.executeQuery("select * from department"); //Resultset recebe os dados do statment realizado

            //Percorremos o Resultset para obter os valores
            while(rs.next()){
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finall{
            Database.closeResultSet(rs);
            Database.closeStatment((st));
            Database.closeConnection();
        }
    }
}
