package org.example;

public class Patient {
    private String name;
    private Integer gravite;
    private VisibleSymptom visibleSymptom;

    public Patient() {
        name = "David";
        gravite = 0;
        visibleSymptom = VisibleSymptom.MIGRAINE;
    }

    public Patient(String name, Integer gravity){
        this.name = name;
        this.gravite = gravity;
        this.visibleSymptom = VisibleSymptom.UNKNOW;
    }

    public Patient(String name, Integer gravity, VisibleSymptom symptom) {
        this.name = name;
        this.gravite = gravity;
        this.visibleSymptom = symptom;
    }

    public String getName() {
        return this.name;
    }

    public Integer getGravity() {
        return gravite;
    }

    public VisibleSymptom getSymptom() {
        return visibleSymptom;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Patient) {
            Patient p = (Patient)obj;
            return p.getName().equals(getName()) && p.getGravity() == getGravity()
            && p.getSymptom() == getSymptom(); 
        }

        return false;
    }
}
