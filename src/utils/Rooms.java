package utils;

public class Rooms {
    private final int id;
    private final String roomName;
    private final int roomPrice;

    public Rooms(int id, String roomName, int roomPrice){
        this.id = id;
        this.roomName = roomName;
        this.roomPrice = roomPrice;
    }

    public int getId(){
        return id;
    }

    public String getroomName(){
        return this.roomName;
    }

    public int getRoomPrice(){
        return this.roomPrice;
    }

}
