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

import es.uc3m.tiw.model.Curso;
import es.uc3m.tiw.model.Leccion;
import es.uc3m.tiw.model.Usuario;

public class LeccionDao implements ILeccion{
	
	
	private EntityManager em;
	private UserTransaction ut;
	
	
	public LeccionDao(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}
	
	@Override
	public Leccion createLeccion(Leccion leccionNuevo) throws NotSupportedException, SystemException, IllegalStateException, SecurityException, HeuristicMixedException, HeuristicRollbackException, RollbackException {

		ut.begin();
		em.persist(leccionNuevo);
		ut.commit();
		return leccionNuevo;
		
	}
	/* (non-Javadoc)
	 * @see es.uc3m.tiw.model.daos.IPersona#findAll()
	 */
	@Override
	public List<Leccion> findAll() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{

		List<Leccion> listaLecciones = em.createQuery("SELECT u from Leccion u",Leccion.class).getResultList();
		
		return listaLecciones;
	}
	
	@Override
	public Leccion findById(int id) {
	return 	em.find(Leccion.class, new Integer(id));

	
	}
	
	public List<Leccion> BuscarLeccionCurso (int id){
	//	List<Leccion> listaLeccionesCurso = em.createQuery("SELECT l from Curso c, Leccion l WHERE c.idCursos= l.identificador", Leccion.class).getResultList();
		List<Leccion> listaLeccionesCurso = em.createQuery("SELECT l from Leccion l WHERE l.curso.idcursos = :idcursos",Leccion.class).setParameter("idcursos", id).getResultList();
		return listaLeccionesCurso;

	}
	
	@Override
	public void removeLeccion(Leccion leccion) throws NotSupportedException, SystemException, IllegalStateException, SecurityException, HeuristicMixedException, HeuristicRollbackException, RollbackException{
		ut.begin();
		em.remove(em.merge(leccion));
		ut.commit();
	}
	
	public Leccion findByIdAndName(int idLeccion, String titulo) {// este igual hay q cambiarlo y encontrarlo por id solamente y con alguna relacion con el curso. 
		
		Query query =  em.createQuery("SELECT u FROM Leccion u where u.idleccion=:idleccion and u.titulo=:titulo", Leccion.class);
		query.setParameter("idcursos", idLeccion);
		query.setParameter("titulo", titulo);
		return (Leccion) query.getSingleResult();
		
		
	}
	

}
