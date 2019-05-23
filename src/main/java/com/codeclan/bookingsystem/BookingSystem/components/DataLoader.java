package com.codeclan.bookingsystem.BookingSystem.components;

import com.codeclan.bookingsystem.BookingSystem.models.Booking;
import com.codeclan.bookingsystem.BookingSystem.models.Course;
import com.codeclan.bookingsystem.BookingSystem.models.Customer;
import com.codeclan.bookingsystem.BookingSystem.repositories.BookingRepository.BookingRepository;
import com.codeclan.bookingsystem.BookingSystem.repositories.CourseRepository.CourseRepository;
import com.codeclan.bookingsystem.BookingSystem.repositories.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CourseRepository courseRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args) {
        Customer customer1 = new Customer("Bob", "Edinburgh", 25);
        customerRepository.save(customer1);
        Customer customer2 = new Customer("James", "Iverness", 26);
        customerRepository.save(customer2);

        Course course1 = new Course("Java", "Glasgow", 4);
        courseRepository.save(course1);
        Course course2 = new Course("JavaScript", "Edinburgh", 3);
        courseRepository.save(course2);

        Booking booking1 = new Booking("25-06-2019", customer1, course1);
        bookingRepository.save(booking1);
        Booking booking2 = new Booking("25-04-2019", customer1, course2);
        bookingRepository.save(booking2);
        Booking booking3 = new Booking("25-03-2019", customer2, course1);
        bookingRepository.save(booking3);







    }
}
