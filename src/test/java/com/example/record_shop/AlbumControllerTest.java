package com.example.record_shop;

import Controller.AlbumController;
import Service.AlbumManagerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Album;
import model.Genre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(classes = RecordShopApplication.class)
public class AlbumControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AlbumManagerService albumManagerService;

    @InjectMocks
    private AlbumController albumController;
    private ObjectMapper objectMapper;

    // Mock albums
    private Album mockAlbum1;
    private Album mockAlbum2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Initialize mock data
        mockAlbum1 = new Album();
        mockAlbum1.setTitle("IGOR");
        mockAlbum1.setArtist("Tyler The Creator");
        mockAlbum1.setReleaseYear(2019);
        mockAlbum1.setGenre(Genre.HIPHOP);

        mockAlbum2 = new Album();
        mockAlbum2.setTitle("Kerplunk");
        mockAlbum2.setArtist("Green Day");
        mockAlbum2.setReleaseYear(1991);
        mockAlbum2.setGenre(Genre.ROCK);
        objectMapper = new ObjectMapper();
    }

    @Test
    public void canRetrieveAllAlbums() throws Exception {
        //arrange
        List<Album> mockAlbumList = Arrays.asList(mockAlbum1, mockAlbum2);
        given(albumManagerService.getAllAlbums()).willReturn(mockAlbumList);
        //act and assert
        mockMvc.perform(get("/api/v1/records")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(mockAlbumList)));
    }

}

