package recordstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import recordstore.database.ChinookDatabase;
import recordstore.models.Artist;

public class ArtistDao {
	
	private ChinookDatabase db;
	
	public ArtistDao(ChinookDatabase db) {
		this.db = db;
	}

	public List<Artist> getAllArtists() {
		
		Connection connection = db.connect();
		PreparedStatement statement = null;
		ResultSet results = null;
		ArrayList<Artist> list = new ArrayList();
		
		try {
		statement = connection.prepareStatement("SELECT * FROM Artist;");
		results = statement.executeQuery();
		
			while(results.next()) {
				long id = results.getLong("ArtistId");
				String name = results.getString("Title");
				list.add(new Artist(id, name));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
