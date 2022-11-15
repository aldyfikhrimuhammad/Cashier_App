package tugasEnamCoba;

import java.util.*;

import tugasEnamCoba.model.Menu;
import tugasEnamCoba.service.MenuDAO;
import tugasEnamCoba.service.MenuDAOImp;
import tugasEnamCoba.model.Order;
import tugasEnamCoba.service.OrderDAO;
import tugasEnamCoba.service.OrderDAOImp;

public class Main {

    // Instance object dan variabel yang dibutuhkan
    static Integer opsi;
    static int total;
    static int index, amount;
    static boolean state = true;
    String lanjutkanProgram = "y";
    static Scanner inputUser = new Scanner(System.in);
    static MenuDAO<Menu, Integer> menu = new MenuDAOImp();
    static OrderDAO<Integer> order = new OrderDAOImp();
    static List<Integer> nomor = new ArrayList<Integer>(total);
    static List<Integer> pesanan = new ArrayList<Integer>(total);
    static List<Integer> tipe = new ArrayList<Integer>(total);

    private static MenuDAO<Menu, Integer> makananDao;
    private static MenuDAO<Menu, Integer> minumanDao;
    private static MenuDAO<Menu, Integer> paketDao;
    private static MenuDAO<Menu, Integer> totalPesanan;

    public void chooseOption() {

        // Main Menu
        if (totalPesanan.findAll().isEmpty()) {
            System.out.println("""
                    \n========== Warung Sehat, Cerdas, dan Bahagia ==========\s
                    1. Daftar Menu
                    2. Pemesanan
                    3. Pembayaran"""
            );
        } else {
            System.out.println("""
                    \n========== Warung Sehat, Cerdas, dan Bahagia ==========\s
                    1. Daftar Menu
                    2. Pemesanan
                    3. Pembayaran"""
            );
            // Mencetak pesanan
            System.out.print("Pesanan Anda : " + totalPesanan.findAll() + "\n");
        }

        // Mengambil input user
        System.out.print("Pilih Menu : ");
        opsi = inputUser.nextInt();
        inputUser.nextLine();
    }

    public static void main(String[] args) {

        // Instance object yang diperlukan
        Main main = new Main();
        Menu menu = new Menu();
        Order order01 = new Order();
        MenuDAOImp menuDAOImp = new MenuDAOImp();
        OrderDAOImp orderDAOImp = new OrderDAOImp();
        makananDao = new MenuDAOImp();
        minumanDao = new MenuDAOImp();
        paketDao = new MenuDAOImp();
        totalPesanan = new MenuDAOImp();

        // Input data makanan sebagai menu
        Menu makanan = new Menu(1, "Ayam Goreng", 12000);
        makananDao.save(makanan);
        makanan = new Menu(2, "Ikan Bakar", 18000);
        makananDao.save(makanan);
        makanan = new Menu(3, "Sop Iga", 15000);
        makananDao.save(makanan);
        makanan = new Menu(4, "Sate Kambing", 25000);
        makananDao.save(makanan);

        // Input data minuman sebagai menu
        Menu minuman = new Menu(1,"Teh Manis", 8000);
        minumanDao.save(minuman);
        minuman = new Menu(2, "Es Jeruk", 10000);
        minumanDao.save(minuman);
        minuman = new Menu(3, "Kopi Susu", 12000);
        minumanDao.save(minuman);
        minuman = new Menu(4, "Air Mineral", 5000);
        minumanDao.save(minuman);

        // Input data paket sebagai menu
        Menu paket = new Menu(1, "Paket Lengkap Ayam", 20000);
        paketDao.save(paket);
        paket = new Menu(2, "Paket Lengkap Ikan", 28000);
        paketDao.save(paket);
        paket = new Menu(3, "Paket Campur 1", 30000);
        paketDao.save(paket);
        paket = new Menu(4, "Paket Campur 2", 28000);
        paketDao.save(paket);

        do {
            main.chooseOption();
            switch (opsi) {

                // Menampilkan daftar menu
                case 1 -> {
                    System.out.println("\n========== DAFTAR MENU ==========");

                    System.out.println("\n========== Menu Makanan Sehat ==========");
                    int i = 0;
                    for (Menu makananMenu : makananDao.findAll()) {
                        i++;
                        System.out.println(i + ". " + makananMenu);
                    }

                    System.out.println("\n========== Menu Minuman Cerdas ==========");
                    int j = 0;
                    for (Menu minumanMenu : minumanDao.findAll()) {
                        j++;
                        System.out.println(j + ". " + minumanMenu);
                    }

                    System.out.println("\n========== Menu Paket Bahagia ==========");
                    int k = 0;
                    for (Menu paketMenu : paketDao.findAll()) {
                        k++;
                        System.out.println(k + ". " + paketMenu);
                    }
                }
                case 2 -> {

                    // Menampilkan menu pemesanan
                    while (main.lanjutkanProgram.equals("y")) {
                        System.out.println("""
                    ========== PEMESANAN ==========\s
                    1. Makanan
                    2. Minuman
                    3. Paket
                    4. Ubah Pesanan
                    5. Hapus Pesanan"""
                        );

                        // Mencetak pesanan
                        System.out.print("Pesanan Anda : " + totalPesanan.findAll() + "\n");

                        // Mengambil input user
                        System.out.print("Pilih Menu : ");
                        int pilihMenu = inputUser.nextInt();
                        inputUser.nextLine();

                        // Menampilkan pilihan menu yang dapat dipesan
                        switch (pilihMenu) {
                            case 1 -> {

                                while (main.lanjutkanProgram.equals("y")) {
                                    System.out.println("\n========== Menu Makanan Sehat ==========");
                                    int a = 0;
                                    for (Menu makananMenu : makananDao.findAll()) {
                                        a++;
                                        System.out.println(a + ". " + makananMenu);
                                    }

                                    // Mengambil input user
                                    System.out.print("Pilih Makanan : ");
                                    int index = inputUser.nextInt();
                                    inputUser.nextLine();
                                    makanan.setTotalPesanan(index - 1);

                                    // Save data pesanan
                                    totalPesanan.save(makananDao.findById(makanan.getTotalPesanan()));
                                    System.out.println("Pesanan berhasil ditambahkan!");

                                     // Mencetak pesanan
                                    System.out.print("Pesanan Anda : " + totalPesanan.findAll() + "\n");

                                    System.out.print("Ingin menambahkan menu lain? (y / n): ");
                                    main.lanjutkanProgram = inputUser.nextLine().toLowerCase();
                                }
                            }
                            case 2 -> {

                                while (main.lanjutkanProgram.equals("y")) {
                                    System.out.println("\n========== Menu Minuman Cerdas ==========");
                                    int b = 0;
                                    for (Menu minumanMenu : minumanDao.findAll()) {
                                        b++;
                                        System.out.println(b + ". " + minumanMenu);
                                    }

                                    // Mengambil input user
                                    System.out.print("Pilih Minuman : ");
                                    int index = inputUser.nextInt();
                                    inputUser.nextLine();
                                    minuman.setTotalPesanan(index - 1);

                                    // Save data pesanan
                                    totalPesanan.save(minumanDao.findById(minuman.getTotalPesanan()));
                                    System.out.println("Pesanan berhasil ditambahkan!");

                                    // Mencetak pesanan
                                    System.out.print("Pesanan Anda : " + totalPesanan.findAll() + "\n");

                                    System.out.print("Ingin menambahkan menu lain? (y / n): ");
                                    main.lanjutkanProgram = inputUser.nextLine().toLowerCase();
                                }
                            }
                            case 3 -> {

                                while (main.lanjutkanProgram.equals("y")) {
                                    System.out.println("\n========== Menu Paket Bahagia ==========");
                                    int c = 0;
                                    for (Menu paketMenu : paketDao.findAll()) {
                                        c++;
                                        System.out.println(c + ". " + paketMenu);
                                    }

                                    // Mengambil input user
                                    System.out.print("Pilih Paket : ");
                                    int index = inputUser.nextInt();
                                    inputUser.nextLine();
                                    paket.setTotalPesanan(index - 1);

                                    // Save data pesanan
                                    totalPesanan.save(paketDao.findById(paket.getTotalPesanan()));
                                    System.out.println("Pesanan berhasil ditambahkan!");

                                    // Mencetak pesanan
                                    System.out.print("Pesanan Anda : " + totalPesanan.findAll() + "\n");

                                    System.out.print("Ingin menambahkan menu lain? (y / n): ");
                                    main.lanjutkanProgram = inputUser.nextLine().toLowerCase();
                                }
                            }
                            case 4 -> {

                                while (main.lanjutkanProgram.equals("y")) {
                                    System.out.println("\n========== Ubah Pesanan ==========");

                                    // Mencetak pesanan
                                    System.out.print("Pesanan Anda : " + totalPesanan.findAll() + "\n");

                                    // Mengambil input user
                                    System.out.print("Pilih pesanan Yang Akan diubah : ");
                                    int index = inputUser.nextInt();
                                    inputUser.nextLine();
                                    paket.setTotalPesanan(index - 1);

                                    // Update data pesanan
//                                    totalPesanan.update(index, );

                                    System.out.println("Pesanan berhasil diubah!");

                                    // Mencetak pesanan setelah terubah
                                    System.out.print("Pesanan Anda : " + totalPesanan.findAll() + "\n");

                                    System.out.print("Ingin mengubah menu lain? (y / n): ");
                                    main.lanjutkanProgram = inputUser.nextLine().toLowerCase();
                                }
                            }
                            case 5 -> {

                                while (main.lanjutkanProgram.equals("y")) {
                                    System.out.println("\n========== Hapus Pesanan ==========");

                                    // Mencetak pesanan
                                    System.out.print("Pesanan Anda : " + totalPesanan.findAll() + "\n");

                                    // Mengambil input user
                                    System.out.print("Pilih pesanan yang akan dihapus : ");
                                    int index = inputUser.nextInt();
                                    inputUser.nextLine();
                                    paket.setTotalPesanan(index - 1);

                                    // Delete data pesanan
                                    totalPesanan.delete(index - 1);
                                    System.out.println("Pesanan berhasil dihapus!");

                                    // Mencetak pesanan setelah terhapus
                                    System.out.print("Pesanan Anda : " + totalPesanan.findAll() + "\n");

                                    System.out.print("Ingin menghapus pesanan lain? (y / n): ");
                                    main.lanjutkanProgram = inputUser.nextLine().toLowerCase();
                                }
                            }
                            default -> System.out.println("Menu tidak tersedia!");
                        }
                    }
                    
                    main.lanjutkanProgram = "y";
                }
                case 3 -> {

                    do {
                        System.out.println("\n========== PEMBAYARAN ==========");

                        // Mencetak jumlah pesanan
                        int jumlah = 0;
                        int k = 0;
                        for (Menu paketMenu : totalPesanan.findAll()) {
                            k++;
                            System.out.println(k + ". " + paketMenu);
                            jumlah  += paketMenu.getHarga();
                        }
                        // Mencetak harga yang harus dibayarkan
                        System.out.println("Jumlah yang harus dibayarkan beserta PPN : " + "Rp " + (jumlah + (jumlah * 11 / 100)));

                        // Mengambil input user
                        System.out.print("Masukan jumlah uang : ");
                        amount = inputUser.nextInt();
                        inputUser.nextLine();


                        // Pengecekan kondisi pembayaran
                        if (amount < jumlah) {
                            System.out.println("Uang anda tidak cukup!");
                            state = true;
                        } else {
                            order.payment(amount, jumlah);
                            state = false;
                            nomor.clear();
                            pesanan.clear();
                        }
                    } while (state);

                }
                default -> {
                    System.out.println("Menu yang anda pilih tidak tersedia!");
                }
            }
        } while ((main.lanjutkanProgram.equalsIgnoreCase("y")));

    }
}
