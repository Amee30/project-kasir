package utils;

public class Rooms {
    private int id;
    private String roomName;
    private int roomPrice;

    public Rooms(int id, String roomName, int roomPrice){
        this.id = id;
        this.roomName = roomName;
        this.roomPrice = roomPrice;
    }

    public void setID(int id){
        this.id = id;
    }

    public void setRoomName(String roomName){
        this.roomName = roomName;
    }

    public void setRoomPrice(int roomPrice){
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
