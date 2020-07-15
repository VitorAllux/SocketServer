package Controlador;
public class Tradutor {
	private Dicionario dicionario;
	
	public Tradutor(Dicionario dicionario) {
		this.dicionario = dicionario;
	}

	public Dicionario getDicionario() {
		return dicionario;
	}

	public void setDicionario(Dicionario dicionario) {
		this.dicionario = dicionario;
	}

	public String traduzirParaIngles(String palavra){
		Palavra p = dicionario.check(palavra);
		if(p != null){
			return p.getEn(); 
		} 
		
		return "Tradu��o n�o encontrada!";
	}

	public String traduzirParaPortugues(String palavra){
		Palavra p = dicionario.check(palavra);
		if(p != null){
			return p.getPt(); 
		} 
		
		return "Tradu��o n�o encontrada!";
	}
}
