package com.codefactory.team3.controller;

import com.codefactory.team3.model.*;
import com.codefactory.team3.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/")
public class MainController {

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping(path = "/hotels")
    public @ResponseBody Iterable<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping(path = "/hotelrooms")
    public @ResponseBody Iterable <Room> getAllRooms(){
        return roomRepository.findAll();
    }

   @Autowired
   private CategoryRepository roomCategorys;

   @GetMapping(path ="/roomCategorys")
    public @ResponseBody Iterable<Category> getAllCategorys(){
        return roomCategorys.findAll();
    }

    @Autowired
    private DateRepository dateRespository;

    @GetMapping(path ="/bookingDate")
    public @ResponseBody Iterable<Bookingdate> getAllDate(){
        return dateRespository.findAll();
    }

    @Autowired
    private HotelServicesRepository serviceRespository;

    @GetMapping(path="/services")
    public @ResponseBody Iterable<HotelServices> getAllService(){
        return serviceRespository.findAll();
    }

    @Autowired
    private LoginRepository loginRepository;

    @GetMapping(path = "/login")
    public @ResponseBody Iterable<Login> getAllLogin() {
        return loginRepository.findAll();
    }

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/user")
    public @ResponseBody Iterable<User> getAllUser() { return userRepository.findAll(); }

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping(path = "/booking")
    public @ResponseBody Iterable<Booking> getAllBooking() { return bookingRepository.findAll(); }

}
