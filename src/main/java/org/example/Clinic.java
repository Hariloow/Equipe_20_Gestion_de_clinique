package org.example;

import java.util.LinkedList;

public class Clinic {
    private final LinkedList<Patient> fileMedecin;
    TriageType medecinTriageType;
    private final LinkedList<Patient> fileRadio;
    TriageType radiologyTriageType;

    public Clinic(TriageType medecinTriageType, TriageType radiologyTriageType) {
        fileMedecin = new LinkedList<>();
        this.medecinTriageType = medecinTriageType;
        fileRadio = new LinkedList<>();
        this.radiologyTriageType = radiologyTriageType;
    }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        Patient patient = new Patient(name, gravity, visibleSymptom);
        fileMedecin.addLast(patient);

        if (visibleSymptom == VisibleSymptom.SPRAIN || visibleSymptom == VisibleSymptom.BROKEN_BONE)
            fileRadio.addLast(patient);
    }

    public Boolean medecinEstVide() {
        return fileMedecin.isEmpty();
    }

    public Boolean radioEstVide() {
        return fileRadio.isEmpty();
    }

    public Patient getPatientMedecin() {
        Patient premierPatient = fileMedecin.getFirst();

        fileMedecin.removeFirst();

        return premierPatient;
    }

    public Patient getPatientRadio() {
        Patient premierPatient = fileRadio.getFirst();

        fileRadio.removeFirst();

        return premierPatient;
    }
}
