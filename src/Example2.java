import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class Example2 {
    private static Set<String> arquivosCopiados;

    public static void main(String[] args) {
        List<String> origens = new ArrayList<>();
        origens.add("D:\\Users\\Felipe");  // Pasta raiz de origem 1
        origens.add("D:\\Users\\Felipe\\Pictures");  // Pasta raiz de origem 2

        String destino = "F:\\Destino";  // Caminho completo da pasta de destino na rede

        String[] pastasDesejadas = {"AnyDesk", "Vídeos"};  // Pastas que serão copiadas
        
        arquivosCopiados = new HashSet<>();

        for (String origem : origens) {
            for (String pasta : pastasDesejadas) {
                copiarPasta(origem, destino, pasta);
            }
        }

        System.out.println("A cópia dos arquivos foi concluída.");
    }

    private static void copiarPasta(String origem, String destino, String pastaDesejada) {
        try {
            Path origemPath = Paths.get(origem, pastaDesejada);
            Path destinoPath = Paths.get(destino, pastaDesejada);

            Files.walkFileTree(origemPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    Path targetPath = destinoPath.resolve(origemPath.relativize(dir));
                    Files.createDirectories(targetPath);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Path targetPath = destinoPath.resolve(origemPath.relativize(file));

                    if (arquivosCopiados.contains(targetPath.toString())) {
                        if (Files.getLastModifiedTime(file).compareTo(Files.getLastModifiedTime(targetPath)) <= 0) {
                            return FileVisitResult.CONTINUE;  // Arquivo já copiado e não foi modificado, continua
                        }
                    }

                    Files.copy(file, targetPath, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);
                    arquivosCopiados.add(targetPath.toString());

                    System.out.println("O arquivo \"" + file.getFileName() + "\" foi copiado para a pasta de destino.");

                    return FileVisitResult.CONTINUE;
                }
            });

            System.out.println("A cópia dos arquivos da pasta \"" + pastaDesejada + "\" da origem \"" + origem + "\" foi concluída.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro durante a cópia dos arquivos da pasta \"" + pastaDesejada + "\" da origem \"" + origem + "\": " + e.getMessage());
        }
    }
}