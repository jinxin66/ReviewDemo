package Algorithm;

import sun.font.TrueTypeFont;

// 搜索排序列表
public class Indexing {
    static int str[] = {1,2,3,4,5,7,8,9,11,15,19,21,25,29,31,35,39,41,48,49,59,61,62,64,68,69,75,77,79,81,94,100};
    public static void main(String[] args){
//        System.out.println("数组长度" + str.length);
//        System.out.println("index:" + Linear(35));
//        System.out.println("index:" + Binnary(35));
        int [][] arr = {
                {1,2,3,4,5,6,7,8},
                {9,10,11,12,13,14,15,16},
                {17,18,19,20,21,22,23,24},
                {25,26,27,28,29,30,31,32},
                {33,34,35,36,37,38,39,40},
                {41,42,43,44,45,46,47,48},
                {49,50,51,52,53,54,55,56},
                {57,58,59,60,61,62,63,64}
        };
        System.out.println(dianhun(arr,3,4));
    }

    //Linear顺序查找
    public static int Linear(int n){
        int times = 0;
        for (int i=0;i<str.length;i++){
            times ++;
            if (str[i]==n){
                System.out.println("遍历次数："+ times);
                return i;
            }
        }
        return times;
    }

    //Binnary二分查找,前提是数组有序
    public static int Binnary(int n){
        int times = 0;
        int start = 0;
        int end = str.length;
        while (start<=end){
            times ++;
            int index = (start+end)/2;
            if (str[index]==n){
                System.out.println("遍历次数："+ times);
                return index;
            }
            else if (str[index]<n)
                start = index+1;
            else if (str[index]>n)
                end = index-1;
        }
        return times;
    }

    //Binary Search Trees二叉树
    //AVL Trees (Balanced binary search trees)平衡二叉树（左右子树高度差不超过1）
    //Red-Black Trees红黑树（弱平衡二叉树）（左右子树高度差不超过1倍）

    //Splay Trees
    //Open Hash Tables (Closed Addressing)
    //Closed Hash Tables (Open Addressing)
    //Closed Hash Tables, using buckets
    //Trie (Prefix Tree, 26-ary Tree)
    //Radix Tree (Compact Trie)
    //Ternary Search Tree (Trie with BST of children)

    //B Trees（在红黑树的基础上单节点存放多元素）
    //B+ Trees（B Trees的基础上在非叶子节点存放索引在叶子结点属性

    public static int dianhun(int[][] arr, int n,int m){
        System.out.println(arr[n][m]); // 直接输出这个数用于检验

        int times = 1; // 圈数 自己算第一圈
        for (int i=0;i<times;i++){
            int x = -i;
            int y = -i; // 设置遍历偏移量 初始化

            if (n+x<0 || m+y<0)
                break;
            times ++; // 判断是否出界 否则动态增加一圈

            int time = i==0 ? 1 : i*8; // 计算每圈遍历几个元素
            for (int j=0;j<time;j++){
                if (i==0); //排除特殊情况 其余进行方向判断
                else if (j<(i*2+1))
                    y++;
                else if (j<(i*2+1)*2)
                    x++;
                else if (j<(i*2+1)*3)
                    y--;
                else
                    x--;

                // 判断越界 跳出当前循环次
                if (m+y<0 || m+y>arr.length-1)
                    continue;
                if (n+x<0 || n+x>arr[m+y].length-1)
                    continue;

                System.out.println(arr[n+x][m+y]); // 遍历输出
            }
        }
        return times; // 返回圈数
    }
}
