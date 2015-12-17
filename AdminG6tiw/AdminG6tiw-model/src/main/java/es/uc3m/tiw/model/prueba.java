package es.uc3m.tiw.model;

import javax.persistence.*;


public class prueba {
public static void main(String[] args){
System.out.println("Antes de mandar a llamar crearDatos");
crearDatos();
}
public static void crearDatos(){
EntityManagerFactory emf = null;
EntityManager em= null;
System.out.println("Antes de createEntityManagerFactory");

emf = Persistence.createEntityManagerFactory("AdminG6tiw-model");
System.out.println("Luego de createEntityManagerFactory");
em = emf.createEntityManager();

System.out.println("Luego de createEntityManager");
try{
Curso p = new Curso();
Usuario p2 = new Usuario();
//p.setidCurso(1);
p.setIdcursos(1);;
p2.setIdusuarios(1);

//p.setNombreCurso("prueba");
p.setTitulo("hola q tal");
p2.setNombre("Hola");

/*p.setId(5);
p.setNombres("Adolfo Javier");
p.setApellidos("Urrutia Zambrana");
p.setEdad(35);*/
em.getTransaction().begin();
em.persist(p);
//em.persist(p2);
em.getTransaction().commit();
System.out.println("Todo bien");
}
catch(Exception e){
em.getTransaction().rollback();
System.out.println("Error" + e.getMessage());
}
finally{
em.close();
emf.close();
}
}
}