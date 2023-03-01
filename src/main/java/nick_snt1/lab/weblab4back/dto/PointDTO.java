package nick_snt1.lab.weblab4back.dto;

import lombok.Data;
import lombok.NonNull;

@Data 
public class PointDTO {
    @NonNull private Double x, y, r;    
}
