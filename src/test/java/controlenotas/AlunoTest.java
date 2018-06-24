package controlenotas;

import org.testng.annotations.Test;

import controlenotas.DAO.AlunoDAO;
import controlenotas.DAO.BaseDAO;
import controlenotas.classes.Aluno;

public class AlunoTest {

    BaseDAO<Aluno, Integer> alunoDAO = new AlunoDAO();

    @Test
    public void criarTabela() {

        this.alunoDAO.criarDDL();
    }

    @Test(dependsOnMethods = "criarTabela", enabled = false)
    public void inserir() {

        final Aluno aluno = new Aluno();
        aluno.setNome("Pedro");
        aluno.setCurso("CBSI");
        aluno.setMatricula("201711140038");

        this.alunoDAO.inserir(aluno);
    }

    @Test(dependsOnMethods = "criarTabela")
    public void deletar() {

        final int cod = 12;
        System.out.println("\nDELETAR REGISTRO: " + cod);
        this.alunoDAO.buscarPor(cod);
        this.alunoDAO.excluir(cod);
    }

    @Test(dependsOnMethods = "criarTabela")
    public void listarPorID() {

        final int cod = 10;
        System.out.println("\nBUSCA POR COD = " + cod);
        this.alunoDAO.buscarPor(cod);
    }

    @Test(dependsOnMethods = "criarTabela")
    public void listartodos() {

        System.out.println("\nBUSCA TODOS");
        this.alunoDAO.buscarTodos();
    }
}
