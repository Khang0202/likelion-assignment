package vn.edu.likelion.project.day25062024.assignment.service;

import vn.edu.likelion.project.day25062024.assignment.model.Event;

public interface EventService {
    void input();

    void inputConsole();

    void getEvents();

    Event getEvent(String id);

    Event addEvent(Event event);

    boolean deleteEvent(String id);
}
