package com.example.record_shop;

import Controller.AlbumController;
import Service.AlbumManagerService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.mockito.InjectMocks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;

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


}

