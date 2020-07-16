public class Animals {
    private String name;

    public Animals(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    @Override
    public boolean equals(Object otherAnimals){
        if (!(otherAnimals instanceof Animals)) {
            return false;
        } else {
            Animals newAnimals = (Animals) otherAnimals;
            return this.getName().equals(newAnimals.getName());
        }
    }
}
