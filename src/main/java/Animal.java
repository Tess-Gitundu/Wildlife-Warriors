import javax.sql.rowset.CachedRowSet;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;

public class Animal implements Sightings{
    private String name;
    private String location;
    private String ranger;
    private int id;

    public Animal(String name, String location, String ranger) {
        this.name = name;
        this.location = location;
        this.ranger = ranger;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRanger() {
        return ranger;
    }

    public void setRanger(String ranger) {
        this.ranger = ranger;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object otherAnimal){
        if (!(otherAnimal instanceof Animal)) {
            return false;
        } else {
            Animal newAnimal = (Animal) otherAnimal;
            return this.getName().equals(newAnimal.getName()) &&
                    this.getLocation().equals(newAnimal.getLocation()) &&
                    this.getRanger().equals(newAnimal.getRanger());
        }
    }

    @Override
    public void save() {
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO animals (name, location, ranger) VALUES (:name, :location, :ranger)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("location", this.location)
                    .addParameter("ranger", this.ranger)
                    .executeUpdate()
                    .getKey();
        }
    }

    @Override
    public void delete() {

    }

    public static List<Animal> all() {
        String sql = "SELECT * FROM animals";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Animal.class);
        }
    }

    public static Animal find(int id) {
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM animals where id=:id";
            Animal animal = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Animal.class);
            return animal;
        }
    }

    public static void clearAll() {
        String sql = "DELETE from animals";
        try (Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
