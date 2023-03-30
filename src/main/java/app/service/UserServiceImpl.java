package app.service;

import app.models.User;
import app.repository.UserRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository rep;

    public UserServiceImpl(UserRepository rep) {
        this.rep = rep;
    }

    @Transactional
    public void save(User user){
        rep.save(user);
    }

    public User findById(long id) {
        return rep.findById(id).get();
    }

    @Transactional
    public void update (long id,User userUpdated) {
        User user = findById(id);
        user.setName(userUpdated.getName());
    }

    @Transactional
    public void delete (long id) {
        rep.deleteById(id);
    }

    public Iterable<User> getAllUsers() {
        return rep.findAll();
    }
}
