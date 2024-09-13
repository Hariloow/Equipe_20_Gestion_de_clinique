package org.example;

import java.util.LinkedList;

public class CommunityCenter {
    private final WaitingQueue file;

    public CommunityCenter(TriageType triageType) {
        file = new WaitingQueue(triageType);
    }

    public void triagePatient(Patient patient) {
        if (patient.getSymptom() == VisibleSymptom.CORONAVIRUS)
            return;

        if (file.getTypeTriage() == TriageType.FIFO)
            file.getFile().addLast(patient);
        else if (file.getTypeTriage() == TriageType.GRAVITY) {
            int index = 0;
            while (index < file.getFile().size() && patient.getGravity() >= 5 && file.getFile().get(index).getGravity() >= patient.getGravity())
                index++;

            file.getFile().add(index, patient);
        }
    }

    public Patient getPatient(){
        Patient patient = file.getFile().getFirst();

        file.getFile().removeFirst();

        return patient;
    }

    public Boolean isPatientCovidInQueue() {
        int index = 0;

        while (index < file.getFile().size()) {
            if (file.getFile().get(index).getSymptom() == VisibleSymptom.CORONAVIRUS)
                return true;
            index++;
        }

        return false;
    }
}
