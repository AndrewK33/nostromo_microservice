package ru.geekbrains.nostromo.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.nostromo.entity.Rover;

@Repository
public interface RoverRepository extends JpaRepository<Rover, Long> {

}
