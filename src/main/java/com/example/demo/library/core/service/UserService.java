package com.example.demo.library.core.service;

import com.example.demo.library.core.exceptions.repository.ResourceNotFoundException;
import com.example.demo.library.core.model.User;
import com.example.demo.library.core.repository.UserRepository;
import com.example.demo.library.rest.dto.UserDTO;
import com.example.demo.library.rest.dto.UserRequestDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public List<UserDTO> getAllUsers(){
    List<User> users = userRepository.findAll();
    //List<User> users = userRepository.findAllUsers(); we can work like that also, since it returns all users too

    return users.
            stream()
            .map(UserDTO::new)
            .collect(toList());
    }
    public UserDTO getUserById(String id) throws ResourceNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new ResourceNotFoundException("The user with this ID does not exist.");
        }
        return new UserDTO(user.get());
    }

    public UserDTO addUser(UserRequestDTO payload) {
        User user = userRepository.save(payload.toEntity());
        return new UserDTO(user);
    }
    public void deleteUser(String id){
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(userRepository::delete);
    }
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return (UserDetails) userRepository.findByUsernameOrEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };}
}
