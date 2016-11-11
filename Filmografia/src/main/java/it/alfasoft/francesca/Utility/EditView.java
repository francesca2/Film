package it.alfasoft.francesca.Utility;

import it.alfasoft.francesca.bean.Film;
import it.alfasoft.francesca.controller.FilmController;
import it.alfasoft.francesca.servizi.Servizi;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

@ManagedBean(name="dtEditView")
@SessionScoped
public class EditView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private List<Film> films;
	         
	    @ManagedProperty("#{fc}")
	    private FilmController controller;
	    
	    @PostConstruct
	    public void init() {
	        films=controller.getListaFilm();
	    }
 
	    public List<Film> getFilms() {
			return films;
	    }

		public void setFilms(List<Film> films) {
			this.films = films;
		}

		public List<String> getGeneri() {
	        return controller.getGeneri();
	    }
	    
	    public FilmController getController() {
			return controller;
		}

		public void setController(FilmController controller) {
			this.controller = controller;
		}

		public void onRowEdit(RowEditEvent event) {
			controller.aggiornaFilm((Film) event.getObject());
	        FacesMessage msg = new FacesMessage("Film Edited", ((Film) event.getObject()).getNome());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	     
	    public void onRowCancel(RowEditEvent event) {
	    	controller.eliminaFilm((Film) event.getObject());
	        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Film) event.getObject()).getNome());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }

	    public static long getSerialversionuid() {
			return serialVersionUID;
		}
}
