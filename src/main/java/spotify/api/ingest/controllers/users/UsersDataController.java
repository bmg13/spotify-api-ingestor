package spotify.api.ingest.controllers.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import spotify.api.ingest.services.interfaces.UsersDataService;

@CrossOrigin(maxAge = 3600)
@Controller
@RequestMapping(
        path = "/ingest/user",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class UsersDataController {

    private static final String BEARER = "Bearer ";

    private UsersDataService usersDataService;

    @Autowired
    public UsersDataController(UsersDataService usersDataService){
        this.usersDataService = usersDataService;
    }

    @GetMapping(path = "/followed-artists/auth/{auth}")
    public ResponseEntity<String> getUserFollowedArtists(@PathVariable String auth) {
        return ResponseEntity.ok(this.usersDataService.retrieveUserFollowedArtists(BEARER + auth));
    }

    @GetMapping(path = "/{userId}/auth/{auth}")
    public ResponseEntity<String> getSpecificUserProfile(@PathVariable String userId, @PathVariable String auth) {
        return ResponseEntity.ok(this.usersDataService.retrieveSpecificUserProfile(userId, BEARER + auth));
    }

    @GetMapping(path = "/top-artists/auth/{auth}")
    public ResponseEntity<String> getUserTopArtists(@PathVariable String auth) {
        return ResponseEntity.ok(this.usersDataService.retrieveUserTopArtists(BEARER + auth));
    }
}
