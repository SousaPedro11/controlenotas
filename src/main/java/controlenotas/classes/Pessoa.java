package controlenotas.classes;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public abstract class Pessoa {

    private final int cod;

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

    @Override
    public String toString() {

        return ReflectionToStringBuilder.toString(this);
    }

}
