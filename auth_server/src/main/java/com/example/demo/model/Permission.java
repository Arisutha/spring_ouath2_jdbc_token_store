package com.example.demo.model;
import lombok.Data;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "permission")
@Data
public class Permission implements Serializable{

	private static final long serialVersionUID = 5290323905768709315L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "name")
	private String name;

}
