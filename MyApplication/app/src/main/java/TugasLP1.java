//Juan P Kuganda - F55123061
public class TugasLP1 {
    private int panjang;
    private int lebar;
    private int t;
    private int r;

    public void setT(int t){
        this.t = t;
    }
    public void setR(int r){
        this.r = r * r;
    }
    public double hitungTabung(){
        return  3.14 * t * r;
    }
    public void setPanjang(int panjang){
        this.panjang = panjang;
    }
    public void setLebar(int lebar){
        this.lebar = lebar;
    }
    public int hitungluas(){
        return  panjang * lebar;
    }
    public static void main(String[] args){
        TugasLP1 rumus = new TugasLP1();
        rumus.setPanjang(10);
        System.out.println("Panjang: " + rumus.panjang);
        rumus.setLebar(5);
        System.out.println("Lebar: " + rumus.lebar);
        int luas = rumus.hitungluas();
        System.out.println("Luas Persegi adalah " + luas);
        System.out.println("\n=============================\n");
        rumus.setR(4);
        System.out.println("nilai r: " + rumus.r);
        rumus.setT(13);
        System.out.println("nilai t: " + rumus.t);
        double volume = rumus.hitungTabung();
        System.out.println("Volume tabung: " + volume);
    }
}
