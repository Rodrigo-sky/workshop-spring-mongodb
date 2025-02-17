package com.rodrigoteixeira.workshopmongo.services;

import com.rodrigoteixeira.workshopmongo.domain.User;
import com.rodrigoteixeira.workshopmongo.exception.ObjectNotFoundException;
import com.rodrigoteixeira.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repository.findById(id);

        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
