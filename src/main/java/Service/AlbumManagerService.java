package Service;

import model.Album;
import model.Genre;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AlbumManagerService {
    List<Album> getAllAlbums();
    Optional<Album> getAlbumById(Long id);
    List<Album> getAlbumsInStock();
    List<Album> listAllAlbumsByArtist(String artist);
    List<Album> listAllAlbumByReleaseYear(int releaseYear);
    List<Album> listAllAlbumsByGenre(Genre genre);
    Optional<Record> getAlbumByName(String name);
    Album addNewAlbum(Album album);
    Album updateAlbumDetails(Long id, Album album);
    int deleteAlbumById(Long id);

}