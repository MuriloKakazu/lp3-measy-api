package br.com.murilokakazu.ec7.ftt.cefsa.application.resources.rest;

import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Track;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Track_;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.repository.AlbumRepository;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static br.com.murilokakazu.ec7.ftt.cefsa.domain.specifications.SpecificationsHelper.*;
import static br.com.murilokakazu.ec7.ftt.cefsa.domain.specifications.TrackSpecifications.*;
import static org.springframework.data.jpa.domain.Specification.*;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/v1")
public class TrackRestResource {
    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @GetMapping("/track/{id}")
    public ResponseEntity<Track> getById(@PathVariable(value = "id") UUID id) {
        if (!trackRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ok(trackRepository.findById(id).get());
    }

    @GetMapping("/album/{id}/tracks")
    public ResponseEntity<List<Track>> getByAlbumId(@PathVariable(value = "id") UUID albumId) {
        if (!albumRepository.existsById(albumId)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ok(trackRepository.findAll(where(isFieldEqual(Track_.ALBUM_ID, albumId))));
    }

    @GetMapping("/tracks/search")
    public ResponseEntity<List<Track>> search(@RequestParam(value = "q") String query) {
        return ok(trackRepository.findAll(matching(query)));
    }

    @GetMapping(path="/tracks")
    public ResponseEntity<List<Track>> searchBySpecifications(Track prototype){
        return ok(trackRepository.findAll(matching(prototype)));
    }

    @PostMapping("/track")
    public ResponseEntity<Track> post(@RequestBody Track track) {
        if (trackRepository.existsById(track.getId())) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return ok(trackRepository.save(track));
    }

    @PutMapping("/track")
    public ResponseEntity<Track> put(@RequestBody Track track) {
        if (!trackRepository.existsById(track.getId())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ok(trackRepository.save(track));
    }

    @DeleteMapping("/track/{id}")
    public ResponseEntity<Track> delete(@PathVariable(value = "id") UUID id) {
        if (!trackRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        trackRepository.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
