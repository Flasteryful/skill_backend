package model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class AuthorDto {

    private String firstName;

    private String lastName;

    private String biography;

}