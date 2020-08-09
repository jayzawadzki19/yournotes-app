package pl.zawadzki.yournotes.api;

import org.springframework.web.bind.annotation.*;
import pl.zawadzki.yournotes.pojo.User;
import pl.zawadzki.yournotes.repository.UserRepository;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserApi {

    private UserRepository userRepository;

    public UserApi(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable("id") Long id){
        return userRepository.findById(id);
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        userRepository.deleteById(id);
    }

}
