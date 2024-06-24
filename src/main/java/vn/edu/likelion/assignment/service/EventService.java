package vn.edu.likelion.assignment.service;

import vn.edu.likelion.assignment.model.Customer;
import vn.edu.likelion.assignment.model.Event;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public interface EventService {
    void input();
    void inputConsole();
    void getEvents();
    Event getEvent(String id);
    Event addEvent(Event event);
    boolean deleteEvent(String id);
}
