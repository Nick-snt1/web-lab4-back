package nick_snt1.lab.weblab4back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import nick_snt1.lab.weblab4back.dto.AuthResponse;
import nick_snt1.lab.weblab4back.dto.UserDTO;
import nick_snt1.lab.weblab4back.model.Role;
import nick_snt1.lab.weblab4back.model.User;
import nick_snt1.lab.weblab4back.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired private UserRepository        repo;
    @Autowired private PasswordEncoder       passwordEncoder;
    @Autowired private JwtService            jwtService;
    @Autowired private AuthenticationManager authManager;
 
    public AuthResponse register(UserDTO req) throws Exception {
        if (repo.findByName(req.getName()) != null) throw new Exception();
        User user = User.builder().name(req.getName()).password(passwordEncoder.encode(req.getPassword())).role(Role.USER).build();
        repo.save(user);
        return AuthResponse.builder().token(jwtService.generateToken(user)).build();
    }
    
    public AuthResponse authenticate(UserDTO req) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(req.getName(), req.getPassword()));
        User user = repo.findByName(req.getName()).orElseThrow();
        return AuthResponse.builder().token(jwtService.generateToken(user)).build();
    }
}
