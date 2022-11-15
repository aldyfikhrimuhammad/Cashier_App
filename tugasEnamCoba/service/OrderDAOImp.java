package tugasEnamCoba.service;

import tugasEnamCoba.model.Menu;
import tugasEnamEmpatKali.model.Order;
import tugasEnamEmpatKali.service.MenuDaoImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImp implements OrderDAO<Integer> {

    // Instance object dan variabel yang dibutuhkan
    int jumlah;
    private Order order = new Order();
    private MenuDaoImpl menudao = new MenuDaoImpl();
    List<Order> listofOrder = new ArrayList<Order>();

    // Method untuk mendapatkan data order
    @Override
    public void order(List<Integer> index, List<Integer> orders, List<Integer> type) {
        for (int i = 0; i < index.size(); i++) {
            listofOrder.add(new Order(index.get(i), orders.get(i), type.get(i)));
        }
    }

    // Method untuk mendapatkan data semua order
    @Override
    public void getOrders() {
    }

    // Method untuk mendapatkan total ppn
    @Override
    public int getTotalPesananPPN() {
        return (jumlah + (jumlah * 11 / 100));
    }

    // Method untuk mencetak struk
    @Override
    public void payment(Integer amount, Integer kembalian) {
        System.out.println("\n========== STRUK PEMBAYARAN ==========");
        LocalDateTime dateTimeNow = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd/MM/yyyy, HH:mm:ss");
        String dateTimeFormatted = dateTimeNow.format(formatter);
        System.out.println(dateTimeFormatted);
        System.out.println("\nUang yang dibayarkan  : " + amount);
        System.out.println("Uang yang dikembalikan  : " + (amount - kembalian));
        System.out.println("\nTerima kasih!");
        listofOrder.clear();
    }

    // CRUD Methods
//    @Override
    public List<Order> findAll() {
        return listofOrder;
    }
//    @Override
    public Order findById(Integer id) {
        return listofOrder.get(id);
    }
//    @Override
    public void save(Order data) {
        listofOrder.add(data);
    }
//    @Override
    public void update(Integer id, Order data) {
        listofOrder.set(id, data);
    }
//    @Override
    public void delete(Integer id) {
        listofOrder.remove((int)id);
    }

//    public int getHarga(int id) {
//        Order order = this.findById(id);
//        // harga = kuan x harga item
//        int harga = order.getKuantitas() * order.getMenu().getHarga();
//        order.setTotalHarga(harga);
//        return harga;
//
//    }
//
//    public int getTotalHarga() {
//        int totalHarga = 0;
//        for (Order order : listOfOrder ) {
//            totalHarga += order.getTotalHarga();
//        }
//        return totalHarga;
//    }

}
