package dev.asid.runnerz.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RunNotFoundExeptiion extends RuntimeException  {
 public RunNotFoundExeptiion(){
     super("Run not found");
 }
}
