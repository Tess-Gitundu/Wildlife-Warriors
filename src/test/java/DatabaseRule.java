import org.junit.rules.ExternalResource;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class DatabaseRule extends ExternalResource {

    @Override
    protected void before() {
        DB.sql2o = new Sql2o("jdbc:postgres://ylymowtlnioklz:02dbb8c85e701306cae688ef1fa49e4c95fd79a774316b643d2bb025a842a002@ec2-35-168-194-15.compute-1.amazonaws.com:5432/d3f87p3gc0b20m", "ylymowtlnioklz", "02dbb8c85e701306cae688ef1fa49e4c95fd79a774316b643d2bb025a842a002");
    }

    @Override
    protected void after() {
        try(Connection con = DB.sql2o.open()) {
            String deleteAnimalQuery = "DELETE FROM animals *;";
            String deleteEndangeredQuery = "DELETE FROM endangered *;";
            con.createQuery(deleteAnimalQuery).executeUpdate();
            con.createQuery(deleteEndangeredQuery).executeUpdate();
        }
    }
}
