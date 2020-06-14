package br.com.murilokakazu.ec7.ftt.cefsa.application.resources.rest;

import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Album;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Album_;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static br.com.murilokakazu.ec7.ftt.cefsa.domain.specifications.SpecificationsHelper.isEqual;
import static org.springframework.data.jpa.domain.Specification.*;
import static br.com.murilokakazu.ec7.ftt.cefsa.domain.specifications.AlbumSpecifications.*;

@RestController
@RequestMapping(path = "/v1")
public class AlbumRestResource {

    @Autowired
    private AlbumRepository albumRepository;

    @GetMapping("/album/{id}")
    public Album getById(@PathVariable(value = "id") UUID id) {
        return albumRepository.findById(id).get();
    }

    @GetMapping("/artist/{id}/albums")
    public List<Album> getByArtistId(@PathVariable(value = "id") UUID artistId) {
        return albumRepository.findAll(where(isEqual(Album_.ARTIST_ID, artistId)));
    }

    @GetMapping("/albums")
    public List<Album> searchBySpecifications(Album prototype) {
        return albumRepository.findAll(bySpecifications(prototype));
    }

    @PostMapping("/album")
    public Album post(@RequestBody Album album) {
        return albumRepository.save(album);
    }

    @PutMapping("/album")
    public Album put(@RequestBody Album album) {
        return albumRepository.save(album);
    }
}