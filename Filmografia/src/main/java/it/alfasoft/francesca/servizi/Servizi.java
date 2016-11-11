package it.alfasoft.francesca.servizi;

import java.util.List;

import it.alfasoft.francesca.bean.Film;
import it.alfasoft.francesca.dao.FilmDao;

public class Servizi {

	FilmDao fdao= new FilmDao();

	public boolean addFilm(Film f){
		return fdao.aggiungiFilm(f);
	}

	public List<Film> getAllfilms(){
		return fdao.getFilm();
	}
	
	public Film trovaConId(long id){
		return fdao.trovaFilmConId(id);
	}
	
	public boolean updateFilm(Film f){
		return fdao.aggiornaVoce(f);
	}
	
	public boolean deleteFilm(Film f){
		return fdao.eliminaFilm(f);
	}
}
