//juan p kuganda - f55123061
public class ProgramConstractor {
    private String merk;
    private static String pemilik;

    protected ProgramConstractor(){
        merk = null;
    }
    protected ProgramConstractor(String merk){
        this.merk = merk;
    }
    protected void setMerk(String merk){
        this.merk = merk;
    }
    protected String getMerk(){
        return merk;
    }
    protected static void setPemilik(String pemilik){
        ProgramConstractor.pemilik = pemilik;
    }
    protected static String getPemilik(){
        return ProgramConstractor.pemilik = pemilik;
    }
    protected void tampil(String a){
        System.out.println(a);
    }
    protected void hapus(){
        merk = null;
        pemilik = null;
    }
    public static void main(String[] args){
        ProgramConstractor program = new ProgramConstractor();
        program.setMerk("koenigseg");
        System.out.println("merek:" + program.getMerk());

        ProgramConstractor.setPemilik("koenigseg");
        System.out.println("pemilik:" + ProgramConstractor.getPemilik());
    }
}
