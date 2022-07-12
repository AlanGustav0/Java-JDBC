# JPA Hibernate

JPA é a Biblioteca padrão do Java de Mapeamento 
de objeto-relacional onde JPA é a especificação e o Hibernate a implementação.

Java Persistênce API (JPA) é a especificação padrão da plataforma Java EE para mapeamento de objeto-relacional e persistência de dados.

## Principais classes

#### • EntityManager
Um objeto EntityManager encapsula uma conexão com a base de dados e serve para efetuar operações de
acesso a dados (inserção, remoção, deleção, atualização) em entidades (clientes, produtos, pedidos, etc.)

#### • EntityManagerFactory
Um objeto EntityManagerFactory é utilizado para instanciar objetos EntityManager.

# JDBC
JDBC (Java Database Connectivity): API padrão do Java para acesso a dados.
Ela é uma API de nível de chamada, isso que dizer que as instruções SQL são
transmitidas como sequências para a API, que então se encarrega de executá-las na base de dados.


##### Fontes:
[https://docs.oracle.com/javaee/7/api/javax/persistence/EntityManager.html] 
[https://docs.oracle.com/javaee/7/api/javax/persistence/EntityManagerFactory.html] 
[https://docs.oracle.com/javase/8/docs/technotes/guides/jdbc/] 
[https://docs.oracle.com/javase/8/docs/api/java/sql/package-summary.html] 

Todo conteúdo deste repositório foi com base no curso de [Java Completo](https://www.udemy.com/course/java-curso-completo) 
do professor Nélio Alves.