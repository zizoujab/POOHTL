package model;

public class Note {
	
	String note; 
	String lastModified;
	
	
	public Note(String  note, String date) {
		this.note =  note ; 
		this.lastModified=date ; 
	}
	public String getLastModified() {
		return lastModified;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

}
