package it.alfasoft.francesca.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import it.alfasoft.francesca.bean.Film;
import it.alfasoft.francesca.servizi.Servizi;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean(name="fc", eager=true)
public class FilmController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Film> listaFilm;
	private Servizi s;
	
	public FilmController() {
		s= new Servizi();
	}

	public String aggiungi(Film f) {
		s.addFilm(f);	
		return "elencoFilm";
	}

	public List<Film> getListaFilm() {
		return listaFilm;
	}

	public void setListaFilm(List<Film> listaFilm) {
		this.listaFilm = listaFilm;
	}

	public Servizi getS() {
		return s;
	}

	public void setS(Servizi s) {
		this.s = s;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public List<Film> updateLista(){
		this.setListaFilm(s.getAllfilms());
		
		return listaFilm;
	}
	
	public String modificaFilm(long idFilm){
		
		Film film = s.trovaConId(idFilm);
		ExternalContext externalContext = FacesContext.getCurrentInstance()
										.getExternalContext();
		Map<String,Object> requestMap = externalContext.getRequestMap();
		requestMap.put("f", film);
		
		return "ModificaFilm";
		
	}
	
	public String aggiornaFilm(Film fl){
	
		s.updateFilm(fl);
		
		return "elencoFilm?faces-redirect=true";
		
	}
	
	public String cancellaFilm(long id){
		Film f=s.trovaConId(id);
		s.deleteFilm(f);
		
		return "elencoFilm?faces-redirect=true";
	}

}
