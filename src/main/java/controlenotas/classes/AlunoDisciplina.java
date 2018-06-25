package controlenotas.classes;

import controlenotas.annotations.Fk;
import controlenotas.annotations.Id;

public class AlunoDisciplina extends ObjetoBase<AlunoDisciplina, Integer> {

    @Id
    private int cod;

    @Fk
    private int codAluno;

    @Fk
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
