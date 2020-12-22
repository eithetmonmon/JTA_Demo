package com.may.phyo.service;

import com.may.phyo.db.address.dao.AddressDao;
import com.may.phyo.db.address.ds.Address;
import com.may.phyo.db.student.dao.StudentDao;
import com.may.phyo.db.student.ds.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
    private final StudentDao studentDao;
    private final AddressDao addressDao;

    public StudentService(StudentDao studentDao, AddressDao addressDao) {
        this.studentDao = studentDao;
        this.addressDao = addressDao;
    }
    @Transactional
    public void purgeData(){
        studentDao.deleteAll();
        addressDao.deleteAll();
    }

    @Transactional
    public void saveData(){
        System.out.println("Saving Student..........");
        studentDao.save(new Student(1,"John Cedrick","Design Engineer"));
        System.out.println("Saved Student");

        System.out.println("Saving Address");
        addressDao.save(new Address(1,"Golden Lane","1005"));
        System.out.println("Saved Address");
    }

    @Transactional
    public void listAllData(){
        System.out.println("List of Studnet");
        studentDao.findAll().forEach(System.out::println);
        System.out.println("List of Address");
        addressDao.findAll().forEach(System.out::println);
    }
}
