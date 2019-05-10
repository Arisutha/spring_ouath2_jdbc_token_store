package com.example.demo.model;

import java.io.Serializable;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
@Data
public class Role implements Serializable{

	private static final long serialVersionUID = -2975877849722398826L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "permission_role", joinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "permission_id", referencedColumnName = "id")})
    private List<Permission> permissions;


}
