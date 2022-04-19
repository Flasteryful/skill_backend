package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Employee {

    private String id;

    private String lastName;

    private Department department;

}