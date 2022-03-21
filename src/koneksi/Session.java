package koneksi;

public class Session {
    private static int id;
    private static String username,password,name,level;
    
    public static void setId(int id){
        Session.id = id;
    }

    public static void setUsername(String username){
        Session.username = username;
    }
    
    public static void setPassword(String password){
        Session.password = password;
    }
    
    public static void setName(String name){
        Session.name = name;
    }
    
    public static void setLevel(String level){
        Session.level = level;
    }
    
    public int getId(){
        return id;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getName(){
        return name;
    }
    
    public String getLevel(){
        return level;
    }
}
