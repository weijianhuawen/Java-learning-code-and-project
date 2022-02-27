import java.util.*;

public class Test {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>();//创建基于小根堆的优先队列
        priorityQueue1.offer(1);
        priorityQueue1.offer(2);
        priorityQueue1.offer(3);
        System.out.println(priorityQueue1);
        System.out.println("============");
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });//使用隐藏内部类创建基于小根堆的优先队列
        priorityQueue2.offer(1);
        priorityQueue2.offer(2);
        priorityQueue2.offer(3);
        System.out.println(priorityQueue2);
        System.out.println("============");
        PriorityQueue<Integer> priorityQueue3 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });//使用隐藏内部类创建基于大根堆的优先队列
        priorityQueue3.offer(1);
        priorityQueue3.offer(2);
        priorityQueue3.offer(3);
        System.out.println(priorityQueue3);
        System.out.println("============");
        PriorityQueue<Integer> priorityQueue4 = new PriorityQueue<>((x, y) -> x-y);//使用lambda表达式创建基于小根堆的优先队列
        priorityQueue4.offer(1);
        priorityQueue4.offer(2);
        priorityQueue4.offer(3);
        System.out.println(priorityQueue4);
        System.out.println("============");
        PriorityQueue<Integer> priorityQueue5 = new PriorityQueue<>((x, y) -> y-x);//使用lambda表达式创建基于大根堆的优先队列
        priorityQueue5.offer(1);
        priorityQueue5.offer(2);
        priorityQueue5.offer(3);
        System.out.println(priorityQueue5);
        System.out.println("============");
        PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o2.get(0) + o2.get(1) - o1.get(0) - o1.get(1);
            }
        });
    }
}
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //构造大根堆
        PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o2.get(0) + o2.get(1) - o1.get(0) - o1.get(1);
            }
        });
        int cnt = 0;
        for (int i = 0; i < Math.min(k,nums1.length); i++) {
            for (int j = 0; j < Math.min(k, nums2.length); j++) {
                List<Integer> digits = new ArrayList<>();
                digits.add(nums1[i]);
                digits.add(nums2[j]);
                if (cnt < k) {
                    priorityQueue.offer(digits);
                    cnt++;
                } else {
                    int topAdd = priorityQueue.peek().get(0) + priorityQueue.peek().get(1);
                    if (digits.get(0) + digits.get(1) < topAdd) {
                        //1.出堆顶元素
                        priorityQueue.poll();
                        //2.入目标元素
                        priorityQueue.offer(digits);
                    }
                }
            }
        }
        //返回值是List所以先得将优先队列转换成List再返回
        List<List<Integer>> ret = new ArrayList(priorityQueue);
        return ret;
    }
    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {

        PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>(k, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return (o2.get(0)+o2.get(1))-(o1.get(0)+o1.get(1));
            }
        });
        for (int i = 0; i < Math.min(nums1.length,k); i++) {
            for (int j = 0; j < Math.min(nums2.length,k); j++) {
                if(maxHeap.size() < k) {
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(nums1[i]);
                    tmpList.add(nums2[j]);
                    maxHeap.offer(tmpList);
                }else {
                    int top = maxHeap.peek().get(0) + maxHeap.peek().get(1);
                    if(top > nums1[i]+nums2[j]) {
                        //记住  要弹出的
                        maxHeap.poll();

                        List<Integer> tmpList = new ArrayList<>();
                        tmpList.add(nums1[i]);
                        tmpList.add(nums2[j]);
                        maxHeap.offer(tmpList);
                    }
                }
            }
        }
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < k && !maxHeap.isEmpty(); i++) {
            ret.add(maxHeap.poll());
        }
        return ret;
    }
}
