package lab1.patuvanje;

public class GodishenOdmor extends Patuvanje {
    private final int vreme;

    public GodishenOdmor(String ime, int cena, int vreme) {
        super(ime, cena - 1000);
        this.vreme = vreme;
    }

    @Override
    public int vratiVremeVoDenovi() {
        return vreme;
    }
}