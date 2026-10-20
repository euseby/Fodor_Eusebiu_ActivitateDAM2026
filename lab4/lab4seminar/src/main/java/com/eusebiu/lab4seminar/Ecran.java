package com.eusebiu.lab4seminar;

import java.io.Serializable;

public class Ecran implements Serializable {
    private String producator;
    private boolean esteOled;
    private String format;
    private String rezolutie;
    private float rating;
    private boolean esteSmart;

    public Ecran(String producator,boolean esteOled, String format, String rezolutie, float rating, boolean esteSmart){
        this.producator = producator;
        this.esteOled = esteOled;
        this.format = format;
        this.rezolutie = rezolutie;
        this.rating = rating;
        this.esteSmart = esteSmart;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ecran{");
        sb.append("producator='").append(producator).append('\'');
        sb.append(", esteOled=").append(esteOled);
        sb.append(", format='").append(format).append('\'');
        sb.append(", rezolutie='").append(rezolutie).append('\'');
        sb.append(", rating=").append(rating);
        sb.append(", esteSmart=").append(esteSmart);
        sb.append('}');
        return sb.toString();
    }
}
