package recordstore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import recordstore.dao.ArtistDao;
import recordstore.database.ChinookDatabase;
import recordstore.models.Artist;


@WebServlet("/Artist")
public class ArtistServlet extends HttpServlet {
	
	private ArtistDao artistDao = new ArtistDao(new ChinookDatabase());
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException, ServletException {
		long id = Long.parseLong(req.getParameter("id"));
		
		Artist a = artistDao.findArtist(id);
		// resp.getWriter().println(a.getName());
		
		req.setAttribute("artist", a);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/ArtistList.jsp");
		dispatcher.include(req, resp);
	}
}

