
public class TestarClasse {
	
	public static void main(String[] args) {
		
		Origem backup1 = new Origem();
		
		backup1.setOrigem("D:\\Users\\78_tic");
		backup1.setDestino("D:\\Users\\78_tic\\Destino");
		backup1.setPastasSelecionadas(new String[]{"pasta1", "pasta2"});
		
		System.out.println(backup1.getOrigem());
		System.out.println(backup1.getDestino());
		
	
	}

}
