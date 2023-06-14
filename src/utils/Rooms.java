package utils;

public class Rooms {
    private String id;
    private String roomName;
    private int roomPrice;

    public Rooms(String id, String roomName, int roomPrice){
        this.id = id;
        this.roomName = roomName;
        this.roomPrice = roomPrice;
    }

    public String getId(){
        return id;
    }

    public String getroomName(){
        return this.roomName;
    }

    public int getRoomPrice(){
        return this.roomPrice;
    }

}
