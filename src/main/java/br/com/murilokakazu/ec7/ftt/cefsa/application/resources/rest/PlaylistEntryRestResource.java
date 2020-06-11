package br.com.murilokakazu.ec7.ftt.cefsa.application.resources.rest;

import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.PlaylistEntry;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.repository.PlaylistEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/v1/playlist-entries")
public class PlaylistEntryRestResource {
    @Autowired
    private PlaylistEntryRepository playlistEntryRepository;

    @GetMapping("/{id}")
    public PlaylistEntry getById(@PathVariable(value = "id") UUID id) {
        return playlistEntryRepository.findById(id).get();
    }

    @PostMapping
    public PlaylistEntry create(@RequestBody PlaylistEntry playlistEntry) {
        return playlistEntryRepository.save(playlistEntry);
    }

    @PutMapping
    public PlaylistEntry put(@RequestBody PlaylistEntry playlistEntry) {
        return playlistEntryRepository.save(playlistEntry);
    }
}
