package com.egor.tasks.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "password", length = 120, nullable = false)
    private String password;

    @Column(name = "email", unique = true, length = 50, nullable = false)
    private String email;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Task> authorTasks = new ArrayList<>();

    @OneToMany(mappedBy = "assigned", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Task> assignedTasks = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        var userRole = new HashSet<SimpleGrantedAuthority>();
        userRole.add(new SimpleGrantedAuthority("ROLE_USER"));
        return userRole;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(authorTasks, user.authorTasks) &&
                Objects.equals(assignedTasks, user.assignedTasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password, email, authorTasks, assignedTasks);
    }
}
