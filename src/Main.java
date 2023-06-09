import utils.Kost;
import utils.Member;
import utils.Rooms;

import java.util.Scanner;


public class Main {

    public static Scanner scan = new Scanner(System.in);
    static Kost libs = new Kost();
    public static void main(String[] args) {
        String goBack = "y";
        initKostData();

        while (goBack.equalsIgnoreCase("y")){
            showMenu();
            int sel = chooseMenu();

            switch (sel) {
                case 1 -> exeOrderRoom();
                case 2 -> exeEndRoomRent();
                case 3 -> showRoom();
                case 4 -> showMember();
                case 5 -> showRentedRoom();
                case 6 -> addRoom();
                case 7 -> addUser();
                case 8 -> remMembers();
                case 9 -> remRoom();
                case 10 -> editRoom();
                case 11 -> editMember();
                case 12 -> {
                    return;
                }

                default -> System.out.println("Opsi Tidak Tersedia");
            }
            System.out.println("Continue? (y/n)");
            System.out.print("Your Input >> ");
            goBack = scan.next();
        }
    }

    public static void initKostData(){
        //Room List
        libs.addRoom(new Rooms(1, "Kamar Kost Luas (BerAC) No 1 LT 1", 1200000), true);
        libs.addRoom(new Rooms(2, "Kamar Kost Luas (Tidak BerAC) No 2 LT 1", 950000), true);
        libs.addRoom(new Rooms(3, "Kamar Kost Standar No 3 LT 1", 750000), true);
        libs.addRoom(new Rooms(4, "Kamar Kost Standar No 4 LT 2", 750000), true);
        libs.addRoom(new Rooms(5, "Kamar Kost Standar No 5 LT 2", 750000), true);
        libs.addRoom(new Rooms(6, "Kamar Kost Standar No 6 LT 2", 750000), true);
        libs.addRoom(new Rooms(7, "Kamar Kost Standar No 7 LT 2", 750000), true);

        //User List
        libs.addMember(new Member(1, "Ketut Garing"), true);
        libs.addMember(new Member(2, "Muhammad Jax"), true);
        libs.addMember(new Member(3, "Rahmad Aditya Alfonzo"), true);
        libs.addMember(new Member(4, "Muhammad Dicky Aprilianto"), true);
        libs.addMember(new Member(5, "Made Terminal Kuningan"), true);

    }

    public static int chooseMenu(){
        System.out.print("Your Input >> ");
        int select = scan.nextInt();
        scan.nextLine();
        return select;
    }

    public static void showMenu() {
        System.out.println("""
                +==========[Program Pemesanan Kamar Kost]============+
                | No |                                               |
                |----|--------------[Order Zone]---------------------|
                | 1  | Proses Sewa Kamar                             |
                | 2  | Proses Selesai Sewa Kamar                     |
                |----|--------------[Display Zone]-------------------|
                | 3  | Tampilkan Kamar Kost                          |
                | 4  | Tampilkan User                                |
                | 5  | Tampilkan Kamar Kost Yang Sudah Tersewa       |
                |----|--------------[Adding Zone]--------------------|
                | 6  | Tambahkan Kamar Kost                          |
                | 7  | Tambahkan User                                |
                |----|----------[Delete Zone (Danger!)]--------------|
                | 8  | Hapus User                                    |
                | 9  | Hapus Kamar                                   |
                |----|---------------[Edit Zone]---------------------|
                | 10 | Edit Kamar                                    |
                | 11 | Edit User                                     |
                |----|-----------------------------------------------|
                | 12 | Exit Program                                  |
                |----|                                               |
                +====================================================+
                """);
    }

    public static void showRoom(){
        libs.showRooms();
    }

    public static void showMember(){
        libs.showMember();
    }
    public static void showRentedRoom(){
        System.out.println("Masukan ID User : ");
        int memberID = scan.nextInt();

        libs.showRentedRooms(memberID);
    }

    public static void exeOrderRoom(){
        String goBack;
        System.out.println("Masukan ID User");
        int memberID = scan.nextInt();

        showRoom();

        System.out.println("Pilih Nomer Kamar");
        int roomID = scan.nextInt();

        System.out.println("Masukan No Telp");
        long noTelp = scan.nextLong();

        scan.nextLine();

        System.out.println("+==========[Confirmation]==========+");
        libs.showMemberByID(memberID);
        libs.showRoomsByID(roomID);
        System.out.println("+==================================+");

        System.out.println("Apakah Ini Sudah Benar? (y/n)");
        System.out.print("Your Input >> ");
        goBack = scan.next();

        if (goBack.equalsIgnoreCase("y")) {
            libs.orderInvoice(memberID, roomID, noTelp);
            libs.rentRoom(roomID, memberID);

        } else if (goBack.equalsIgnoreCase("n")) {
            exeOrderRoom();

        } else {
            System.out.println("Tolong Masukan Input Berupa (y/n) Y berarti " +
                    "Akan Melakukan Proses Tambah User, N Berarti Akan Mengulang Proses Input" +
                    ", dan Selain Dari Itu Akan Melakukan Proses Kembali ke Menu");
        }
    }

    public static void exeEndRoomRent(){
        String goBack;
        System.out.println("Masukan ID User");
        int memberID = scan.nextInt();

        System.out.println("Masukan Nomer Kamar");
        int roomID = scan.nextInt();

        System.out.println("+==========[Confirmation]==========+");
        libs.showMemberByID(memberID);
        libs.showRentedRooms(memberID);


        System.out.println("Apakah Ini Sudah Benar? (y/n)");
        System.out.print("Your Input >> ");
        goBack = scan.next();

        if (goBack.equalsIgnoreCase("y")) {
            libs.endRoomRent(roomID, memberID);

        } else if (goBack.equalsIgnoreCase("n")) {
            showMenu();

        } else {
            System.out.println("Tolong Masukan Input Berupa (y/n) Y berarti " +
                    "Akan Melakukan Proses Tambah User, N Berarti Akan Mengulang Proses Input" +
                    ", dan Selain Dari Itu Akan Melakukan Proses Kembali ke Menu");
        }

    }

    public static void addRoom(){
        String goBack;
        System.out.println("Masukan Nomer Kamar");
        int roomID = scan.nextInt();

        scan.nextLine();

        System.out.println("Masukan Tipe Kamar Beserta Nomer Kamar dan Lantai Berapa");
        String roomName = scan.nextLine();

        System.out.println("Masukan Harga Kamar");
        int roomPrice = scan.nextInt();

        System.out.println("+==========[Confirmation]==========+");
        System.out.printf("|Nomer Kamar %s |\n",roomID);
        System.out.printf("|Tipe Kamar %s |\n",roomName);
        System.out.printf("|Harga Kamar %s |\n",roomPrice);
        System.out.println("+==================================+");
        System.out.println("Apakah Ini Sudah Benar? (y/n)");
        System.out.print("Your Input >> ");
        goBack = scan.next();

        if (goBack.equalsIgnoreCase("y")) {
            System.out.println("Berhasil Menambahkan Kamar");
            libs.addRoom(new Rooms(roomID, roomName, roomPrice), true);

        } else if (goBack.equalsIgnoreCase("n")){
            addRoom();

        } else {
            System.out.println("Tolong Masukan Input Berupa (y/n) Y berarti " +
                    "Akan Melakukan Proses Tambah User, N Berarti Akan Mengulang Proses Input" +
                    ", dan Selain Dari Itu Akan Melakukan Proses Kembali Ke Menu");
        }
    }


    public static void addUser(){
        String goBack;
        System.out.println("Masukan Nomer User");
        int userID = scan.nextInt();

        System.out.println("Masukan Nama Calon User");
        String userName = scan.next();

        System.out.println("+==========[Confirmation]==========+");
        System.out.printf("|Nomer User %s |\n",userID);
        System.out.printf("|Nama User %s |\n",userName);
        System.out.println("+==================================+");
        System.out.println("Apakah Ini Sudah Benar? (y/n)");
        System.out.print("Your Input >> ");
        goBack = scan.next();

        if (goBack.equalsIgnoreCase("y")) {
            libs.addMember(new Member(userID, userName), true);
            System.out.println("Berhasil Menambahkan User");

        } else if (goBack.equalsIgnoreCase("n")){
            addUser();

        } else {
            System.out.println("Tolong Masukan Input Berupa (y/n) Y berarti " +
                    "Akan Melakukan Proses Tambah User, N Berarti Akan Mengulang Proses Input" +
                    ", dan Selain Dari Itu Akan Melakukan Proses Kembali Ke Menu");
        }
    }

    public static void remMembers(){
        try{
        String goBack;
        showMember();
        System.out.println();
        System.out.println("Masukan ID Member Yang Ingin DiHapus");
        int memberID = scan.nextInt();

        System.out.printf("Anda Yakin Menghapus User Ke %s ? ", memberID);
        System.out.println("(Proses Ini Tidak Bisa Dikembalikan/Undo!!!)");
        System.out.println("Pilih 'y' Untuk Melanjutkan 'n' Untuk Membatalkan, dan Akan Kembali ke Menu");
        System.out.print("Your Input >> ");
        goBack = scan.next();

        if (goBack.equalsIgnoreCase("y")) {
            libs.remMember(memberID);

        } else if (goBack.equalsIgnoreCase("n")){
            showMenu();

        } else {
            System.out.println("Input Salah dan Akan Kembali ke Menu");
            showMenu();
        }

        } catch (Exception e){
            System.out.println("ID Member Not Valid");
        }
    }

    public static void remRoom(){
        try{
            String goBack;
            showRoom();
            System.out.println();
            System.out.println("Masukan ID Kamar Yang Ingin DiHapus");
            int roomID = scan.nextInt();

            System.out.printf("Anda Yakin Menghapus Kamar Ke %s ? ", roomID);
            System.out.println("(Proses Ini Tidak Bisa Dikembalikan/Undo!!!)");
            System.out.println("Pilih 'y' Untuk Melanjutkan 'n' Untuk Membatalkan, dan Akan Kembali ke Menu");
            System.out.print("Your Input >> ");
            goBack = scan.next();

            if (goBack.equalsIgnoreCase("y")) {
                libs.remRoom(roomID);

            } else if (goBack.equalsIgnoreCase("n")){
                showMenu();

            } else {
                System.out.println("Input Salah dan Akan Kembali ke Menu");
                showMenu();
            }

        } catch (Exception e){
            System.out.println("ID Member Not Valid");
        }
    }

    public static void editRoom(){
        String goBack;
        showRoom();
        System.out.println("Masukan ID Yang Ingin Di Edit");
        int roomID = scan.nextInt();

        System.out.println("Masukan ID Baru/ID Yang Sama");
        int newID = scan.nextInt();

        scan.nextLine();

        System.out.println("Masukan Nama Kamar");
        String roomName = scan.nextLine();

        System.out.println("Masukan Harga Kamar");
        int roomPrice = scan.nextInt();

        System.out.println("+==========[Confirmation]==========+");
        System.out.println("Sebelum");
        libs.showRoomsByID(roomID);
        System.out.println();

        System.out.println("Sesudah");
        System.out.printf("+==========[List Kamar Ke %s]==========+\n", newID);
        System.out.printf("|Tipe Kamar  : %s |\n|Harga : Rp%d/Bulan |\n", roomName, roomPrice);
        System.out.println("+=====================================+");

        System.out.println("Apakah Ini Sudah Benar? (y/n)");
        System.out.print("Your Input >> ");
        goBack = scan.next();

        if (goBack.equalsIgnoreCase("y")) {
            libs.editRoom(roomID ,newID ,roomName, roomPrice);

        } else if (goBack.equalsIgnoreCase("n")) {
            editRoom();

        } else {
            System.out.println("Tolong Masukan Input Berupa (y/n) Y berarti " +
                    "Akan Melakukan Proses Tambah User, N Berarti Akan Mengulang Proses Input" +
                    ", dan Selain Dari Itu Akan Melakukan Proses Kembali ke Menu");
        }
    }

    public static void editMember(){
        String goBack;
        showMember();
        System.out.println("Masukan ID Yang Ingin Di Edit");
        int roomID = scan.nextInt();

        System.out.println("Masukan ID Baru/ID Yang Sama");
        int newID = scan.nextInt();

        scan.nextLine();

        System.out.println("Masukan Nama Member");
        String userName = scan.nextLine();

        System.out.println("+==========[Confirmation]==========+");
        System.out.println("Sebelum");
        libs.showMemberByID(roomID);
        System.out.println("+======================================+");
        System.out.println();
        System.out.println("Sesudah");
        System.out.printf("+==========[User Member Ke %s]==========+\n", newID);
        System.out.printf("|%s |\n", userName);
        System.out.println("+======================================+");

        System.out.println("Apakah Ini Sudah Benar? (y/n)");
        System.out.print("Your Input >> ");
        goBack = scan.next();

        if (goBack.equalsIgnoreCase("y")) {
            libs.editMember(roomID, newID, userName);

        } else if (goBack.equalsIgnoreCase("n")) {
            editMember();

        } else {
            System.out.println("Tolong Masukan Input Berupa (y/n) Y berarti " +
                    "Akan Melakukan Proses Tambah User, N Berarti Akan Mengulang Proses Input" +
                    ", dan Selain Dari Itu Akan Melakukan Proses Kembali ke Menu");
        }
    }
}