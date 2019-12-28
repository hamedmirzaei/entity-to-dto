package spring.boot.entity.dto.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "SKILL_TABLE")
public class SkillEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", unique = true, nullable = false)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToMany(mappedBy = "skills")
    private List<UserEntity> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}
