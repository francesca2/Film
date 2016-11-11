package it.alfasoft.francesca.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import it.alfasoft.francesca.bean.Film;
import it.alfasoft.francesca.servizi.Servizi;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean(name="fc", eager=true)
@SessionScoped
public class FilmController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private final static String[] generi;
	 
	 
	    static {
	        generi = new String[7];
	        generi[0] = "Avventura";
	        generi[1] = "Commedia";
	        generi[2] = "Drammatico";
	        generi[3] = "Horror";
	        generi[4] = "Animazione";
	        generi[5] = "Fantascienza";
	        generi[6] = "Fantastico";
	    }
	 
	
	private List<Film> listaFilm;
	private Servizi s;
	
	public FilmController() {
	}

    @PostConstruct
    public void init(){
    	s=new Servizi();
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
	
	public String eliminaFilm(Film f){
		s.deleteFilm(f);
		
		return "tabella?faces-redirect=true";
	}

	public void caricaFilm(){
		setListaFilm(s.getAllfilms());
		
	}
	
    public List<String> getGeneri() {
        return Arrays.asList(generi);
    }
    

}
