package nick_snt1.lab.weblab4back.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data @Builder 
public class UserDTO {
    @NonNull private String name, password;
}
