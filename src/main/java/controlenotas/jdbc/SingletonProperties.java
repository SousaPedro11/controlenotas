package controlenotas.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SingletonProperties {

    private static SingletonProperties instancia = null;

    private Properties properties;

    public SingletonProperties load(final String nomeArquivo) {

        this.properties = new Properties();

        try (InputStream inputStream = ClassLoader.getSystemResourceAsStream(nomeArquivo)) {
            this.properties.load(inputStream);
        } catch (final IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
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