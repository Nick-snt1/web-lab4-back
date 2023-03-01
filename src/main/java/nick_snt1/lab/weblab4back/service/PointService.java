package nick_snt1.lab.weblab4back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import nick_snt1.lab.weblab4back.model.Point;
import nick_snt1.lab.weblab4back.repository.PointRepository;

@Service
public class PointService {
    
    @Autowired PointRepository repo;

    public void addPoint(Point point) {
        repo.save(point);
    }
    
    public List<Point> getPoints(String owner) {
        return repo.findByOwner(owner);
    }

    public void deletePoints(String owner) {
        repo.deleteByOwner(owner);
    }
}
