package com.example.record_shop;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import com.example.record_shop.packages.Controller.AlbumController;
import com.example.record_shop.packages.Service.AlbumManagerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.record_shop.packages.model.Album;
import com.example.record_shop.packages.model.Genre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


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

    @Test
    public void canRetrieveAlbumById() throws Exception {
        // Arrange
        given(albumManagerService.getAlbumById(1L))
                .willReturn(Optional.of(mockAlbum1));

        // Act & Assert
        mockMvc.perform(get("/api/v1/records/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(mockAlbum1)));
    }

    @Test
    public void canAddAlbumWithPostRequest() throws Exception {

        given(albumManagerService.addNewAlbum(any(Album.class))).willReturn(mockAlbum2);
        // Mock the response from getAllAlbums to include the new album
        List<Album> mockAlbumList = Collections.singletonList(mockAlbum2);
        given(albumManagerService.getAllAlbums()).willReturn(mockAlbumList);

        // mock controller layer / api testing
        mockMvc.perform(post("/api/v1/records")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mockAlbum2)))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(mockAlbum2)));

        mockMvc.perform(get("/api/v1/records")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(mockAlbumList)));

    }
    @Test
    public void testUpdateAlbum() throws Exception {
        Album updatedAlbumInfo = new Album();
        updatedAlbumInfo.setTitle("Wolf");
        updatedAlbumInfo.setArtist("Tyler The Creator");
        updatedAlbumInfo.setReleaseYear(2013);
        updatedAlbumInfo.setGenre(Genre.HIPHOP);

        when(albumManagerService.updateAlbumDetails(anyLong(), any(Album.class))).thenReturn(updatedAlbumInfo);

        mockMvc.perform(put("/api/v1/records/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedAlbumInfo)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Wolf"))
                .andExpect(jsonPath("$.releaseYear").value(2013));

    }
    @Test
    public void testDeleteAlbum() throws Exception {
        doNothing().when(albumManagerService).deleteAlbumById(anyLong());

        mockMvc.perform(delete("/api/v1/records/1"))
                .andExpect(status().isNoContent());
    }
}

