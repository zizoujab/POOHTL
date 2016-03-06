package db;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

import model.Note;


public class FileDataAccess implements DAO {
	public final String filenameString="Notes.txt";
	@Override
	public void save(String note) throws Exception {
    PrintWriter out=new PrintWriter(filenameString)	;
	out.println(note);
	out.close();
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Note loadNote() throws Exception {
		String everything ="";
		BufferedReader br = new BufferedReader(new FileReader(filenameString));
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		     everything= sb.toString();
		} finally {
		    br.close();
		}
		
		return new Note(everything,"");
		

	}
	

}
