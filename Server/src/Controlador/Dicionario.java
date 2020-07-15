package Controlador;
import java.util.HashSet;
import java.util.Set;

public class Dicionario {
	private Set<Palavra> palavras;

	public Dicionario() {
		Set<Palavra> setPalavras = new HashSet<Palavra>();
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

	public Set<Palavra> getPalavras() {
		return palavras;
	}

	public void setPalavras(Set<Palavra> palavras) {
		this.palavras = palavras;
	}
}
