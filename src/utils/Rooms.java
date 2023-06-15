package utils;

public class Rooms {
    private final String id;
    private final String roomName;
    private final int roomPrice;

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
