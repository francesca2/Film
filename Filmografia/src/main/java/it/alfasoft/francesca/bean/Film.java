package it.alfasoft.francesca.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@ManagedBean(name="f", eager=true)
public class Film implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_Film;
	
	private String nome;
	private String data;
	private String regista;
	private String codice;
	private String genere;
	
	@Transient
	private List<String> generi;
	
	public Film() {
		generi=new ArrayList<String>();
		generi.add("Avventura");
		generi.add("Commedia");
		generi.add("Drammatico");
		generi.add("Horror");
		generi.add("Animazione");
		generi.add("Fantascienza");
		generi.add("Fantastico");
	}
	
	public Film( String nome, String data, String regista,
			String codice, String genere) {
		this.nome = nome;
		this.data = data;
		this.regista = regista;
		this.codice = codice;
		this.genere = genere;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getRegista() {
		return regista;
	}

	public void setRegista(String regista) {
		this.regista = regista;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getId_Film() {
		return id_Film;
	}

	public void setId_Film(long id_Film) {
		this.id_Film = id_Film;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}
	
	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public List<String> getGeneri() {
		return generi;
	}

	public void setGeneri(List<String> generi) {
		this.generi = generi;
	}

	public void validazioneCodice(FacesContext context, UIComponent component, Object value) throws ValidatorException{
		
		if(value==null){
			return;
		}
		String cf = value.toString();
		if(!cf.startsWith("mov")){
			FacesMessage msg= new FacesMessage("Il codice deve iniziare con mov");
			throw new ValidatorException(msg);
		}
	}
	

}
