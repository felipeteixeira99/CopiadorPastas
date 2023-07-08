import java.io.File;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Verificador {
	
	public static void main(String[] args) {
		
		Origem dir = new Origem();
		dir.setOrigem("D:\\Users\\78_tic\\Documents");
		dir.setPastasSelecionadas(new String[]{"Gerais", "Pessoais", "Conhecimento"});
		
		File verifica = new File(dir.getOrigem());
		int contador = 0;
		if (verifica.exists() && verifica.isDirectory()) {
			
			List<File> arquivosEncontrados = new ArrayList<>();
			
            // Obter a lista de arquivos no diretório
            File[] arquivos = verifica.listFiles();
            
            // Iterar sobre os arquivos
            for (File arquivo : arquivos) {
                // Verificar se é um arquivo
                if (arquivo.isFile()) {
                	arquivosEncontrados.add(arquivo);
                	contador++;
                }
            }
            
            for( File arquivo : arquivosEncontrados) {
                	//Obtem a data da ultima modificação
                	long ultimaModificacaoMili = arquivo.lastModified();
                	Date ultimaModificacao = new Date(ultimaModificacaoMili);
                    System.out.println("Nome do arquivo: " + arquivo.getName());
                    System.out.println("Caminho completo: " + arquivo.getAbsolutePath());
                    System.out.println("Data Ultima alteração: " + ultimaModificacao);
                    System.out.println("Tamanho do arquivo: " + arquivo.length() + " bytes");
                    System.out.println("----------------------------------");
               	}
			}
		else {
            	System.out.println("O diretorio não Existe!");
            }
		System.out.println("Arquivos Encontrados: " + contador);
            
		}	
}

