package spotify.api.ingest.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spotify.api.ingest.external.ExternalApiIngestImpl;

@Service
public class IngestServiceImpl implements IngestService{

    private static final Logger LOGGER = LoggerFactory.getLogger(IngestServiceImpl.class);

    private ExternalApiIngestImpl externalApiIngest;

    @Autowired
    public IngestServiceImpl(ExternalApiIngestImpl externalApiIngest){
        this.externalApiIngest = externalApiIngest;
    }

    @Override
    public String getSingleArtist(String artistId, String auth) {
        LOGGER.info("About to get the artist with id {} .", artistId);
        String singleArtistData = this.externalApiIngest.retrieveSingleArtistDetails(artistId, auth);
        LOGGER.info("Single artist data retrieved.");
        return singleArtistData;
    }
}
