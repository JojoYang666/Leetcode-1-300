package leetcode_1To300;

/**
 * 本代码来自 Cspiration，由 @Cspiration 提供
 * 题目来源：http://leetcode.com
 * - Cspiration 致力于在 CS 领域内帮助中国人找到工作，让更多海外国人受益
 * - 现有课程：Leetcode Java 版本视频讲解（1-900题）（上）（中）（下）三部
 * - 算法基础知识（上）（下）两部；题型技巧讲解（上）（下）两部
 * - 节省刷题时间，效率提高2-3倍，初学者轻松一天10题，入门者轻松一天20题
 * - 讲师：Edward Shi
 * - 官方网站：https://cspiration.com
 * - 版权所有，转发请注明出处
 */
public class _134_GasStation {
    /**
     * 134. Gas Station
     * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

     You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
     You begin the journey with an empty tank at one of the gas stations.

     Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

     非常经典的一道题。可以转换成求最大连续和做，但是有更简单的方法。基于一个数学定理：

     如果一个数组的总和非负，那么一定可以找到一个起始位置，从他开始绕数组一圈，累加和一直都是非负的
     （证明貌似不难，以后有时间再补）


     有了这个定理，判断到底是否存在这样的解非常容易，只需要把全部的油耗情况计算出来看看是否大于等于0即可。

     那么如何求开始位置在哪？

     注意到这样一个现象：

     1. 假如从位置i开始，i+1，i+2...，一路开过来一路油箱都没有空。说明什么？说明从i到i+1，i+2，...肯定是正积累。
     2. 现在突然发现开往位置j时油箱空了。这说明什么？说明从位置i开始没法走完全程(废话)。那么，我们要从位置i+1开始重新尝试吗？不需要！为什么？
     因为前面已经知道，位置i肯定是正积累，那么，如果从位置i+1开始走更加没法走完全程了，因为没有位置i的正积累了。
     同理，也不用从i+2，i+3，...开始尝试。所以我们可以放心地从位置j+1开始尝试。

     https://www.cnblogs.com/boring09/p/4248482.html

     time : O(n)
     space : O(1)

     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0 || cost.length == 0 || gas.length != cost.length) return -1;
        int total = 0, sum = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += (gas[i] - cost[i]);
            if (sum < 0) {
                sum = (gas[i] - cost[i]);
                start = i;
            } else {
                sum += (gas[i] - cost[i]);
            }
        }
        return total < 0 ? -1 : start;
    }
}
