public class Main {

    public static void main(String[] args) {
        BigInt bigInt=new BigInt("99");
        String s=bigInt.div("99");
        System.out.println(s);

        BigInt bigInt1=new BigInt("99");
        String s1=bigInt1.cross("99");
        System.out.println(s1);

        BigInt bigInt2=new BigInt("99");
        String s2=bigInt2.minimize("99");
        System.out.println(s2);

        BigInt bigInt3=new BigInt("99");
        String s3=bigInt3.sum("99");
        System.out.println(s3);

        BigInt bigInt4=new BigInt("99");
        int s4=bigInt4.Comparison("99");
        System.out.println(s4);

        BigInt bigInt5=new BigInt("99");
        int s5=bigInt4.Comparison(98);
        System.out.println(s5);
    }
}