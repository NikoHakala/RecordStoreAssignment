package recordstore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import recordstore.dao.AlbumDao;
import recordstore.dao.ArtistDao;
import recordstore.database.ChinookDatabase;
import recordstore.models.Album;
import recordstore.models.Artist;


@WebServlet("/artist")
public class ArtistServlet extends HttpServlet {
	
	private ArtistDao artistDao = new ArtistDao(new ChinookDatabase());
	private AlbumDao albumDao = new AlbumDao(new ChinookDatabase());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException, ServletException {
		long id = Long.parseLong(req.getParameter("id"));
		
		Artist a = artistDao.findArtist(id);
		List<Album> albums = albumDao.findAlbum(id);
		// resp.getWriter().println(a.getName());
		
		req.setAttribute("artists", a);
		req.setAttribute("albums", albums);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/Artist.jsp");
		dispatcher.include(req, resp);
	}
}

