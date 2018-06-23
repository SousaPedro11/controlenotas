package controlenotas.classes;

import java.util.ArrayList;
import java.util.List;

import controlenotas.annotations.AtribuirToString;
import controlenotas.annotations.Coluna;
import controlenotas.annotations.Tabela;

@Tabela(schema = "controlenotas", nome = "aluno")
public class Aluno extends Pessoa {

    @AtribuirToString(prefixo = "Matricula: ", sufixo = "\n")
    @Coluna(nome = "MATRICULA", tipo = "INT")
    private int matricula;

    @AtribuirToString(prefixo = "Curso: ", sufixo = "\n")
    @Coluna(nome = "CURSO", tamanho = 80)
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

}
