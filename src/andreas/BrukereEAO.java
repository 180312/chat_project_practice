package andreas;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BrukereEAO {

	@PersistenceContext(unitName = "brukerePU")
	private EntityManager em;
	
	public Brukere getBrukere() {
		return em.find(Brukere.class, 1);
	}
	
	public void oppdaterBrukere(Brukere brukere) {
		em.merge(brukere);
	}
		
}
