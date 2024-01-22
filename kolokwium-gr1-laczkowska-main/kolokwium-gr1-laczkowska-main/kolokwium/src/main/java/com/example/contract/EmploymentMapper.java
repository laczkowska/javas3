package com.example.contract;
import com.example.model.Employment;

public class EmploymentMapper {
    public EmploymentDto mapEmploymentToDto(Employment employment) {
        EmploymentDto employmentDto = new EmploymentDto();
        employmentDto.setCompany(employment.getCompany());
        employmentDto.setPosition(employment.getPosition());
        employmentDto.setStartDate(employment.getStartDate());
        employmentDto.setEndDate(employment.getEndDate());
        return employmentDto;
    }
}
