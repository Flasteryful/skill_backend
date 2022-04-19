package model.dto;

import javax.annotation.processing.Generated;
import model.Department;
import model.Employee;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-19T22:53:42+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeDto entityToDto(Employee entity) {
        if ( entity == null ) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setNumber( entity.getId() );
        employeeDto.setLastName( entity.getLastName() );
        employeeDto.setDepartmentDto( departmentToDepartmentDto( entity.getDepartment() ) );

        return employeeDto;
    }

    @Override
    public Employee dtoToEntity(EmployeeDto dto) {
        if ( dto == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId( dto.getNumber() );
        employee.setLastName( dto.getLastName() );
        employee.setDepartment( departmentDtoToDepartment( dto.getDepartmentDto() ) );

        return employee;
    }

    protected DepartmentDto departmentToDepartmentDto(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentDto departmentDto = new DepartmentDto();

        departmentDto.setId( department.getId() );
        departmentDto.setName( department.getName() );

        return departmentDto;
    }

    protected Department departmentDtoToDepartment(DepartmentDto departmentDto) {
        if ( departmentDto == null ) {
            return null;
        }

        Department department = new Department();

        department.setId( departmentDto.getId() );
        department.setName( departmentDto.getName() );

        return department;
    }
}
