package model.dto;

import javax.annotation.processing.Generated;
import model.Department;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-19T22:53:42+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public DepartmentDto entityToDto(Department entity) {
        if ( entity == null ) {
            return null;
        }

        DepartmentDto departmentDto = new DepartmentDto();

        departmentDto.setId( entity.getId() );
        departmentDto.setName( entity.getName() );

        return departmentDto;
    }

    @Override
    public Department dtoToEntity(DepartmentDto dto) {
        if ( dto == null ) {
            return null;
        }

        Department department = new Department();

        department.setId( dto.getId() );
        department.setName( dto.getName() );

        return department;
    }
}
