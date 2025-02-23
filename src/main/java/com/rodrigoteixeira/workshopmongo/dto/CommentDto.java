package com.rodrigoteixeira.workshopmongo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String text;
    private Date date;
    private AuthorDto author;
}
