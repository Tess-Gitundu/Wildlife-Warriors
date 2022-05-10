import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;


public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");


        //Path to main home page
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //Path to add or view animals
        get("/animals", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Animal> animals = Animal.all();
            model.put("animals", animals);
            return new ModelAndView(model, "animal.hbs");
        }, new HandlebarsTemplateEngine());

        //Path to and or view endangered animals
        get("/endangered", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Endangered> endangered = Endangered.all();
            model.put("endangered", endangered);
            return new ModelAndView(model, "endangered.hbs");
        }, new HandlebarsTemplateEngine());

        //Path to create an animal
        get("/animals/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Animal> animals = Animal.all();
            model.put("animals", animals);
            return new ModelAndView(model, "animal-form.hbs");
        }, new HandlebarsTemplateEngine());

        //Supposed to be path to collect user input
        post("/animals/all", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String animalName = request.queryParams("name");
            String sightLocation = request.queryParams("location");
            String rangerName = request.queryParams("ranger");
            Animal newAnimal = new Animal(animalName, sightLocation, rangerName);
            model.put("newAnimal", newAnimal);
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //Supposed to be path to show all animals
        get("/animals/all", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Animal> animals = Animal.all();
            model.put("animals", animals);
            return new ModelAndView(model, "animal-detail.hbs");
        }, new HandlebarsTemplateEngine());

        //Path to create an endangered animal
        get("/endangered/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Endangered> endangered = Endangered.all();
            model.put("endangered", endangered);
            return new ModelAndView(model, "animal-form.hbs");
        }, new HandlebarsTemplateEngine());

        //Supposed to be path to collect user input
        post("/endangered/all", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String animalName = request.queryParams("name");
            String sightLocation = request.queryParams("location");
            String rangerName = request.queryParams("ranger");
            String healthStatus = request.queryParams("health");
            int ageOfAnimal = Integer.parseInt(request.queryParams("age"));
            Endangered newEndangeredAnimal = new Endangered(animalName, sightLocation, rangerName, healthStatus, ageOfAnimal);
            model.put("newEndangeredAnimal", newEndangeredAnimal);
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        get("/endangered/all", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Endangered> endangered = Endangered.all();
            model.put("endangered", endangered);
            return new ModelAndView(model, "endangered-detail.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
