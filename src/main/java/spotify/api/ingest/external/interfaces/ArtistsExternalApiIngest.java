package spotify.api.ingest.external.interfaces;

public interface ArtistsExternalApiIngest {

    String retrieveSingleArtistDetails(String artistId, String auth);

    String retrieveSingleArtistTopTracksForCountry(String artistId, String countryCode, String auth);

    String retrieveSingleArtistRelatedArtists(String artistId, String auth);
}
