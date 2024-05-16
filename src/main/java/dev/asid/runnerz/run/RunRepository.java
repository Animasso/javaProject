package dev.asid.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {
    private final List<Run>runs = new ArrayList<>();

    List<Run> findAll(){
    return runs;
    }
    Optional<Run> findById(Integer id){
    return runs.stream()
            .filter(run -> run.id()==id)
            .findFirst();

    }
    void create(Run run){
        runs.add(run);
    }

    void update(Run run, Integer id) {
        Optional<Run> existingRun = findById(id);
        existingRun.ifPresent(r -> {
            int index = runs.indexOf(r);
            if (index != -1) {
                runs.set(index, run);
            }
        });
    }


    void delete(Integer id){
        runs.removeIf(run -> run.id().equals(id) );
    }
    @PostConstruct
    public void init(){
        runs.add(new Run(1,
                "Monday morning run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(30, ChronoUnit.MINUTES),
                3,
                Location.INDOOR));
        runs.add(new Run(2,
                "Tuesday morning run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(68, ChronoUnit.MINUTES),
                6,
                Location.INDOOR));
    }
}
