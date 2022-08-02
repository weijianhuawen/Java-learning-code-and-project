package ld76;

public class Main {

}
class Solution1 {
    public int findClosestNumber(int[] nums) {
        int minDistance = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int x = Math.abs(nums[i]);
            if (x < minDistance) minDistance = nums[i];
            else if (x == minDistance && nums[i] > minDistance) minDistance = nums[i];
        }
        return minDistance;
    }
}

class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ans = 0;
        int n = total / cost1;
        for (int i = 0; i <= n; i++) {
            int newTotal = total - i * cost1;
            ans += 1 + newTotal / cost2;
        }
        return ans;
    }
}

class ATM {
    private int[] moneyNums;
    private final int[] moneys = {20, 50, 100, 200, 500};

    public ATM() {
        moneyNums = new int[5];
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < banknotesCount.length; i++) {
            moneyNums[i] += banknotesCount[i];
        }

    }

    public int[] withdraw(int amount) {
        int[] tmp = new int[5];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = moneyNums[i];
        }
        int[] ans = new int[5];
        int len = moneyNums.length-1;
        for (int i = len; i >=0;i--) {
            if (amount < 0) {
                moneyNums = tmp;
                return new int[]{-1};
            }
            int money = moneys[i];
            while (moneyNums[i] > 0 && money <= amount) {
                int n = amount / money;
                if (n <= moneyNums[i]) {
                    amount -= money * n;
                    moneyNums[i] -= n;
                    ans[i] += n;
                } else {
                    amount -= money * moneyNums[i];
                    moneyNums[i] = 0;
                    ans[i] += moneyNums[i];
                }
            }
        }
        if (amount == 0) {
            return ans;
        } else {
            moneyNums = tmp;
            return new int[]{-1};
        }
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */