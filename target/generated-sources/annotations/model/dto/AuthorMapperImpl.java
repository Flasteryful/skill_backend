package model.dto;

import javax.annotation.processing.Generated;
import model.Author;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-19T22:53:42+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public AuthorDto entityToDto(Author entity) {
        if ( entity == null ) {
            return null;
        }

        AuthorDto authorDto = new AuthorDto();

        authorDto.setFirstName( entity.getAuthorFirstName() );
        authorDto.setLastName( entity.getAuthorLastName() );
        authorDto.setBiography( entity.getAuthorBiography() );

        return authorDto;
    }

    @Override
    public Author dtoToEntity(AuthorDto dto) {
        if ( dto == null ) {
            return null;
        }

        Author author = new Author();

        author.setAuthorFirstName( dto.getFirstName() );
        author.setAuthorLastName( dto.getLastName() );
        author.setAuthorBiography( dto.getBiography() );

        return author;
    }
}
