package me.kimyelin.algorithm.greedy;

import java.util.ArrayList;

class Activity{
    String name;
    int start;
    int end;

    Activity(String name, int start, int end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }
}

public class Main {
    public static void selectActivity(ArrayList<Activity> list){
        //종료 시간 기준으로 오름차순
        //Collections.sort(list, (x1, x2)->x1.end - x2.end);
        list.sort((x1, x2) -> x1.end - x2.end);

        int curTime = 0;
        ArrayList<Activity> res = new ArrayList<>();
        for(Activity item : list){
            if(curTime <= item.start){
                curTime = item.end;
                res.add(item);
            }
        }

        for(Activity item: res){
            System.out.print(item.name+" ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        ArrayList<Activity> ls = new ArrayList<>();
        ls.add(new Activity("A",1,5));
        ls.add(new Activity("B",4,5));
        ls.add(new Activity("C",2,3));
        ls.add(new Activity("D",4,7));
        ls.add(new Activity("E",6,10));
        selectActivity(ls);
    }
}
