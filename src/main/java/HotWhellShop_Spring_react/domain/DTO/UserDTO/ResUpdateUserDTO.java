package HotWhellShop_Spring_react.domain.DTO.UserDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResUpdateUserDTO {
    private String user_name;
    private String email;
    private String avt;
    private String phone;
    private long id;
}
