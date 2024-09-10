package org.example;

import static org.junit.Assert.*;
import org.junit.Test;

public class ClinicTest {
    @Test
    public void quandAjouterPatientAvecMigraine() {
        Clinic clinic = new Clinic(TriageType.FIFO, TriageType.FIFO);

        Patient patient = new Patient("David", 0, VisibleSymptom.MIGRAINE);
        clinic.triagePatient(patient.getName(), patient.getGravite(), patient.getSymptom());

        assertEquals(clinic.getPatientMedecin(), patient);

        assertTrue(clinic.radioEstVide());
    }

    @Test
    public void quandAjouter2Patients_AvecOneFluFileNonVide() {
        Clinic clinic = new Clinic(TriageType.FIFO, TriageType.FIFO);

        Patient patientJohn = new Patient("John", 0, VisibleSymptom.MIGRAINE);
        Patient patientDoe = new Patient("Doe", 0, VisibleSymptom.FLU);

        clinic.triagePatient(patientJohn.getName(), patientJohn.getGravite(), patientJohn.getSymptom());
        clinic.triagePatient(patientDoe.getName(), patientDoe.getGravite(), patientDoe.getSymptom());

        assertEquals(clinic.getPatientMedecin(), patientJohn);
        assertEquals(clinic.getPatientMedecin(), patientDoe);

        assertTrue(clinic.radioEstVide());
    }

    @Test
    public void quandAjouterPatient_AvecEntorse() {
        Clinic clinic = new Clinic(TriageType.FIFO, TriageType.FIFO);

        Patient patient = new Patient("David", 0, VisibleSymptom.SPRAIN);
        clinic.triagePatient(patient.getName(), patient.getGravite(), patient.getSymptom());

        assertEquals(clinic.getPatientMedecin(), patient);

        assertEquals(clinic.getPatientRadio(), patient);
    }

    @Test
    public void quandAjouterPatient_AvecFLU7() {
        Clinic clinic = new Clinic(TriageType.FIFO, TriageType.FIFO);

        Patient patient = new Patient("David", 0, VisibleSymptom.SPRAIN);
        clinic.triagePatient(patient.getName(), patient.getGravite(), patient.getSymptom());

        assertEquals(clinic.getPatientMedecin(), patient);

        assertEquals(clinic.getPatientRadio(), patient);
    }
}
