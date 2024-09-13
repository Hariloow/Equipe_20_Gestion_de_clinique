package org.example;

import java.util.LinkedList;

public class WaitingQueue {
    private final TriageType typeTriage;
    private final LinkedList<Patient> file;

    WaitingQueue(TriageType typeTriage){
        this.typeTriage = typeTriage;
        file = new LinkedList<Patient>();
    }

    public TriageType getTypeTriage() {
        return typeTriage;
    }

    public LinkedList<Patient> getFile() {
        return file;
    }
}
