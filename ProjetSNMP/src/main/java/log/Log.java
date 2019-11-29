package log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;


public class Log {
	public static void success(String message) throws IOException {
		File SuccessFile = new File(Constante.SuccessPath);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(dtf.format(now));  
		write(SuccessFile, "[ " + dtf.format(now) +" ] SUCCESS : " + message);
	}

	public static void error(String message) throws IOException {
		File ErrorFile = new File(Constante.ErrorPath);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(dtf.format(now));  
		write(ErrorFile, "[ " + dtf.format(now) +" ] ERROR : " + message);
	}

	public static void modif(String message) throws IOException {
		File ErrorFile = new File(Constante.ModifPath);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(dtf.format(now));  
		write(ErrorFile, "Modifié le [ " + dtf.format(now) +" ] : " + message);
	}

	public static void write (File file, String ligne) throws IOException {
		PrintWriter writer;
		try {
			boolean exists = file.exists();
			if (exists == true ) {
				String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
				writer = new PrintWriter(file);
				writer.println(content);
				writer.println(ligne);
				writer.close();
			}
			else {
				writer = new PrintWriter(file);
				writer.println(ligne);
				writer.close();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public static void listerLog(String file) {
		try {
			InputStream flux=new FileInputStream(file);
			InputStreamReader lecture=new InputStreamReader(flux);
			BufferedReader buff=new BufferedReader(lecture);
			String ligne;
			while ((ligne=buff.readLine())!=null){
				System.out.println(ligne);
			}
			buff.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	public static void voirSuccess()  {
		listerLog(Constante.SuccessPath);
	}
	public static void voirErreur()  {
		listerLog(Constante.ErrorPath);
	}
	public static void voirModif()  {
		listerLog(Constante.ModifPath);
	}
}



