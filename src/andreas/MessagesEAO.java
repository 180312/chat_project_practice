package andreas;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MessagesEAO {
	
	@PersistenceContext(unitName = "messagesPU")
	private EntityManager em;
	
	public Messages getMessages() {
		return em.find(Messages.class, 1);
	}
	
	public void updateMessages(Messages messages) {
		em.merge(messages);
	}

}
