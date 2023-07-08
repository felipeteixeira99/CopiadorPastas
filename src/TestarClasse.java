
public class TestarClasse {
	
	public static void main(String[] args) {
		
		Origem backup1 = new Origem();
		
		backup1.setOrigem("D:\\Users\\Usuario");
		backup1.setDestino("D:\\Users\\Usuario");
		backup1.setPastasSelecionadas(new String[]{"pasta1", "pasta2"});
		
		System.out.println(backup1.getOrigem());
		System.out.println(backup1.getDestino());
		
	
	}

}
