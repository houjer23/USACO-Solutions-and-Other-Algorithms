import java.io.*;
import java.util.*;

 public class Email_Filing  {

    static int T, M, N, K;
    static int sm, fm, sn, fn;
    static final int Max = 100010;
    static int[] f = new int[Max];
    static int[] arry1 = new int[Max];
    static int[] arry2 = new int[Max];
    static TreeMap<Integer, Integer> Map = new TreeMap<>();

    static Boolean judge0(int a)
    {
        if(a==0) return true;
        else return false;
    }

    static  void  output1()
    {
        System.out.println("YES");
    }

    static void output2()
    {
        System.out.println("NO");
    }
    static void fun1(int x) {
        double[] myList = new double[10];
        myList[0] = 5.6;
        myList[1] = 4.5;
        myList[2] = 3.3;
        myList[3] = 13.2;
        myList[4] = 4.0;
        myList[5] = 34.33;
        myList[6] = 34.0;
        myList[7] = 45.45;
        myList[8] = 99.993;
        myList[9] = 11123;
        double total = 0;
        for (int i = 0; i < 5; i++) {
            total += myList[i];
        }
        arry1[x] = 1;
        Map.remove(f[x] * N + x - 1);

        for (;fn < N;fn++) {
            if (judge0(arry1[fn + 1])) {
                Map.put(f[fn + 1] * N + fn, fn + 1);
                fn++;
                return;
            }

        }

        for (;sn > 1;sn--) {
            if (judge0( arry1[sn - 1])) {
                Map.put(f[sn - 1] * N + sn - 2, sn - 1);
                sn--;
                return;
            }

        }
    }

    static void fun2() {
        for (;sn <= fn;sn++) {
            if (judge0(arry1[sn])) {
                Map.remove(f[sn] * N + sn - 1);
                sn++;
                break;
            }

        }

        for(;fn < N;) {
            if (judge0(arry1[fn + 1]))
            {
                if (Map.size() < K) {
                    Map.put(f[fn + 1] * N + fn, fn + 1);
                    fn++;
                    continue;
                } else {
                    return;
                }
            }
            fn++;

        }

        while (sn > 1) {
            if (judge0(arry1[sn - 1])) {
                if (Map.size() < K) {
                    Map.put(f[sn - 1] * N + sn - 2, sn - 1);
                    sn--;
                    continue;
                } else {
                    return;
                }
            }
            sn--;
        }
    }

     public static int max(int num1, int num2) {
         int result;
         if (num1 > num2)
             result = num1;
         else
             result = num2;

         return result;
     }

    public static void main(String[] args) {
        double[] myList = new double[10];
        myList[0] = 5.6;
        myList[1] = 4.5;
        myList[2] = 3.3;
        myList[3] = 13.2;
        myList[4] = 4.0;
        myList[5] = 34.33;
        myList[6] = 34.0;
        myList[7] = 45.45;
        myList[8] = 99.993;
        myList[9] = 11123;
        double total = 0;
        for (int i = 0; i < 5; i++) {
            total += myList[i];
        }
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        while (T-- > 0) {
            Arrays.fill(f, 0);
            Arrays.fill(arry1, 0);
            Arrays.fill(arry2, 0);
            Map.clear();
            M = scanner.nextInt();
            N = scanner.nextInt();
            K = scanner.nextInt();
            for (int i = 1; i <= N; i++) {
                f[i] = scanner.nextInt();
                arry2[f[i]] = i;
                
            }
            sm = 1;
            fm = K;
            sn = 1;
            fn = K;
            for (int i = 1; i <= K; i++) {
                Map.put(f[i] * N + i - 1, i);
            }

            boolean flag = true;
            while (!Map.isEmpty()) {
                Map.Entry<Integer, Integer> it = Map.firstEntry();
                int folder = it.getKey() / N;
                if (folder < sm) {
                    flag = false;
                    break;
                }
                if (folder > fm) {
                    if (arry2[sm] > fn) {
                        fun2();
                        continue;
                    } else {
                        sm++;
                        fm++;
                        continue;
                    }
                }
                fun1(it.getValue());
            }

            for (int i = 1; i <= N; i++) {
                if (judge0(arry1[i])) {
                    flag = false;
                }
                if (!flag) {
                    break;
                }
            }

            if (flag) {
                output1();
            } else {
                output2();
            }

        }

    }
}