package ListaDirectorio;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class ListarDirectorio {

    public static void main(String[] args) {

        File directorio = new File("/Users/agustinaheredia/Documents");
        listarDirectorio(directorio);
    }

    public static void listarDirectorio(File directorio) {

        
        File[] contenido = directorio.listFiles();

       
        Arrays.sort(contenido);
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("archivo.txt"))) {
        	for (File archivo : contenido) {
        	
        		if (archivo.isDirectory()) {
                    bw.write("Directorio - " + archivo.getName() + " - Fecha de modificación: " + new Date(archivo.lastModified()));
                    bw.newLine(); // Inserta un salto de línea
                    listarDirectorio(archivo);
            	
                    } else {
                    	bw.write("Archivo - " + archivo.getName() + " - Fecha de modificación: " + new Date(archivo.lastModified()));
                    	bw.newLine(); // Inserta un salto de línea
                    	
                    	 if (archivo.getName().endsWith(".txt")) {
                    		 try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                    	            String linea;
                    	            while ((linea = br.readLine()) != null) {
                    	                System.out.println(linea);
                    	            }
                    	        } catch (IOException e) {
                    	            e.printStackTrace();
                    	        }
                    	 }
                    	
                    }
        	}
        	} catch (IOException e) {
        		e.printStackTrace();
        	}
        
    }
}
