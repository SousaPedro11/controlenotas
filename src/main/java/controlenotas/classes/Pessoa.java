package controlenotas.classes;

public abstract class Pessoa extends ObjetoBase<Pessoa, Integer> {

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
