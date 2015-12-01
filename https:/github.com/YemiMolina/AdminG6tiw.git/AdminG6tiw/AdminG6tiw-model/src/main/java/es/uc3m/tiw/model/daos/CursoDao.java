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
import es.uc3m.tiw.model.Curso;

public class CursoDao  implements ICurso{

	private EntityManager em;
	private UserTransaction ut;
	
	



	public CursoDao(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}


	/* (non-Javadoc)
	 * @see es.uc3m.tiw.model.daos.IPersona#createUsuario(es.uc3m.tiw.model.Usuario)
	 */
	@Override
	public Curso createCurso(Curso cursoNuevo) throws NotSupportedException, SystemException, IllegalStateException, SecurityException, HeuristicMixedException, HeuristicRollbackException, RollbackException {

		ut.begin();
		em.persist(cursoNuevo);
		ut.commit();
		return cursoNuevo;
		
	}

	/* (non-Javadoc)
	 * @see es.uc3m.tiw.model.daos.IPersona#findAll()
	 */
	@Override
	public List<Curso> findAll() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
			
	
		
		//List<Usuario> listaUsuarios = em.createQuery("SELECT u from Usuario u",Usuario.class).getResultList();
		List<Curso> listaCursos = em.createQuery("SELECT u from Curso u",Curso.class).getResultList();
		
		return listaCursos;
	}
	
	@Override
	public Curso findById(int id) {
	return 	em.find(Curso.class, new Long(id));

	
	}
	@Override
	public void removeCurso(Curso curso) throws NotSupportedException, SystemException, IllegalStateException, SecurityException, HeuristicMixedException, HeuristicRollbackException, RollbackException{
		ut.begin();
		em.remove(em.merge(curso));
		
		ut.commit();
	}


	public Curso findByIdAndName(int id, String titulo) {
			
		Query query =  em.createQuery("SELECT u FROM Curso u where u.idcursos=:idcursos and u.titulo=:titulo", Curso.class);
		query.setParameter("idcursos", id);
		query.setParameter("titulo", titulo);
		return (Curso) query.getSingleResult();
		
		
	}
	
	
	
}
