import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
//
// Classe para ler o arquivo e retornar o array com todas as colunas.
//
public class Colunas {
	
public ArrayList<String> nomes(String pFile)  {
   ArrayList<String> col = new ArrayList<String>();
	try {
		for (String line : Files.readAllLines(Paths.get(pFile))) {
		    for (String part : line.split("\\s+")) {
		        col.add(part);
		    }
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return col;
	
}
}
