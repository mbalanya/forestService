import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;


public class App {

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }

    public static void main(String[] args) {

        port(getHerokuAssignedPort());
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/createNormalAnimal", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String animalName = request.queryParams("animalName");
            String health = request.queryParams("health");
            String age = request.queryParams("age");
            String location = request.queryParams("location");
            String rangerName = request.queryParams("rangerName");
            NormalAnimals newNormalAnimals = new NormalAnimals(animalName);
            newNormalAnimals.save();
            int animalsId = newNormalAnimals.getId();
            Sightings newSightings = new Sightings(location, animalsId, rangerName);
            newSightings.save();
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        post("/createEndangeredAnimal", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String animalName = request.queryParams("animalName");
            String health = request.queryParams("health");
            String age = request.queryParams("age");
            String location = request.queryParams("location");
            String rangerName = request.queryParams("rangerName");
            EndangeredAnimals newEndangeredAnimals = new EndangeredAnimals(animalName);
            newEndangeredAnimals.save();
            int animalsId = newEndangeredAnimals.getId();
            Sightings newSightings = new Sightings(location, animalsId, rangerName);
            newSightings.save();
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());
    }
}