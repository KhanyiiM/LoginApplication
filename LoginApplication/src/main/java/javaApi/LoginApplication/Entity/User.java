package javaApi.LoginApplication.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User{

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String email;
private String password;

}

     

