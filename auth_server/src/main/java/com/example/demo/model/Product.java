package com.example.demo.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "product")
@Data
public class Product implements Serializable{

	private static final long serialVersionUID = 2205319210288250779L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private Long id;

    @Version
    @Column(name = "version")
    private Integer version;

    @NotEmpty
    @Column(name = "name")
    private String name;

    @Column(name = "available")
    private boolean available;
   

}
