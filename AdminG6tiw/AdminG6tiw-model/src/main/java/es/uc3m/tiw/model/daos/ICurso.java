package es.uc3m.tiw.model.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import es.uc3m.tiw.model.Usuario;
import es.uc3m.tiw.model.Curso;

public interface ICurso {

	public abstract Curso createCurso(Curso cursoNuevo)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException, NotSupportedException, SystemException, IllegalStateException, SecurityException, HeuristicMixedException, HeuristicRollbackException, RollbackException;

	public abstract List<Curso> findAll() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, SQLException;
	
	public abstract List<Curso> BuscarCursoUsuario (int id);

	public abstract Curso findById(int id) throws SQLException;

	public abstract void removeCurso(Curso curso)
			throws NotSupportedException, SystemException,
			IllegalStateException, SecurityException, HeuristicMixedException,
			HeuristicRollbackException, RollbackException;

}