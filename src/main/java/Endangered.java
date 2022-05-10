import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;

public class Endangered implements Sightings{
    private String name;
    private String location;
    private String ranger;
    private String health;
    private int age;
    private int id;

    public Endangered(String name, String location, String ranger, String health, int age) {
        this.name = name;
        this.location = location;
        this.ranger = ranger;
        this.health = health;
        this.age = age;
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

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object otherEndangered){
        if (!(otherEndangered instanceof Endangered)) {
            return false;
        } else {
            Endangered newEndangered = (Endangered) otherEndangered;
            return this.getName().equals(newEndangered.getName()) &&
                    this.getLocation().equals(newEndangered.getLocation()) &&
                    this.getRanger().equals(newEndangered.getRanger()) &&
                    this.getHealth().equals(newEndangered.getHealth()) &&
                    this.getAge() == newEndangered.getAge();
        }
    }


    @Override
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO endangered (name, location, ranger, health, age) VALUES (:name, :location, :ranger, :health, :age)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("location", this.location)
                    .addParameter("ranger", this.ranger)
                    .addParameter("health", this.health)
                    .addParameter("age", this.age)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Endangered> all() {
        String sql = "SELECT * FROM endangered";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql).executeAndFetch(Endangered.class);
        }
    }

    public static Endangered find(int id) {
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM endangered where id=:id";
            Endangered endangered = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Endangered.class);
            return endangered;
        }
    }

    public static void clearAll() {
        String sql = "DELETE from endangered";
        try (Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
    @Override
    public void delete() {

    }
}
