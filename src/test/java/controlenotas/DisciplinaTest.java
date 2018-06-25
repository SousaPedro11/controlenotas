package controlenotas;

import org.testng.annotations.Test;

import controlenotas.DAO.BaseDAO;
import controlenotas.DAO.DisciplinaDAO;
import controlenotas.classes.Disciplina;

public class DisciplinaTest {

    BaseDAO<Disciplina, Integer> disciplinaDAO = new DisciplinaDAO();

    @Test
    public void criarTabela() {

        this.disciplinaDAO.criarDDL();
    }

    @Test(dependsOnMethods = "criarTabela", enabled = true)
    public void inserir() {

        final Disciplina disciplina = new Disciplina();
        disciplina.setNome("OO");
        disciplina.setSemestre(3);
        disciplina.setCargahoraria(60);
        disciplina.setProfessor("Gustavo");
        disciplina.setTurma("2018.1");

        this.disciplinaDAO.inserir(disciplina);
    }

    @Test(dependsOnMethods = "inserir", enabled = true)
    public void alterar() {

        final int cod = 2;
        System.out.println("\nALTERAR REGISTRO: " + cod);
        final Disciplina disciplina = new Disciplina();
        disciplina.setNome("TS");
        disciplina.setSemestre(3);
        disciplina.setCargahoraria(60);
        disciplina.setProfessor("Lídio");
        disciplina.setTurma("2018.1");

        try {

            System.out.println("Registro Atual");
            this.disciplinaDAO.alterar(disciplina, cod);
            this.disciplinaDAO.buscarPor(cod);
        } catch (final Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test(dependsOnMethods = "inserir", enabled = true)
    public void deletar() {

        final int cod = 1;
        System.out.println("\nDELETAR REGISTRO: " + cod);
        this.disciplinaDAO.buscarPor(cod);
        this.disciplinaDAO.excluir(cod);
    }

    @Test(dependsOnMethods = "inserir", enabled = true)
    public void listarPorID() {

        final int cod = 2;
        System.out.println("\nBUSCA POR COD = " + cod);
        this.disciplinaDAO.buscarPor(cod);
    }

    @Test(dependsOnMethods = "inserir", enabled = true)
    public void listartodos() {

        System.out.println("\nBUSCA TODOS");
        this.disciplinaDAO.buscarTodos();
    }
}
