import db.DataBase;
import enums.Gender;
import impl.DoctorImpl;
import impl.HospitalImpl;
import impl.PatientImpl;
import model.Doctor;
import model.Hospital;
import model.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Patient>patients = new ArrayList<>(
                List.of(new Patient(1L,"Asan","Asanov","0779235467", Gender.MALE,35)));
        List<Patient>patient3 = new ArrayList<>(
                List.of(new Patient(1L,"erik","erikov","0779235467", Gender.MALE,35)));
        List<Patient>patients2 = new ArrayList<>(
                List.of(new Patient(1L,"Uson","Usonov","0779235678", Gender.MALE,24)));


        List<Doctor>doctors = new ArrayList<>(
                List.of(new Doctor(1L,"Manas","Abdugany uulu","manas@gmail.com",patients,Gender.MALE)));

        List<Doctor>doctors2 = new ArrayList<>(
                List.of(new Doctor(2L,"Nurik","Alymbai uulu","nur@gmail.com",patients,Gender.MALE)));

        List<Hospital>hospitalList = new ArrayList<>(
                List.of(new Hospital(2L,"Bishkekskiy","City Bishkek",doctors2,patients2))
        );

        DataBase dataBase = new DataBase();
        HospitalImpl hospital = new HospitalImpl(dataBase);
        DoctorImpl doctor = new DoctorImpl(dataBase);
        PatientImpl patient = new PatientImpl(dataBase);
        while (true){
            int a = new Scanner(System.in).nextInt();
            switch (a){
                case 1:
                    System.out.println("Add hospital!");
                    System.out.println(hospital.addHospital(new Hospital(1L, "Respublicansliy", "Ala-Too", doctors, patients)));
                    break;
                case 2:
                    System.out.println("Add hospitals!");
                    System.out.println(hospital.addHospitals(hospitalList));
                    break;
                case 3:
                    System.out.println("Get hospital by ID");
                    System.out.println(hospital.getHospitalById(1L));
                    break;
                case 4:
                    System.out.println("Get all hospitals");
                    System.out.println(hospital.getAllHospitals());
                    break;
                case 5:
                    System.out.println("Update hospital");
                    hospital.updateHospital(2L,new Hospital(3L,"Oshskiy","Osh"));
                    break;
                case 6:
                    System.out.println("Sort Hospital by name ");
                    System.out.println(hospital.sortHospitalByName("A"));
                    break;
                case 7:
                    System.out.println(doctor.addDoctor(new Doctor(1L, "Malik", "Malikov", "malik@gmail", patients, Gender.MALE)));
                    break;
                case 8:
                    System.out.println(doctor.getDoctorById(2L));
                    break;
                case 9:
                    System.out.println(doctor.filterByGender("MALE"));
                    break;
                case 10:
                    System.out.println(doctor.getAllDoctors());
                    break;
                case 11:
                    System.out.println(patient.addHospital(patient3));
                    break;
                case 12:
                    System.out.println(patient.getPatientByfirstName("Asan"));
                    break;
                case 13:
                    System.out.println(patient.getAllPatients());
                    break;
                case 14:
                    patient.groupingByGender();
                case 15:
                    System.out.println(patient.filterByAge());
            }
        }
    }
}