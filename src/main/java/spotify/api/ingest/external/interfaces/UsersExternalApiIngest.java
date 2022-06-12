package spotify.api.ingest.external.interfaces;

public interface UsersExternalApiIngest {

    String retrieveUserFollowedArtists(String auth);

    String retrieveSpecificUserProfile(String userId, String auth);

    String retrieveUserTopArtists(String auth);
}
