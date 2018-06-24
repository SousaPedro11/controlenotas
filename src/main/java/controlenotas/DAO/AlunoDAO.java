package controlenotas.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import controlenotas.classes.Aluno;

public class AlunoDAO extends BaseDAO<Aluno, Integer> {

    @Override
    public Aluno converter(final ResultSet rs) throws SQLException {

        final Aluno aluno = new Aluno();
        aluno.setCod(rs.getInt("cod"));
        aluno.setNome(rs.getString("nome"));
        aluno.setCurso(rs.getString("curso"));
        aluno.setMatricula(rs.getString("matricula"));
        return aluno;
    }
}
