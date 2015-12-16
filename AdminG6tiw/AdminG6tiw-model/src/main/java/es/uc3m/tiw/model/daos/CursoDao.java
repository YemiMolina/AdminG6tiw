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

		Curso cursoRepetido=null;
	
		Curso cursoRetorno=null;
		
		if (cursoNuevo.getIdcursos()!=null ){// aqui hay un curso con el mismo id osea que se modifica 
			cursoRepetido=findById(cursoNuevo.getIdcursos());
			if(cursoRepetido!=null){// debe estar obligatoriament en la lista
				ut.begin();
				System.out.println("(cursoDAO) se va  a modificar un curso " + cursoRepetido.getTitulo());
				em.merge(cursoNuevo);// le paso el curso modificado con los cambios qye haya hecho el usuario
				ut.commit();
				cursoRepetido=cursoNuevo;
			}else if(cursoRepetido==null){
				System.out.println("el id no esta en lista");
			}
			
		}else {
			ut.begin();
			System.out.println("CreateCurso en CursoDAO");
			em.persist(cursoNuevo);
			ut.commit();
			cursoRepetido=cursoNuevo;
			
			
		}
		
		return cursoRepetido;
		
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
	
	public List<Curso> BuscarCursoUsuario (int id){
		//	List<Leccion> listaLeccionesCurso = em.createQuery("SELECT l from Curso c, Leccion l WHERE c.idCursos= l.identificador", Leccion.class).getResultList();
			List<Curso> listaCursoUsuario = em.createQuery("SELECT c from Curso c WHERE c.usuario.idusuarios = :idusuarios",Curso.class).setParameter("idusuarios", id).getResultList();
			return listaCursoUsuario;
			}
	
	
	@Override
	public Curso findById(int id) {
		Query query =  em.createQuery("SELECT u FROM Curso u join fetch u.Profesor where u.idcursos=:idcursos", Curso.class);
		query.setParameter("idcursos", id);
		//Curso cursoEncontrado=em.find(Curso.class, new Integer(id));
		return (Curso) query.getSingleResult();
	
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
