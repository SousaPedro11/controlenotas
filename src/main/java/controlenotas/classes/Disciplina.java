package controlenotas.classes;

import java.util.ArrayList;
import java.util.List;

import controlenotas.annotations.AtribuirToString;
import controlenotas.annotations.Coluna;
import controlenotas.annotations.Id;
import controlenotas.annotations.IgnorarHashcodeEquals;
import controlenotas.annotations.Tabela;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Tabela(schema = "controlenotas", nome = "disciplina")
public class Disciplina extends ObjetoBase<Disciplina, Integer> {

    @Id
    @Coluna(nome = "COD", tipo = "SMALLINT", auto = true)
    @AtribuirToString(prefixo = "COD: ", sufixo = "\n")
    private int cod;

    @Coluna(nome = "DISCIPLINA", tamanho = 80)
    @AtribuirToString(prefixo = "DISCIPLINA: ", sufixo = "\n")
    private String disciplina;

    @Coluna(nome = "SEMESTRE", tipo = "INT")
    @AtribuirToString(prefixo = "SEMESTRE: ", sufixo = "\n")
    private int semestre;

    @Coluna(nome = "CARGAHORARIA", tipo = "INT")
    @AtribuirToString(prefixo = "CARGAHORARIA: ", sufixo = "\n")
    private int cargahoraria;

    @Coluna(nome = "PROFESSOR", tamanho = 80)
    @AtribuirToString(prefixo = "PROFESSOR: ", sufixo = "\n")
    private String professor;

    @Coluna(nome = "TURMA", tamanho = 80)
    @AtribuirToString(prefixo = "TURMA: ", sufixo = "\n")
    private String turma;

    @IgnorarHashcodeEquals
    private int avaliacoes;

    @IgnorarHashcodeEquals
    Notas nota;

    List<Double> notas = new ArrayList<>();

    public Disciplina() {
    }

    /**
     * @param cod
     * @param disciplina
     * @param semestre
     * @param cargahoraria
     * @param professor
     * @param turma
     */
    public Disciplina(final String disciplina,
                    final int semestre,
                    final int cargahoraria,
                    final String professor,
                    final String turma) {
        this.disciplina = disciplina;
        this.semestre = semestre;
        this.cargahoraria = cargahoraria;
        this.professor = professor;
        this.turma = turma;
    }

    public int getCod() {

        return this.cod;
    }

    public void setCod(final int cod) {

        this.cod = cod;
    }

    public String getDisciplina() {

        return this.disciplina;
    }

    public void setDisciplina(final String nome) {

        this.disciplina = nome;
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

    public int getAvaliacoes() {

        return this.avaliacoes;
    }

    public void setAvaliacoes(final int avaliacoes) {

        this.avaliacoes = avaliacoes;
    }

}
