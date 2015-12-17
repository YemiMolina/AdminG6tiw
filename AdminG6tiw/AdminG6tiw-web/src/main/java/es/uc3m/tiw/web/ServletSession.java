package es.uc3m.tiw.web;

import java.util.logging.Logger;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class ServletSession implements HttpSessionListener, HttpSessionAttributeListener {
	Logger log = Logger.getLogger("es.uc3m.tiw.web.ServletSesion");
    /**
     * Default constructor. 
     */
	/*contador*/
	int cont = 0;
    public ServletSession() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
    	
         log.info("Sessión creada");
         cont++;
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 

    	log.info("Sesión destruida");
        cont--;
    }

	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		log.info("Atributo añadido "+arg0.getName()+" "+arg0.getValue());
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		log.info("Atributo eliminado "+arg0.getName());
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		log.info("Atributo reemplazado "+arg0.getName()+ " "+arg0.getValue());
		
	}
	
}
