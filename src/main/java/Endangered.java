public class Endangered implements Sightings{
    private String name;
    private String location;
    private String ranger;
    private String health;
    private int age;

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

    }
    @Override
    public void delete() {

    }
}
