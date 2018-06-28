package controlenotas;

import java.util.Optional;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import controlenotas.DAO.AlunoDAO;
import controlenotas.DAO.BaseDAO;
import controlenotas.classes.Aluno;

public class AlunoTest {

    BaseDAO<Aluno, Integer> alunoDAO = new AlunoDAO();

    private int getTotalRegistros() {

        return 10;
    }

    @BeforeClass
    @Test
    public void criarTabela() {

        this.alunoDAO.criarDDL();
    }

    @Test
    public void inserir() {

        // inserir multiplos registros
        for (int i = 0; i < this.getTotalRegistros(); i++) {

            final Aluno aluno = new Aluno();
            aluno.setNome("Pedro");
            aluno.setCurso("CBSI");
            aluno.setMatricula("201711140038");

            this.alunoDAO.inserir(aluno);
        }
    }

    @Test(dependsOnMethods = "inserir")
    public void alterar() {

        final int cod = 4;
        System.out.println("\nALTERAR REGISTRO: " + cod);
        final Optional<Aluno> optional = this.alunoDAO.buscarPor(cod, false);
        Assert.assertTrue(optional.isPresent());

        final Aluno aluno = optional.get();
        aluno.setCurso("CBSI");
        aluno.setNome("Pedro");

        this.alunoDAO.alterar(aluno);
    }

    @Test(dependsOnMethods = "alterar")
    public void excluir() {

        final int cod = 1;
        System.out.println("\nDELETAR REGISTRO: " + cod);
        this.alunoDAO.buscarPor(cod, true);
        this.alunoDAO.excluir(cod);
    }

    @Test(dependsOnMethods = "alterar")
    public void buscarPorChavePrimaria() {

        final int cod = 2;
        System.out.println("\nBUSCA POR COD = " + cod);
        this.alunoDAO.buscarPor(cod, true);
    }

    @Test(dependsOnMethods = "alterar")
    public void listartodos() {

        System.out.println("\nBUSCA TODOS");
        this.alunoDAO.buscarTodos();
    }
}
