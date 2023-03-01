package nick_snt1.lab.weblab4back.repository;

import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import nick_snt1.lab.weblab4back.model.Point;

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {
    List<Point>         findByOwner  (String owner);
    @Transactional long deleteByOwner(String owner);
}
