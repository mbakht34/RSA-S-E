
import java.util.ArrayList;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
       int a = new Random().nextInt(pNum(100).size());
       int b = new Random().nextInt(pNum(100).size());
       int p = pNum(100).get(a);
       int q = pNum(100).get(b);
       int r = (p-1)*(q-1);
       ArrayList<Integer> eNumbers = new ArrayList<Integer>();

// e must be 1<e<r and also co prime with p*q and r
    for (int l = 2; l<r; l++){
        if (coprimeCheck(l, p*q) == true && coprimeCheck(l, r) == true){
            eNumbers.add(l);

        }
    }
        int c = new Random().nextInt(eNumbers.size());
        int e = eNumbers.get(c);

        System.out.println(eNumbers);
        System.out.println(e);


    }

    public static ArrayList<Integer> pNum(int p) {
        ArrayList<Integer> numberArr = new ArrayList<>();
        for (int i = 2; i <= p; i++) {
            if (isPrime(i)) {
                numberArr.add(i);
            }
        }
        return numberArr;
    }
    public static boolean isPrime(int n2) {
        for (int i = 2; i < n2; i++) {
            if (n2 % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static int NCF(int a, int b)
    {
        if (a == 0 || b == 0)
            return 0;

        if (a == b)
            return a;

        // a is greater
        if (a > b)
            return NCF(a-b, b);

        return NCF(a, b-a);
    }
    public static boolean coprimeCheck(int a, int b) {

        if (NCF(a, b) == 1)
            return true;
        else
            return false;
    }


}