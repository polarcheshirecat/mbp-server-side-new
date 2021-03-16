package ru.spb.devpractices.masterbest.serverside.services.model;import lombok.AllArgsConstructor;import org.springframework.security.crypto.password.PasswordEncoder;import org.springframework.stereotype.Service;import ru.spb.devpractices.masterbest.serverside.exceptions.UserNotFoundException;import ru.spb.devpractices.masterbest.serverside.model.User;import ru.spb.devpractices.masterbest.serverside.repo.UsersRepo;import java.util.List;@Service@AllArgsConstructorpublic class UserService {    private final UsersRepo usersRepo;    private final PasswordEncoder passwordEncoder;    public User getUserById (Long id) {        return usersRepo.findById(id).orElseThrow(UserNotFoundException::new);    }    public User save(User user) {        user.setPassword(passwordEncoder.encode(user.getPassword()));        return usersRepo.save(user);    }    public List<User> getAllUsers () {        return usersRepo.findAll();    }    public User getUserByUsername (String username){        return usersRepo.findUserByUsername(username).orElseThrow(UserNotFoundException::new);    }    }