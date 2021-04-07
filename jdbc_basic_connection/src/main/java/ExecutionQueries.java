import java.util.List;

public class ExecutionQueries {

    public static void main(String[] args) {

        //Listando cursos-------->
        CursosDAO cursos = new CursosDAO();
        List<Cursos> listaCursos = cursos.listCursos();
        listaCursos.stream().forEach(System.out::println);

        //Listando curso a partir do ID-------->

        Cursos curso = cursos.getById(2);
        System.out.println(curso);

        //Criar curso a partir do ID-------->

        //curso = new Cursos("Marketing","Vespertino");
        //cursos.createCurso(curso);

        //Deletar curso a partir do ID-------->
//        cursos.delete(2);
//        listaCursos = cursos.listCursos();
//        listaCursos.stream().forEach(System.out::println);

        //Atualizar curso a partir do ID-------->

        Cursos cursoAtualizar = cursos.getById(5);

        cursoAtualizar.setNome_curso("Publicidade");
        cursoAtualizar.setPeriodo("NOTURNO");
        cursos.update(cursoAtualizar);
        listaCursos = cursos.listCursos();
        listaCursos.stream().forEach(System.out::println);


    }
}
