package recordstore.models;

public class Album {
	
	private long artistId;
	private long id;
	private String title;

	public Album(long id, long artistId, String title) {
		this.id = id;
		this.title = title;
		this.artistId = artistId;
	}
	
	public long getId() {
		return id;
	}

	public long getArtistId() {
		return artistId;
	}

	public String getTitle() {
		return title;
	}

}

