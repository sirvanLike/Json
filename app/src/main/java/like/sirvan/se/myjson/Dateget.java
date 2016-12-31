package like.sirvan.se.myjson;


public class Dateget {

    private String id;
    private String Locate;

    public Dateget(String id, String locate) {
        this.id = id;
        this.Locate = locate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocate() {
        return Locate;
    }

    public void setLocate(String locate) {
        Locate = locate;
    }
}
