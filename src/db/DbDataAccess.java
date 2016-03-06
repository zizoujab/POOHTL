package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import model.Note;


public class DbDataAccess implements DAO {

	Connection connection = DataSource.getInstance() ; 
	
	
	@Override
	public void save(String note ) throws Exception  {
		String saveQuery =" insert into `data`.`notes` (`note`, `lastModified`) values ( ?,?)";
		PreparedStatement savePreparedStatement = connection.prepareStatement(saveQuery);
		savePreparedStatement.setString(1, note);
		savePreparedStatement.setString(2, getCurrentDate());
		savePreparedStatement.executeUpdate();
	}
	
	

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
	
	private String getCurrentDate(){
		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String currentTime = sdf.format(dt);
		return currentTime; 
	}



	@Override
	public Note loadNote() throws Exception {
		String selectString = " select note,lastModified from notes " ; 
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(selectString);
		Note note=null ; 
		while (rs.next()){
			 String noteString = rs.getString("note");
			 String date = rs.getString("lastModified");
			 note = new Note(noteString,date);
		}
		return note;
	}

}
