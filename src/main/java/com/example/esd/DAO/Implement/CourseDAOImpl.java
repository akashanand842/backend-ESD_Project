package com.example.esd.DAO.Implement;

import com.example.esd.Bean.Course;
import com.example.esd.DAO.CourseDAO;
import com.example.esd.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {

    @Override
    public boolean addCourse(Course courseObj) {
        try(Session session= HibernateSessionUtil.getSession()) {
            Transaction transaction=session.beginTransaction();
            session.persist(courseObj);
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
    public List<Course> getCourseList() {
        List<Course> courseList = new ArrayList<>();
        try (Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            for (final Object course : session.createQuery("from Course ").list()) {
                courseList.add((Course) course);
            }
            transaction.commit();
        } catch (HibernateException exception) {
            System.out.println("Hibernate Exception");
            exception.printStackTrace();
        }
        return courseList;
    }


    @Override
    public boolean updateCourse(Course course) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            Query q1 = session.createQuery("from Course where courseCode=:id");
            q1.setParameter("id", course.getCourseCode());
            if(q1.getResultList().size()<1) {
                System.out.println("here");
                return false;
            }
            Query q = session.createQuery("update Course set capacity =: new_capacity,credits=:new_credit  where courseCode=:id");
            q.setParameter("new_capacity", course.getCapacity());
            q.setParameter("new_credit", course.getCredits());
            q.setParameter("id",course.getCourseCode());
            q.executeUpdate();
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public boolean deleteCourse(Course course) {
        try(Session session= HibernateSessionUtil.getSession()) {
            Transaction transaction=session.beginTransaction();

            Query q=session.createQuery("from Course where courseCode=:ID");
            q.setParameter("ID",course.getCourseCode());
            if(q.list().size() != 1){
                return false;
            }
            Course result=(Course)q.list().get(0);
            session.delete(result);
            System.out.println("Delete Function");
            transaction.commit();
            return true;
        }
        catch (HibernateException exception){
            System.out.println("Hibernate Exception");
            System.out.println(exception.getLocalizedMessage());
            return false;
        }
    }
}
