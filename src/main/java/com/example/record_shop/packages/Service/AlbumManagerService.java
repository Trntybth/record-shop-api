package com.example.record_shop.packages.Service;

import com.example.record_shop.packages.model.Album;
import com.example.record_shop.packages.model.Genre;
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
    void deleteAlbumById(Long id);

}