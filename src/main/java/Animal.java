public class Animal implements Sightings{
    private String name;
    private String location;
    private String ranger;

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

    }

    @Override
    public void delete() {

    }
}
