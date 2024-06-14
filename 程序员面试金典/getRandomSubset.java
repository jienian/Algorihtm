
/**
 * 13.8: lambda 随机数
 * 
 * 要使用 lambda 表达式来编写一个方法 getRandomSubset(List<Integer> list)，
 * 返回一个列表中所有可能的子集（包括空子集）的随机子集，并且每个子集被选中的概率都相同，
 * 我们可以考虑使用 Random 类和 Stream API 来实现。核心思路是对每个元素独立地进行随机决定，是否将其包含在结果子集中。
 * 
 */


package com.spd.carinfo.ui;

import androidx.core.util.Supplier;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SubsetGenerator {
    public static List<Integer> getRandomSubset(List<Integer> list){
        Random rand = new Random();
        Supplier<Boolean> coinFlip  = () -> rand.nextBoolean();
        return list.stream()
                .filter(item -> coinFlip.get())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);
        List<Integer> randomSubset = getRandomSubset(list);
        System.out.println(randomSubset);

    }
}
