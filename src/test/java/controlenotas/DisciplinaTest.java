package controlenotas;

import java.util.Optional;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import controlenotas.DAO.BaseDAO;
import controlenotas.DAO.DisciplinaDAO;
import controlenotas.classes.Disciplina;

public class DisciplinaTest {

    BaseDAO<Disciplina, Integer> disciplinaDAO = new DisciplinaDAO();

    private int getTotalRegistros() {

        return 10;
    }

    @BeforeClass
    @Test
    public void criarTabela() {

        this.disciplinaDAO.criarDDL();
    }

    @Test
    public void inserir() {

        // inserir multiplos registros
        for (int i = 0; i < this.getTotalRegistros(); i++) {

            // final Disciplina disciplina = new Disciplina();
            // disciplina.setDisciplina("OO");
            // disciplina.setSemestre(3);
            // disciplina.setCargahoraria(60);
            // disciplina.setProfessor("Gustavo");
            // disciplina.setTurma("2018.1");

            final Disciplina disciplina = new Disciplina("OO2", 3, 60, "Gustavo", "2018.2");
            disciplina.insereNotas();
            final double d = disciplina.calcularMedia();
            disciplina.setMedia(d);

            this.disciplinaDAO.inserir(disciplina);
        }
    }

    @Test
    public void calculaMedia() {

        final Disciplina disciplina = new Disciplina("BD", 3, 60, "Sei Não", "2019.2");
        disciplina.insereNotas();
        final double d = disciplina.calcularMedia();
        disciplina.setMedia(d);
        System.out.println(disciplina);
    }

    @Test(dependsOnMethods = "inserir")
    public void alterar() {

        final int cod = 3;
        System.out.println("\nALTERAR REGISTRO: " + cod);
        final Optional<Disciplina> optional = this.disciplinaDAO.buscarPor(cod, false);
        Assert.assertTrue(optional.isPresent());

        final Disciplina disciplina = optional.get();
        disciplina.setCargahoraria(45);
        disciplina.setProfessor("AlfredoMito");
        disciplina.setTurma("2018.2");

        this.disciplinaDAO.alterar(disciplina);
    }

    @Test(dependsOnMethods = "alterar")
    public void deletar() {

        final int cod = 1;
        System.out.println("\nDELETAR REGISTRO: " + cod);
        this.disciplinaDAO.buscarPor(cod, true);
        this.disciplinaDAO.excluir(cod);
    }

    @Test(dependsOnMethods = "alterar")
    public void listarPorID() {

        final int cod = 2;
        System.out.println("\nBUSCA POR COD = " + cod);
        this.disciplinaDAO.buscarPor(cod, true);
    }

    @Test(dependsOnMethods = "alterar")
    public void listartodos() {

        System.out.println("\nBUSCA TODOS");
        this.disciplinaDAO.buscarTodos();
    }
}
