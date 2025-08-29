package com.projeto.cadastro_usuario.infrastructure.repository;

import com.projeto.cadastro_usuario.infrastructure.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}
