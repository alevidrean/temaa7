package ex2;
enum TipTobe{ELECTRONICE,ACUSTICE}
public class SetTobe extends InstrumentMuzical {
    private TipTobe tip_tobe;
    private int nr_tobe;
    private int nr_cinele;

    public SetTobe() {}

    public SetTobe(String producator, int pret, TipTobe tip_tobe, int nr_tobe, int nr_cinele) {
        super(producator, pret);
        this.tip_tobe = tip_tobe;
        this.nr_tobe = nr_tobe;
        this.nr_cinele = nr_cinele;
    }

    public TipTobe getTipTobe()
    {
        return tip_tobe;
    }

    public int getNr_tobe()
    {
        return nr_tobe;
    }

    public int getNr_cinele()
    {
        return nr_cinele;
    }

    public void setTipTobe(TipTobe tip_tobe)
    {
        this.tip_tobe = tip_tobe;
    }


    public void setNr_tobe(int nr_tobe)
    {
        this.nr_tobe = nr_tobe;
    }

    public void setNr_cinele(int nr_cinele)
    {
        this.nr_cinele = nr_cinele;
    }

    @Override
    public String toString() {
        return super.toString() + "," + tip_tobe + "," + nr_tobe + "," + nr_cinele;
    }

}
