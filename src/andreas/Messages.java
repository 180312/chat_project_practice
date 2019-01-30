package andreas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "messages")
public class Messages {
	
	@Id
	private int id;
	
	@OneToMany(
	        cascade = CascadeType.ALL, 
	        orphanRemoval = true,
	        fetch = FetchType.EAGER,
	        mappedBy = "messages"
	    )
	private List<Melding> liste = new ArrayList<>();
	
	public List<Melding> getMessages() {
		return liste;
	}
	
	public synchronized void leggTilMelding(Melding melding) {
		liste.add(melding);
		melding.setListe(this);
	}

}
