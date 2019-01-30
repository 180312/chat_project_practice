package andreas;

import javax.servlet.http.HttpServletRequest;

public class Validering {
	
	private String mobil;
	private String fornavn;
	private String etternavn;
	private String passord;
	private String passord1;


	public Validering(HttpServletRequest request) {
		this.fornavn = request.getParameter("fornavn");
		this.etternavn = request.getParameter("etternavn");
		this.mobil = request.getParameter("mobil");
		this.passord = request.getParameter("passord");
		this.passord1 = request.getParameter("passord1");
	}
	
	public boolean isAllInputGyldig() {
		return isFornavnGyldig() && 
				isEtternavnGylig() && 
				isMobilGyldig() && 
				isPassordGyldig() &&
				isPassord1Gyldig();
	}



	public boolean isPassord1Gyldig() {
		return passord1.equals(passord);
	}

	public boolean isPassordGyldig() {
		return passord.length() > 5;
	}

	public boolean isMobilGyldig() {
		return mobil != null && mobil.matches("^\\d{8}$");
	}

	public boolean isEtternavnGylig() {
		return etternavn.length() > 1 && Character.isUpperCase(etternavn.charAt(0));
	}

	public boolean isFornavnGyldig() {
		return fornavn.length() > 1 && Character.isUpperCase(fornavn.charAt(0));
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

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}


	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	public String getPassord1() {
		return passord1;
	}

	public void setPassord1(String passord1) {
		this.passord1 = passord1;
	}

}
