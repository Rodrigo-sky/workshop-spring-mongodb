package com.rodrigoteixeira.workshopmongo.services;

import com.rodrigoteixeira.workshopmongo.domain.Post;
import com.rodrigoteixeira.workshopmongo.exception.ObjectNotFoundException;
import com.rodrigoteixeira.workshopmongo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String title) {
        return repository.findByTitleContainingIgnoreCase(title);
    }
}
