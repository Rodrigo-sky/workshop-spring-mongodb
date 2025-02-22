package com.rodrigoteixeira.workshopmongo.dto;

import com.rodrigoteixeira.workshopmongo.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;

@NoArgsConstructor
@Data
public class AuthorDto implements java.io.Serializable{

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;

    public AuthorDto(User user){
        this.id = user.getId();
        this.name = user.getName();
    }
}
