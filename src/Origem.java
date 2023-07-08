import java.io.File;

public class Origem {
	
	private String origem; //vai entrar um diretorio 
	private String destino; //destino desse diretorio 
	private String[] pastasSelecionadas; //quais as pastas eu quero deste diretorio 
	
	public String getOrigem() {
		System.out.printf("Origem: ");
		return this.origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	
	public String getDestino() {
		System.out.printf("Destino: ");
		return this.destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	public String[] getPastasSelecionadas() {
		return pastasSelecionadas;
	}
	
	public void setPastasSelecionadas(String[] pastasSelecionadas) {
		this.pastasSelecionadas = pastasSelecionadas;
	}
}





