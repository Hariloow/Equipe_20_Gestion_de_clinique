package org.example;

public class Clinic {
    private final WaitingQueue fileMedecin;
    private final WaitingQueue fileRadio;

    public Clinic(TriageType medecinTriageType, TriageType radiologyTriageType) {
        fileMedecin = new WaitingQueue(medecinTriageType);
        fileRadio = new WaitingQueue(radiologyTriageType);
    }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        if(visibleSymptom == VisibleSymptom.CORONAVIRUS)
            return;

        Patient patient = new Patient(name, gravity, visibleSymptom);

        addPatientList(fileMedecin, patient);

        if (visibleSymptom == VisibleSymptom.SPRAIN || visibleSymptom == VisibleSymptom.BROKEN_BONE)
            addPatientList(fileRadio, patient);
    }

    public Boolean medecinEstVide() {
        return fileMedecin.getFile().isEmpty();
    }

    public Boolean radioEstVide() {
        return fileRadio.getFile().isEmpty();
    }

    public Patient getPatientMedecin() {
        Patient premierPatient = fileMedecin.getFile().getFirst();

        fileMedecin.getFile().removeFirst();

        return premierPatient;
    }

    public Patient getPatientRadio() {
        Patient premierPatient = fileRadio.getFile().getFirst();

        fileRadio.getFile().removeFirst();

        return premierPatient;
    }

    public void addPatientList(WaitingQueue queue, Patient patient){
        if (queue.getTypeTriage() == TriageType.FIFO || patient.getGravity() <= 5)
            queue.getFile().addLast(patient);
        else if (queue.getTypeTriage() == TriageType.GRAVITY) {
            int index = 0;
            while (index < queue.getFile().size() && patient.getGravity() >= 5 && queue.getFile().get(index).getGravity() >= patient.getGravity())
                index++;

            queue.getFile().add(index, patient);
        }
    }

    public Boolean isPatientCovidInMedecinList() {
        int index = 0;

        while (index < fileMedecin.getFile().size()) {
            if (fileMedecin.getFile().get(index).getSymptom() == VisibleSymptom.CORONAVIRUS)
                return true;
            index++;
        }

        return false;
    }
}
