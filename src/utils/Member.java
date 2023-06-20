package utils;


public class Member extends RentRoom {

    private int id;
    private String username;
    private long noTelp;


    public Member(int id, String username){
        this.id = id;
        this.username = username;

    }
    // Constructor Overloading
    public Member(long noTelp){
        this.noTelp = noTelp;

    }

    public int getId(){
        return id;
    }

    public String getUsername(){
        return username;
    }

    public long getNoTelp(){
        return noTelp;
    }
    @Override
    public void greets(){
        System.out.println("|Terima Kasih dan Tolong Untuk Pengguna Kost" +
                " Yth Untuk Menggunakan Kamar Kost Dengan Bijak|");
    }

}
