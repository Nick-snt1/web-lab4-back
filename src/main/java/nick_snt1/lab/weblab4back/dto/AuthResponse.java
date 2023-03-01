package nick_snt1.lab.weblab4back.dto;

import lombok.NonNull;
import lombok.Builder;
import lombok.Data;

@Data @Builder
public class AuthResponse {
    @NonNull private String token;
}
