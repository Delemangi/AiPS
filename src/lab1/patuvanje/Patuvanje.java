package lab1.patuvanje;

public abstract class Patuvanje {
    private String ime;
    private int cena;

    public Patuvanje(String ime, int cena) {
        this.ime = ime;
        this.cena = cena;
    }

    public abstract int vratiVremeVoDenovi();

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }
}