package spotify.api.ingest.services.users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spotify.api.ingest.external.users.UsersExternalApiIngestImpl;
import spotify.api.ingest.services.interfaces.UsersDataService;

@Service
public class UsersDataServiceImpl implements UsersDataService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsersDataServiceImpl.class);

    private UsersExternalApiIngestImpl usersExternalApiIngest;

    @Autowired
    public UsersDataServiceImpl(UsersExternalApiIngestImpl usersExternalApiIngest){
        this.usersExternalApiIngest = usersExternalApiIngest;
    }

    @Override
    public String retrieveUserFollowedArtists(String auth) {
        LOGGER.info("About to get the followed artists for user.");
        String userFollowedArtists = this.usersExternalApiIngest.retrieveUserFollowedArtists(auth);
        LOGGER.info("Single user followed artists retrieved.");
        return userFollowedArtists;
    }

    @Override
    public String retrieveSpecificUserProfile(String userId, String auth) {
        LOGGER.info("About to get the user with id {} .", userId);
        String userProfile = this.usersExternalApiIngest.retrieveSpecificUserProfile(userId, auth);
        LOGGER.info("Single user data retrieved.");
        return userProfile;
    }

    @Override
    public String retrieveUserTopArtists(String auth) {
        LOGGER.info("About to get the top items for user.");
        String userTopItems = this.usersExternalApiIngest.retrieveUserTopArtists(auth);
        LOGGER.info("Single user top items data retrieved.");
        return userTopItems;
    }
}
