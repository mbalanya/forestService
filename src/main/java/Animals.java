import org.sql2o.*;

import java.util.List;

public class Animals {
    private String name;
    private int id;

    public Animals(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name) VALUES (:name)";
            con.createQuery(sql)
                    .addParameter("name", this.name)
                    .executeUpdate();
        }
    }

    public static List<Animals> all() {
        String sql = "SELECT * FROM animals";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Animals.class);
        }
    }

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
