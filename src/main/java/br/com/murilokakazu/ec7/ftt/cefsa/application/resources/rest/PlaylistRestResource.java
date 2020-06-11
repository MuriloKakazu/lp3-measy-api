package br.com.murilokakazu.ec7.ftt.cefsa.application.resources.rest;

import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Playlist;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/v1/playlists")
public class PlaylistRestResource {
    @Autowired
    private PlaylistRepository playlistRepository;

    @GetMapping("/{id}")
    public Playlist getById(@PathVariable(value = "id") UUID id) {
        return playlistRepository.findById(id).get();
    }

    @PostMapping
    public Playlist create(@RequestBody Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    @PutMapping
    public Playlist put(@RequestBody Playlist playlist) {
        return playlistRepository.save(playlist);
    }
}
