package controlenotas.classes;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Aluno extends Pessoa {

    private int matricula;

    private String curso;

    List<Disciplina> disc = new ArrayList<>();

    public Aluno(final int cod, final String nome) {
        super(cod, nome);
    }

    public Aluno(final int cod, final String nome, final int matricula, final String curso) {
        super(cod, nome);
        this.matricula = matricula;
        this.curso = curso;
    }

    public int getMatricula() {

        return this.matricula;
    }

    public void setMatricula(final int matricula) {

        this.matricula = matricula;
    }

    public String getCurso() {

        return this.curso;
    }

    public void setCurso(final String curso) {

        this.curso = curso;
    }

    @Override
    public String toString() {

        return ReflectionToStringBuilder.toString(this);
    }
}
