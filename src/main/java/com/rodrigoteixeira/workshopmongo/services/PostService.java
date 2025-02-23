package com.rodrigoteixeira.workshopmongo.services;

import com.rodrigoteixeira.workshopmongo.domain.Post;
import com.rodrigoteixeira.workshopmongo.exception.ObjectNotFoundException;
import com.rodrigoteixeira.workshopmongo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
