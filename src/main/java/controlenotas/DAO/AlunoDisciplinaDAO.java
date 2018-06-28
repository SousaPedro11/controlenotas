package controlenotas.DAO;

import controlenotas.classes.AlunoDisciplina;

public class AlunoDisciplinaDAO extends BaseDAO<AlunoDisciplina, Integer> {

    // @Override
    // public List<AlunoDisciplina> buscarTodos() {
    //
    // final List<AlunoDisciplina> lista = new ArrayList<>();
    // final StringBuilder sql = new StringBuilder();
    // sql.append("select * from controlenotas.aluno ");
    // sql.append("inner join controlenotas.aluno_disciplina ");
    // sql.append("on aluno.cod = aluno_disciplina.cod_aluno ");
    // sql.append("inner join controlenotas.disciplina on disciplina.cod = aluno_disciplina.cod_disciplina;");
    //
    // try (Statement stmt = this.getConexao().createStatement();
    // ResultSet rs = stmt.executeQuery(sql.toString())) {
    //
    // while (rs.next()) {
    // lista.add(this.converter(rs));
    // }
    //
    // lista.forEach(System.out::println);
    //
    // } catch (final SQLException | InstantiationException | IllegalAccessException e) {
    // e.printStackTrace();
    // }
    // return lista;
    // }
}
