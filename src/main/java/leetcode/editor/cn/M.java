package leetcode.editor.cn;

import java.util.Map;

public class M {

    public static void p(Map map){
        if (map==null) {
            System.out.println("null");
        }
        System.out.println("==================  size" + map.size());
        map.forEach((k,v)->{
            System.out.println(k + "->" + v);
        });

    }

    public static void main(String[] args) {

    }
}