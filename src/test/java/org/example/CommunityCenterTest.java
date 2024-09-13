package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class CommunityCenterTest {

    @Test
    public void ajouterPatientFIFONonVide_FLU_secondDansListe(){
        CommunityCenter communityCenter = new CommunityCenter(TriageType.FIFO);

        Patient patientJohn = new Patient("John", 0, VisibleSymptom.FLU);
        Patient patientDoe = new Patient("Doe", 0, VisibleSymptom.FLU);

        communityCenter.triagePatient(patientJohn);
        communityCenter.triagePatient(patientDoe);

        assertEquals(communityCenter.getPatient(), patientJohn);
        assertEquals(communityCenter.getPatient(), patientDoe);
    }

    @Test
    public void ajouterPatientGravityNonVide_FLU7_premierDansListe(){
        CommunityCenter communityCenter = new CommunityCenter(TriageType.GRAVITY);

        Patient patientJohn = new Patient("John", 4, VisibleSymptom.FLU);
        Patient patientDoe = new Patient("Doe", 7, VisibleSymptom.FLU);

        communityCenter.triagePatient(patientJohn);
        communityCenter.triagePatient(patientDoe);

        assertEquals(communityCenter.getPatient(), patientDoe);
    }
}
