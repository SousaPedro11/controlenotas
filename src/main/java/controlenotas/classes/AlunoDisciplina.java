package controlenotas.classes;

import controlenotas.annotations.AtribuirToString;
import controlenotas.annotations.Coluna;
import controlenotas.annotations.Fk;
import controlenotas.annotations.Id;

public class AlunoDisciplina extends ObjetoBase<AlunoDisciplina, Integer> {

    @Id
    @Coluna(nome = "COD", tipo = "SMALLINT", auto = true)
    @AtribuirToString(prefixo = "Cod: ", sufixo = "\n")
    private int cod;

    @Fk(referencia = "ALUNO")
    @Coluna(nome = "COD_ALUNO", tipo = "SMALLINT")
    @AtribuirToString(prefixo = "COD_ALUNO: ", sufixo = "\n")
    private int codAluno;

    @Fk(referencia = "DISCIPLINA")
    @Coluna(nome = "COD_DISCIPLINA", tipo = "SMALLINT")
    @AtribuirToString(prefixo = "COD_DISCIPLINA: ", sufixo = "\n")
    private int codDisciplina;

    public AlunoDisciplina() {

    }

    /**
     * @param codAluno
     * @param codDisciplina
     */
    public AlunoDisciplina(final int codAluno, final int codDisciplina) {

        this.codAluno = codAluno;
        this.codDisciplina = codDisciplina;
    }

    public int getCod() {

        return this.cod;
    }

    public void setCod(final int cod) {

        this.cod = cod;
    }

    public int getCodAluno() {

        return this.codAluno;
    }

    public void setCodAluno(final int codAluno) {

        this.codAluno = codAluno;
    }

    public int getCodDisciplina() {

        return this.codDisciplina;
    }

    public void setCodDisciplina(final int codDisciplina) {

        this.codDisciplina = codDisciplina;
    }

}
