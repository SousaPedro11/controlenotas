package controlenotas.classes;

import controlenotas.DAO.AlunoDAO;
import controlenotas.DAO.AlunoDisciplinaDAO;
import controlenotas.DAO.BaseDAO;
import controlenotas.DAO.DisciplinaDAO;

public class Main {

    public static void main(final String[] args) {

        final BaseDAO<AlunoDisciplina, Integer> adDAO = new AlunoDisciplinaDAO();

        final BaseDAO<Disciplina, Integer> disciplinaDAO = new DisciplinaDAO();

        final BaseDAO<Aluno, Integer> alunoDAO = new AlunoDAO();

        // criar tabelas
        alunoDAO.criarDDL();
        disciplinaDAO.criarDDL();
        adDAO.criarDDL();

        // Cadastrar Aluno

        final Aluno aluno1 = new Aluno("Pedro", "201711140038", "CBSI");

        final Aluno aluno2 = new Aluno();
        aluno2.setNome("Angela Rodrigues");
        aluno2.setCurso("CBSI");
        aluno2.setMatricula("201711140037");

        // Cadastrar Disciplina

        final Disciplina disciplina1 = new Disciplina();
        disciplina1.setDisciplina("OO");
        disciplina1.setCargahoraria(60);
        disciplina1.setSemestre(3);
        disciplina1.setTurma("2018.2");
        disciplina1.setProfessor("Gustavo");

        final Disciplina disciplina2 = new Disciplina("ED", 3, 60, "Pedro", "2018.2");

        // Cadastrar notas
        disciplina1.insereNotas();
        disciplina2.insereNotas();

        // Calcular Média
        final double d1 = disciplina1.calcularMedia();
        disciplina1.setMedia(d1);
        final double d2 = disciplina2.calcularMedia();
        disciplina2.setMedia(d2);

        // associar na tabela intermediaria
        final AlunoDisciplina aluno1d1 = new AlunoDisciplina(1, 1);
        final AlunoDisciplina aluno1d2 = new AlunoDisciplina(1, 2);
        final AlunoDisciplina aluno2d1 = new AlunoDisciplina(2, 1);

        // insere nas tabelas
        alunoDAO.inserir(aluno1);
        alunoDAO.inserir(aluno2);
        disciplinaDAO.inserir(disciplina1);
        disciplinaDAO.inserir(disciplina2);
        adDAO.inserir(aluno1d1);
        adDAO.inserir(aluno1d2);
        adDAO.inserir(aluno2d1);

        // Retornar Resultados
        System.out.println("\nBUSCA TODOS");
        System.out.println("ALUNO 1");
        alunoDAO.buscarPor(1, true);
        disciplinaDAO.buscarPor(1, true);
        disciplinaDAO.buscarPor(2, true);

        System.out.println("Aluno 2");
        alunoDAO.buscarPor(2, true);
        disciplinaDAO.buscarPor(1, true);
    }

}
