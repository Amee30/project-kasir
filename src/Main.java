import utils.Library;
import utils.Member;
import utils.Rooms;
import java.util.Scanner;


public class Main {

    public static Scanner scan = new Scanner(System.in);
    static Library libs = new Library();
    public static void main(String[] args) {
        String goBack = "y";
        initLibraryData();

        while (goBack.equalsIgnoreCase("y")){
            showMenu();
            int sel = chooseMenu();

            switch (sel) {
                case 1 -> showRoom();
                case 2 -> showMember();
                case 3 -> {
                    return;
                }

                default -> System.out.println("Opsi Tidak Tersedia");
            }
            System.out.println("Continue? (y/n)");
            System.out.print("Your Input >> ");
            goBack = scan.next();
        }

    }

    public static void initLibraryData(){
        //Room List
        libs.addRoom(new Rooms("1", "Kamar Kost Luas (BerAC) No 1 LT 1", 1200000), true);
        libs.addRoom(new Rooms("2", "Kamar Kost Luas (Tidak BerAC) No 2 LT 1", 950000), true);
        libs.addRoom(new Rooms("3", "Kamar Kost Standar No 3 LT 1", 750000), true);
        libs.addRoom(new Rooms("4", "Kamar Kost Standar No 4 LT 2", 750000), true);
        libs.addRoom(new Rooms("5", "Kamar Kost Standar No 5 LT 2", 750000), true);
        libs.addRoom(new Rooms("6", "Kamar Kost Standar No 6 LT 2", 750000), true);
        libs.addRoom(new Rooms("7", "Kamar Kost Standar No 7 LT 2", 750000), true);

        //User List
        libs.addMember(new Member("1", "Ketut Garing"), true);
        libs.addMember(new Member("2", "Kadek Jax"), true);
        libs.addMember(new Member("3", "Rahmad Aditya Alfonzo"), true);
        libs.addMember(new Member("4", "Muhammad Dicky Aprilianto"), true);
        libs.addMember(new Member("5", "Made Terminal Kuningan"), true);
    }

    public static int chooseMenu(){
        System.out.print("Your Input >> ");
        int select = scan.nextInt();
        scan.nextLine();
        return select;
    }

    public static void showMenu() {
        System.out.println("""
                +==========[Aplikasi Pemesanan Kamar Kost]==========+
                |---|                                               |
                | 1 | Proses Sewa Kamar                             |
                | 2 | Proses Selesai Sewa Kamar                     |
                | 3 | Tampilkan Kamar Kost                          |
                | 4 | Tampilkan User                                |
                | 5 | Tampilkan Kamar Kost Yang Sudah Tersewa       |
                | 6 | Tambahkan Kamar Kost                          |
                | 7 | Tambahkan User                                |
                | 8 | Exit Program                                  |
                |---|                                               |
                +===================================================+
                """);
    }

    public static void showRoom(){
        libs.showRooms();
    }

    public static void showMember(){
        libs.showMember();
    }





}
