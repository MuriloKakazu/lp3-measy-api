package br.com.murilokakazu.ec7.ftt.cefsa.application.resources.rest;

import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Playlist;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Playlist_;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static br.com.murilokakazu.ec7.ftt.cefsa.domain.specifications.PlaylistSpecifications.*;
import static br.com.murilokakazu.ec7.ftt.cefsa.domain.specifications.SpecificationsHelper.*;
import static org.springframework.data.jpa.domain.Specification.*;

@RestController
@RequestMapping(value = "/v1")
public class PlaylistRestResource {
    @Autowired
    private PlaylistRepository playlistRepository;

    @GetMapping("/playlist/{id}")
    public Playlist getById(@PathVariable(value = "id") UUID id) {
        return playlistRepository.findById(id).get();
    }

    @GetMapping("/account/{id}/playlists")
    public List<Playlist> getByOwnerId(@PathVariable(value = "id") UUID ownerId) {
        return playlistRepository.findAll(where(isFieldEqual(Playlist_.OWNER_ID, ownerId)));
    }

    @GetMapping("/playlists")
    public List<Playlist> searchBySpecifications(Playlist prototype) {
        return playlistRepository.findAll(matching(prototype));
    }

    @GetMapping("/playlist/search")
    public List<Playlist> search(@RequestParam(value = "q") String query) {
        return playlistRepository.findAll(matching(query));
    }

    @PostMapping("/playlist")
    public Playlist post(@RequestBody Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    @PutMapping("/playlist")
    public Playlist put(@RequestBody Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    @DeleteMapping("/playlist/{id}")
    public void delete(@PathVariable(value = "id") UUID id) {
        playlistRepository.deleteById(id);
    }
}
