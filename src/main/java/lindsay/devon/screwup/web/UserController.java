package lindsay.devon.screwup.web;

import lindsay.devon.screwup.Repository.UserRepository;
import lindsay.devon.screwup.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by devon on 11/2/16.
 */

@RestController
@CrossOrigin
        //(origins = "http://localhost:8100")
public class UserController {

    private static final String VIEW_INDEX = "user";

    @Autowired
    UserRepository repo;


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Iterable<User> getAllUsers() { return repo.findAll(); }

    @RequestMapping(value = "/user", method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody User createNewUser(@RequestBody User user) {
        repo.saveAndFlush(user);
        return user;
    }

    @RequestMapping(value = "/findByUsername/{username}", method = RequestMethod.GET)
    public User findByUsername(@PathVariable String username) {
        User temp = repo.findByUsername(username);
        return temp;
    }






}

