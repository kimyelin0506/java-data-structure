package me.kimyelin.set;


import java.util.ArrayList;
//Set 없이 구현하기
public class Practice {
    public static void main(String[] args){
        //test
        MySet a = new MySet();

        a.add(1);
        a.add(1);
        a.add(1);
        System.out.printf("a.list: %s\n",a.list);
        line();
        a.add(2);
        a.add(3);
        System.out.printf("a.list: %s\n",a.list);
        line();

        a = new MySet(new int[]{1,2,3,4,5});
        MySet b = new MySet(new int[]{2,4,6,8,10});
        System.out.printf("a: %s\n", a.list);
        System.out.printf("b: %s\n", b.list);
        line();

        MySet res = a.retainAll(b);
        System.out.printf("교집합: %s\n", res.list);
        line();

        res = a.addAll(b);
        System.out.printf("합집합: %s\n", res.list);
        line();

        res = a.removeAll(b);
        System.out.printf("차집합: %s\n", res.list);
        line();

    }
    private static void line(){
        System.out.println("-------------------------------");
    }
}

//집합을 위한 기능 추가
class MySet{
    //ArrayList
    ArrayList<Integer> list;
    //생성자1: 객체 생성의 역할
    MySet(){
        this.list = new ArrayList<Integer>();
    }
    //생성자2: 파라미터값을 받아 객체 생성의 역할
    MySet(int[] arr){
        this.list = new ArrayList<Integer>();
        for(int item : arr){
            this.list.add(item);
        }
    }
    //원소 추가 (중복 X)
    public void add(int x){
        for(int item: this.list){
            if(item == x){
                return;
            }
        }
        this.list.add(x);
    }
    //교집합: 기존의 a의 내용은 그대로 두고 새로운 교집합된 결과를 리턴
    public MySet retainAll(MySet b){
        MySet result = new MySet();  //반환을 위한 객체 생성

        for(int itemA : this.list){  //자기 자신의 리스트를 순회하고
            for(int itemB : b.list){  //새로 들어오는 리스트를 순회하여 리턴함
                if(itemA == itemB){
                    result.add(itemA);
                }
            }
        }
        return result;
    }
    //합집합: 기존의 a의 내용은 그대로 두고 새로운 합집합된 결과를 리턴
    public MySet addAll(MySet b){
        MySet result = new MySet();

        for(int itemA : this.list){
            result.add(itemA);
        }
        for(int itemB : b.list){
            result.add(itemB);  //위의 생성한 add(): 중복 없이 추가 가능
        }
        return result;
    }
    //차집합
    public MySet removeAll(MySet b){
        MySet result = new MySet();  //반환을 위한 새로운 자료형

        for(int itemA : this.list){
            boolean containFlag = false;

            for(int itemB : b.list){
                if(itemA == itemB){
                    containFlag = true;  //같은 원소가 있다면
                    break;
                }
            }

            if(!containFlag){  //A-B에서 살아남는 원소: 즉, B에 포함되지 않는 원소
                result.add(itemA);
            }
        }
        return result;
    }

}
