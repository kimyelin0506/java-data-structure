package me.kimyelin.algorithm.greedy;

import java.util.HashMap;
import java.util.Map;

public class Main2 {
    public static void getChangeCoins(int receiveMoney, int price){
        final int[] coins = {500,100,50,10,5,1};
        HashMap<Integer, Integer> res = new HashMap<>();
        int change = receiveMoney-price;
        int cnt=0;

        for (int coin : coins) {
            if (change < coin) {
                continue;
            }
            int q = change / coin;
            res.put(coin, res.getOrDefault(coin, 0) + q);  //getOrDefault(): 원래 있는 값 가져오기 함수
            change %= coin;
            cnt += q;
        }
        System.out.println("거스름돈 동전 개수: "+cnt);

        for(Map.Entry<Integer, Integer> cur : res.entrySet()){
            System.out.println(cur.getKey() +" : "+ cur.getValue());
        }
    }

    public static void main(String[] args){
        getChangeCoins(1000,100);
        getChangeCoins(1234,500);
    }
}
