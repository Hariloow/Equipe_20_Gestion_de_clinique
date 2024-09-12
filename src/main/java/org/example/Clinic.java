package org.example;

import java.util.LinkedList;

public class Clinic {
    private final LinkedList<Patient> fileMedecin;
    private final LinkedList<Patient> fileRadio;
    TriageType medecinTriageType;
    TriageType radiologyTriageType;

    public Clinic(TriageType medecinTriageType, TriageType radiologyTriageType) {
        fileMedecin = new LinkedList<>();
        fileRadio = new LinkedList<>();
        this.medecinTriageType = medecinTriageType;
        this.radiologyTriageType = radiologyTriageType;
    }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        Patient patient = new Patient(name, gravity, visibleSymptom);

        if (medecinTriageType == TriageType.FIFO || patient.getGravite() <= 5)
            fileMedecin.addLast(patient);
        else if (medecinTriageType == TriageType.GRAVITY) {
            int index = 0;
            while (index < fileMedecin.size() && fileMedecin.get(index).getGravite() >= patient.getGravite()) {
                index++;
            }
            fileMedecin.add(index, patient);
        }

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
