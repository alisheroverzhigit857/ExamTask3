package db;

import model.Doctor;
import model.Hospital;
import model.Patient;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    List<Hospital> hospitals = new ArrayList<>();
    List<Doctor> doctors = new ArrayList<>();
    List<Patient> patients = new ArrayList<>();

    public DataBase(List<Hospital> hospita, List<Doctor> doctor, List<Patient> patient) {
        this.hospitals = hospita;
        this.doctors = doctor;
        this.patients = patient;
    }

    public DataBase() {
    }

    public List<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
