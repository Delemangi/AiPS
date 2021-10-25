package lab1.patuvanje;

public class PraznicnoPatuvanje extends Patuvanje {
    private int pocD;
    private int pocM;
    private int krajD;
    private int krajM;

    private void checkDate(int pocD, int pocM, int krajD, int krajM) throws Exception {
        if (pocM > krajM || (pocM == krajM && pocD > krajD)) {
            throw new Exception("Iskluchok");
        }
    }

    public PraznicnoPatuvanje(String ime, int cena, int pocD, int pocM, int krajD, int krajM) {
        super(ime, cena);

        try {
            checkDate(pocD, pocM, krajD, krajM);
        } catch (Exception e) {
            int temp = pocD;
            pocD = krajD;
            krajD = temp;

            temp = pocM;
            pocM = krajM;
            krajM = temp;

            System.out.println("Iskluchok");
        }

        this.pocD = pocD;
        this.pocM = pocM;
        this.krajD = krajD;
        this.krajM = krajM;
    }

    @Override
    public int vratiVremeVoDenovi() {
        return (krajM - pocM) * 30 + (krajD - pocD);
    }

    public int getPocD() {
        return pocD;
    }

    public int getPocM() {
        return pocM;
    }

    public int getKrajD() {
        return krajD;
    }

    public int getKrajM() {
        return krajM;
    }
}
