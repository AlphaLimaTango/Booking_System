package com.codeclan.bookingsystem.BookingSystem.repositories.CourseRepository;

import com.codeclan.bookingsystem.BookingSystem.models.Course;
import com.codeclan.bookingsystem.BookingSystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findCoursesByRating(int rating);


    List<Customer> findCustomersByCourseId(Long course);


    List<Course> findCoursesByCustomerId(Long customer_id);
}
