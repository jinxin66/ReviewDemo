package Algorithm;

//递归
public class Recursion {
    public  static  void  main(String[] args){
        System.out.println(Factorial(10));
        System.out.println(Reversing("abcdefghijk"));
    }

    //递归阶乘
    public static int Factorial(int n){
        if (n<=1) {
            return 1;
        } else {
            int n_1 = Factorial(n-1);
            int result = n * n_1;
            return result;
        }
    }

    //递归字符串反转
    public static String Reversing(String n){
        if (n==""||n.length()==1){
            return n;
        } else {
            String n_1 = Reversing(n.substring(1));
            String result = n_1 + n.substring(0,1);
            return  result;
        }
    }

    //递归n皇后
    public static void NQueens(int n){

    }
}
