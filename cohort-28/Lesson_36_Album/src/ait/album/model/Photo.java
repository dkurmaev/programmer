package ait.album.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Photo implements Comparable<Photo>{
	private int albumid;
	private int photoid;
	private String title;
	private String url;
	private LocalDateTime date;

	public Photo(int albumid, int photoid, String title, String url, LocalDateTime date) {
		this.albumid = albumid;
		this.photoid = photoid;
		this.title = title;
		this.url = url;
		this.date = date;
	}



	public int getAlbumid() {
		return albumid;
	}

	public void setAlbumid(int albumid) {
		this.albumid = albumid;
	}

	public int getPhotoid() {
		return photoid;
	}

	public void setPhotoid(int photoid) {
		this.photoid = photoid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Photo " + "albumid = " + albumid + ", photoid = " + photoid + ", title = " + title + ", url = " + url + ", date=" + date;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Photo photo = (Photo) o;
		return albumid == photo.albumid && photoid == photo.photoid;
	}

	@Override
	public int hashCode() {
		return Objects.hash(albumid, photoid);
	}

	@Override
	public int compareTo(Photo photo) {
		return this.date.compareTo(photo.date);
	}
}