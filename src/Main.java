import utils.Product;


import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static ArrayList<Product> products = new ArrayList<>();
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        String goBack = "y";
        initProduct();

        while (goBack.equalsIgnoreCase("y")){
            showMenu();
            int sel = chooseMenu();

            switch (sel) {
                case 1 -> showProduct();
                case 2 -> addProduct();
                case 3 -> editProduct();
                case 4 -> deleteProduct();
                default -> System.out.println("Opsi Tidak Tersedia");
            }
            System.out.println("Continue? (y/n)");
            goBack = scan.next();
        }

    }
        public static void initProduct(){

            Product product1 = new Product();
            product1.setID(1);
            product1.setproductName("Baterai Alkaline");
            product1.setProductPrice(18000);

            Product product2 = new Product();
            product2.setID(2);
            product2.setproductName("Jam Dinding");
            product2.setProductPrice(50000);

            Product product3 = new Product();
            product3.setID(3);
            product3.setproductName("Senter Portable MultiFungsi + PowerBank");
            product3.setProductPrice(340000);

            products.add(product1);
            products.add(product2);
            products.add(product3);
        }

        public static void showProduct(){
            for (Product product : products) {
                System.out.println(product.getId() + " " + product.getProductName() + " Rp" + product.getProductPrice());
            }
        }

        public static void addProduct(){
            System.out.println("Masukan ID Product : ");
            int id = scan.nextInt();
            scan.nextLine();
            System.out.println("Masukan Nama Product : ");
            String name = scan.nextLine();

            System.out.println("Masukan Harga Product : ");
            int price = scan.nextInt();

            Product productAdd = new Product();
            productAdd.setID(id);
            productAdd.setproductName(name);
            productAdd.setProductPrice(price);

            products.add(productAdd);
        }

        public static void editProduct(){
            System.out.println("Masukan ID Product Yang Ingin Di Edit : ");
            int id = scan.nextInt();

            System.out.println("Masukan ID Product Yang Baru : ");
            int idNew = scan.nextInt();
            scan.nextLine();

            System.out.println("Masukan Nama Product Baru : ");
            String newName = scan.nextLine();

            System.out.println("Masukan Harga Baru : ");
            int newPrice = scan.nextInt();

            Product edit = products.get(id-1);
            edit.setID(idNew);
            edit.setproductName(newName);
            edit.setProductPrice(newPrice);
            products.set(id-1, edit);
        }

        public static void deleteProduct() {
            System.out.println("Masukan ID Product Yang Ingin Dihapus");
            int id = scan.nextInt();

            products.remove(id-1);
        }

        public static void showMenu(){
            System.out.println("CRUD Kasir (PROTOTYPE VER!)");
            System.out.println("""
                    1. Show Product Available
                    2. Add Product
                    3. Update Product
                    4. Delete Product
                    """);
        }

        public static int chooseMenu(){
            System.out.print("Your Choise : ");
            return scan.nextInt();
        }

}
