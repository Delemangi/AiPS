package lab1.patuvanje;

public class PraznicnoPatuvanje extends Patuvanje {
    private int pocD;
    private int pocM;
    private int krajD;
    private int krajM;

    public PraznicnoPatuvanje(String ime, int cena, int pocD, int pocM, int krajD, int krajM) {
        super(ime, cena);

        try {
            if (pocM > krajM || (pocM == krajM && pocD > krajD)) {
                throw new Exception("Iskluchok");
            }

            this.pocD = pocD;
            this.pocM = pocM;
            this.krajD = krajD;
            this.krajM = krajM;
        } catch (Exception e) {
            System.out.println(e.getMessage());

            this.pocD = krajD;
            this.pocM = krajM;
            this.krajD = pocD;
            this.krajM = pocM;
        }
    }

    @Override
    public int vratiVremeVoDenovi() {
        return (krajM - pocM) * 30 + (krajD - pocD);
    }

    public int getPocM() {
        return pocM;
    }
}