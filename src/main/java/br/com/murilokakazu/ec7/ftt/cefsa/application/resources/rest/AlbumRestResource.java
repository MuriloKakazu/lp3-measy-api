package br.com.murilokakazu.ec7.ftt.cefsa.application.resources.rest;

import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Album;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/v1/albums")
public class AlbumRestResource {

    @Autowired
    private AlbumRepository albumRepository;

    @GetMapping("/{id}")
    public Album getById(@PathVariable(value = "id") UUID id) {
        return albumRepository.findById(id).get();
    }

    @PostMapping
    public Album create(@RequestBody Album album) {
        return albumRepository.save(album);
    }

    @PutMapping
    public Album put(@RequestBody Album album) {
        return albumRepository.save(album);
    }
}