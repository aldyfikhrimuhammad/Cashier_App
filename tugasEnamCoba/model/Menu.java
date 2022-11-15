package tugasEnamCoba.model;

public class Menu{

    // Variabel yang digunakan
    private String menu;
    private Integer index;
    private Integer harga;
    private Integer totalPesanan;

    // Default constructor
    public Menu(){
    }

    // Constructor
    public Menu(Integer index, String  menu, Integer harga) {
        this.index = index;
        this.menu = menu;
        this.harga = harga;
    }

    // Getter
    public Integer getIndex() {
        return index;
    }
    public String getMenu() {
        return this.menu;
    }
    public Integer getHarga() {
        return this.harga;
    }
    public Integer getTotalPesanan() {
        return totalPesanan;
    }

    // Setter
    public void setIndex(Integer index) {
        this.index = index;
    }
    public void setMenu(String menu) {
        this.menu = menu;
    }
    public void setHarga(Integer harga) {
        this.harga = harga;
    }
    public void setTotalPesanan(Integer totalPesanan) {
        this.totalPesanan = totalPesanan;
    }

    // Method cetak ke String
    @Override
    public String toString() {
        return menu + " - Rp " + harga;
    }
}