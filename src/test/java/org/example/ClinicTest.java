package org.example;

import static org.junit.Assert.*;
import org.junit.Test;

public class ClinicTest {
    @Test
    public void quandAjouterPatientAvecMigraine() {
        Clinic clinic = new Clinic(TriageType.FIFO, TriageType.FIFO);

        Patient patient = new Patient("David", 0, VisibleSymptom.MIGRAINE);
        clinic.triagePatient(patient.getName(), patient.getGravity(), patient.getSymptom());

        assertEquals(clinic.getPatientMedecin(), patient);

        assertTrue(clinic.radioEstVide());
    }

    @Test
    public void quandAjouter2Patients_AvecOneFluFileNonVide() {
        Clinic clinic = new Clinic(TriageType.FIFO, TriageType.FIFO);

        Patient patientJohn = new Patient("John", 0, VisibleSymptom.MIGRAINE);
        Patient patientDoe = new Patient("Doe", 0, VisibleSymptom.FLU);

        clinic.triagePatient(patientJohn.getName(), patientJohn.getGravity(), patientJohn.getSymptom());
        clinic.triagePatient(patientDoe.getName(), patientDoe.getGravity(), patientDoe.getSymptom());

        assertEquals(clinic.getPatientMedecin(), patientJohn);
        assertEquals(clinic.getPatientMedecin(), patientDoe);

        assertTrue(clinic.radioEstVide());
    }

    @Test
    public void quandAjouterPatient_AvecEntorse() {
        Clinic clinic = new Clinic(TriageType.FIFO, TriageType.FIFO);

        Patient patient = new Patient("David", 0, VisibleSymptom.SPRAIN);
        clinic.triagePatient(patient.getName(), patient.getGravity(), patient.getSymptom());

        assertEquals(clinic.getPatientMedecin(), patient);

        assertEquals(clinic.getPatientRadio(), patient);
    }

    @Test
    public void quandAjouterPatient_AvecFLU7() {
        Clinic clinic = new Clinic(TriageType.FIFO, TriageType.FIFO);

        Patient patient = new Patient("David", 0, VisibleSymptom.SPRAIN);
        clinic.triagePatient(patient.getName(), patient.getGravity(), patient.getSymptom());

        assertEquals(clinic.getPatientMedecin(), patient);

        assertEquals(clinic.getPatientRadio(), patient);
    }

    @Test
    public void ajouterPatientMedecinGravityPasVide_avecFLU7_trier(){
        Clinic clinic = new Clinic(TriageType.GRAVITY, TriageType.FIFO);

        Patient patientJohn = new Patient("John",4 , VisibleSymptom.MIGRAINE);
        Patient patientDoe = new Patient("Doe", 7, VisibleSymptom.FLU);

        clinic.triagePatient(patientJohn.getName(), patientJohn.getGravity(), patientJohn.getSymptom());
        clinic.triagePatient(patientDoe.getName(), patientDoe.getGravity(), patientDoe.getSymptom());

        assertEquals(clinic.getPatientMedecin(), patientDoe);
    }

    @Test
    public void ajouterPatientMedecinGravityRadioFifoPasVide_avecBB7_trier(){
        Clinic clinic = new Clinic(TriageType.GRAVITY, TriageType.FIFO);

        Patient patientJohn = new Patient("John",4 , VisibleSymptom.BROKEN_BONE);
        Patient patientDoe = new Patient("Doe", 7, VisibleSymptom.BROKEN_BONE);

        clinic.triagePatient(patientJohn.getName(), patientJohn.getGravity(), patientJohn.getSymptom());
        clinic.triagePatient(patientDoe.getName(), patientDoe.getGravity(), patientDoe.getSymptom());

        assertEquals(clinic.getPatientRadio(), patientJohn);
        assertEquals(clinic.getPatientRadio(), patientDoe);
    }

    @Test
    public void ajouterPatientMedecinRadioGravityPasVide_avecBB7_trier(){
        Clinic clinic = new Clinic(TriageType.GRAVITY, TriageType.GRAVITY);

        Patient patientJohn = new Patient("John",4 , VisibleSymptom.BROKEN_BONE);
        Patient patientDoe = new Patient("Doe", 7, VisibleSymptom.BROKEN_BONE);

        clinic.triagePatient(patientJohn.getName(), patientJohn.getGravity(), patientJohn.getSymptom());
        clinic.triagePatient(patientDoe.getName(), patientDoe.getGravity(), patientDoe.getSymptom());

        assertEquals(clinic.getPatientRadio(), patientDoe);
    }

    @Test
    public void ajouterPatient_avecCovid_renvoyerChezLui(){
        Clinic clinic = new Clinic(TriageType.GRAVITY, TriageType.GRAVITY);

        Patient patientJohn = new Patient("John",1000000 , VisibleSymptom.CORONAVIRUS);

        clinic.triagePatient(patientJohn.getName(), patientJohn.getGravity(), patientJohn.getSymptom());

        assertFalse(clinic.isPatientCovidInMedecinList());
    }
}
