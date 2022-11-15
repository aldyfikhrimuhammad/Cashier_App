package tugasEnamCoba.model;

public class Order {

    // Variabel yang digunakan
    private int index, kuantitas, pesanan, totalHarga;
    private Menu menu;

    // Default constructor
    public Order(){
    }

    // Constructor
    public Order(int kuantitas, Menu menu){
        this.kuantitas = kuantitas;
        this.menu = menu;
    }

    // Setter
    public void setIndex(int index) {
        this.index = index;
    }
    public void setKuantitas(int kuantitas) {
        this.kuantitas = kuantitas;
    }
    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }
    public void setPesanan(int pesanan) {
        this.pesanan = pesanan;
    }

    // Getter
    public int getIndex() {
        return index;
    }
    public int getKuantitas() {
        return kuantitas;
    }
    public Menu getMenu() {
        return menu;
    }
    public int getTotalHarga() {
        return totalHarga;
    }
    public int getPesanan() {
        return pesanan;
    }
}
