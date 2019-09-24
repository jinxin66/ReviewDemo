package Test;

public class JvmTest {
/*
    jvm内存分配简单理解
    |----------线程----------|
    | |-----程序计数器-----| |
    | |--------------------| |
    | |------独占栈区------| |
    | | |-----add栈帧----| | |
    | | | |-局部变量表-| | | |
    | | | | -----------| | | |
    | | | |--操作数栈--| | | |
    | | | | -----------| | | |
    | | | |--动态链接--| | | |
    | | | | -----------| | | |
    | | | |--方法接口--| | | |
    | | | | -----------| | | |
    | | |----------------| | |
    | | | |-局部变量表-| | | |
    | | | | -----------| | | |
    | | | |--操作数栈--| | | |
    | | | | -----------| | | |
    | | | |--动态链接--| | | |
    | | | | -----------| | | |
    | | | |--方法接口--| | | |
    | | | | -----------| | | |
    | | |----------------| | |
    | |--------------------| |
    | |-----本地方法快-----| |
    | |--------------------| |
    |------------------------|
    */
    public  int add(){
        int a = 1; //将1压人操作数栈，然后弹出到局部变量表a上
        int b = 2; //将2压人操作数栈，然后弹出到局部变量表b上
        int c = (a+b)*10; //将a值，b值先后压入操作数栈，并弹出相加，将所得值及10先后压入操作数栈，弹出并相乘，写入局部变量表c上
        return c; //将 c值想到返回区，
    } //执行结束从栈顶销毁add栈帧

    public static void main(String [] args){ //开始执行时在虚拟机栈区申请一个独占内存并分配一个方法栈帧
        JvmTest test = new JvmTest();  //在虚拟机堆区申请一个内存存放 new MainTest()并将地址通过操作数栈赋值到局部变量表test上
        test.add(); //调用到add方法，在独占栈顶申请一个新的栈帧，并关将程序计数器地址放入方法接口
    }
}