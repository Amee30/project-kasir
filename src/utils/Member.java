package utils;

public class Member extends RentRoom {

    private final String id;
    private final String username;


    public Member(String id, String username){
        this.id = id;
        this.username = username;

    }

    public String getId(){
        return id;
    }

    public String getUsername(){
        return username;
    }
    // Budhi was here
}
