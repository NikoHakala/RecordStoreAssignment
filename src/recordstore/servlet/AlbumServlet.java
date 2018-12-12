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

@WebServlet("/album")
public class AlbumServlet extends HttpServlet {
	
	private AlbumDao albumDao = new AlbumDao(new ChinookDatabase());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException, ServletException {
		long id = Long.parseLong(req.getParameter("AlbumId"));
		
		List<Album> aa = albumDao.findAlbum(id);
		//resp.getWriter().println(aa.getTitle());
		
		req.setAttribute("albums", aa);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/Album.jsp");
		dispatcher.include(req, resp);
	}

}
