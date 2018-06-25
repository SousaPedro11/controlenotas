package controlenotas.classes;

import controlenotas.annotations.AtribuirToString;

public class Turma extends ObjetoBase<Turma, Integer> {

    @AtribuirToString(prefixo = "", sufixo = "")
    private String turma;

    public Turma() {

    }

    public Turma(final String string) {
        this.turma = string;
    }

    public String getTurma() {

        return this.turma;
    }

    public void setTurma(final String turma) {

        this.turma = turma;
    }

}
