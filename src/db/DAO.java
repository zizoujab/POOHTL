package db;

import model.Note;

public interface DAO {
	
	public void save (String note ) throws Exception ; 
	public void remove(); 
	public Note loadNote() throws Exception ; 

}
