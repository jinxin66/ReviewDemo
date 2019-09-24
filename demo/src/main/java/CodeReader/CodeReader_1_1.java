package CodeReader;

import com.sun.xml.internal.messaging.saaj.util.CharReader;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingQueue;

public class CodeReader_1_1 {
    public static void main(String [] args){
        Object  obj = new Object();
        System.out.println(obj + " Object "+ obj.hashCode() + " and " + obj.equals(obj.hashCode()));



        Boolean b = new Boolean(true);
        System.out.println(b + " Boolean " + b.hashCode());
        Byte bytes = 1;
        System.out.println(bytes + " Byte " + bytes.hashCode());
        Character c = '1';
        System.out.println(c + " Character " + c.hashCode());
        Short s = 1;
        System.out.println(s + " Short " + s.hashCode());
        Integer integer = new Integer(1);
        System.out.println(integer +" Integer "+ integer.hashCode() + " and " + integer.compareTo(1));//比较大小
        Long l = 1l;
        System.out.println(l + " Long " + l.hashCode());
        Float f = 1f;
        System.out.println(f + " Float " + f.hashCode());
        Double d = 1d;
        System.out.println(d + " Double " + d.hashCode());



        String str = new String("abc");
        str.concat("def");
        str.substring(1);
        System.out.println(str + " String " + str.hashCode());

        //StringBuilder StringBuffer 均继承自 AbstractStringBuilder ，具体实现时调用super的方法，而
        // StringBuffer 在重写实现方法调用super方法时加上了synchronized
        //StringBuilder StringBuffer 的 hashCode equls 继承自Object
        StringBuilder sbd = new StringBuilder("abc");
        sbd.append("def");
        sbd.substring(1);
        sbd.subSequence(1,2);
        System.out.println(sbd + " StringBuilder " + sbd.hashCode());

        StringBuffer sbf = new StringBuffer("abc");
        sbf.append("def");
        System.out.println(sbf + " StringBuffer " + sbf.hashCode());



        Vector vector = new Vector();
        vector.add(1);
        System.out.println(vector.toString() + " Vector " + vector.hashCode());

        Stack stack = new Stack();
        stack.push(1);
        System.out.println(stack.toString() + " Stack " + stack.hashCode());

        ArrayList arrayList = new ArrayList();
        Arrays arrays;
        arrayList.add(1);
        System.out.println(arrayList.toString() + " ArrayList " + arrayList.hashCode());

        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        System.out.println(linkedList.toString() + " LinkedList " + linkedList.hashCode());



        HashSet hashSet = new HashSet();
        hashSet.add(1);
        System.out.println(hashSet.toString() + " HashSet " + hashSet.hashCode());

        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(1);
        System.out.println(linkedHashSet.toString() + " LinkedHashSet " + linkedHashSet.hashCode());

        TreeSet treeSet = new TreeSet();
        treeSet.add(1);
        System.out.println(treeSet.toString() + " TreeSet " + treeSet.hashCode());



        ArrayBlockingQueue arrayBlockingQueue;
        LinkedBlockingQueue linkedBlockingQueue;



        HashMap hashMap = new HashMap();
        hashMap.put(1,1);
        System.out.println(hashMap.toString() + " HashMap " + hashMap.hashCode());
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

        Hashtable hashtable = new Hashtable();
        hashtable.put(1,1);
        System.out.println(hashtable.toString() + " Hashtable " + hashtable.hashCode());

        TreeMap treeMap = new TreeMap();
        treeMap.put(1,1);
        System.out.println(treeMap.toString() + " TreeMap " + treeMap.hashCode());

        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(1,1);
        System.out.println(linkedHashMap.toString() + " LinkedHashMap " + linkedHashMap.hashCode());

        WeakHashMap weakHashMap = new WeakHashMap();
        weakHashMap.put(1,1);
        System.out.println(weakHashMap.toString() + " WeakHashMap " + weakHashMap.hashCode());

    }
}
