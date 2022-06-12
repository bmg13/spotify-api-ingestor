package spotify.api.ingest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import spotify.api.ingest.services.IngestServiceImpl;

@CrossOrigin(maxAge = 3600)
@Controller
@RequestMapping(
        path = "/ingest",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class IngestController {

    private IngestServiceImpl ingestService;

    @Autowired
    public IngestController(IngestServiceImpl ingestService){
        this.ingestService = ingestService;
    }

    @GetMapping(path = "/artist/{artistId}/auth/{auth}")
    public ResponseEntity<String> getSingleArtist(@PathVariable String artistId, @PathVariable String auth) {
        return ResponseEntity.ok(this.ingestService.getSingleArtist(artistId, "Bearer " + auth));
    }
}
