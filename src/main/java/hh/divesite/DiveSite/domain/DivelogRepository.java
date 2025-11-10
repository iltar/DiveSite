package hh.divesite.DiveSite.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DivelogRepository extends CrudRepository<Divelog, Long> {
    List<Divelog> findAllByDiver(User diver);
}
