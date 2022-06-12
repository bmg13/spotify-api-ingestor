package spotify.api.ingest.services.interfaces;

public interface UsersDataService {

    String retrieveUserFollowedArtists(String auth);

    String retrieveSpecificUserProfile(String userId, String auth);

    String retrieveUserTopArtists(String auth);
}
