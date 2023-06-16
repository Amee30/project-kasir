package utils;

import java.util.ArrayList;

public class Library {
    private final ArrayList<Rooms> roomlist = new ArrayList<>();
    private final ArrayList<Member> memberList = new ArrayList<>();



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
            System.out.printf("+==========[User Member Ke %s]==========+\n", member.getId());
            System.out.printf("|%s |\n", member.getUsername());
            System.out.println("+======================================+");
        }
    }

    public void showRentedRooms(String memberID){
        Member member = getMemberByID(memberID);
        if (member == null) {
            return;
        }

        for (Rooms rooms : member.getRentedList()) {
            System.out.printf("+==========[Nomer Kamar %s]==========+\n", rooms.getId());
            System.out.printf("|Tipe Kamar : %s |\n", rooms.getroomName());
            System.out.println("+===================================+");
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
            System.out.println("Berhasil Menambahkan User");
            this.memberList.add(member);

        }catch (LibraryException e){
            System.out.println("This Member ID Already Exist");
        }

    }

    public void remMember(String memberID){
            Member member = this.getMemberByID(memberID);
            if (member == null) {
                System.out.println("This User ID Not Available");
                return;
            }
            System.out.println("Berhasil Menghapus User");
            this.memberList.remove(member);
    }

    public void remRoom(String roomID){
        Rooms rooms = this.getRoomsID(roomID);
        if (rooms == null) {
            System.out.println("This User ID Not Available");
            return;
        }
        System.out.println("Berhasil Menghapus Kamar");
        this.roomlist.remove(rooms);
    }

    public void isIdMembExist(String id) throws LibraryException {
        for (Member member : this.memberList) {
            if (member.getId().equals(id)) {
                throw new LibraryException();
            }
        }
    }

    private Rooms getRoomByID(String id, Rooms[] roomList){
        for (Rooms rooms : roomList) {
            if (rooms != null && rooms.getId().equals(id)) {
            return rooms;
            }
        }
        return null;
    }

    private Rooms getRoomsID(String id){
        for (Rooms rooms : this.roomlist){
            if (rooms.getId().equals(id)) {
                return rooms;
            }
        }
        return null;
    }

    private Member getMemberByID(String id){
        for (Member member : this.memberList) {
            if (member.getId().equals(id)) {
                return member;
            }
        }
        return null;
    }

    private int getMemberIndex(Member member){
        return this.memberList.indexOf(member);
    }

    public void rentRoom(String roomID, String memberID){
        Rooms rooms = this.getRoomByID(roomID, getRoomList());
        this.roomlist.remove(rooms);

        Member member = this.getMemberByID(memberID);
        int memberIndex = this.getMemberIndex(member);
        this.memberList.get(memberIndex).completeLease(rooms);
    }

    public void endRoomRent(String roomID, String memberID){
        Member member = this.getMemberByID(memberID);
        int memberIndex = this.getMemberIndex(member);

        if (member == null) {
            return;
        }

        Rooms rooms = this.getRoomByID(roomID, member.getRentedList());
        this.roomlist.add(rooms);
        this.memberList.get(memberIndex).lease(rooms);
    }
}
