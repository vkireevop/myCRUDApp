package app.service;

import app.models.User;

public interface UserService {
    void save(User user);

    User findById(long id);

    void update (long id,User userUpdated);

    void delete (long id);

    Iterable<User> getAllUsers();
}
