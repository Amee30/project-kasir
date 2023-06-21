package utils;

import java.util.ArrayList;

public class Kost {
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

    public void showRoomsByID(int roomID){
         Rooms rooms = this.roomlist.get(roomID -1);

            System.out.printf("+==========[List Kamar Ke %s]==========+\n", rooms.getId());
            System.out.printf("|Tipe Kamar  : %s |\n|Harga : Rp%d/Bulan |\n", rooms.getroomName(), rooms.getRoomPrice());
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

    public void showMemberByID(int memberID){
        Member member = this.memberList.get(memberID -1);

            System.out.printf("+==========[User Member Ke %s]==========+\n", member.getId());
            System.out.printf("|%s |\n", member.getUsername());
    }

    public void showRentedRooms(int memberID){
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

    public void isIdRoomExist(int id) throws LibraryException {
        for (Rooms rooms : this.roomlist) {
            if (rooms.getId() == id) {
                throw new LibraryException();
            }

        }
    }

    public void addMember(Member member, boolean duplicateCheck){
        try {
            if (duplicateCheck) {
                isIdMembExist(member.getId());
            }
            this.memberList.add(member);

        }catch (LibraryException e){
            System.out.println("This Member ID Already Exist");
        }

    }

    public void remMember(int memberID){
            Member member = this.getMemberByID(memberID);
            if (member == null) {
                System.out.println("This User ID Not Available");
                return;
            }
            System.out.println("Berhasil Menghapus User");
            this.memberList.remove(member);
    }

    public void remRoom(int roomID){
        Rooms rooms = this.getRoomsID(roomID);
        if (rooms == null) {
            System.out.println("This User ID Not Available");
            return;
        }
        System.out.println("Berhasil Menghapus Kamar");
        this.roomlist.remove(rooms);
    }

    public void isIdMembExist(int id) throws LibraryException {
        for (Member member : this.memberList) {
            if (member.getId() == id) {
                throw new LibraryException();
            }
        }
    }

    private Rooms getRoomByID(int id, Rooms[] roomList){
        for (Rooms rooms : roomList) {
            if (rooms != null && rooms.getId() == id) {
            return rooms;
            }
        }
        return null;
    }

    private Rooms getRoomsID(int id){
        for (Rooms rooms : this.roomlist){
            if (rooms.getId() == id) {
                return rooms;
            }
        }
        return null;
    }

    private Member getMemberByID(int id){
        for (Member member : this.memberList) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    private int getMemberIndex(Member member){
        return this.memberList.indexOf(member);
    }

    public void rentRoom(int roomID, int memberID){
        Rooms rooms = this.getRoomByID(roomID, getRoomList());
        this.roomlist.remove(rooms);

        Member member = this.getMemberByID(memberID);
        int memberIndex = this.getMemberIndex(member);
        this.memberList.get(memberIndex).lease(rooms);
    }

    public void endRoomRent(int roomID, int memberID){
        Member member = this.getMemberByID(memberID);
        int memberIndex = this.getMemberIndex(member);

        if (member == null) {
            return;
        }

        Rooms rooms = this.getRoomByID(roomID, member.getRentedList());
        this.roomlist.add(rooms);
        this.memberList.get(memberIndex).completeLease(rooms);
    }


    public void orderInvoice(int memberID, int roomID, long noTelp){
            Member member = this.memberList.get(memberID -1);
            Rooms rooms = this.roomlist.get(roomID -1);
            Member member2 = new Member(noTelp);

            System.out.println("+=================[Invoice]===================+");
            System.out.printf("|Nama User  : %s |\n", member.getUsername());
            System.out.printf("|No Telp User  : %d |\n", member2.getNoTelp());
            System.out.printf("|Tipe Kamar  : %s |\n", rooms.getroomName());
            System.out.printf("|Harga Yang Harus Dibayarkan  : %d |\n", rooms.getRoomPrice());
            System.out.println("|Silahkan Berikan Invoice ini ke Pengurus Kos Beserta Bukti Pembayaran|");
            member.greets();
            System.out.println("+===============[Terima Kasih]================+");
    }

    public void editRoom(int roomID, int newID, String roomName, int roomPrice){
        Rooms rooms = roomlist.get(roomID -1);
        rooms.setID(newID);
        rooms.setRoomName(roomName);
        rooms.setRoomPrice(roomPrice);
        roomlist.set(roomID-1, rooms);
    }

    public void editMember(int memberID, int newID, String userName){
        Member member = memberList.get(memberID-1);
        member.setId(newID);
        member.setUsername(userName);
        memberList.set(memberID-1, member);
    }
}
