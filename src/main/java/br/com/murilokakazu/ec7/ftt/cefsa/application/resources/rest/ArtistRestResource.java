package br.com.murilokakazu.ec7.ftt.cefsa.application.resources.rest;

import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Album;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Artist;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/v1/artists")
public class ArtistRestResource {
    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping("/{id}")
    public Artist getById(@PathVariable(value = "id") UUID id) {
        return artistRepository.findById(id).get();
    }

    @PostMapping
    public Artist create(@RequestBody Artist artist) {
        return artistRepository.save(artist);
    }

    @PutMapping
    public Artist put(@RequestBody Artist artist) {
        return artistRepository.save(artist);
    }
}
