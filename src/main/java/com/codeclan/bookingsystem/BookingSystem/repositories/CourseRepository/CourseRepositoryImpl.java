package com.codeclan.bookingsystem.BookingSystem.repositories.CourseRepository;

import com.codeclan.bookingsystem.BookingSystem.models.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseRepositoryImpl {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Customer> findCustomersByCourseId(Long course){

        List<Customer> result = null;

        Session session = entityManager.unwrap(Session.class);
        try{
            Criteria cr = session.createCriteria(Customer.class);
            cr.createAlias("bookings", "bookingAlias");
            cr.add(Restrictions.eq("bookingAlias.course.id", course));
            result = cr.list();
        }
        catch (HibernateException ex){
            ex.printStackTrace();;
        }
        return result;
    }
}
