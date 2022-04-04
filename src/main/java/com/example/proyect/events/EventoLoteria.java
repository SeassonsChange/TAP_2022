package com.example.proyect.events;

import javafx.event.Event;
import javafx.event.EventHandler;

import java.util.Timer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


public class EventoLoteria implements EventHandler {
    private Timer tiempo;





    @Override
    public void handle(Event event) {
        System.out.println("Mi primer evento FoviFest desde otra clase :)");
    }


}
