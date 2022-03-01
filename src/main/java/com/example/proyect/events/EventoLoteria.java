package com.example.proyect.events;

import javafx.event.Event;
import javafx.event.EventHandler;

public class EventoLoteria implements EventHandler {
    @Override
    public void handle(Event event) {
        System.out.println("Mi primer evento FoviFest desde otra clase :)");
    }
}
