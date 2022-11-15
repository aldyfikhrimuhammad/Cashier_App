package tugasEnamCoba.service;

import java.util.List;

public interface MenuDAO<T, K> {

    // CRUD methods
    List<T> findAll();
    T findById(K id);
    void save(T data);
    void update(K id, T data);
    void delete(K id);

    void getMakanan();
    String getNamaMakanan(K index);
    int getHargaMakanan(K index);

    void getMinuman();
    String getNamaMinuman(K index);
    int getHargaMinuman(K index);

    void getPaket();
    String getNamaPaket(K index);
    int getHargaPaket(K index);
}
