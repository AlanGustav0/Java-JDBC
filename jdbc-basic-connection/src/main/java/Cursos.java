public class Cursos {

    private int id;
    private String nome_curso;
    private String periodo;

    public Cursos(){

    }

    public Cursos(int id,String nome_curso,String periodo){
        this.id = id;
        this.nome_curso = nome_curso;
        this.periodo = periodo;
    }

    public Cursos(String nome_curso,String periodo){
        this.nome_curso = nome_curso;
        this.periodo = periodo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_curso() {
        return nome_curso;
    }

    public void setNome_curso(String nome_curso) {
        this.nome_curso = nome_curso;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @Override
    public String toString() {
        return "Id: " + getId() + "\n" +
                "Nome do Curso: " + getNome_curso() + "\n" +
                "Período: " + getPeriodo();

    }
}
