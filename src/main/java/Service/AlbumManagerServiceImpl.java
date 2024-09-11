package Service;

import Repository.AlbumRepository;
import model.Album;
import model.Genre;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AlbumManagerServiceImpl implements AlbumManagerService {


    @Autowired
    AlbumRepository albumRepository;

    @Override
    public List<Album> getAllAlbums() {
        return new ArrayList<>(albumRepository.findAll());
    }

    @Override
    public Optional<Album> getAlbumById(Long id) {
        return albumRepository.findById(id);
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
        if (album == null) {
            throw new IllegalArgumentException("Album cannot be null.");
        }
        return albumRepository.save(album);
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
