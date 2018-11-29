package recordstore.servlet;

import java.io.IOException;

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

@WebServlet("/album")
public class AlbumServlet extends HttpServlet {
	
	private AlbumDao albumDao = new AlbumDao(new ChinookDatabase());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException, ServletException {
		long id = Long.parseLong(req.getParameter("AlbumId"));
		
		Album a = albumDao.findAlbum(id);
		resp.getWriter().println(a.getTitle());
		
		req.setAttribute("album", a);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/Album.jsp");
		dispatcher.include(req, resp);
	}

}
