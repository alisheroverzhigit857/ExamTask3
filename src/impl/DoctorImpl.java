package impl;

import db.DataBase;
import enums.Gender;
import model.Doctor;
import model.Hospital;
import service.DoctorService;

import javax.print.Doc;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DoctorImpl implements DoctorService<Doctor> {

    private DataBase dataBase;

    public DoctorImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public List<Doctor> addDoctor(Doctor doctor) {
        for (Hospital h : dataBase.getHospitals()) {
            h.getDoctors().add(doctor);
            return h.getDoctors();
        }

        return null;
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return dataBase.getDoctors().stream().filter(doctor -> doctor.getId()==(id)).findFirst().orElse(null);
    }

    @Override
    public List<Doctor> filterByGender(String gender) {
        List<Doctor> list = dataBase.getDoctors().stream().filter(doctor -> doctor.getGender().equals(Gender.MALE)).sorted(Comparator.comparing(Doctor::getGender)).toList();

        return list;

    }

    @Override
    public List<Doctor> getAllDoctors() {
       return dataBase.getDoctors();

    }
}
