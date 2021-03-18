package com.edu.utez.gespro.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rol")
//@JsonIdentityInfo(scope = Role.class,generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrol")
    private long id;

    @Column(name = "nombre")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "role")
    private List<Employe> employe;


}
