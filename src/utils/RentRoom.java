package utils;

import java.util.ArrayList;

abstract class RentRoom {
    private final ArrayList<Rooms> rentedRoom = new ArrayList<>();

    public void lease(Rooms rooms){
        this.rentedRoom.add(rooms);
    }

    public void completeLease(Rooms rooms){
        this.rentedRoom.remove(rooms);
    }

    public Rooms[] getRentedList(){
        Rooms[] rentArray = new Rooms[rentedRoom.size()];
        int i = 0;
        for (Rooms rooms : rentedRoom) {
            rentArray[i++] = rooms;
        }
        return rentArray;
    }

    public abstract void greets();




}
