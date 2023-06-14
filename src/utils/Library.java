package utils;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    public Scanner scnn = new Scanner(System.in);
    private final ArrayList<Rooms> roomlist = new ArrayList<>();
    private final ArrayList<Member> memberList = new ArrayList<>();



    public static void orderRoom(){
        char isContinue = 'y';
    }

    public Rooms[] getRoomList(){
        Rooms[] roomsArray = new Rooms[this.roomlist.size()];
        int i = 0;
        for (Rooms rooms : this.roomlist) {
            roomsArray[i++] = rooms;
        }
        return roomsArray;
    }

    public void showRooms(){
        for (Rooms rooms : getRoomList()) {
            if (rooms == null) {
                continue;
            }
            System.out.printf("+==========[List Kamar Ke %s]==========+\n", rooms.getId());
            System.out.printf("|Tipe Kamar  : %s |\n|Harga : Rp%d/Bulan |\n", rooms.getroomName(), rooms.getRoomPrice());
            System.out.println("+=====================================+");
        }
    }

    public Member[] getMemberList(){
        Member[] MemArray = new Member[this.memberList.size()];
        int i = 0;
        for (Member member : this.memberList) {
            MemArray[i++] = member;
        }
        return MemArray;
    }

    public void showMember(){
        for (Member member : getMemberList()) {
            if (member == null) {
                continue;
            }
            System.out.println("+==========[User Member]==========+");
            System.out.printf("|%s %s \n|", member.getId(), member.getUsername());
            System.out.println("+=================================+");
        }
    }

    public void addRoom(Rooms rooms, boolean duplicateCheck){
        try {
            if (duplicateCheck){
                isIdRoomExist(rooms.getId());
            }

            this.roomlist.add(rooms);

        } catch (LibraryException e) {
            System.out.println("ID Kamar Ini Telah Terdaftar");
        }
    }

    public void isIdRoomExist(String id) throws LibraryException {
        for (Rooms rooms : this.roomlist) {
            if (rooms.getId().equals(id)) {
                throw new LibraryException();
            }

        }
    }

    public void addMember(Member member, boolean duplicateCheck){
        try {
            if (duplicateCheck) {
                isIdMembExist(member.getId());
            }
        }catch (LibraryException e){
            System.out.println("This Member ID Already Exist");
        }

    }

    public void isIdMembExist(String id) throws LibraryException {
        for (Member member : this.memberList) {
            if (member.getId().equals(id)) {
                throw new LibraryException();
            }
        }
    }

}
