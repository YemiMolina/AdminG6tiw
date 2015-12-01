package es.uc3m.tiw.model.daos;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.Usuario;

public class PersonaDao  implements IPersona {

	private EntityManager em;
	private UserTransaction ut;
	
	



	public PersonaDao(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}


	/* (non-Javadoc)
	 * @see es.uc3m.tiw.model.daos.IPersona#createUsuario(es.uc3m.tiw.model.Usuario)
	 */
	@Override
	public Usuario createUsuario(Usuario usuarioNuevo) throws NotSupportedException, SystemException, IllegalStateException, SecurityException, HeuristicMixedException, HeuristicRollbackException, RollbackException {

		ut.begin();
		em.persist(usuarioNuevo);
		ut.commit();
		return usuarioNuevo;
		
	}

	/* (non-Javadoc)
	 * @see es.uc3m.tiw.model.daos.IPersona#findAll()
	 */
	@Override
	public List<Usuario> findAll() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
			
	
		
		List<Usuario> listaUsuarios = em.createQuery("SELECT u from Usuario u",Usuario.class).getResultList();
		
		
		return listaUsuarios;
	}
	
	@Override
	public Usuario findById(int id) {
	return 	em.find(Usuario.class, new Long(id));

	
	}
	@Override
	public void removeUsuario(Usuario usuario) throws NotSupportedException, SystemException, IllegalStateException, SecurityException, HeuristicMixedException, HeuristicRollbackException, RollbackException{
		ut.begin();
		em.remove(em.merge(usuario));
		
		ut.commit();
	}


	public Usuario findByNickAndPassword(String user, String password) {
			
		Query query =  em.createQuery("SELECT u FROM Usuario u where u.nick=:nick and u.password=:password", Usuario.class);
		query.setParameter("nick", user);
		query.setParameter("password", password);
		return (Usuario) query.getSingleResult();
		
		
	}
	
	
	
}
