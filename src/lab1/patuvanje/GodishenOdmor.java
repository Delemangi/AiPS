package lab1.patuvanje;

public class GodishenOdmor extends Patuvanje {
    private int vreme;

    public GodishenOdmor(String ime, int cena, int vreme) {
        super(ime, cena);
        this.vreme = vreme;
    }

    @Override
    public int vratiVremeVoDenovi() {
        return vreme;
    }

    public int getVreme() {
        return vreme;
    }
}
