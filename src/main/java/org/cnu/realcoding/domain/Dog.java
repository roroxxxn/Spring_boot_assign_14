package org.cnu.realcoding.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor  // constructer 자동 정의됨
@AllArgsConstructor
public class Dog {
    private String name;
    private String kind;
    private String ownerName;
    private String ownerPhoneNumber;
    private List<String> medicalRecords;
    private int age;


}
