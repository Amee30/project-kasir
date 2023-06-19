package utils;


public class Member extends RentRoom {

    private final int id;
    private final String username;


    public Member(int id, String username){
        this.id = id;
        this.username = username;

    }

    public int getId(){
        return id;
    }

    public String getUsername(){
        return username;
    }
    // Budhi was here

    @Override
    public void greets(){
        System.out.println("Terima Kasih dan Tolong Untuk Pengguna Kost" +
                " Yth Untuk Menggunakan Kamar Kost Dengan Bijak");
    }

}
