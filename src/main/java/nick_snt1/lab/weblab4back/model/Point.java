package nick_snt1.lab.weblab4back.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity @Table(name="web_lab4_points")
public class Point {

    @Id
    @SequenceGenerator(name = "points_seq", sequenceName = "points_seq", allocationSize = 1)
    @GeneratedValue   (strategy = GenerationType.SEQUENCE, generator = "points_seq")
    @JsonIgnore private Long   id;
    private Double x;
    private Double y;
    private Double r;
    private String hit;
    @JsonIgnore private String owner;
    
    public Point(Double x, Double y, Double r, String hit, String owner) {
        this.x = x; this.y = y; this.r = r; this.hit = hit; this.owner = owner;
    }
}
