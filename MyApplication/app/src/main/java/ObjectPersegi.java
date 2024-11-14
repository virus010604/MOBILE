//Juan P Kuganda - F55123061
public class ObjectPersegi {
    private int panjang;
    private int lebar;
    private int r;
    private int t;

    public void setJari(int r){
        this.r = r * r;
    }
    public void setTinggi(int t){
        this.t = t;
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
    public double hitungTabung(){
        return  r * t * 3.14;
    }
    public static void main(String[] args){
        ObjectPersegi a = new ObjectPersegi();
        a.setPanjang(10);
        System.out.println("Panjang: " + a.panjang);
        a.setLebar(5);
        System.out.println("Lebar: " + a.lebar);
        int luas = a.hitungluas();
        System.out.println("Luas Persegi adalah " + luas);

        System.out.println("\n\n===========================\n\n");
        a.setJari(2);
        System.out.println("Jari-jari: " + a.r);
        a.setTinggi(10);
        System.out.println("Tinggi: " + a.t);
        double luas2 = a.hitungTabung();
        System.out.println("Luas Persegi adalah " + luas2);
    }
}

