package vn.edu.likelion.project.day25062024.assignment.service.impl;

import vn.edu.likelion.project.day25062024.assignment.model.Event;
import vn.edu.likelion.project.day25062024.assignment.model.Storage;
import vn.edu.likelion.project.day25062024.assignment.service.EventService;
import vn.edu.likelion.helpers.DateFormat;
import vn.edu.likelion.helpers.Input;


public class EventServiceImpl implements EventService {

    @Override
    public void input() {
        System.out.print("Nhập số lượng sự kiện: ");
        int numInput = Input.inputInt();
        if (numInput > 0 && numInput <= 5) {
            if (Storage.eventArrayList.size() + numInput <= 5) {
                for (int i = 1; i <= numInput; i++) {
                    System.out.println("----------------------" + i + "----------------------");
                    inputConsole();
                }
            } else {
                throw new RuntimeException("Already have " + Storage.eventArrayList.size() + ", can not add more than 5 or less than 1 events");
            }
        } else {
            throw new RuntimeException("Can not add more than 5 or less than 1 events");
        }
    }

    @Override
    public void getEvents() {
        for (Event e : Storage.eventArrayList) {
            e.show();
            System.out.println("------------------------------------");
        }
    }

    @Override
    public Event getEvent(String id) {
        for (Event event : Storage.eventArrayList) {
            if (event.getId().equalsIgnoreCase(id)) {
                return event;
            }
        }
        throw new RuntimeException("Event with id " + id + " does not exist");
    }

    @Override
    public Event addEvent(Event event) {
        if (checkEventExists(event.getId())) {
            throw new RuntimeException("Event with id " + event.getId() + " already exists");
        } else if (!checkAvailableToAdd()) {
            throw new RuntimeException("Can not add more than 5 events");
        } else if (Storage.eventArrayList.add(event)) {
            return Storage.eventArrayList.get(Storage.eventArrayList.size() - 1);
        } else {
            throw new RuntimeException("Event with id " + event.getId() + " can not be added");
        }
    }

    @Override
    public boolean deleteEvent(String id) {
        for (int i = 0; i < Storage.eventArrayList.size(); i++) {
            if (Storage.eventArrayList.get(i).getId().equals(id)) {
                Storage.eventArrayList.remove(i);
                return true;
            }
        }
        throw new RuntimeException("Event with id " + id + " does not exist");
    }

    public boolean checkEventExists(String eventId) {
        for (Event e : Storage.eventArrayList) {
            return e.getId().equals(eventId);
        }
        return false;
    }

    public boolean checkAvailableToAdd() {
        return Storage.eventArrayList.size() < 6;
    }

    @Override
    public void inputConsole() {
        if (checkAvailableToAdd()) {
            Event event = new Event();
            System.out.println("Nhập tên sự kiện");
            event.setName(Input.inputString());
            System.out.println("Nhập ngày tổ chức");
            System.out.println("format: " + DateFormat.PATTERN);
            event.setDateStart(DateFormat.parseStringToLocalDate(Input.inputString()));
            System.out.println("Nhập số lượng khách mời tối đa");
            event.setSlot(Input.inputInt());
            addEvent(event);
        } else {
            throw new RuntimeException("Can not add more than 5 events");
        }
    }
}
