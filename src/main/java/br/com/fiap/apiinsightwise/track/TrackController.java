package br.com.fiap.apiinsightwise.track;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("track")
@CrossOrigin(origins = "http://localhost:3000")
public class TrackController {

    private final TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping
    public List<Track> findAll() {
        return trackService.findAll();
    }

    @PostMapping
    public Track create(@RequestBody Track track) {
        return trackService.create(track);
    }
}
