package com.may.phyo.db.student.ds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    @Id
    private int id;
    private String name;
    private String subject;
    public Student(){

    }
}
