package Service;

import model.Album;
import model.Genre;

import java.util.List;
import java.util.Optional;

public class AlbumManagerServiceImpl implements AlbumManagerService {
    @Override
    public List<Album> getAllAlbums() {
        return List.of();
    }

    @Override
    public Optional<Album> getAlbumById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Album> getAlbumsInStock() {
        return List.of();
    }

    @Override
    public List<Album> listAllAlbumsByArtist(String artist) {
        return List.of();
    }

    @Override
    public List<Album> listAllAlbumByReleaseYear(int releaseYear) {
        return List.of();
    }

    @Override
    public List<Album> listAllAlbumsByGenre(Genre genre) {
        return List.of();
    }

    @Override
    public Optional<Record> getAlbumByName(String name) {
        return Optional.empty();
    }

    @Override
    public Album addNewAlbum(Album album) {
        return null;
    }

    @Override
    public Album updateAlbumDetails(Long id, Album album) {
        return null;
    }

    @Override
    public int deleteAlbumById(Long id) {
        return 0;
    }
}
