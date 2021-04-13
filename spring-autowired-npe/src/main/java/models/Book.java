package models;

import java.io.Serializable;

import javax.persistence.Entity;/**=jpa*/
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * https://www.baeldung.com/spring-boot-hibernate
 * 
 * Serializable : https://www.jmdoudoux.fr/java/dej/chap-jpa.htm
 */
@Entity
public class Book implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	private String titre;
	private String auteur;

	// standard constructors
	public Book(String titree, String auteurr) {
		titre = titree;
		auteur = auteurr;
	}

	// standard getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

}