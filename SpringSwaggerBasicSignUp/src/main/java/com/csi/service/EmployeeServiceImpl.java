package com.csi.service;

import com.csi.dao.EmployeeDao;
import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDaoImpl;


    @Override
    public void signUp(Employee employee) {

        employeeDaoImpl.signUp(employee);
    }

    @Override
    public boolean signIn(String empEmailId, String empPassword) {

        return employeeDaoImpl.signIn(empEmailId,empPassword);
    }
}
