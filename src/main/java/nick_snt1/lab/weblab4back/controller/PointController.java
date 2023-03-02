package nick_snt1.lab.weblab4back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

import nick_snt1.lab.weblab4back.model.Point;
import nick_snt1.lab.weblab4back.util.AreaChecker;
import nick_snt1.lab.weblab4back.dto.PointDTO;
import nick_snt1.lab.weblab4back.service.PointService;

@RestController
@RequestMapping("/api/points")
@CrossOrigin
public class PointController {

    @Autowired private PointService pointService;
    
    @GetMapping("/get_points")
    public ResponseEntity<?> getPoints(Principal principal) {
        return ResponseEntity.ok(pointService.getPoints(principal.getName()));
    }

    @PostMapping("/add_point")
    public ResponseEntity<?> addPoint(@Validated @RequestBody PointDTO dto, Principal principal) {
        Point point = Point.builder()
            .x(dto.getX()).y(dto.getY()).r(dto.getR())
            .hit(AreaChecker.isHit(dto.getX(), dto.getY(), dto.getR()) ? "Hit" : "Miss")
            .owner(principal.getName()).build();
        pointService.addPoint(point);
        return ResponseEntity.ok(point);
    }

    @DeleteMapping("/delete_points")
    public ResponseEntity<?> deletePoints(Principal principal) {
        pointService.deletePoints(principal.getName());
        return ResponseEntity.ok().build();
    }
}
