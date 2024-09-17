package com.djungleacademy.security;

import com.djungleacademy.entity.User;
import com.djungleacademy.enums.UserType;
import com.djungleacademy.repository.UserRepository;
import lombok.Data;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private final UserRepository  userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
/*     process of authentication
     Handles the user authentication process by validating the username and password,
     and returns an Authentication object containing user information and authorities.*/
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();
        User user =userRepository.findByEmail(email);

        // If a user is found and password matches, create an Authentication token with user's email, password, and roles
        if(user!= null && passwordEncoder.matches(password,user.getPassword())) {
            return new UsernamePasswordAuthenticationToken(
                    user.getUserName(),//chose a field to be principle(username)
                    null,//no need to mention password cause the passwordEncoder has done the job
                    getGrantedAuthorities(user.getUserType())
            );
        }
        else {
            throw new BadCredentialsException("Bad credentials");
        }

    }

    private List<GrantedAuthority> getGrantedAuthorities(UserType roles) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("Role_" + roles.getValue()));
        // simpleGrantedAuthority is for create Role obj -> public SimpleGrantedAuthority(String role) {
        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
/*   This method checks if the provided authentication type is supported by this provider.
     Since CustomAuthenticationProvider is an implementation of AuthenticationProvider,
     it must handle specific authentication token types. Here, we verify if the provided
     authentication is of type UsernamePasswordAuthenticationToken, which this provider can process.
     We check the token type, not the provider itself. */
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
