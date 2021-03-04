package ru.spb.devpractices.masterbest.serverside.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.spb.devpractices.masterbest.serverside.model.User;
import ru.spb.devpractices.masterbest.serverside.repo.UsersRepo;
import ru.spb.devpractices.masterbest.serverside.services.model.UserService;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {


    private final UsersRepo usersRepo;
    public UserDetailsServiceImpl(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userByUsername = usersRepo.findUserByUsername(username);
        if(userByUsername.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }
        User user = userByUsername.get();
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(user.getRole());
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),y
                grantedAuthorities
        );
    }
}