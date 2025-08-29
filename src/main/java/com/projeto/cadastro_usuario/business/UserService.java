package com.projeto.cadastro_usuario.business;

import com.projeto.cadastro_usuario.infrastructure.entities.User;
import com.projeto.cadastro_usuario.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user){
        userRepository.saveAndFlush(user);
    }

    public User searchUserByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email not found!")
        );
    }

    public void deleteUserByEmail(String email){
        userRepository.deleteByEmail(email);
    }

    public void updateUserByEmail(String email, User user){
        User userEntity = searchUserByEmail(email);
        User updatedUser = User.builder()
                .email(user.getEmail() != null ?
                        user.getEmail() : userEntity.getEmail())
                .name(user.getName() != null ?
                        user.getName() : userEntity.getName())
                .build();

        userRepository.saveAndFlush(updatedUser);
    }
}
