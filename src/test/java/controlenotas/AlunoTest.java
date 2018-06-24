package controlenotas;

import org.junit.Test;

import controlenotas.DAO.AlunoDAO;
import controlenotas.DAO.BaseDAO;
import controlenotas.classes.Aluno;

public class AlunoTest {

    BaseDAO<Aluno, Integer> alunoDAO = new AlunoDAO();

    @Test
    public void criarTabela() {

        this.alunoDAO.criarDDL();
    }

    @Test
    public void inserir() {

        final Aluno aluno = new Aluno();
        aluno.setNome("Pedro");
        aluno.setCurso("CBSI");
        aluno.setMatricula("201711140038");

        this.alunoDAO.inserir(aluno);
    }

}
