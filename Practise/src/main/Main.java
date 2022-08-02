package main;

import java.util.*;

public class Main {
    //strExce:7_This_is_a_test    strActual:_hs_s_a_es
    public static void func(String strExce,String strActual) {
        //字符串转大写
        strExce = strExce.toUpperCase();
        strActual = strActual.toUpperCase();
        //建立机集合用来存放实际输出字符
        Set<Character> setActual = new HashSet<>();

        for (Character c : strActual.toCharArray()) {
            setActual.add(c);
        }
        //辅助集合，输出前判断字符已经输出过
        Set<Character> setAns = new HashSet<>();

        for (Character c : strExce.toCharArray()) {
            if (!setActual.contains(c) && !setAns.contains(c)) {
                System.out.print(c);
                setAns.add(c);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            func(s1, s2);
        }
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        //1.统计词频
        Map<String, Integer> map = new HashMap<>();
        for (String word: words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        //2.排序词频,Topk找词频最高的几个键值对，建小堆

        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            //词频相同时，按关键字优先字典顺序大的放在堆顶
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue().compareTo(o2.getValue()) == 0) {
                    return o2.getKey().compareTo(o1.getKey());
                }
                return o1.getValue() - o2.getValue();
            }
        });

        //3.遍历map，进行topK
        for (Map.Entry<String, Integer> x: map.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(x);
            } else {
                Map.Entry<String, Integer> top = minHeap.peek();
                if (x.getValue() == top.getValue() && x.getKey().compareTo(top.getKey()) < 0) {
                    minHeap.poll();
                    minHeap.offer(x);
                } else if (x.getValue() > top.getValue()) {
                    minHeap.poll();
                    minHeap.offer(x);
                }
            }
        }

        //4.将minHeap元素逆序存入List

        List<String> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (!minHeap.isEmpty()) {
                list.add(minHeap.poll().getKey());
            }
        }
        Collections.reverse(list);
        return list;
    }
}