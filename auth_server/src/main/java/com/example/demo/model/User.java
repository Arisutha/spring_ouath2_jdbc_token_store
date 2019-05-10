package com.example.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User implements Serializable{
	private static final long serialVersionUID = 4852717085561061283L;


	public User() {
    }

    public User(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.enabled = user.isEnabled();
        this.accountNonExpired = user.isAccountNonExpired();
        this.credentialsNonExpired = user.isCredentialsNonExpired();
        this.accountNonLocked = user.isAccountNonLocked();
        this.roles = user.getRoles();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "firstName")
    private String firstName;
    
    @Column(name = "lastName")
    private String lastName;
    
    @Column(name = "age", length = 3)
    private Integer age;
    
    @Column(name = "salary")
    private BigDecimal salary;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "enabled")
    private boolean enabled;
    
    @Column(name = "accountNonExpired")
    private boolean accountNonExpired;
    
    @Column(name = "credentialsNonExpired")
    private boolean credentialsNonExpired;
    
    @Column(name = "accountNonLocked")
    private boolean accountNonLocked;
    
    @Column(name = "createdBy")
    private String createdBy;
    
    @Column(name = "createdDate")
    private Date createdDate;
    
    @Column(name = "changeBy")
    private String changeBy;
    
    @Column(name = "changeDate")
    private Date changeDate;
    
    @Column(name = "deletedBy")
    private String deletedby;
    
    @Column(name = "deletedDate")
    private Date deletedDate;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_user", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;

}
