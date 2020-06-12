package br.com.murilokakazu.ec7.ftt.cefsa.application.resources.rest;

import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Track;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/v1")
public class TrackRestResource {
    @Autowired
    private TrackRepository trackRepository;

    @GetMapping("/track/{id}")
    public Track getById(@PathVariable(value = "id") UUID id) {
        return trackRepository.findById(id).get();
    }

    @PostMapping("/track")
    public Track post(@RequestBody Track track) {
        return trackRepository.save(track);
    }

    @PutMapping("/track")
    public Track put(@RequestBody Track track) {
        return trackRepository.save(track);
    }
}
