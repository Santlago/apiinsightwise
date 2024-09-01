package br.com.fiap.apiinsightwise.track;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackService {

    private final TrackRepository trackRepository;

    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public List<Track> findAll() {
        return trackRepository.findAll();
    }

    public Track create(Track track) {
        return trackRepository.save(track);
    }
}
