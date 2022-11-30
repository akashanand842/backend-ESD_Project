package com.example.esd.DAO.Implement;

import com.example.esd.Bean.Employee;
import com.example.esd.DAO.EmployeeDAO;
import com.example.esd.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public boolean addEmployee(Employee employee) {
        try(Session session= HibernateSessionUtil.getSession()) {
            Transaction transaction=session.beginTransaction();
            session.persist(employee);
            transaction.commit();
            return true;
        }
        catch (HibernateException exception){
            System.out.println("Hibernate Exception");
            System.out.println(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public boolean verifyEmployee(Employee employee) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            Query q = session.createQuery("from Employee where department=:dept and userId=:uid and password =:passwd");
            q.setParameter("dept", "Admin");
            q.setParameter("uid", employee.getUserId());
            q.setParameter("passwd",employee.getPassword());
            if(q.getResultList().size()<1) {
                System.out.println(" Employee not login here");
                return false;
            }
            transaction.commit();
            return true;
        }
        catch (HibernateException exception) {
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }
}
