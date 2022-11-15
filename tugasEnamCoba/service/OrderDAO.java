package tugasEnamCoba.service;

import java.util.List;

public interface OrderDAO<K> {

    void order(List<K> index, List<K> orders, List<K> type);
    void payment(K amount, K kembalian);
    void getOrders();
    int getTotalPesananPPN();

}
