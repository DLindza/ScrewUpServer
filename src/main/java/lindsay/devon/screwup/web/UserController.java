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
    private static final String VIEW_USER = "user/{username}";

    @Autowired
    UserRepository repo;


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Iterable<User> getAllUsers() { return repo.findAll(); }

    @RequestMapping(value = "/user", method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody User createNewUser(@RequestBody User user) {
        user.fillBudget();
        repo.saveAndFlush(user);

        return user;
    }

    @RequestMapping(value = "/findByUsername/{username}", method = RequestMethod.GET)
    public User findByUsername(@PathVariable String username) {
        User temp = repo.findByUsername(username);
        return temp;
    }

    @RequestMapping(value = "/fillbudget/{username}", method = RequestMethod.GET)
    public User fillBudget(@PathVariable String username) {
        User temp = repo.findByUsername(username);
        temp.fillBudget();
        return temp;
    }

//    @RequestMapping(value = "/user/{username}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public String setMonthlyNet(@PathVariable String username, @RequestBody String monthlyNet) {
//        User user = findByUsername(username);
//        user.setMonthlyNet(monthlyNet);
//        repo.saveAndFlush(user);
//        System.out.println(user.getMonthlyNet());
//        return monthlyNet;
//
//    }
//
//    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
//    public String getMonthlyNet(@PathVariable String username) {
//        User user = repo.findByUsername(username);
//        return user.getMonthlyNet();
//    }










}

