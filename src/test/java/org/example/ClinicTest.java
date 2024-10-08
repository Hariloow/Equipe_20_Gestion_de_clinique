package org.example;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class ClinicTest {
    @Test
    void laFileEstInitialementVide() {
        Clinic clinic = new Clinic();
        assertTrue(clinic.estVide());
    }

    @Test
    void quandAjouterPatientAvecMigraine() {
        Clinic clinic = new Clinic();

        Patient patient = new Patient("David", 0, VisibleSymptom.MIGRAINE);
        clinic.triagePatient(patient.getName(), patient.getGravite(), patient.getSymptom());

        Patient p = clinic.getPatientMedecin("David");
        assertTrue(p.equals(patient));

        Patient p2 = clinic.getPatientRadio("David");
        assertNull(p2);
    }

    @Test
    void quandAjouter2Patients_AvecFluFileNonVide() {
        Clinic clinic = new Clinic();

        Patient patientDoe = new Patient("Doe", 0, VisibleSymptom.FLU);

        clinic.triagePatient("John", 0, VisibleSymptom.MIGRAINE);
        clinic.triagePatient(patientDoe.getName(), patientDoe.getGravite(), patientDoe.getSymptom());

        Patient p = clinic.getPatientMedecin(1);
        assertTrue(p.equals(patientDoe));

        Patient p2 = clinic.getPatientRadio("Doe");
        assertNull(p2);
    }

    @Test
    void quandAjouterPatient_AvecEntorse() {
        Clinic clinic = new Clinic();

        Patient patient = new Patient("David", 0, VisibleSymptom.SPRAIN);
        clinic.triagePatient(patient.getName(), patient.getGravite(), patient.getSymptom());

        Patient p = clinic.getPatientMedecin("David");
        assertTrue(p.equals(patient));

        Patient p2 = clinic.getPatientRadio("David");
        assertTrue(p2.equals(patient));
    }
}
