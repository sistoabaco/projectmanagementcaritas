package com.dev.projectmanagementcaritas.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "employees")
public class Employee implements Serializable {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmployee;
    private String firstName;
    private String lastName;
    private String gender;
    private String address;
    private String cellphone;
    private String email;

    @OneToOne
    private User user;
}
