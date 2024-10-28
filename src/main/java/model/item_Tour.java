package model;

public class item_Tour {
    private int Id_tour;
    private String Tour_name;
    private String Price;

    public item_Tour( String price, String tour_name) {
//        Id_tour = id_tour;
        Price = price;
        Tour_name = tour_name;
    }

    public int getId_tour() {
        return Id_tour;
    }

    public void setId_tour(int id_tour) {
        Id_tour = id_tour;
    }

    public String getTour_name() {
        return Tour_name;
    }

    public void setTour_name(String tour_name) {
        Tour_name = tour_name;

    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
