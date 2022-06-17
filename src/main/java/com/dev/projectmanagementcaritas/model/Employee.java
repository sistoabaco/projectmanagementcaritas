package com.dev.projectmanagementcaritas.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

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
//    private String email;
    private String provenance; //district

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date dateBirth;

    //About Contract
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date dateStart;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date dateEnd;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "employee_project",
            joinColumns = @JoinColumn(
                    name = "idEmployee", referencedColumnName = "idEmployee"),
            inverseJoinColumns = @JoinColumn(
                    name = "idProject", referencedColumnName = "idProject"))
    private Collection <Project> project;

}
