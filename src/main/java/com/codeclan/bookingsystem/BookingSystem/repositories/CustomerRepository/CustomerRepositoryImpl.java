package com.codeclan.bookingsystem.BookingSystem.repositories.CustomerRepository;

import com.codeclan.bookingsystem.BookingSystem.models.Course;
import com.codeclan.bookingsystem.BookingSystem.models.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomerRepositoryImpl {
    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Course> findCoursesByCustomerId(Long customer_id){

        List<Course> result = null;

        Session session = entityManager.unwrap(Session.class);
        try{
            Criteria cr = session.createCriteria(Course.class);
            cr.createAlias("bookings", "bookingAlias");
            cr.add(Restrictions.eq("bookingAlias.customer.id", customer_id));
            result = cr.list();
        }
        catch (HibernateException ex){
            ex.printStackTrace();
        }
        return result;
    }


}
