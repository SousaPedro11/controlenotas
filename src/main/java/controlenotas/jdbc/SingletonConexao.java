package controlenotas.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class SingletonConexao {

    private static SingletonConexao instancia;

    private static final Map<String, Connection> mapa = new HashMap<>();

    private SingletonConexao() {
        // Singleton
    }

    public static SingletonConexao getInstancia() {

        if (SingletonConexao.instancia == null) {

            SingletonConexao.instancia = new SingletonConexao();
        }

        return SingletonConexao.instancia;
    }

    public static Connection conectar(final TipoConexao tipo, final String url, final String usuario, final String senha)
                    throws ClassNotFoundException, SQLException {

        ConexaoBase conexao = null;

        switch (tipo) {
            case POSTGRESQL:
                conexao = new ConexaoPostgreSQL();
                break;
            default:
                conexao = new ConexaoH2();
                break;
        }

        Connection con = null;
        final String chave = tipo.name() + url + usuario + senha;

        if (SingletonConexao.mapa.containsKey(chave)) {

            con = SingletonConexao.mapa.get(chave);

        } else {

            con = conexao.conectar(url, usuario, senha);
            SingletonConexao.mapa.put(chave, con);
        }

        return con;
    }

    public static void fechar(final Connection conexao) {

        String chave = null;
        final Set<Entry<String, Connection>> entrySet = SingletonConexao.mapa.entrySet();

        for (final Entry<String, Connection> entrada : entrySet) {

            if (entrada.getValue().equals(conexao)) {

                try {
                    chave = entrada.getKey();
                    conexao.close();
                } catch (final SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        if (chave != null) {

            SingletonConexao.mapa.remove(chave);
        }
    }
}