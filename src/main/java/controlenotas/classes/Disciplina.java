package controlenotas.classes;

import controlenotas.annotations.AtribuirToString;
import controlenotas.annotations.Coluna;
import controlenotas.annotations.Id;

public class Disciplina {

    @Id
    @Coluna(nome = "COD", tipo = "SMALLINT", auto = true)
    @AtribuirToString(prefixo = "Cod: ", sufixo = "\n")
    private int cod;

    @Coluna(nome = "NOME", tamanho = 80)
    @AtribuirToString(prefixo = "Nome: ", sufixo = "\n")
    private String nome;

    @Coluna(nome = "SEMESTRE", tipo = "INT")
    @AtribuirToString(prefixo = "Semestre: ", sufixo = "\n")
    private int semestre;

    @Coluna(nome = "CH", tipo = "INT")
    @AtribuirToString(prefixo = "CH: ", sufixo = "\n")
    private int cargahoraria;

    private Turma turma;

    private Professor professor;

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
