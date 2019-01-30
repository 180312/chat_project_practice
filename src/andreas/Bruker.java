package andreas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "bruker")
public class Bruker {
	
	@Id
	@Column(name = "mobil")
	private String mobil;
	@Column(name = "fornavn")
	private String fornavn;
	@Column(name = "etternavn")
	private String etternavn;
	@Column(name = "passord")
	private String passord;
	
	@ManyToOne
	private Brukere brukere;
	
	public Bruker() {
		
	}
	
	public Bruker(String fornavn, String etternavn, String mobil, String passord) {
		super();
		this.mobil = mobil;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.passord = passord;
	}

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	public void setListe(Brukere brukere) {
		this.brukere = brukere;
		
	}	

}
