package nick_snt1.lab.weblab4back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

import nick_snt1.lab.weblab4back.model.Point;
import nick_snt1.lab.weblab4back.util.AreaChecker;
import nick_snt1.lab.weblab4back.dto.PointDTO;
import nick_snt1.lab.weblab4back.service.PointService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class PointController {

    @Autowired private PointService pointService;
    
    @GetMapping("/get_table")
    public List<Point> getPoints(Principal principal) {
        return pointService.getPoints("user");//principal.getName()
    }

    @PostMapping("/add")
    public Point addPoint(@RequestBody PointDTO pointDTO, Principal principal) {
        Point point = new Point(
            pointDTO.getX(), pointDTO.getY(), pointDTO.getR(), 
            AreaChecker.isHit(pointDTO.getX(), pointDTO.getY(), pointDTO.getR()) ? "Hit" : "Miss","user"
        ); //principal.getName()
        pointService.addPoint(point);
        return point;
    }

    @DeleteMapping("/delete")
    public void deletePoints(Principal principal) {
        pointService.deletePoints("user");//principal.getName()
    }
}
