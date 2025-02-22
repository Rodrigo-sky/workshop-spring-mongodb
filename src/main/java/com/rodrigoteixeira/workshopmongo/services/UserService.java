package com.rodrigoteixeira.workshopmongo.services;

import com.rodrigoteixeira.workshopmongo.domain.User;
import com.rodrigoteixeira.workshopmongo.dto.UserDto;
import com.rodrigoteixeira.workshopmongo.exception.ObjectNotFoundException;
import com.rodrigoteixeira.workshopmongo.repository.PostRepository;
import com.rodrigoteixeira.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private PostRepository postRepository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repository.findById(id);

        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User user) {

        return repository.insert(user);
    }

    public User fromDTO(UserDto userDto) {
        return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    public User update(String id, User user) {
        User newUser = findById(id);
        updateData(newUser, user);
        return repository.save(newUser);
    }

    public void updateData(User newUser, User user) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }
}
