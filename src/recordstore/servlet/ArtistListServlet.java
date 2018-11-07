package recordstore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import recordstore.dao.ArtistDao;
import recordstore.database.ChinookDatabase;
import recordstore.models.Artist;

@WebServlet("/Artists")
public class ArtistListServlet extends HttpServlet {

	private ChinookDatabase db = new ChinookDatabase();
	private ArtistDao artistDao = new ArtistDao(db);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Artist> list = artistDao.getAllArtists();
		
		for (Artist a : list) {
			resp.getWriter().println(a.getName());
		}
		
		
	}	
	
}
