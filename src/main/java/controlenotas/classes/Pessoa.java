package controlenotas.classes;

import controlenotas.annotations.AtribuirToString;

public abstract class Pessoa extends ObjetoBase<Pessoa, Integer> {

    // @Coluna(nome = "NOME", tamanho = 80)
    @AtribuirToString(prefixo = "Nome: ", sufixo = "\n")
    protected String nome;

    public Pessoa(final String nome) {

        this.nome = nome;
    }

    public Pessoa() {

    }

    public void setNome(final String nome) {

        this.nome = nome;
    }

    public String getNome() {

        return this.nome;
    }

}
