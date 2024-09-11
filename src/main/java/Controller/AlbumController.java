package Controller;

import Service.AlbumManagerService;
import model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
