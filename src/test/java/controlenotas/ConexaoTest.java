package controlenotas;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import controlenotas.jdbc.SingletonConexao;
import controlenotas.jdbc.SingletonProperties;
import controlenotas.jdbc.TipoConexao;

public class ConexaoTest {

    private Connection conexao;

    @Test
    public void abrirTest() throws SQLException {

        try {
            final SingletonProperties properties = SingletonProperties.getInstancia("configuracao.properties");
            final TipoConexao tipo = TipoConexao.valueOf(properties.getPropriedade("jdbc.tipo"));
            final String url = properties.getPropriedade("jdbc.url");
            final String usuario = properties.getPropriedade("jdbc.usuario");
            final String senha = properties.getPropriedade("jdbc.senha");

            this.conexao = SingletonConexao.conectar(tipo, url, usuario, senha);

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
            System.exit(1);
        }

        Assert.assertEquals(false, this.conexao.isClosed());
    }

}
