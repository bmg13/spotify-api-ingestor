package spotify.api.ingest.services.artists;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spotify.api.ingest.external.interfaces.ArtistsExternalApiIngest;
import spotify.api.ingest.services.interfaces.ArtistDataService;

@Service
public class ArtistDataServiceImpl implements ArtistDataService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArtistDataServiceImpl.class);

    private ArtistsExternalApiIngest artistsExternalApiIngest;

    @Autowired
    public ArtistDataServiceImpl(ArtistsExternalApiIngest artistsExternalApiIngest){
        this.artistsExternalApiIngest = artistsExternalApiIngest;
    }

    @Override
    public String retrieveSingleArtist(String artistId, String auth) {
        LOGGER.info("About to get the artist with id {} .", artistId);
        String singleArtistData = this.artistsExternalApiIngest.retrieveSingleArtistDetails(artistId, auth);
        LOGGER.info("Single artist data retrieved.");
        return singleArtistData;
    }

    @Override
    public String retrieveSingleArtistTopTracksInSpecificCountry(String artistId, String countryCode, String auth) {
        LOGGER.info("About to get the top tracks of artist with id {} in the country with code {}.",
                artistId, countryCode);
        String singleArtistTopTracksData =
                this.artistsExternalApiIngest.retrieveSingleArtistTopTracksForCountry(artistId, countryCode, auth);
        LOGGER.info("Single artist top tracks data retrieved.");
        return singleArtistTopTracksData;
    }

    @Override
    public String retrieveSingleArtistRelatedArtists(String artistId, String auth) {
        LOGGER.info("About to get the related artists for artist with id {}.", artistId);
        String singleArtistRelatedArtists =
                this.artistsExternalApiIngest.retrieveSingleArtistRelatedArtists(artistId, auth);
        LOGGER.info("Single artist related artists retrieved.");
        return singleArtistRelatedArtists;
    }
}
