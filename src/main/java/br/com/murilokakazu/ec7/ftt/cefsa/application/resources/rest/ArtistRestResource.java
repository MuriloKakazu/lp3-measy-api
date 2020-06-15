package br.com.murilokakazu.ec7.ftt.cefsa.application.resources.rest;

import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Artist;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static br.com.murilokakazu.ec7.ftt.cefsa.domain.specifications.ArtistSpecifications.*;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/v1")
public class ArtistRestResource {
    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping("/artist/{id}")
    public ResponseEntity<Artist> getById(@PathVariable(value = "id") UUID id) {
        if (!artistRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ok(artistRepository.findById(id).get());
    }

    @GetMapping("/artists")
    public ResponseEntity<List<Artist>> searchBySpecifications(Artist prototype) {
        return ok(artistRepository.findAll(matching(prototype)));
    }

    @GetMapping("/artists/search")
    public ResponseEntity<List<Artist>> search(@RequestParam(value = "q") String query) {
        return ok(artistRepository.findAll(matching(query)));
    }

    @PostMapping("/artist")
    public ResponseEntity<Artist> post(@RequestBody Artist artist) {
        if (artistRepository.existsById(artist.getId())) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return ok(artistRepository.save(artist));
    }

    @PutMapping("/artist")
    public ResponseEntity<Artist> put(@RequestBody Artist artist) {
        if (!artistRepository.existsById(artist.getId())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ok(artistRepository.save(artist));
    }

    @DeleteMapping("/artist/{id}")
    public ResponseEntity<Artist> delete(@PathVariable(value = "id") UUID id) {
        if (!artistRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        artistRepository.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
