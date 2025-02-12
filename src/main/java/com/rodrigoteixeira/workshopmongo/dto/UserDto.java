package com.rodrigoteixeira.workshopmongo.dto;

import com.rodrigoteixeira.workshopmongo.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@Data
public class UserDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;

    public UserDto(User user) {
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
    }
}
