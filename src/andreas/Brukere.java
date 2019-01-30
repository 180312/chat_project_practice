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
@Table(schema = "public", name = "brukere")
public class Brukere {
	
	@Id
	private int id;
	
	@OneToMany(
	        cascade = CascadeType.ALL, 
	        orphanRemoval = true,
	        fetch = FetchType.EAGER,
	        mappedBy = "brukere"
	    )
	private List<Bruker> liste = new ArrayList<>();
	
	public List<Bruker> getBrukere() {
		return liste;
	}
	
	public synchronized void leggTilBruker(Bruker bruker) {
		liste.add(bruker);
		bruker.setListe(this);
	}

}
