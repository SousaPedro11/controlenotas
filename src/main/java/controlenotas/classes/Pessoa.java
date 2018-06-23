package controlenotas.classes;

import controlenotas.annotations.AtribuirToString;
import controlenotas.annotations.Coluna;
import controlenotas.annotations.Id;

public abstract class Pessoa extends ObjetoBase<Pessoa, Integer> {

    @Id
    @Coluna(nome = "COD", tipo = "SMALLINT", auto = true)
    @AtribuirToString(prefixo = "Cod: ", sufixo = "\n")
    private final int cod;

    @Coluna(nome = "NOME", tamanho = 80)
    @AtribuirToString(prefixo = "Nome: ", sufixo = "\n")
    private final String nome;

    public Pessoa(final int cod, final String nome) {
        this.cod = cod;
        this.nome = nome;
    }

    public int getCod() {

        return this.cod;
    }

    public String getNome() {

        return this.nome;
    }

}
