package com.rodrigoteixeira.workshopmongo.config;

import com.rodrigoteixeira.workshopmongo.domain.Post;
import com.rodrigoteixeira.workshopmongo.domain.User;
import com.rodrigoteixeira.workshopmongo.dto.AuthorDto;
import com.rodrigoteixeira.workshopmongo.dto.CommentDto;
import com.rodrigoteixeira.workshopmongo.repository.PostRepository;
import com.rodrigoteixeira.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null,simpleDateFormat.parse("21/03/2018") , "PartiuViagem","Vou viajar para São Paulo. Abraços!", new AuthorDto(maria));
        Post post2 = new Post(null,simpleDateFormat.parse("23/03/2018") , "Bom dia","Acordei feliz hoje!", new AuthorDto(maria));

        CommentDto c1 = new CommentDto("Boa viagem mano!", simpleDateFormat.parse("21/03/2018"), new AuthorDto(alex));
        CommentDto c2 = new CommentDto("Aproveite", simpleDateFormat.parse("22/03/2018"), new AuthorDto(bob));
        CommentDto c3 = new CommentDto("Tenha um ótimo dia!", simpleDateFormat.parse("23/03/2018"), new AuthorDto(alex));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);

    }
}
