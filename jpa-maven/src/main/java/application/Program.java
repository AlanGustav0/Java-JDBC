package application;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Program {

    public static void main(String[] args){

        Pessoa p1 = new Pessoa(null,"Carlos da Silva","carlos@email.com");
        Pessoa p2 = new Pessoa(null,"Maria da Silva","maria@email.com");
        Pessoa p3 = new Pessoa(null,"Pedro da Silva","pedro@email.com");

        //Instancia do EntitymanagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");

        //Instancia do EntityManager para conexão com o banco de dados
        EntityManager em = emf.createEntityManager();

         //Inserindo os dados na base de dados--------------------------------------------

        //Inicia a transação dos dados no banco de dados
        System.out.println("Início da transação com banco de dados");
        em.getTransaction().begin();

        System.out.println("Dados persistido com sucesso " + p1);
        em.persist(p1);
        System.out.println("Dados persistido com sucesso " + p2);
        em.persist(p2);
        System.out.println("Dados persistido com sucesso " + p3);
        em.persist(p3);
       // Finalizando a transação realizando o commit na base de dados
        System.out.println("Fim da transação com banco de dados");
         em.getTransaction().commit();
        System.out.println();

        //Buscando os dados na base de dados--------------------------------------------

        Pessoa p = em.find(Pessoa.class,2);
        Pessoa pessoa = p;
        System.out.println("Pessoa encontrada --> " + p);
        System.out.println();

        //Deletando dados na base de dados--------------------------------------------
        System.out.println("Início da transação com banco de dados");
        em.getTransaction().begin();
        em.remove(p);
        System.out.println("Pessoa deletada --> " + pessoa.getName());
        em.getTransaction().commit();
        System.out.println("Fim da transação com banco de dados");
        System.out.println();




        em.close();
        emf.close();


    }
}
