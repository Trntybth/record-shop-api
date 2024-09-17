package com.example.record_shop.packages.Service;

import com.example.record_shop.packages.Repository.AlbumRepository;
import com.example.record_shop.packages.model.Album;
import com.example.record_shop.packages.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
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
    public Album updateAlbumDetails(Long id, Album albumDetails) {
        Optional<Album> optionalAlbum = albumRepository.findById(id);

        if (optionalAlbum.isPresent()) {
            Album existingAlbum = optionalAlbum.get();

            // Update the existing album with new details
            existingAlbum.setTitle(albumDetails.getTitle());
            existingAlbum.setArtist(albumDetails.getArtist());
            existingAlbum.setReleaseYear(albumDetails.getReleaseYear());
            existingAlbum.setGenre(albumDetails.getGenre());

            // Save the updated album
            return albumRepository.save(existingAlbum);
        } else {
            // Handle the case where the album does not exist
            throw new NoSuchElementException("Album not found with the entered ID: " + id);
        }
    }

    @Override
    public void deleteAlbumById(Long id) {
        albumRepository.deleteById(id);
    }
}
