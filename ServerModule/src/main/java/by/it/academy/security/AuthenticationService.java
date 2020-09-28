package by.it.academy.security;


import by.it.academy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service("authService")
public class AuthenticationService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userId) {
        by.it.academy.model.User user = userService.getUserByUserId(userId);
        if (user == null) throw new UsernameNotFoundException("User not found "+userId);
        return new User(
                user.getUserId(),
                user.getPassword(),
                user.getRoles().stream().map(appRole -> new SimpleGrantedAuthority("ROLE_"+appRole.getRoleName()))
                        .collect(Collectors.toList())
        );
    }


}