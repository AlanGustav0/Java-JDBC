import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


//Data Access Object
public class CursosDAO {

    public List<Cursos> listCursos(){

        List<Cursos> cursos = new ArrayList<>();

        try (Connection connect = ConnectionJDBC.getConnection()){
            PreparedStatement prepareState = connect.prepareStatement("SELECT * FROM cursos");
            ResultSet resultSet =  prepareState.executeQuery();

            while(resultSet.next()){
                Cursos curso = new Cursos(resultSet.getInt("id"),
                        resultSet.getString("nome_curso"),
                        resultSet.getString("periodo"));
                cursos.add(curso);
            }
        } catch (SQLException throwables) {
            System.out.printf("Falha na Conexão Atual");
            throwables.printStackTrace();
        }

        return cursos;
    }

    public Cursos getById(int id){

        Cursos curso = new Cursos();

        try (Connection connect = ConnectionJDBC.getConnection()){
            String sql = "SELECT id,nome_curso,periodo FROM cursos WHERE id = ?";

            PreparedStatement prepareState = connect.prepareStatement(sql);
            prepareState.setInt(1,id);
            ResultSet resultSet =  prepareState.executeQuery();

            while(resultSet.next()){
                curso = new Cursos(resultSet.getInt("id"),
                        resultSet.getString("nome_curso"),
                        resultSet.getString("periodo"));
            }


        } catch (SQLException throwables) {
            System.out.printf("Falha na Conexão Atual");
            throwables.printStackTrace();
        }

        return curso;

    }

    public void createCurso(Cursos curso){

        try (Connection connect = ConnectionJDBC.getConnection()){
            String sql = "INSERT INTO cursos(id,nome_curso,periodo) VALUES (?,?,?)";

            PreparedStatement prepareState = connect.prepareStatement(sql);
            prepareState.setInt(1,curso.getId());
            prepareState.setString(2,curso.getNome_curso());
            prepareState.setString(3,curso.getPeriodo());

            int rowsAffected = prepareState.executeUpdate();

            String resultado = (rowsAffected == 1) ? "Inserção bem sucedida! Foi adicionada " + rowsAffected + " linha" :
                    "Inserção bem sucedida! Foram adicionadas " + rowsAffected + " linhas";

            System.out.println(resultado);

        } catch (SQLException throwables) {
            System.out.printf("Falha na Conexão Atual");
            throwables.printStackTrace();
        }

    }

    public void delete(int id){

        try (Connection connect = ConnectionJDBC.getConnection()){
            String sql = "DELETE FROM cursos WHERE id = ?";

            PreparedStatement prepareState = connect.prepareStatement(sql);
            prepareState.setInt(1,id);

            int rowsAffected = prepareState.executeUpdate();

            String resultado = (rowsAffected == 1) ? "Delete bem sucedida! Foi deletada " + rowsAffected + " linha" :
                    "Delete bem sucedido! Foram deletadas " + rowsAffected + " linhas";

            System.out.println(resultado);

        } catch (SQLException throwables) {
            System.out.printf("Falha na Conexão Atual");
            throwables.printStackTrace();
        }

    }

    public void update(Cursos curso){
        try (Connection connect = ConnectionJDBC.getConnection()){
            String sql = "UPDATE cursos SET nome_curso = ?,periodo = ? WHERE id = ?";

            PreparedStatement prepareState = connect.prepareStatement(sql);
            prepareState.setString(1,curso.getNome_curso());
            prepareState.setString(2,curso.getPeriodo());
            prepareState.setInt(3,curso.getId());

            int rowsAffected = prepareState.executeUpdate();

            String resultado = (rowsAffected == 1) ? "Atualização bem sucedida! Foi atualizada " + rowsAffected + " linha" :
                    "Atualização bem sucedido! Foram atualizadas " + rowsAffected + " linhas";

            System.out.println(resultado);

        } catch (SQLException throwables) {
            System.out.printf("Falha na Conexão Atual");
            throwables.printStackTrace();
        }

    }
}
