package de.urr4.mealplanner.adapter.driving.rest.health;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/ping")
public class PingController {

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public String ping() {
        return "ok";
    }
}

