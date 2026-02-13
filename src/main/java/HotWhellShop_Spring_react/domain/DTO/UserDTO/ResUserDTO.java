package HotWhellShop_Spring_react.domain.DTO.UserDTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResUserDTO {
    private String user_name;
    private String email;
    private String avt;
    private String phone;
    private long id;
}
