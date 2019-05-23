package com.codeclan.bookingsystem.BookingSystem.repositories.CourseRepository;

import com.codeclan.bookingsystem.BookingSystem.models.Customer;

import java.util.List;

public interface CourseRepositoryCustom {
    List<Customer> findCustomersByCourseId(Long course);
}
