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
    public void inserirAluno() {

        final Aluno aluno1 = new Aluno("Pedro", "201711140038", "CBSI");

        final Aluno aluno2 = new Aluno();
        aluno2.setNome("Angela Rodrigues");
        aluno2.setCurso("CBSI");
        aluno2.setMatricula("201711140037");

        this.alunoDAO.inserir(aluno1);
        this.alunoDAO.inserir(aluno2);

    }

    @Test(dependsOnMethods = "inserirAluno")
    public void inserirDisciplina() {

        final Disciplina disciplina1 = new Disciplina();
        disciplina1.setDisciplina("OO");
        disciplina1.setCargahoraria(60);
        disciplina1.setSemestre(3);
        disciplina1.setTurma("2018.2");
        disciplina1.setProfessor("Gustavo");
        disciplina1.insereNotas();
        final double d1 = disciplina1.calcularMedia();
        disciplina1.setMedia(d1);

        final Disciplina disciplina2 = new Disciplina("ED", 3, 60, "Pedro", "2018.2");
        disciplina2.insereNotas();
        final double d2 = disciplina2.calcularMedia();
        disciplina2.setMedia(d2);

        this.disciplinaDAO.inserir(disciplina1);
        this.disciplinaDAO.inserir(disciplina2);
    }

    @Test(dependsOnMethods = "inserirDisciplina")
    public void inserirIntermediaria() {

        final AlunoDisciplina aluno1d1 = new AlunoDisciplina(1, 1);
        final AlunoDisciplina aluno1d2 = new AlunoDisciplina(1, 2);
        final AlunoDisciplina aluno2d1 = new AlunoDisciplina(2, 1);

        this.adDAO.inserir(aluno1d1);
        this.adDAO.inserir(aluno1d2);
        this.adDAO.inserir(aluno2d1);
    }

    @Test(dependsOnMethods = "inserirIntermediaria")
    public void listartodos() {

        System.out.println("\nBUSCA TODOS");
        System.out.println("ALUNO 1");
        this.alunoDAO.buscarPor(1, true);
        this.disciplinaDAO.buscarPor(1, true);
        this.disciplinaDAO.buscarPor(2, true);

        System.out.println("Aluno 2");
        this.alunoDAO.buscarPor(2, true);
        this.disciplinaDAO.buscarPor(1, true);
    }
}
