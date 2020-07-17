package Tradutor;
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
		
		return "Tradução não encontrada!";
	}

	public String traduzirParaPortugues(String palavra){
		Palavra p = dicionario.check(palavra);
		if(p != null){
			return p.getPt(); 
		} 
		
		return "Tradução não encontrada!";
	}
	
	public String traduzir(String palavra) {
		Palavra p = dicionario.check(palavra);
		if(p != null) {
			int len = dicionario.cheackLen(palavra);
			if(len == 1) {
				return p.getEn();
			}
			else if(len == 2) {
				return p.getPt();
			}
		}
		return "Tradução não encontrada!";
	}
}
