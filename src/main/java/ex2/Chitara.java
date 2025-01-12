package ex2;

enum TipChitara{ELECTRICA,ACUSTICA,CLASICA}
public class Chitara extends InstrumentMuzical{
    private TipChitara tip_chitara;
    private int nr_corzi;

    public Chitara() {}

    public Chitara(String producator, int pret, TipChitara tip_chitara, int nr_corzi) {
        super(producator, pret);
        this.tip_chitara = tip_chitara;
        this.nr_corzi = nr_corzi;
    }

    public TipChitara getTipChitara()
    {
        return tip_chitara;
    }

    public int getNr_corzi()
    {
        return nr_corzi;
    }

    public void setTipChitara(TipChitara tipChitara)
    {
        this.tip_chitara = tipChitara;
    }

    public void setNr_corzi(int nr_corzi)
    {
        this.nr_corzi = nr_corzi;
    }

    @Override
    public String toString() {
        return super.toString() + "," + tip_chitara + "," + nr_corzi;
    }

}
