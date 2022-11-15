package tugasEnamCoba.service;
import java.util.ArrayList;
import java.util.List;

import tugasEnamCoba.model.Menu;

public class MenuDAOImp implements MenuDAO<Menu, Integer> {

        // Instance object List
        private Menu menu = new Menu();
        List<Menu> menuDao = new ArrayList<>();
        List<Menu> makanan;
        List<Menu> minuman;
        List<Menu> paket;


        // Override CRUD method
        @Override
        public List<Menu> findAll() {
            return menuDao;
        }
        @Override
        public Menu findById(Integer id) {
            return menuDao.get(id);
        }
        @Override
        public void save(Menu data) {
            menuDao.add(data);
        }
        @Override
        public void update(Integer id, Menu data) {
            menuDao.set(id, data);
        }
        @Override
        public void delete(Integer id) {
            menuDao.remove((int) id);
        }

        // Getter Methods
    @Override
    public void getMakanan() {
    }
    @Override
    public String getNamaMakanan(Integer index) {
        menu = makanan.get(index);
        return menu.getMenu();
    }
    @Override
    public int getHargaMakanan(Integer index) {
        menu = makanan.get(index);
        return menu.getHarga();
    }
    @Override
    public void getMinuman() {
    }
    @Override
    public String getNamaMinuman(Integer index) {
        menu = minuman.get(index);
        return menu.getMenu();
    }
    @Override
    public int getHargaMinuman(Integer index) {
        menu = minuman.get(index);
        return menu.getHarga();
    }
    @Override
    public void getPaket() {
    }
    @Override
    public String getNamaPaket(Integer index) {
        menu = paket.get(index);
        return menu.getMenu();
    }
    @Override
    public int getHargaPaket(Integer index) {
        menu = paket.get(index);
        return menu.getHarga();
    }

}

