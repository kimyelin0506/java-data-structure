package me.kimyelin.Data_Structure.array;

import java.util.Arrays;

import static me.kimyelin.Main.line;

//기본 배열 자료형을 이용한 배열의 생성, 삽입, 삭제 기능 구현
class MyArray {
    int arr[];
    // 배열의 초기 사이즈 설정
    MyArray(int size){
        this.arr = new int[size];
    }

    //배열에 데이터 추가
    public void insertData(int index, int data){
        if(index < 0 || index > this.arr.length){
            System.out.println("indext Error");
            return;
        }

        int[] arrDup = this.arr.clone();  // 기존 데이터들을 복사
        this.arr = new int[this.arr.length+1];  // 기존의 배열보다 한 사이즈 크게 만듬
        for (int i = 0; i < index; i++) {  // 바꾸려기 전의 위치까지의 데이터는 그대로 삽입
            this.arr[i] = arrDup[i];
        }
        for (int i = index+1; i < this.arr.length; i++) {  // 추가하고 난 뒤의 배열도 그대로 삽입 -> 넣으려는 자리 하나 빼고
            this.arr[i] = arrDup[i-1];
        }
        this.arr[index] = data;
    }

    //배열에 특정 데이터 삭제: 메모리 보존을 위해 새로 배열을 만듬
    public void removeData(int data){
        int targetIndex = -1;
        for (int i = 0; i < this.arr.length; i++) {
            if(this.arr[i] == data){
                targetIndex = i;
                break;
            }
        }

        if(targetIndex == -1){
            System.out.println("not equals data");
            return;
        }else{
            int[] arrDup = this.arr.clone();
            this.arr = new int[this.arr.length-1];
            for (int i = 0; i < targetIndex; i++) {
                this.arr[i] = arrDup[i];
            }
            for(int i=targetIndex+1; i<this.arr.length; i++){
                this.arr[i] = arrDup[i];
            }
        }
    }

}

public class Practice {
    public static void main(String[] args){
        int size = 5;
        MyArray myArray = new MyArray(size);

        for (int i = 0; i < size; i++) {
            myArray.arr[i] = i+1;
        }
        System.out.println(Arrays.toString(myArray.arr));
        line();

        myArray.arr[0] = 10;
        System.out.println(Arrays.toString(myArray.arr));
        line();

        myArray.insertData(2, 20);
        System.out.println(Arrays.toString(myArray.arr));
        line();
        myArray.insertData(6, 60);
        System.out.println(Arrays.toString(myArray.arr));
        line();

        myArray.insertData(-1, 0);

        myArray.removeData(4);
        System.out.println(Arrays.toString(myArray.arr));
        line();

        myArray.removeData(5);
        System.out.println(Arrays.toString(myArray.arr));
        line();

        myArray.removeData(100);
    }
}
