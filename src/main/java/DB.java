import org.sql2o.*;

public class DB {

    /*public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "null", "null");*/
    public static String connectionString = "jdbc:postgresql://ec2-54-91-178-234.compute-1.amazonaws.com:5432/dbdc742197ov6v";
    public static Sql2o sql2o = new Sql2o(connectionString, "isykkquuzljlnh", "\n" +
            "9b914a6f5f32afa05be9a889ff8daecbdf1e739de1e8508b43bdedb6162c2a8d");
}
