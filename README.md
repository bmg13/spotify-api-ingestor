# Spotify API Ingestor

## Overview
 A SpringBoot service that retrieves data publicly availble on the Spotify API. This serves as simple demonstrator of how to use the Spotify API. Additionally, as an interesting note, this was developed on an iPad using GitHub's available dev tools.


## API usage

### GET and artist
https://developer.spotify.com/documentation/web-api/reference/#/operations/get-an-artist

´´´
curl --request GET \
  --url https://api.spotify.com/v1/artists/id \
  --header 'Authorization: ' \
  --header 'Content-Type: application/json'
´´´


## References

- https://developer.spotify.com/documentation/web-api/
- https://developer.spotify.com/documentation/web-api/reference/#/
- https://medium.com/@ow/the-2021-guide-to-coding-on-an-ipad-pro-5428d062c5ff