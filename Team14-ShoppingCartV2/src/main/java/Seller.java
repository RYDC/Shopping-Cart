public class Seller {
    private String username,password;


    public Seller(String u, String p) {
        username = u;
        password = p;
    }

    public void setUsername(String u){
        username = u;
    }
    public void setPassword(String p){
        password = p;
    }
    public String getUsername(){return username;}
    public String getPassword(){return password;}

}
