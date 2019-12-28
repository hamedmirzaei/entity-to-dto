package spring.boot.entity.dto.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USER_TABLE")
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "USERNAME", unique = true, nullable = false)
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private AddressEntity address;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_SKILL", joinColumns = {@JoinColumn(referencedColumnName = "ID", name = "USERID")}, inverseJoinColumns = {@JoinColumn(referencedColumnName = "ID", name = "SKILLID")})
    private List<SkillEntity> skills;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public List<SkillEntity> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillEntity> skills) {
        this.skills = skills;
    }
}
