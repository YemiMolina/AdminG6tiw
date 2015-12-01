package es.uc3m.tiw.model.daos;

import java.sql.SQLException;
import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import es.uc3m.tiw.model.Usuario;

public interface IUsuario {
	public abstract Usuario createUsuario(Usuario usuarioNuevo)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException, NotSupportedException, SystemException, IllegalStateException, SecurityException, HeuristicMixedException, HeuristicRollbackException, RollbackException;
	
	public abstract Usuario update(Usuario usuario);
	
	public abstract List<Usuario> findAll() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, SQLException;

	public abstract Usuario findById(int id) throws SQLException;

	public abstract void removeUsuario(Usuario usuario)
			throws NotSupportedException, SystemException,
			IllegalStateException, SecurityException, HeuristicMixedException,
			HeuristicRollbackException, RollbackException;

}
