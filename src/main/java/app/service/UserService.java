package app.service;

import app.config.DatabaseConfig;
import app.models.User;
import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository rep;
    public void save(User user){
        rep.save(user);
    }
    public User findById(int id) {
        return rep.findById((long) id).get();
    }
    public void update (int id,User userUpdated) {
        User user = findById(id);
        user.setName(userUpdated.getName());
    }
    public void delete (int id) {
        rep.deleteById((long) id);
    }
    public List<User> getTable() {
        return (List<User>) rep.findAll();
    }
}
