package andreas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "melding")
public class Melding {
	
	@Column(name = "navn")
	private String navn;
	@Column(name = "melding")
	private String melding;
	@Column(name = "date")
	private String date;
	@Id
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	private Messages messages;
	
	public Melding() {
		
	}
	
	public Melding(String navn, String melding, int id) {
		this.id = id;
		this.navn = navn;
		this.melding = melding;
		LocalDate localDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		this.date = localDate.format(formatter);
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getMelding() {
		return melding;
	}

	public void setMelding(String melding) {
		this.melding = melding;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setListe(Messages messages) {
		this.messages = messages;
	}

}
