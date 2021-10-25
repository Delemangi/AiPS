package lab1.maraton;

public class Atleticar {
    private String ime;
    private String pol;
    private int vozrast;
    private double vreme;
    String zemja;

    public Atleticar() {
    }

    public Atleticar(String ime, String pol, int vozrast, double vreme, String zemja) {
        this.ime = ime;
        this.pol = pol;
        this.vozrast = vozrast;
        this.vreme = vreme;
        this.zemja = zemja;
    }

    @Override
    public String toString() {
        return String.format("%s%n%d%n%s%n%.1f%n", ime, vozrast, zemja, vreme);
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public int getVozrast() {
        return vozrast;
    }

    public void setVozrast(int vozrast) {
        this.vozrast = vozrast;
    }

    public double getVreme() {
        return vreme;
    }

    public void setVreme(double vreme) {
        this.vreme = vreme;
    }

    public String getZemja() {
        return zemja;
    }

    public void setZemja(String zemja) {
        this.zemja = zemja;
    }
}