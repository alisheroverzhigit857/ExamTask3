package impl;

import db.DataBase;
import enums.Gender;
import model.Hospital;
import model.Patient;
import service.PatientService;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class PatientImpl implements PatientService {

    private DataBase dataBase;

    public PatientImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public List<Patient> addHospital(List<Patient> patients) {
        for (Hospital h : dataBase.getHospitals()) {
            h.setPatients(patients);
            return h.getPatients();
        }

        return null;
    }

    @Override
    public Patient getPatientByfirstName(String name) {
        List<Patient>patients = dataBase.getPatients();
        Optional<Patient> patientOptional = patients.stream()
                .filter(patient -> patient.getFirstName().equalsIgnoreCase(name))
                .findFirst();
        return patientOptional.orElse(null);
    }

    @Override
    public List<Patient> getAllPatients() {
       return dataBase.getPatients();

    }

    @Override
    public void groupingByGender() {
        dataBase.getPatients().stream().filter(patient -> patient.getGender().equals(Gender.MALE))
                .sorted(Comparator.comparing(Patient::getGender)).distinct().toList().forEach(System.out::println);
    }

    @Override
    public List<Patient> filterByAge() {
        List<Patient> list = dataBase.getPatients().stream().filter(patient -> patient.getAge() > 30)
                .sorted(Comparator.comparing(Patient::getAge)).distinct().toList();
        return list;
    }
}
