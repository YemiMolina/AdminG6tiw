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

import es.uc3m.tiw.model.Leccion;
import es.uc3m.tiw.model.Usuario;

public class UsuarioDao implements IUsuario{

			private EntityManager em;
			private UserTransaction ut;
			
			
			public UsuarioDao(EntityManager em, UserTransaction ut) {
				super();
				this.em = em;
				this.ut = ut;
			}


			/* (non-Javadoc)
			 * @see es.uc3m.tiw.model.daos.IPersona#createUsuario(es.uc3m.tiw.model.Usuario)
			 */
			@Override
			public Usuario createUsuario(Usuario cursoNuevo) throws NotSupportedException, SystemException, IllegalStateException, SecurityException, HeuristicMixedException, HeuristicRollbackException, RollbackException {

				ut.begin();
				System.out.println("CreateCurso en CursoDAO");
				em.persist(cursoNuevo);
				ut.commit();
				return cursoNuevo;
				
			}
			
			public Usuario update(Usuario usuario){
				
				try {
					ut.begin();
					em.merge(usuario);
					ut.commit();
				} catch (SecurityException | IllegalStateException
						| RollbackException | HeuristicMixedException
						| HeuristicRollbackException | SystemException | NotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return usuario;
				
			}

			/* (non-Javadoc)
			 * @see es.uc3m.tiw.model.daos.IPersona#findAll()
			 */
			@Override
			public List<Usuario> findAll() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{

				//List<Usuario> listaUsuarios = em.createQuery("SELECT u from Usuario u",Usuario.class).getResultList();
				List<Usuario> listaUsuarios = em.createQuery("SELECT u from Usuario u",Usuario.class).getResultList();
				
				return listaUsuarios;
			}
			
			@Override
			public Usuario findById(int id) {
				Usuario UsuarioEncontrado=em.find(Usuario.class, new Integer(id));
				return UsuarioEncontrado;
			
			}
			@Override
			public void removeUsuario(Usuario usuario) throws NotSupportedException, SystemException, IllegalStateException, SecurityException, HeuristicMixedException, HeuristicRollbackException, RollbackException{
				ut.begin();
				em.remove(em.merge(usuario));
				ut.commit();
			}
			
			
			

			public Usuario findByIdAndName(int id, String titulo) {
					
				Query query =  em.createQuery("SELECT u FROM Curso u where u.usuario=:idcursos and u.titulo=:titulo", Usuario.class);
				query.setParameter("idcursos", id);
				query.setParameter("titulo", titulo);
				return (Usuario) query.getSingleResult();
				
				
			}
			
			
			

}
