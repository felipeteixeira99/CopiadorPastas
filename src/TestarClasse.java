
public class TestarClasse {
	
	public static void main(String[] args) {
		
		OrigemDestino backup1 = new OrigemDestino();
		
		backup1.setOrigem("D:\\Users\\Usuario");
		backup1.setDestino("D:\\Users\\Usuario");
		backup1.setPastasSelecionadas(new String[]{"pasta1", "pasta2"});
		
		System.out.println(backup1.getOrigem());
		System.out.println(backup1.getDestino());
		
	
	}

}
