package com.cirofreitas.API.Musica;

import com.cirofreitas.API.Musica.model.Album;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class MusicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicaApplication.class, args);
	}
}
