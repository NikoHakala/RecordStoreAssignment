package recordstore.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import recordstore.models.Artist;

public class ArtistDaoTest {

	@Test
	public void testArtistListIsNotEmpty() {
		ArtistDao dao = new ArtistDao();
		List<Artist> all = dao.getAllArtists();

		all.isEmpty();
	}

}
