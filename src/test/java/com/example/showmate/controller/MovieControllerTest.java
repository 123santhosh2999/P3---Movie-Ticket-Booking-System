package com.example.showmate.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.showmate.model.Movie;
import com.example.showmate.service.MovieService;

@WebMvcTest(MovieController.class)
class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    @Test
    void list_returnsMovies() throws Exception {
        Movie m1 = new Movie("Movie 1", "Desc 1", "url1");
        m1.setId(1L);
        Movie m2 = new Movie("Movie 2", "Desc 2", "url2");
        m2.setId(2L);

        when(movieService.listAll()).thenReturn(List.of(m1, m2));

        mockMvc.perform(get("/api/movies"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("\"title\":\"Movie 1\"")))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("\"title\":\"Movie 2\"")));
    }

    @Test
    void createJson_createsMovie() throws Exception {
        Movie saved = new Movie("New", "D", "P");
        saved.setId(10L);

        when(movieService.create(org.mockito.ArgumentMatchers.any(Movie.class))).thenReturn(saved);

        mockMvc.perform(post("/api/movies")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"New\",\"description\":\"D\",\"posterUrl\":\"P\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("\"id\":10")))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("\"title\":\"New\"")));
    }
}
