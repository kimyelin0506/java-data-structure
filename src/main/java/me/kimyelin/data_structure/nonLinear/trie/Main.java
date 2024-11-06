package me.kimyelin.data_structure.nonLinear.trie;

import java.util.HashMap;

import static me.kimyelin.Main.line;

class Node{
    HashMap<Character, Node> child;
    boolean isTerminal;

    public Node(){
        this.child = new HashMap<>();
        this.isTerminal = false;
    }
}
class Trie{
    Node root;

    public Trie(){
        this.root = new Node();
    }

    public void insert(String str){
        Node cur = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);  //단어 하나씩 끊어서

            //putIfAbsent(): HashMap 의 기능으로, 데이터가 있다면 추가, 없다면 넘어감
            cur.child.putIfAbsent(c, new Node());  //넣고
            cur = cur.child.get(c);  //현재 노드를 다음 노드로 넘어감

            if(i == str.length()-1){  //단어가 마지막이라면
                cur.isTerminal = true;  //마지막 단어라는 의미를 부여
                return;
            }
        }
    }

    public boolean search(String str){
        Node cur = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            //containsKey(): HashMap 에서 제공하는 기능으로, 키값 비교
            if(cur.child.containsKey(c)){
                cur = cur.child.get(c);
            }else{
                return false;
            }

            //문자열의 끝을 도착한 경우, 바로 true 를 반환하는 것이 아니라 isTerminal 확인
            if(1 == str.length()-1){
                if(!cur.isTerminal){
                    return false;
                }
            }
        }
        return true;
    }

    public void delete(String str){
        boolean ret = this.delete(this.root,str,0);
        if(ret){
            System.out.println(str+" 삭제 완료");
        }else{
            System.out.println(str+" 단어가 없음");
        }
    }

    //재귀적으로 비교하며 호출
    public boolean delete(Node node, String str, int idx){
        char c = str.charAt(idx);

        if(!node.child.containsKey(c)){  //단어가 없다면
            return false;
        }

        Node cur = node.child.get(c);
        idx++;
        if(idx == str.length()){  //지워야 하는 단어를 찾은 후
            if(!cur.isTerminal){
                return false;
            }

            cur.isTerminal = false;

            if(cur.child.isEmpty()){
                node.child.remove(c);
            }
        }else{  //지워야 하는 단어를 찾기 전
            if(!this.delete(cur,str,idx)){
                return false;
            }
            if(!cur.isTerminal && cur.child.isEmpty()){
                node.child.remove(c);
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("april");
        trie.insert("app");
        trie.insert("ace");
        trie.insert("bear");
        trie.insert("best");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("april"));
        System.out.println(trie.search("app"));
        System.out.println(trie.search("ace"));
        System.out.println(trie.search("bear"));
        System.out.println(trie.search("best"));
        System.out.println(trie.search("abc"));
        line();

        trie.delete("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("april"));
        System.out.println(trie.search("appl"));
        trie.delete("apple");

    }
}
