package dev.asid.runnerz.run;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcClientRunRepository {

    private final JdbcClient jdbcClient;

    public JdbcClientRunRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    // Find all runs
    public List<Run> findAll() {
        return jdbcClient.sql("SELECT * FROM run")
                .query(Run.class)
                .list();
    }
    public Optional<Run> findById(Integer id){
    return jdbcClient.sql("SELECT id, title,started_on, completed_on,miles,location FROM Run WRERE id = id ").param("id",id).query(Run.class) .optional();
}
    private void create(Run run) {
        String sql = "INSERT INTO run (id, title, started_on, completed_on, miles, location) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcClient.sql(sql)
                .param(run.id())
                .param(run.title())
                .param(run.startedOn())
                .param(run.completedOn())
                .param(run.miles())
                .param(run.location().toString())
                .update();
    }
    // Update a run
        public void update(Run run) {
        String sql = "UPDATE run SET title = ?, started_on = ?, completed_on = ?, miles = ?, location = ? WHERE id = ?";
        jdbcClient.sql(sql)
                .param(run.title())
                .param(run.startedOn())
                .param(run.completedOn())
                .param(run.miles())
                .param(run.location().toString())
                .param(run.id())
                .update();
    }

    // Delete a run by id
    public void delete(Integer id) {
        String sql = "DELETE FROM run WHERE id = ?";
        jdbcClient.sql(sql)
                .param(id)
                .update();
    }

    // Count the number of runs
    public int count() {
        { return jdbcClient.sql("select * from run").query().listOfRows().size();}

    }

    // Save multiple runs
    public void saveAll(List<Run> runs) {
       runs.stream().forEach(this::create);
    }


    // Find runs by location
    public List<Run> findByLocation(String location) {
        String sql = "SELECT * FROM run WHERE location = ?";
        return jdbcClient.sql(sql)
                .param(location)
                .query(Run.class)
                .list();
    }
}
