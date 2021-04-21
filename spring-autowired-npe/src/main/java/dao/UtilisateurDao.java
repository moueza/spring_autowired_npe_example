package dao;

//import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import models.Utilisateur;

//import com.sdzee.entities.Utilisateur;
/**
 * https://openclassrooms.com/fr/courses/626954-creez-votre-application-web-avec-java-ee/625580-la-persistance-des-donnees-avec-jpa
 */
//@Stateless
public class UtilisateurDao {
	private static final String JPQL_SELECT_PAR_EMAIL = "SELECT u FROM Utilisateur u WHERE u.email=:email";
	private static final String PARAM_EMAIL = "email";

	// Injection du manager, qui s'occupe de la connexion avec la BDD
	/**
	 * Vous reconnaîtrez ici le nom de l'unité que nous avons déclarée dans le
	 * fichier persistence.xml : bdd_sdzee_PU.
	 */
	@PersistenceContext(unitName = "bdd_sdzee_PU")
	private EntityManager em;

	// Enregistrement d'un nouvel utilisateur
	public void creer(Utilisateur utilisateur) throws DAOException {
		try {
			em.persist(utilisateur);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	// Recherche d'un utilisateur à partir de son adresse email
	public Utilisateur trouver(String email) throws DAOException {
		Utilisateur utilisateur = null;
		Query requete = em.createQuery(JPQL_SELECT_PAR_EMAIL);
		requete.setParameter(PARAM_EMAIL, email);
		try {
			utilisateur = (Utilisateur) requete.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			throw new DAOException(e);
		}
		return utilisateur;
	}
}