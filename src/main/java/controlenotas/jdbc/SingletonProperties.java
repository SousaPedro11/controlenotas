package controlenotas.jdbc;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SingletonProperties {

    private static SingletonProperties instancia = null;

    private Properties properties;

    public SingletonProperties load(final String nomeArquivo) {

        this.properties = new Properties();

        try {
            this.properties.load(new FileReader(nomeArquivo));
        } catch (final IOException e) {
            System.out.println(e.getMessage());
        }

        return this;
    }

    public static SingletonProperties getInstancia(final String nomeArquivo) {

        return SingletonProperties.getInstancia().load(nomeArquivo);
    }

    public static SingletonProperties getInstancia() {

        if (SingletonProperties.instancia == null) {

            SingletonProperties.instancia = new SingletonProperties();
        }

        return SingletonProperties.instancia;
    }

    public String getPropriedade(final String chave) {

        return this.properties.getProperty(chave);
    }
}