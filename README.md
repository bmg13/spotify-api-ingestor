# Spotify API Ingestor

## Overview
 A SpringBoot service that retrieves data publicly available on the Spotify API. This serves as simple demonstrator of how to use the Spotify API. Additionally, as an interesting note, this was developed on an iPad using GitHub's available dev tools.

### Obtain Spotify Dev Credentials

#### Follow this guide
https://developer.spotify.com/documentation/web-api/quick-start/

#### Check dashboard
https://developer.spotify.com/dashboard

## API usage

### Check usage

https://developer.spotify.com/dashboard/applications/<ID>

#### Get the Token to be used in the following requests
https://developer.spotify.com/documentation/general/guides/authorization/client-credentials/

```
POST /api/token HTTP/1.1
Host: accounts.spotify.com
Authorization: Basic <TOKEN CREATED FROM BASE64 ENCODER OF CLIENT_ID:CLIENT_SECRET>
Content-Type: application/x-www-form-urlencoded
Cache-Control: no-cache

grant_type=client_credentials
```

Example of the usage of the Spotify API directly:

```
GET /v1/artists/7mnBLXK823vNxN3UWB7Gfz HTTP/1.1
Host: api.spotify.com
Authorization: Bearer <TOKEN RETRIEVED FROM TOKEN API>
Content-Type: application/json
Cache-Control: no-cache
```

## Artists

### GET an artist

URI: GET /ingest/artist/{artistId}/auth/{auth}
```
GET /ingest/artist/2HPYUQ6GsPbZHvkyYe2jdm/auth/<AUTH> HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
```

### Get artist's top tracks

Country codes can be found here: https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2

URI: GET /ingest/artist/{artistId}/country/{countryCode}/auth/{auth}

```
GET /ingest/artist/2HPYUQ6GsPbZHvkyYe2jdm/country/pt/auth/<AUTH> HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
```

### Get artist's related artists

URI: GET /ingest/artist/{artistId}/related-artists/auth/{auth}

```
GET /ingest/artist/59oA5WbbQvomJz2BuRG071/related-artists/auth/<AUTH> HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
```

## Users

### Get followed artists

```
GET /ingest/user/followed-artists/auth/<AUTH> HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
```

### Get User profile

```
GET /ingest/user/<USER_ID>/auth/<AUTH> HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
```

### Get User top artists

```
GET /ingest/user/top-artists/auth/<AUTH> HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
```


#### Test the API

Black Keys Artist id: 7mnBLXK823vNxN3UWB7Gfz
Shawn James Artist id: 2HPYUQ6GsPbZHvkyYe2jdm
Jungle Artist id: 59oA5WbbQvomJz2BuRG071

## Future improvements
- Retrieve and manage token in application;
- Add testing;
- Add documentation (specially in interfaces);
- Create models for API responses and DTO's;
- Reply to client accordingly (ex: token expired instead of 500);
- Prints showing usage and responses;

## References

- https://developer.spotify.com/documentation/web-api/
- https://developer.spotify.com/console/
- https://developer.spotify.com/documentation/general/guides/authorization/code-flow/
- https://medium.com/@ow/the-2021-guide-to-coding-on-an-ipad-pro-5428d062c5ff