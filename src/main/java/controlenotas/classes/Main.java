package controlenotas.classes;

public class Main {

    public static void main(final String[] args) {

        // Cadastrar Aluno

        final Aluno aluno1 = new Aluno("Pedro", "201711140038", "CBSI");

        final Aluno aluno2 = new Aluno();
        aluno2.setNome("Angela Rodrigues");
        aluno2.setCurso("CBSI");
        aluno2.setMatricula("201711140037");

        System.out.println(aluno1);
        System.out.println(aluno2);
        // Cadastrar Disciplina

        final Disciplina disciplina1 = new Disciplina();
        disciplina1.setDisciplina("OO");
        disciplina1.setCargahoraria(60);
        disciplina1.setSemestre(3);
        disciplina1.setTurma("2018.2");
        disciplina1.setProfessor("Gustavo");

        final Disciplina disciplina2 = new Disciplina("ED", 3, 60, "Pedro", "2018.2");

        System.out.println(disciplina1);
        System.out.println(disciplina2);
        // Cadastrar notas

        // Calcular CRG

        // Retornar Resultados
        // Mostrar Aluno
        // Mostrar Disciplinas + média
    }

}
