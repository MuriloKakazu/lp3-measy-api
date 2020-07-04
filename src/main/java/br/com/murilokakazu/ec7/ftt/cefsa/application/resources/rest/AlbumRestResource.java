package br.com.murilokakazu.ec7.ftt.cefsa.application.resources.rest;

import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Album;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Album_;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.repository.AlbumRepository;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static br.com.murilokakazu.ec7.ftt.cefsa.domain.specifications.SpecificationsHelper.*;
import static org.springframework.data.jpa.domain.Specification.*;
import static br.com.murilokakazu.ec7.ftt.cefsa.domain.specifications.AlbumSpecifications.*;
import static org.springframework.http.ResponseEntity.ok;

@CrossOrigin
@RestController
@RequestMapping(path = "/v1")
public class AlbumRestResource {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping("/album/{id}")
    public ResponseEntity<Album> getById(@PathVariable(value = "id") UUID id) {
        if (!albumRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ok(albumRepository.findById(id).get());
    }

    @GetMapping("/artist/{id}/albums")
    public ResponseEntity<List<Album>> getByArtistId(@PathVariable(value = "id") UUID artistId) {
        if (!artistRepository.existsById(artistId)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ok(albumRepository.findAll(where(isFieldEqual(Album_.ARTIST_ID, artistId))));
    }

    @GetMapping("/albums")
    public ResponseEntity<List<Album>> searchBySpecifications(Album prototype) {
        return ok(albumRepository.findAll(matching(prototype)));
    }

    @GetMapping("/albums/search")
    public ResponseEntity<List<Album>> search(@RequestParam(value = "q") String query) {
        return ok(albumRepository.findAll(matching(query)));
    }

    @PostMapping("/album")
    public ResponseEntity<Album> post(@RequestBody Album album) {
        if (albumRepository.existsById(album.getId())) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return ok(albumRepository.save(album));
    }

    @PutMapping("/album")
    public ResponseEntity<Album> put(@RequestBody Album album) {
        if (!albumRepository.existsById(album.getId())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ok(albumRepository.save(album));
    }

    @DeleteMapping("/album/{id}")
    public ResponseEntity<Album> delete(@PathVariable(value = "id") UUID id) {
        if (!albumRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        albumRepository.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}