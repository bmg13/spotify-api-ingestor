package spotify.api.ingest.controllers.artists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import spotify.api.ingest.services.interfaces.ArtistDataService;

@CrossOrigin(maxAge = 3600)
@Controller
@RequestMapping(
        path = "/ingest/artist",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class ArtistDataController {

    private static final String BEARER = "Bearer ";

    private ArtistDataService artistDataService;

    @Autowired
    public ArtistDataController(ArtistDataService artistDataService){
        this.artistDataService = artistDataService;
    }

    @GetMapping(path = "/{artistId}/auth/{auth}")
    public ResponseEntity<String> getSingleArtist(@PathVariable String artistId, @PathVariable String auth) {
        return ResponseEntity.ok(this.artistDataService.retrieveSingleArtist(artistId, BEARER + auth));
    }

    @GetMapping(path = "/{artistId}/country/{countryCode}/auth/{auth}")
    public ResponseEntity<String> getSingleArtistTopTracksInCountry(@PathVariable String artistId,
                                                  @PathVariable String countryCode,
                                                  @PathVariable String auth) {
        return ResponseEntity.ok(this.artistDataService.retrieveSingleArtistTopTracksInSpecificCountry(
                artistId,
                countryCode,
                 BEARER + auth));
    }

    @GetMapping(path = "/{artistId}/related-artists/auth/{auth}")
    public ResponseEntity<String> getSingleArtistRelatedArtists(@PathVariable String artistId, @PathVariable String auth) {
        return ResponseEntity.ok(this.artistDataService.retrieveSingleArtistRelatedArtists(
                artistId,
                BEARER + auth));
    }
}
