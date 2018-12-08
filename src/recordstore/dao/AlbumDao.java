package recordstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import recordstore.database.ChinookDatabase;
import recordstore.models.Album;
import recordstore.models.Artist;

public class AlbumDao {

	private ChinookDatabase db;
	
	public AlbumDao(ChinookDatabase db) {
		this.db = db;
	}

	public Album findAlbum(long id) {
		Connection connection = db.connect();
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			statement = connection.prepareStatement("SELECT * FROM Album WHERE Artistid = ?");
			statement.setLong(1, id);
			results = statement.executeQuery();

			if (results.next()) {
				long artistId = results.getLong("ArtistId");
				String title = results.getString("Title");
				Album album = new Album(id, artistId, title);
				return album;
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			db.close(results, statement, connection);
		}
	}

	public List<Album> getAllAlbums() {

		Connection connection = db.connect();
		PreparedStatement statement = null;
		ResultSet results = null;
		List<Album> list = new ArrayList();

		try {
			statement = connection.prepareStatement("SELECT * FROM Album");
			results = statement.executeQuery();

			while (results.next()) {
				long artistId = results.getLong("ArtistId");
				long id = results.getLong("AlbumId");
				String title = results.getString("Title");
				list.add(new Album(id, artistId, title));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(results, statement, connection);
		}
		return list;
	}
}
