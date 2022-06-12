package spotify.api.ingest.services.interfaces;

public interface ArtistDataService {

    String retrieveSingleArtist(String artistId, String auth);

    String retrieveSingleArtistTopTracksInSpecificCountry(String artistId, String countryCode, String auth);

    String retrieveSingleArtistRelatedArtists(String artistId, String auth);
}
