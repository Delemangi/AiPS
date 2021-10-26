package lab1.patuvanje;

public abstract class Patuvanje {
    private final String ime;
    private final int cena;

    public Patuvanje(String ime, int cena) {
        this.ime = ime;
        this.cena = cena;
    }

    public abstract int vratiVremeVoDenovi();

    public String getIme() {
        return ime;
    }

    public int getCena() {
        return cena;
    }
}