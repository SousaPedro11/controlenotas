package controlenotas.classes;

public class Disciplina {

    private int cod;

    private String nome;

    private Turma turma;

    private Professor professor;

    private int semestre;

    private int cargahoraria;

    public int getCod() {

        return this.cod;
    }

    public void setCod(final int cod) {

        this.cod = cod;
    }

    public String getNome() {

        return this.nome;
    }

    public void setNome(final String nome) {

        this.nome = nome;
    }

    public Turma getTurma() {

        return this.turma;
    }

    public void setTurma(final Turma turma) {

        this.turma = turma;
    }

    public Professor getProfessor() {

        return this.professor;
    }

    public void setProfessor(final Professor professor) {

        this.professor = professor;
    }

    public int getSemestre() {

        return this.semestre;
    }

    public void setSemestre(final int semestre) {

        this.semestre = semestre;
    }

    public int getCargahoraria() {

        return this.cargahoraria;
    }

    public void setCargahoraria(final int cargahoraria) {

        this.cargahoraria = cargahoraria;
    }

    public void criaDisciplina() {

    }
}
