package spotify.api.ingest.external;

public interface ExternalApiIngest {

    String retrieveSingleArtistDetails(String artistId, String auth);
}
