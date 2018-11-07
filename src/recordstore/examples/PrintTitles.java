package recordstore.examples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import recordstore.database.ChinookDatabase;

public class PrintTitles {

	public static void main(String[] args) throws SQLException {

		ChinookDatabase db = new ChinookDatabase();

		// Yhteyden avaus
		Connection connection = db.connect();

		// Kysely
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM Album " + "ORDER BY AlbumId ASC;");

		// Kyselyn suoritus
		ResultSet results = statement.executeQuery();

		while (results.next()) {

			System.out.println(results.getLong("AlbumId") + " - " + results.getString("Title"));

		}

		// SULJETAAN KAIKKI
		db.close(results, statement, connection);

	}
}
