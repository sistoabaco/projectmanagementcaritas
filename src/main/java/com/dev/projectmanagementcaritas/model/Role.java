package com.dev.projectmanagementcaritas.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "roles")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRole;
    private String description;

    @ManyToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private Collection <User> user;

    public Role(int idRole, String description) {
        this.idRole = idRole;
        this.description = description;
    }
}
