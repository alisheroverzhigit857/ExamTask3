package impl;

import db.DataBase;
import model.Hospital;
import service.HospitalService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HospitalImpl implements HospitalService {

    private DataBase dataBase;

    public HospitalImpl() {
    }

    public HospitalImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public List<Hospital> addHospital(Hospital hospital) {
        List<Hospital>hospitals = dataBase.getHospitals();
        hospitals.add(hospital);
        return hospitals;

    }

    @Override
    public List<Hospital> addHospitals(List<Hospital> hospitals) {
        dataBase.getHospitals().addAll(hospitals);
        return hospitals;
    }

    @Override
    public Hospital getHospitalById(Long id) {
        for (Hospital h : dataBase.getHospitals()) {
            if (h.getId().equals(id)){
                return h;

            }
        }
        return null;
    }

    @Override
    public List<Hospital> getAllHospitals() {
       return dataBase.getHospitals();

    }

    @Override
    public void updateHospital(Long id, Hospital hospital) {
        Hospital hospital1 = getHospitalById(id);
        hospital1.setName(hospital.getName());
        hospital1.setAddress(hospital.getAddress());

    }

    @Override
    public List<Hospital> sortHospitalByName(String sort) {

     List<Hospital>hospitals = dataBase.getHospitals();
        hospitals = hospitals.stream().sorted(Comparator.comparing(Hospital::getName)).collect(Collectors.toList());
        return hospitals;
    }
}
