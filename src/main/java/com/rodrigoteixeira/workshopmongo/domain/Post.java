package com.rodrigoteixeira.workshopmongo.domain;

import com.rodrigoteixeira.workshopmongo.dto.AuthorDto;
import com.rodrigoteixeira.workshopmongo.dto.CommentDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@NoArgsConstructor
public class Post implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Getter    @Setter
    private String id;
    @Getter    @Setter
    private Date date;
    @Getter    @Setter
    private String title;
    @Getter    @Setter
    private String body;
    @Getter    @Setter
    private AuthorDto author;
    @Getter
    private List<CommentDto> comments = new ArrayList<>();

    public Post(String id, Date date, String title, String body, AuthorDto author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
