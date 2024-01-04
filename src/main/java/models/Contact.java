package models;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Contacts\"")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "\"customerId\"")
    private Integer customerId;

    @Column(name = "\"firstName\"", nullable = false, length = 30)
    private String firstName;

    @Column(name = "\"lastName\"", nullable = false, length = 30)
    private String lastName;

    @Column(name = "email", length = 20)
    private String email;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "\"hireDate\"", length = 20)
    private String hireDate;

    @Column(name = "jobid", length = 20)
    private String jobid;

    public Long getid() {
        return id;
    }

    public void setid(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

}