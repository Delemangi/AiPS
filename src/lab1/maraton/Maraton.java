package lab1.maraton;

import java.util.Arrays;

public class Maraton implements IMaraton {
    private String mesto;
    private int godina;
    private Atleticar[] atleticari;

    public Maraton() {
    }

    public Maraton(String mesto, int godina, Atleticar[] atleticari) {
        this.mesto = mesto;
        this.godina = godina;
        this.atleticari = Arrays.copyOf(atleticari, atleticari.length);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(mesto).append("\n").append(godina).append("\n");

        for (Atleticar a : atleticari) {
            sb.append(a.toString());
        }

        return sb.toString();
    }

    @Override
    public Atleticar najdobroVreme() {
        double min = atleticari[0].getVreme();
        Atleticar atleticar = atleticari[0];

        for (Atleticar a : atleticari) {
            if (a.getVreme() < min) {
                min = a.getVreme();
                atleticar = a;
            }
        }

        return atleticar;
    }

    @Override
    public int atleticariOd(String s) {
        int z = 0;

        for (Atleticar a : atleticari) {
            if (a.getZemja().equals(s)) {
                z++;
            }
        }

        return z;
    }
}