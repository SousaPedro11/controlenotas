package controlenotas.classes;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import lombok.Getter;
import lombok.Setter;

public class Aluno extends Pessoa {

    @Getter
    @Setter
    private static int matricula;

    @Getter
    @Setter
    private static String curso;

    private Disciplina disciplina;

    public Aluno(final int cod, final String nome) {
        super(cod, nome);
    }

    public Aluno(final int cod, final String nome, final int matricula, final String curso) {
        super(cod, nome);
        Aluno.matricula = matricula;
        Aluno.curso = curso;
    }

    @Override
    public String toString() {

        return ReflectionToStringBuilder.toString(this);
    }
}
