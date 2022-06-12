package spotify.api.ingest.external.users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import spotify.api.ingest.external.RequestEntityBuilder;
import spotify.api.ingest.external.interfaces.UsersExternalApiIngest;

@Service
public class UsersExternalApiIngestImpl implements UsersExternalApiIngest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsersExternalApiIngestImpl.class);
    private static final String USERS_BASE_URL = "https://api.spotify.com/v1/";
    private static final String MAX_LIMIT_FOLLOWED_VALUE = "50";

    private RestTemplate restTemplate;

    @Autowired
    public UsersExternalApiIngestImpl(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String retrieveUserFollowedArtists(String auth) {
        ResponseEntity<String> response
                = this.restTemplate.exchange(
                USERS_BASE_URL + "/me/following?type=artist&limit=" + MAX_LIMIT_FOLLOWED_VALUE,
                HttpMethod.GET,
                RequestEntityBuilder.buildRequestEntity(auth),
                String.class);

        LOGGER.info("Response: code: {}, body: {}", response.getStatusCodeValue(), response.getBody());
        return response.getBody();
    }

    @Override
    public String retrieveSpecificUserProfile(String userId, String auth) {
        ResponseEntity<String> response
                = this.restTemplate.exchange(
                USERS_BASE_URL + "users/" + userId,
                HttpMethod.GET,
                RequestEntityBuilder.buildRequestEntity(auth),
                String.class);

        LOGGER.info("Response: code: {}, body: {}", response.getStatusCodeValue(), response.getBody());
        return response.getBody();
    }

    @Override
    public String retrieveUserTopArtists(String auth) {
        ResponseEntity<String> response
                = this.restTemplate.exchange(
                USERS_BASE_URL + "/me/top/artists",
                HttpMethod.GET,
                RequestEntityBuilder.buildRequestEntity(auth),
                String.class);

        LOGGER.info("Response: code: {}, body: {}", response.getStatusCodeValue(), response.getBody());
        return response.getBody();
    }
}
