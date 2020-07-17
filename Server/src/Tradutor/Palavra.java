package Tradutor;

public class Palavra {
	//linguas
	private String pt;
	private String en;
	
	public Palavra(String pt, String en) {
		this.en = en;
		this.pt = pt;
	}

	public String getPt() {
		return pt;
	}

	public void setPt(String pt) {
		this.pt = pt;
	}

	public String getEn() {
		return en;
	}

	public void setEn(String en) {
		this.en = en;
	}
	
	
}
