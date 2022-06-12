package spotify.api.ingest.external.artists;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import spotify.api.ingest.external.RequestEntityBuilder;
import spotify.api.ingest.external.interfaces.ArtistsExternalApiIngest;

@Service
public class ArtistsExternalApiIngestImpl implements ArtistsExternalApiIngest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArtistsExternalApiIngestImpl.class);
    private static final String ARTISTS_BASE_URL = "https://api.spotify.com/v1/artists/";

    private RestTemplate restTemplate;

    @Autowired
    public ArtistsExternalApiIngestImpl(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String retrieveSingleArtistDetails(String artistId, String auth) {
        ResponseEntity<String> response
                = this.restTemplate.exchange(
                ARTISTS_BASE_URL + artistId,
                HttpMethod.GET,
                RequestEntityBuilder.buildRequestEntity(auth),
                String.class);

        LOGGER.info("Response: code: {}, body: {}", response.getStatusCodeValue(), response.getBody());
        return response.getBody();
    }

    @Override
    public String retrieveSingleArtistTopTracksForCountry(String artistId, String countryCode, String auth) {
        ResponseEntity<String> response
                = this.restTemplate.exchange(
                ARTISTS_BASE_URL + artistId + "/top-tracks?market=" + countryCode,
                HttpMethod.GET,
                RequestEntityBuilder.buildRequestEntity(auth),
                String.class);

        LOGGER.info("Response: code: {}, body: {}", response.getStatusCodeValue(), response.getBody());
        return response.getBody();
    }

    @Override
    public String retrieveSingleArtistRelatedArtists(String artistId, String auth) {
        ResponseEntity<String> response
                = this.restTemplate.exchange(
                ARTISTS_BASE_URL + artistId + "/related-artists",
                HttpMethod.GET,
                RequestEntityBuilder.buildRequestEntity(auth),
                String.class);

        LOGGER.info("Response: code: {}, body: {}", response.getStatusCodeValue(), response.getBody());
        return response.getBody();
    }
}
