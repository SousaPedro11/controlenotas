package controlenotas.DAO;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.reflect.FieldUtils;

import controlenotas.annotations.Coluna;
import controlenotas.annotations.DataType;
import controlenotas.annotations.EnumType;
import controlenotas.annotations.Fk;
import controlenotas.annotations.IEntidade;
import controlenotas.annotations.Id;
import controlenotas.annotations.Tabela;
import controlenotas.jdbc.SingletonConexao;
import controlenotas.jdbc.SingletonProperties;
import controlenotas.jdbc.TipoConexao;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public abstract class BaseDAO<T extends IEntidade<K>, K extends Serializable> {

    /**
     * Método utilizado para criar uma conexão com o banco
     *
     * @author Pedro
     * @see java.sql.Connection
     * @return Connection
     */
    public Connection getConexao() {

        Connection conexao = null;

        if (conexao == null) {

            try {
                final SingletonProperties properties = SingletonProperties.getInstancia("configuracao.properties");
                final TipoConexao tipo = TipoConexao.valueOf(properties.getPropriedade("jdbc.tipo"));
                final String url = properties.getPropriedade("jdbc.url");
                final String usuario = properties.getPropriedade("jdbc.usuario");
                final String senha = properties.getPropriedade("jdbc.senha");

                conexao = SingletonConexao.conectar(tipo, url, usuario, senha);

            } catch (ClassNotFoundException | SQLException e) {

                e.printStackTrace();
                System.exit(1);
            }
        }

        return conexao;
    }

    // Métodos generalizados
    protected String getNomeTabela() {

        final StringBuilder nomeT = new StringBuilder();
        final Tabela tabela = this.getClasseEntidade().getAnnotation(Tabela.class);
        nomeT.append(tabela.schema());
        nomeT.append(".");
        nomeT.append(tabela.nome());

        return nomeT.toString();

    }

    /**
     * Cria tabelas no banco de dados a partir dos objetos utilizando Reflexão
     *
     * @author Pedro
     */
    public void criarDDL() {

        final StringBuilder ctH2 = new StringBuilder();
        final Tabela tabela = this.getClasseEntidade().getAnnotation(Tabela.class);

        ctH2.append("CREATE SCHEMA IF NOT EXISTS ");
        ctH2.append(tabela.schema().toUpperCase()).append(";\n");

        ctH2.append("CREATE TABLE IF NOT EXISTS ");
        ctH2.append(tabela.schema()).append(".");
        ctH2.append(tabela.nome().toUpperCase());
        ctH2.append(" (");
        final String colunas = FieldUtils.getFieldsListWithAnnotation(this.getClasseEntidade(), Coluna.class)
                        .stream()
                        .map(f -> {

                            final StringBuilder sb = new StringBuilder();
                            final Id id = f.getAnnotation(Id.class);

                            final Coluna coluna = f.getAnnotation(Coluna.class);
                            sb.append("\t").append(coluna.nome() + " ")
                                            .append(coluna.tipo());

                            if (String.class.isAssignableFrom(f.getType()) || f.getType().isEnum()) {
                                sb.append("(" + coluna.tamanho() + ") ");
                            }

                            sb.append(id != null ? " PRIMARY KEY " : " ");
                            sb.append(coluna.auto() ? " AUTO_INCREMENT " : " ")
                                            .append(coluna.nulo() ? " " : "NOT NULL ");
                            return sb.toString();
                        }).collect(Collectors.joining(",\n")).replaceAll("\\s+", " ");
        ctH2.append(colunas).append("\n);");

        final String fks = FieldUtils.getFieldsListWithAnnotation(this.getClasseEntidade(), Fk.class)
                        .stream()
                        .map(f -> {
                            final StringBuilder fow = new StringBuilder();
                            final Fk fk = f.getAnnotation(Fk.class);
                            if (fk != null) {
                                fow.append("FOREIGN KEY ");
                                fow.append("(");
                                fow.append(f.getName());
                                fow.append(")");
                                fow.append("REFERENCES");
                            }
                            return fow.toString();
                        }).collect(Collectors.joining(",\n")).replaceAll("\\s+", " ");
        try (Statement statement = this.getConexao().createStatement()) {

            statement.execute(ctH2.toString());

        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Exclui um registro do banco a partir da chave primária
     *
     * @author Pedro
     *
     * @param chavePrimaria
     */
    public final void excluir(final Integer chavePrimaria) {

        final StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ").append(this.getNomeTabela());
        sb.append(" WHERE cod = ?");

        try (PreparedStatement ps = this.getConexao().prepareStatement(sb.toString())) {

            ps.setInt(1, chavePrimaria);
            ps.executeUpdate();

        } catch (final Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Lista todos os registros do banco de dados
     *
     * @author Pedro
     *
     * @return Lista de objetos, {@code List<object>}
     */
    public final List<T> buscarTodos() {

        final List<T> lista = new ArrayList<>();

        try (Statement stmt = this.getConexao().createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM " + this.getNomeTabela())) {

            while (rs.next()) {
                lista.add(this.converter(rs));
            }
            for (final T t : lista) {
                System.out.println(t);
            }
        } catch (final SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return lista;
    }

    /**
     * Busca registro do banco de dados a partir da chave primaria
     *
     * @author Pedro
     * @param chavePrimaria
     * @return Objeto contendo um registro, {@code Optional<T>}
     */
    public final Optional<T> buscarPor(final K chavePrimaria) {

        Optional<T> t = Optional.empty();
        final StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ").append(this.getNomeTabela());
        sb.append(" WHERE cod = ?");

        try (PreparedStatement stmt = this.getConexao().prepareStatement(sb.toString())) {

            stmt.setObject(1, chavePrimaria);
            final ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                t = Optional.ofNullable(this.converter(rs));
            }

            System.out.println(t.get());

        } catch (final Exception e) {
            System.out.println(e.getMessage());
        }

        return t;
    }

    /**
     * Insere um registro no banco de dados com as colunas obtidas a partir de seus atributos utilizando reflexão
     *
     * @author Pedro
     *
     * @param objeto
     */
    public final void inserir(final T objeto) {

        final Map<String, Object> mapa = new LinkedHashMap<>(Stream.of(objeto.getClass().getDeclaredFields())
                        .filter(f -> !f.isAnnotationPresent(Id.class) && f.isAnnotationPresent(Coluna.class))
                        .collect(Collectors.toMap(f -> f.getAnnotation(Coluna.class).nome(),
                                        f -> {
                                            Object valor = null;
                                            try {
                                                valor = FieldUtils.readDeclaredField(objeto, f.getName(), true);
                                            } catch (final IllegalAccessException e) {
                                                e.printStackTrace();
                                            }
                                            return valor;
                                        })));

        final StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ");
        sb.append(this.getNomeTabela());
        sb.append(" (");
        sb.append(mapa.keySet()
                        .stream()
                        .collect(Collectors.joining(", ")));
        sb.append(")");
        sb.append(" VALUES (");
        sb.append(mapa.keySet()
                        .stream()
                        .map(x -> "?")
                        .collect(Collectors.joining(", ")));
        sb.append(")");

        try {
            this.cadastrarInterno(sb.toString(), mapa);
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public final void alterar(final T objeto, final K chavePrimaria) throws Exception {

        final Map<String, Object> mapa = new LinkedHashMap<>(Stream.of(objeto.getClass().getDeclaredFields())
                        .filter(f -> !f.isAnnotationPresent(Id.class))
                        .collect(Collectors.toMap(f -> f.getAnnotation(Coluna.class).nome(),
                                        f -> {
                                            Object valor = null;
                                            try {
                                                valor = FieldUtils.readDeclaredField(objeto, f.getName(), true);
                                            } catch (final IllegalAccessException e) {
                                                e.printStackTrace();
                                            }
                                            return valor;
                                        })));

        final StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append(this.getNomeTabela());
        sb.append(" SET ");
        sb.append(mapa.keySet()
                        .stream()
                        .map(x -> x + " = ?")
                        .collect(Collectors.joining(", ")));
        sb.append("WHERE COD = ?");

        try {
            this.cadastrarInterno(sb.toString(), mapa, chavePrimaria);
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método a ser utilizado para identificar se é uma inserção ou alteração no banco
     *
     * @author Pedro
     *
     * @param objeto
     * @throws Exception
     */
    public void cadastrar(final T objeto) throws Exception {

        if (objeto.getChavePrimaria() != null) {
            this.alterar(objeto, objeto.getChavePrimaria());
        } else {
            this.inserir(objeto);
        }
    }

    private void cadastrarInterno(final String sql, final Map<String, Object> mapa) throws Exception {

        this.cadastrarInterno(sql, mapa, null);
    }

    /**
     * Método utilizado para definir o Statement utilizado para alterações no banco
     *
     * @author Pedro
     * @param sql
     * @param mapa
     * @param chavePrimaria
     * @throws Exception
     */
    private void cadastrarInterno(final String sql, final Map<String, Object> mapa, final K chavePrimaria) throws Exception {

        try (PreparedStatement pstm = this.getConexao().prepareStatement(sql)) {

            int contador = 1;

            for (final Object valor : mapa.values()) {

                if (valor instanceof java.sql.Date) {

                    final java.sql.Date data = (valor == null) ? null
                                    : new java.sql.Date((long) valor);
                    // : new java.sql.Date(((Date) valor).getTime());
                    pstm.setDate(contador++, data);

                } else if (valor instanceof Enum) {

                    pstm.setObject(contador++, ((Enum<?>) valor).name());

                } else {
                    pstm.setObject(contador++, valor);
                }
            }

            if (chavePrimaria != null) {

                pstm.setObject(contador++, chavePrimaria);
            }

            pstm.executeUpdate();

        } catch (final Exception e) {
            throw e;
        }
    }

    /**
     * Método utilizado para identificar a classe do objeto por reflexao
     *
     * @author Pedro
     * @return {@code Class<T>}
     */
    @SuppressWarnings("unchecked")
    protected Class<T> getClasseEntidade() {

        final int posicaoGenerics = 0;

        return (Class<T>) ((ParameterizedType) this.getClass()
                        .getGenericSuperclass()).getActualTypeArguments()[posicaoGenerics];
    }

    /**
     * Método utilizado para obter classes com chave primária (ID)
     *
     * @author Pedro
     * @return {@code Class<T>}
     */
    @SuppressWarnings("unchecked")
    protected Class<K> getClasseChavePrimaria() {

        final int posicaoGenerics = 1;

        return (Class<K>) ((ParameterizedType) this.getClass()
                        .getGenericSuperclass()).getActualTypeArguments()[posicaoGenerics];
    }

    /**
     * Método utilizado para converter Resultset para objeto
     *
     * @param rs
     * @return {@code <T> Objeto}
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public final T converter(final ResultSet rs) throws SQLException, InstantiationException, IllegalAccessException {

        final T objeto = this.getClasseEntidade().newInstance();

        Stream.of(objeto.getClass().getDeclaredFields())
                        .filter(f -> f.isAnnotationPresent(Coluna.class))
                        .forEach(f -> {
                            try {
                                f.setAccessible(true);
                                if (f.isAnnotationPresent(DataType.class)) {
                                    final DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                    final String dataform = formatter.format(rs.getObject("nascimento"));

                                    Date localDate;
                                    try {
                                        localDate = formatter.parse(dataform);
                                        f.set(objeto, localDate);
                                    } catch (final ParseException e) {
                                        e.printStackTrace();
                                    }

                                } else if (f.isAnnotationPresent(EnumType.class)) {

                                    f.set(objeto, Enum.valueOf((Class<Enum>) f.getType(), rs.getString(f.getName())));

                                } else {
                                    f.set(objeto, rs.getObject(f.getName()));
                                }
                            } catch (IllegalArgumentException | IllegalAccessException | SQLException e) {
                                e.printStackTrace();
                            }
                        });

        return objeto;

    }
}