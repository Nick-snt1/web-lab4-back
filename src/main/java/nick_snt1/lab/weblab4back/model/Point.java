package nick_snt1.lab.weblab4back.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Data @Builder @AllArgsConstructor @NoArgsConstructor
@Entity @Table(name="web_lab4_points")
public class Point {

    @Id
    @SequenceGenerator(name = "points_seq", sequenceName = "points_seq", allocationSize = 1)
    @GeneratedValue   (strategy = GenerationType.SEQUENCE, generator = "points_seq")
    @JsonIgnore private Long   id;
    private Double x, y, r;
    private String hit;
    @JsonIgnore private String owner;
}
