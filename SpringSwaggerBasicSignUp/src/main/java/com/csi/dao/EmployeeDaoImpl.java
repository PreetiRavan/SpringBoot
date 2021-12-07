package com.csi.dao;

import com.csi.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

    private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();

    @Override
    public void signUp(Employee employee) {

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        session.save(employee);
        transaction.commit();
    }

    @Override
    public boolean signIn(String empEmailId, String empPassword) {

        Session session = factory.openSession();

        List<Employee> empList = session.createQuery("from Employee").list();

        boolean status = false;

        for(Employee ee : empList) {
            if (ee.getEmpEmailId().equals(empEmailId) && ee.getEmpPassword().equals(empPassword)) {
                status = true;
            }
        }
        return status;
    }
}
