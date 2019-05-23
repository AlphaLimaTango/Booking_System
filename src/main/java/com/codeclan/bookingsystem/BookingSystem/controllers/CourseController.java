package com.codeclan.bookingsystem.BookingSystem.controllers;

import com.codeclan.bookingsystem.BookingSystem.models.Course;
import com.codeclan.bookingsystem.BookingSystem.repositories.BookingRepository.BookingRepository;
import com.codeclan.bookingsystem.BookingSystem.repositories.CourseRepository.CourseRepository;
import com.codeclan.bookingsystem.BookingSystem.repositories.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/ratings/{rating}")
    public List<Course> findCoursesByRating(@PathVariable int rating){
        return courseRepository.findCoursesByRating(rating);
    }

    @GetMapping(value = "/customers/{customer_id}")
    public List<Course> findCoursesByCustomerId(@PathVariable Long customer_id){
        return courseRepository.findCoursesByCustomerId(customer_id);
    }
}
