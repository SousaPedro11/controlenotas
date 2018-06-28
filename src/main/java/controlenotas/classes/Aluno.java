package controlenotas.classes;

import controlenotas.annotations.AtribuirToString;
import controlenotas.annotations.Coluna;
import controlenotas.annotations.Id;
import controlenotas.annotations.Tabela;

@Tabela(schema = "controlenotas", nome = "aluno")
public class Aluno extends Pessoa {

    @Id
    @Coluna(nome = "COD", tipo = "SMALLINT", auto = true)
    @AtribuirToString(prefixo = "COD: ", sufixo = "\n")
    private int cod;

    @Coluna(nome = "NOME", tamanho = 80)
    @AtribuirToString(prefixo = "NOME: ", sufixo = "\n")
    private String nome;

    @AtribuirToString(prefixo = "MATRICULA: ", sufixo = "\n")
    @Coluna(nome = "MATRICULA", tamanho = 20)
    private String matricula;

    @AtribuirToString(prefixo = "CURSO: ", sufixo = "\n")
    @Coluna(nome = "CURSO", tamanho = 80)
    private String curso;

    // @AtribuirToString(prefixo = "CRG: ", sufixo = "\n")
    // private double CRG;

    // private List<Disciplina> disciplina;

    public Aluno(final String nome, final String matricula, final String curso) {
        super(nome);
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

    public Aluno(final String nome) {
        super(nome);
    }

    public Aluno() {

    }

    public void setCod(final int cod) {

        this.cod = cod;
    }

    public int getCod() {

        return this.cod;
    }

    @Override
    public String getNome() {

        return this.nome;
    }

    @Override
    public void setNome(final String nome) {

        this.nome = nome;
    }

    public String getMatricula() {

        return this.matricula;
    }

    public void setMatricula(final String matricula) {

        this.matricula = matricula;
    }

    public String getCurso() {

        return this.curso;
    }

    public void setCurso(final String curso) {

        this.curso = curso;
    }

}
