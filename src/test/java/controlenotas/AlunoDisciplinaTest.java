package controlenotas;

import org.testng.annotations.Test;

import controlenotas.DAO.AlunoDAO;
import controlenotas.DAO.AlunoDisciplinaDAO;
import controlenotas.DAO.BaseDAO;
import controlenotas.DAO.DisciplinaDAO;
import controlenotas.classes.Aluno;
import controlenotas.classes.AlunoDisciplina;
import controlenotas.classes.Disciplina;

public class AlunoDisciplinaTest {

    BaseDAO<AlunoDisciplina, Integer> adDAO = new AlunoDisciplinaDAO();

    BaseDAO<Disciplina, Integer> disciplinaDAO = new DisciplinaDAO();

    BaseDAO<Aluno, Integer> alunoDAO = new AlunoDAO();

    @Test
    public void criarTabela() {

        this.alunoDAO.criarDDL();
        this.disciplinaDAO.criarDDL();
        this.adDAO.criarDDL();
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
        final inserir aluno1

        final iserir
        d1



    }
}
