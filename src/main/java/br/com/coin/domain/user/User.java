package br.com.coin.domain.user;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Table(name = "users")
@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first_name;

    private String last_name;

    private String email;

    private String password;

    private String cpf;

    private String phone;

    private Date date_of_birthday;

    private UserRole role;


    public User(UserRequestDTO userRequestDTO) {
        this.first_name = userRequestDTO.first_name();
        this.last_name = userRequestDTO.last_name();
        this.email = userRequestDTO.email();
        this.password = userRequestDTO.password();
        this.cpf = userRequestDTO.cpf();
        this.phone = userRequestDTO.phone();
        this.date_of_birthday = userRequestDTO.date_of_birthday();
        this.role = UserRole.fromValue(userRequestDTO.role());
        //this.data = new DataUser(userRequestDTO.data_user());
    }

    public User(){
    }
    public User(String first_name, String last_name, String email, String password, String cpf,String phone, Date date_of_birthday,String role) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.cpf = cpf;
        this.phone = phone;
        this.date_of_birthday = date_of_birthday;
        this.email = email;
        this.password = password;
        this.role = UserRole.fromValue(role.trim().toLowerCase());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;

    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Date getDate_of_birthday() {
        return date_of_birthday;
    }
    public void setDate_of_birthday(Date date_of_birthday) {
        this.date_of_birthday = date_of_birthday;
    }

    public void updateData(UpdateUser newDataUser){
        if(newDataUser.first_name() != null){
            this.first_name = newDataUser.first_name();
        }
        if(newDataUser.last_name() != null){
            this.last_name = newDataUser.last_name();
        }
        if(newDataUser.email() != null){
            this.email = newDataUser.email();
        }
        if(newDataUser.password() != null){
            this.password = newDataUser.password();
        }
        if(newDataUser.phone() != null){
            this.phone = newDataUser.phone();
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"),new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
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
}
