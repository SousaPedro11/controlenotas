package controlenotas.classes;

import controlenotas.annotations.AtribuirToString;
import controlenotas.annotations.Coluna;
import controlenotas.annotations.Id;
import controlenotas.annotations.Tabela;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Tabela(schema = "controlenotas", nome = "disciplina")
public class Disciplina extends ObjetoBase<Disciplina, Integer> {

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

    @Coluna(nome = "CARGAHORARIA", tipo = "INT")
    @AtribuirToString(prefixo = "CH: ", sufixo = "\n")
    private int cargahoraria;

    @Coluna(nome = "PROFESSOR", tamanho = 80)
    @AtribuirToString(prefixo = "Professor: ", sufixo = "\n")
    private String professor;

    @Coluna(nome = "TURMA", tamanho = 80)
    @AtribuirToString(prefixo = "Turma: ", sufixo = "\n")
    private String turma;

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

    public String getProfessor() {

        return this.professor;
    }

    public String getTurma() {

        return this.turma;
    }

    public void setProfessor(final String professor) {

        this.professor = professor;
    }

    public void setTurma(final String turma) {

        this.turma = turma;
    }

}
