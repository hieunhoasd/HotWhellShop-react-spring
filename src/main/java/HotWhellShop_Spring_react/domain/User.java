package HotWhellShop_Spring_react.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @NotBlank(message = "user_name khong duoc de trong")
    private String user_name;

    @NotBlank(message = "password khong duoc de trong")

    private String password;

    @NotBlank(message = "email khong duoc de trong")
    private String email;

    private String avt;

    private String phone;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
