package br.com.murilokakazu.ec7.ftt.cefsa.application.resources.rest;

import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Playlist;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Playlist_;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.repository.AccountRepository;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static br.com.murilokakazu.ec7.ftt.cefsa.domain.specifications.PlaylistSpecifications.*;
import static br.com.murilokakazu.ec7.ftt.cefsa.domain.specifications.SpecificationsHelper.*;
import static org.springframework.data.jpa.domain.Specification.*;
import static org.springframework.http.ResponseEntity.ok;

@CrossOrigin
@RestController
@RequestMapping(value = "/v1")
public class PlaylistRestResource {
    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/playlist/{id}")
    public ResponseEntity<Playlist> getById(@PathVariable(value = "id") UUID id) {
        if (!playlistRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ok(playlistRepository.findById(id).get());
    }

    @GetMapping("/account/{id}/playlists")
    public ResponseEntity<List<Playlist>> getByOwnerId(@PathVariable(value = "id") UUID ownerId) {
        if (!accountRepository.existsById(ownerId)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ok(playlistRepository.findAll(where(isFieldEqual(Playlist_.OWNER_ID, ownerId))));
    }

    @GetMapping("/playlists")
    public ResponseEntity<List<Playlist>> searchBySpecifications(Playlist prototype) {
        return ok(playlistRepository.findAll(matching(prototype)));
    }

    @GetMapping("/playlist/search")
    public ResponseEntity<List<Playlist>> search(@RequestParam(value = "q") String query) {
        return ok(playlistRepository.findAll(matching(query)));
    }

    @PostMapping("/playlist")
    public ResponseEntity<Playlist> post(@RequestBody Playlist playlist) {
        if (playlistRepository.existsById(playlist.getId())) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return ok(playlistRepository.save(playlist));
    }

    @PutMapping("/playlist")
    public ResponseEntity<Playlist> put(@RequestBody Playlist playlist) {
        if (!playlistRepository.existsById(playlist.getId())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ok(playlistRepository.save(playlist));
    }

    @DeleteMapping("/playlist/{id}")
    public ResponseEntity<Playlist> delete(@PathVariable(value = "id") UUID id) {
        if (!playlistRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        playlistRepository.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
