package model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class EmployeeDto {

    private String number;

    private String lastName;

    private DepartmentDto departmentDto;

}
