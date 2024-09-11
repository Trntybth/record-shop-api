package Controller;

import Service.AlbumManagerService;
import model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/records")
public class AlbumController {

    @Autowired
    private AlbumManagerService albumManagerService;

    @GetMapping
    public ResponseEntity<List<Album>> getAll() {
        List<Album> records = albumManagerService.getAllAlbums();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Album> getAlbumById(@PathVariable Long id) {
        return albumManagerService.getAlbumById(id);
    }

    @PostMapping
    public ResponseEntity<Album> addAlbum(@RequestBody Album album) {
        if (album == null) {
            return ResponseEntity.badRequest().build(); // return 400 bad request
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(albumManagerService.addNewAlbum(album));
    }
}
