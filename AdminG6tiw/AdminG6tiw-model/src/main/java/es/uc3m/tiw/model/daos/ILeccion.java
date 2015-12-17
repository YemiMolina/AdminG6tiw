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
import es.uc3m.tiw.model.Leccion;

public interface ILeccion {
	
	public abstract Leccion createLeccion(Leccion leccionNuevo)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException, NotSupportedException, SystemException, IllegalStateException, SecurityException, HeuristicMixedException, HeuristicRollbackException, RollbackException;

	public abstract List<Leccion> findAll() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, SQLException;

	public abstract Leccion findById(int id) throws SQLException;

	public abstract void removeLeccion(Leccion leccion)
			throws NotSupportedException, SystemException,
			IllegalStateException, SecurityException, HeuristicMixedException,
			HeuristicRollbackException, RollbackException;

	public abstract List<Leccion> BuscarLeccionCurso(int idCursoUrl1);

}
