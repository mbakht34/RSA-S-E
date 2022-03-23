
import java.lang.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// Modify the display content to suit your purposes...
class menu {
     static final String TITLE =
            "\n2910326 Computer Security coursework RSA PROGRAM\n"+
                    "   by Mohammad Bakht (mbakh002), Mitchell Downes (mdown001), Mohammadparsa Hekmatnia (mhekm001)\n\n\n"+
                    "\t********************\n"+
                    "\t1. RSA Program \n" +
            "\t0. Exit \n"+
            "\t********************\n"+
            "Please input a single digit (0-1):\n";
    menu() {
        int selected=-1;
        while (selected!=0) {
            System.out.println(TITLE);
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            try {
                selected = Integer.parseInt(in.readLine());
                switch(selected) {
                    case 1:  q1();
                        break;

                        }
            }
            catch(Exception ex) {}  } // end while
        System.out.println("Bye!");
    }
    // Modify the types of the methods to suit your purposes...
    private void q1() {
        Scanner inp = new Scanner(System.in);

        System.out.println("Would you like to \n 1. Encrypt or \n 2. Decrypt a message? \n Please select 1-2");
        int sel = inp.nextInt();
        switch(sel){
            case 1:
                System.out.println("Please input message to encrypt: ");
                int input1 = inp.nextInt();
                RSAencrypt(input1);

                break;
            case 2:
                System.out.println("Please enter the encrypted message: ");
                int encMes = inp.nextInt();
                System.out.println("Please enter the decryption key: ");
                int uDecKey = inp.nextInt();
                System.out.println("Please enter the value of N: ");
                int uN = inp.nextInt();
                RSAdycrypt(encMes, uDecKey, uN);



                break;
        }




    }
    static int RSAencrypt(int userInput){
        //      RSA Program
//        select a random number out of 200
        int a = new Random().nextInt(pNum(200).size());
        int b = new Random().nextInt(pNum(200).size());

//      Create a prime number array of first 200 numbers and select a random one
//      prime number key pairs selected

        int p = pNum(200).get(a);
        int q = pNum(200).get(b);

//      N is the modulas number and T is the totient
        int N = p * q;
        int T = (p-1) * (q-1);
        int pubKey;
        for (pubKey = 0; pubKey < T; pubKey++) {

            // Checks if the number is co prime
            if (GrtComDen(pubKey,T)==1) {
                break;
            }
        }
//
        int privKey = 0;
        for (int i =0; i<=9; i++) {
//            formula for privKeyecryption or something idk
            int x = 1 + (i*T);

            if (x % pubKey == 0) {
                privKey = x / pubKey;
                break;
            }
        }
        System.out.println("the value of privKey = " + privKey);
        System.out.println("the value of N = " + N);

        double encrypted;
        encrypted = (Math.pow(userInput,pubKey))%N;
        System.out.println("Encrypted message is : " + encrypted);

        // converting int value of n to BigInteger
        BigInteger N2 = BigInteger.valueOf(N);

        // converting float value of c to BigInteger
        BigInteger encrypted2 = BigDecimal.valueOf(encrypted).toBigInteger();
        BigInteger myText;

        myText = (encrypted2.pow(privKey)).mod(N2);
        System.out.println("the decrypted text is "+ myText);


        return 0;
    }

    //  function to check the greatest common denomenator (used to find co prime numbers)

    static int GrtComDen(int e, int z)
    {
        if (e == 0)
            return z;
        else
            return GrtComDen(z % e, e);
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
    public static boolean isPrime(int myNum) {
        for (int i = 2; i < myNum; i++) {
            if (myNum % i == 0) {
                return false;
            }
        }
        return true;
    }
    static int RSAdycrypt(int enc, int priv, int N3 ){
        BigInteger N2 = BigInteger.valueOf(N3);

        // converting float value of c to BigInteger
        BigInteger encrypted2 = BigDecimal.valueOf(enc).toBigInteger();
        BigInteger myText2 = (encrypted2.pow(priv)).mod(N2);

        System.out.println("the decrypted text is "+ myText2);

        return 0;

    }

    public static void main(String[] args) {
        new menu();
    } }