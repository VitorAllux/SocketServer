package Tradutor;
import java.util.HashSet;
import java.util.Set;

public class Dicionario {
	private Set<Palavra> palavras;

	public Dicionario() {		
		Set<Palavra> setPalavras = new HashSet<Palavra>();
 		setPalavras.add(new Palavra("the", "o"));
		setPalavras.add(new Palavra("of", "sobre"));
		setPalavras.add(new Palavra("and", "e"));
		setPalavras.add(new Palavra("a", "um"));
		setPalavras.add(new Palavra("to", "para"));
		setPalavras.add(new Palavra("in", "dentro"));
		setPalavras.add(new Palavra("is", "este"));
		setPalavras.add(new Palavra("you", "voce"));
		setPalavras.add(new Palavra("that", "que"));
		setPalavras.add(new Palavra("it", "isto"));
		setPalavras.add(new Palavra("he", "ele"));
		setPalavras.add(new Palavra("was", "estava"));
		setPalavras.add(new Palavra("for", "para"));
		setPalavras.add(new Palavra("on", "em"));
		setPalavras.add(new Palavra("are", "são"));
		setPalavras.add(new Palavra("with", "com"));
		setPalavras.add(new Palavra("his", "dele"));
		setPalavras.add(new Palavra("they", "eles"));
		setPalavras.add(new Palavra("i", "eu"));
		setPalavras.add(new Palavra("at", "em"));
		setPalavras.add(new Palavra("be", "ser"));
		setPalavras.add(new Palavra("this", "esta"));
		setPalavras.add(new Palavra("have", "ter"));
		setPalavras.add(new Palavra("from", "de"));
		setPalavras.add(new Palavra("word", "palavras"));
		setPalavras.add(new Palavra("time", "tempo"));
		setPalavras.add(new Palavra("people", "pessoas"));
		setPalavras.add(new Palavra("way", "modo"));
		setPalavras.add(new Palavra("water", "agua"));
		setPalavras.add(new Palavra("words", "palavras"));
		setPalavras.add(new Palavra("man", "homem"));
		setPalavras.add(new Palavra("work", "trabalho"));
		setPalavras.add(new Palavra("part", "parte"));
		setPalavras.add(new Palavra("place", "lugar"));
		setPalavras.add(new Palavra("things", "coisas"));
		setPalavras.add(new Palavra("years", "anos"));
		setPalavras.add(new Palavra("number", "número"));
		setPalavras.add(new Palavra("men", "homens"));
		setPalavras.add(new Palavra("name", "nome"));
		setPalavras.add(new Palavra("mister", "senhor"));
		setPalavras.add(new Palavra("home", "casa"));
		setPalavras.add(new Palavra("sweet", "doçe"));
		setPalavras.add(new Palavra("air", "ar"));
		setPalavras.add(new Palavra("line", "linha"));
		setPalavras.add(new Palavra("end", "final"));
		setPalavras.add(new Palavra("sound", "som"));
		setPalavras.add(new Palavra("house", "casa"));
		setPalavras.add(new Palavra("world", "mundo"));
		setPalavras.add(new Palavra("school", "escola"));
		setPalavras.add(new Palavra("form", "forma"));
		setPalavras.add(new Palavra("food", "comida"));
		setPalavras.add(new Palavra("nome", "name"));
		setPalavras.add(new Palavra("mundo", "world"));
		setPalavras.add(new Palavra("homem", "man"));
		setPalavras.add(new Palavra("mulher", "woman"));
		setPalavras.add(new Palavra("cachorro", "dog"));
		setPalavras.add(new Palavra("gato", "cat"));
		setPalavras.add(new Palavra("legal", "cool"));
		palavras = setPalavras;
	}

	public Palavra check(String palavra) {
		for (Palavra p : palavras) {
			if (p.getPt().equals(palavra) || p.getEn().equals(palavra)) {
				return p;
			}
		}
		return null;
	}
	
	public int cheackLen(String palavra) {
		for(Palavra p : palavras) {
			if(p.getPt().equals(palavra)) {
				return 1;
			}
			else if(p.getEn().equals(palavra)) {
				return 2;
			}
		}
		return 0;
	}

	public Set<Palavra> getPalavras() {
		return palavras;
	}

	public void setPalavras(Set<Palavra> palavras) {
		this.palavras = palavras;
	}
}
