# java-data-structure-practice
  ## 학습 목표 
   - 알고리즘 학습 전 자바로 자료구조, 기초수학 학습하기
   - 이론을 실제 자바로 구현하기
   - 학습과 동시에 git 활용 방법 적응하기

# [기초수학]
### 기초수학-1주차
    1. git, project setting
        (1) git과 프로젝트 연동
            - 인텔: [Sytem Build: Gradle], [JDK: Oracle 21]로 프로젝트 생성
            - 인텔: Git-Github에 repository 생성
            - cmd: [branch 전환: $ git branch -b {전환할 이름}] 
        (2) 환경 설정 - 자바 인텔 한글깨짐(Gradle) 설정
            - [File]-[Settings]-[File Encodings]-Global, [Project Encoding, Properties Files 설정: UTF-8]
            - [File]-[Settings]-[Build, Exexcution Deplyment]-[Gradle]: 모두 Intellij IDEA 변경

    2. practice: 집합
        (1) Set function(java.util.HashSet)
            - 자바에서 집합 사용: HashSet 이용
            - HashSet은 새로운 객체로 결과값을 리턴하는 것이 아니므로 새로운 객체를 리턴하는 MySet 설정
        (2) MySet: 공통-반환을 위한 새로운 객체(파라미터X)를 만들고, 파라미터를 입력받는 생성자를 통해 기능처리(중복X)
            - 교집합(retianAll(MySet b)): 자기 자신의 리스트를 순회하면서 파라미터 값으로 새로 들어오는 리스트 또한 
                순회하여 같은 값이 있다면 새로운 객체에 담아 반환
            - 합집합(addAll(MySet b)): 자기 자신의 리스트를 순회하며 새로 반환할 객체에 담고, 새로 들어온 객체의 
                리스트에서 중복되지 않는 값 또한 넣어 반환
            - 차집합(removeAll(MySet b)): 자기 자신의 리스트를 순회하면서 새로 들어온 객체의 리스트도 순회하며 같은   
                값이 없다면 새로운 객체에 값을 담아 리턴함
### 기초수학-2주차
    1. practice: 경우의 수
        (1) 경우의 수-곱의 법칙과 합의 법칙
            - 곱의 법칙: 사건A 와 사건B 가 동시에 일어날 경우의 수
            - 합의 법칙: 사건A 또는 사건B 가일어날 경우의 수
        (2) 약수: (M % N == 0)일 경우, N은 M의 약수임(0 < N <= M)
        (3) 최대공약수(GCD): A와 B의 공통 약수이면서 가장 큰 수
            - 자신의 수의 절반 이하만 약수임, 예외는 자기 자신
        (4) 최소공배수(LCM): A와 B의 공통 약수이면서 가장 작은 수
            >> LCM = A*B / GCD
### 기초수학-3주차
    1. practice: 순열
        (1) 팩토리얼(Factorial): 1~n까지의 모든 자연수의 곱
            >> n! = n(n-1)(n-2)...1
        (2) 순열(Permutation): 순서를 정하여 나열, 서로 다른 n개 줄에 r개를 선택하는 경우의 수(순서O, 중복X)
            >> nPr = n!/(n-r)! = n(n-1)(n-2)...(n-r+1) (0<r<=n)
            * practice 1
                -자릿수를 바꿔나가면서 앞의 뽑는 개수(r)만큼 확인하여 경우의 수 추출
                -swap을 이용하여 자릿수를 바꿈
                -재귀함수를 이용하여 호출할 때마다 depth를 늘려 자릿수 변경
                -원하는 자릿수(r)만큼 만들어졌다면 원소를 추출하고 전으로 돌아감 -> 반복
            * practice 2
                -visited[]를 이용하여 해당 자리를 방문했을 경우 true, 방문하지 않았다면 false를 나타냄
                -해당 자리를 방문하지 않았다면 방문을 알리고(true), 그 자리를 out[]에 저장 후 재귀함수를 통해 다음으로 넘어감
                -원하는 자깃수(r)만큼 반복된 경우 원소를 추출하고 이전으로 돌아가 반복
        (3) 중복 순열(Duplicate Permutation): 서로 다른 n개 중에 r개를 선택하는 경우의 수(순서O, 중복O)
            >> n^r
        (4) 원 순열(Circle Permutation): 원 모양의 테이블에 n개의 원소를 나열하는 경우의 수
            >> (n-1)!
### 기초수학-4주차
    1. practice: 조합
        - 순열과 팩토리얼을 이용해 구현 가능
        (1) 조합(Combination): 서로 다른 n개 중에서 r개를 선택하는 경우의 수(순서X,중복X)
            >> nCr = n!/(n-r)!*r! = nPr/r! = n(n-1)(n-2)...(n-r+1)/r(r-1)...1
            * week3의 *practice2를 이용하여 구현
                -현재 함수가 방문하고 있는 자릿수를 true로 표시
                -재귀함수를 이용하여 자릿수+1을 파라미터 값으로 넘기고, 앞서 원소 하나를 뽑았으므로 뽑을 개수-1을 넣어 전달
                -위를 반복하다 원소를 다 뽑으면(r==0) 그동안의 원소를 호출하고 돌아감
                -돌아와서 방문하고 있던 자릿수를 false로 바꾸고, 재귀함수를 이용해 자릿수+1을 넘김
                -위를 반복하여 원소를 추출하고 자릿수가 끝까지 다 돌면 종료함
        (2) 중복 조합(Duplicate Combination): 서로 다른 n개 중에서 r개를 선택하는 경우의 수(순서X,중복O)
            >> nHr = (n+r-1)Cr
### 기초수학-5주차
    1. practice: 정화식과 재귀함수
        (1) 정화식(Recurrence): 어떤 수열의 일반항을 그 이전의 항들을 이용하여 정의한 식
            >> F1 = F2 = 1, F(n+2) = F(n+1) + F(n) //피보나치 수열
        (2) 재귀 함수(Recursive Function): 어떤 함수가 자신을 다시 호출하여 작업을 수행하는 방식
            *Practice1: factorial을 재귀함수로 구현
                -현재 수의 factorial = 현재의 수*이전의 수 이므로 return값에 넣어줌
                -종료 조건식으로 현재의 수가 1이되는 경우에는 1을 리턴하며 종료
            *Practice2: 최대공약수를 재귀함수로 구현
                -최대공약수는 두 수의 공통 약수 중 가장 큰 수를 구하는 것이므로
                -두 수의 공통점을 찾기 위해 두 수를 서로 나누고 나머지 구해서 나누는 것을 반복하면서
                -처음으로 나머지가 0이 되는 경우가 둘이 서로 가진 약수 중 가장 큰 수임 
### 기초수학-6주차
    1. practice: 지수와 로그
        (1) 제곱(pow): 같은 수를 두번 곱함, 거듭제곱: 같은 수를 거듭하여 곱함
            *마이너스 지수를 적용하기 위해 마이너스 유무를 판단하여 마이너스인 경우 역수를 취함
        (2) 제곱근(sqrt): a를 제곱하여 b가 될 때, a를 b의 제곱근이라고 함
            *바빌로니아법 이용: 반복할수록 제곱근의 근사값에 접근
        (3) 로그(log): a가 b로 되기 위해 제곱해야 하는 횟수
### 기초수학-7주차
    1.practice: 알고리즘 복잡도
        (1) 복잡도(Complexity): 알고리즘의 성능을 나타내는 척도, 시간 복잡도와 공간 복잡도는 Trade-off관계
            -빅오 표기법 사용(Big O): 최악의 경우 기준
        (2) 시간 복잡도(Time Complexity): 알고리즘의 필요 연산 횟수
            >> [낮은 복잡도] O(1) < O(logN) < O(N) < O(NlogN) < O(N^2) < O(2^N) [높은 복잡도]
        (3) 공간 복잡도(Space Complexity): 알고리즘의 필요 메모리 사용량

# [자료구조]
### 자료구조-1주차
    1. practice: 배열
        *pracrice: 생성된 배열에서 요소를 삭제하거나 추가하기 위해서는 
            (삭제) 
                배열에 같은 값을 가지는 요소가 있는지 확인 후, 있다면 그 값의 인덱스를 구하고 인덱스를 기준으로   
                새로운 배열(기존의 길이-1)에 기존 값 추가, 타겟 인덱스 후의 값도 추가하여 길이조정된 새로운 배열을 생성
            (추가) 
                기존 배열의 길이보다 인덱스의 크기가 크지 않은지 확인 후. 넣고 싶은 인덱스 자리를 기준으로 
                새로운 배열(기존의 길이+1)에 기존 값 추가, 타겟 인덱스 후의 값도 추가 후 타겟 인덱스에 데이터를 삽입하여 
                새로운 배열을 생성
        (1) 배열(Array)
            -많은 수의 데이터를 다룰 때 사용하는 자료구조
            -각 데이터를 인덱스와 1:1 대응
            -데이터가 메모리 상에 연속적인 저잘
        (2) 장점: 인덱스를 이용하여 데이터에 빠르게 접근 가능
        (3) 단점: 데이터의 추가/삭제가 번거로움
            -미리 최대길이를 정해서 생성
            -가변 길이 배열은 배열의 크기를 변경할 때마다 새로운 배열을 생성
            -데아터 삭제 시, 인덱스를 유지하기 위해 빈공간 유지
### 자료구조-2주차
    1. practice: 연결 리스트
        *practice1: 단순 연결리스트(Simple Linked List) 구현
        *practice2: 양방향 연결리스트(Doubly Linked List) 구현
        *practice3: 원형 연결리스트(Circle Linked List) 구현
        (1) 연결 리스트(Linked List)
            -데이터를 링크로 연결해서 관리하는 자료구조
            -자료의 순서 존재, 메모리상 연속성 존재X
        (2) 장점
            -데이터 공간을 미리 할당할 필요X
            -리스트의 길이가 가변적 --> 데이터 삭제,추가 용이
        (3) 단점
            -연결 구조를 위한 별도의 데이터 공간 필요(Node)
            -연결 정보를 찾는 시간 필요(상대적 접근속도 느림)
            -데이터 추가,삭제 시 앞 뒤 데이터의 연결을 재구성하는 작업 필요
        (4) 연결 리스트의 기본 구조
            *노드(Node): 데이터 저장 단위, 값, 포인터로 구성
                -포인터(Pointer): 다음 노드나 이전 노드의 연결정보
                -데이터나 링크는 여러개 존재 가능
            *데이터 추가(addData): 데이터 추가 위치(head, 중간, tail)에 따른 연결 작업 필요
                [가장 앞에 추가-head]: 추가 할 데이터 담을 노드 생성 -> 링크 연결 작업 -> head 이전(prev) 작업
                [중간에 추가]: 추가할 데이터를 담을 노드 생성 -> head로부터 데이터 추가 위치 직전까지 순회 -> 링크 연결 작업
                [끝에 추가-tail]: 추가할 데이터를 담는 노드 생성 -> head로부터 끝노드까지 순회 -> 링크 연결 작업
            *데이터 삭제(removeData): 데이터 삭제 위치(head, 중간, tail)에 따른 연결 작업 필요
                [가장 앞에 삭제-head]: 삭제 대상 노드 지정 -> head이전 작업 -> 대상 삭제
                [중간 삭제]: head부터 삭제 대상까지 순회, 해당 노드 지정 -> 삭제 대상 이전(prev)/이후(next) 링크 연결 작업 -> 대상 삭제
                [끝 삭제=tail]: head부터 끝까지 순회 -> 끝 노드 삭제 -> 삭제 이전(prev)의 노드의 링크 처리
### 자료구조-3주차
    1. practice: 스택
        *practice1: ArrayList로 스택 구현
        *practice2: Array로 스택 구현
        (1) 스택(Stack)
            -후입 선출(Last In First Out, LIFO): 마지막에 들어온 데이터가 먼저 나감
            -데이터가 입력된 순서의 역순으로 처리되어야 할 때 사용
        (2) 스택 기본 구조
            -Top: 스택 공간 중 가장 마지막에 들어온 데이터/Bottom: 스택 구조 중 가장 먼저 들어온 데이터
            -데이터 추가(Push): 스택의 가장 마지막 위치에 데이터 추가
            -데이터 꺼내기(Pop): 스택의 가장 마지막 위치에서 데이터 꺼냄
### 자료구조-4주차
    1. practice: 큐
        *practice1: ArrayList를 이용한 Queue
        *practice2: Array를 이용한 원형 Queue
        (1) 큐(Queue)
            -선입선출(First In First Out,FIFO): 먼저 들어온 데이터가 먼저 나감
            -입력 순서대로 데이터 처리가 필요한 경우
        (2) 큐 기본 구조
            -front: 큐 공간 중 맨 먼저 나가는 위치/rear: 큐 공간 중 맨 마지막에 나가는 위치
            -데이터 추가(Enqueue): 큐에 데이터 추가
            -데이터 꺼내기(Dequeue): 큐에서 데이터 꺼내기
### 자료구조-5주차
    1. practice: 데크
        *practice1: ArrayList를 이용한 데크 구현
        *practice2: Array를 이용한 데크 구현
            -원형으로 관리하기 위해 만들려는 사이즈+1 처리 <-- front 앞자리는 비워두기 때문
            -데크 공간의 마지막 자리에서 +1을 하고 데크 공간만큼 빠졌을 때 front의 위치와 같다면 데크는 가득참을 의미
            -front는 데이터가 추가될수록 앞으로 쌓이므로 위치는 -1씩 변하는데, 원형으로 관리하기 위해 
                생성된 배열만큼 더함
        (1) 데크(Deque): 양쪽에서 삽입/삭제가 모두 가능한 자료구조
            -Deque: Doubly-ended Queue
            -Stack + Queue
        (2) 데크 기본 구조
            -용어(Front: -First, Rear: -Last)
                -add(offer): 추가
                -remove(poll): 삭제
                    *remove는 데크에 데이터가 없으면 에러를 throw, poll은 null을 리턴
            -일부 기능을 제한하여 용도에 맞게 변형가능
        (3) 입력 제한한 데크(Scroll): 한 쪽의 입력을 제한한 데크
        (4) 출력 제한한 데크(Shelf): 한 쪽의 출력을 제한한 데크
### 자료구조-6주차
    1. practice: 해시 테이블
        *practice1: Array를 이용한 Hash Table 구현
            -기본 해시 함수: key % (해시테이블 사이즈)
        *practice2: 해시 충돌 해결 - 개방 주소법(선형 탐사법)
        *practice3: 해시 충돌 해결 - 개방 주소법(제곱 탐사법)
        *practice4: 해시 충돌 해결 - 개방 주소법(이중 해싱)
            -두 번째 해싱 함수: 해시 테이블의 사이즈보다 조금 작은 소수를 이용하여 구함
        *practice5: 해시 충돌 해결 - 분리 연결법
            -Node와 LinkedList 이용(단방향)
            -기본 Node와 LinkedList와 다르게 key값도 입력받아 저장
        (1) 해시 테이블(hash Table)
            -키(key)와 값(Value)을 대응시켜 저장하는 데이터 구조: 키 값을 이용해 해당 데이터에 빠르게 접근
            -해싱: key를 특정 계산식에 넣어 나온 결과를 사용하여 값에 접근
        (2) 해시 테이블 기본 구조
            -키(Key): 해시 테이블 접근을 위한 입력값
            -해시 함수(Hash Funtion): 키를 해시값으로 매핑하는 연산
                *좋은 해시 함수: hash Value에 골고루 접근 가능
            -해시 값(hash Value): 해시 테이블의 인덱스
            -해시 테이블(Hash Table): 키-값을 연산하여 저장하는 데이터 구조
        (3) 해시 충돌
            -해시 테이블의 같은 공간에 서로 다른 값을 저장하려는 경우 
                -> 서로 다른 키의 해시함수를 통한 해시 값이 동일한 경우
            -해시 충돌 해결 방법 : <1>개방 주소법, <2>분리 연결법
        (4) 해시 충돌 해결 방안 1: 개방 주소법
            -개방 주소법(Open Address)
                *충돌 시 테이블에서 비어있는 공간의 hash를 찾아 데이터 저장
                *hash : value --> 1:1 관계
                *비어있는 공간 탐색에 대한 분류: 선형 탐사법, 제곱 탐사법, 이중 해싱
                    -선형 탐사법(linear Probing)
                        *빈 공간을 순차적 탐사법 
                            -> 충돌 발생 지점부터 이후 빈공간까지 순서대로 탐사
                        *일차 군집화 문제 발생: 반복된 충돌 발생 시 해당 지점 주변에 데이터 몰림
                    -제곱 탐사법(Quadratic Proding)
                        *빈 공간을 n제곱만큼의 간격을 두고 탐사하는 방법
                            -> 충돌 발생 지점부터 이후의 빈 공간을 n제곱 간격으로 탐사
                        *일차 군집화 문제 해결
                        *이차 군집화 문제 발생 가능
                    -이중 해싱(Double Hashing)
                        *해싱 함수를 이중으로 사용
                            -> 해싱 함수 1: 최초 해시를 구할 때 사용
                            -> 해싱 함수 2: 충돌 발생 시, 탐사 이동 간격을 구할 때 사용
        (5) 해시 충돌 해결 방안 2: 분리 연결법
            -분리 연결법(Seperate Chaining)
                *해시 테이블을 연결리스트로 구성
                *충돌 발생 시, 테이블 내의 다른 위치를 탐색하는 것이 아닌 연결리스트를 이영해 해당 테이블에 데이터 연결
### 자료구조-7주차
    1. practcie: 트리
        *practice1: Array를 이용한 이진트리 구현, 순회
        *practice2: LinkedList를 이용한 이진트리 구현, 순회
        *practcie3: Tree 구조 복습, 구현
        (1) 트리(Tree)
            -노드와 링크로 구현된 자료구조(그래프의 일종, Not Cycle)
            -계층적 구조를 나타낼 때 사용
        (2) 트리 구조
            -노드(Node): 트리 구조의 자료값을 담고 있는 단위
                -루트 노드(Root): 부모가 없는 노드, 가장 위의 노드
                -잎새 노드(Leaf): 자식이 없는 노드(=단말)
                -내부 노드(Internal): 잎새 노드를 제외한 모든 노드
            -에지(Edge): 노드 간의 연결선(=link, branch)
            -부모(Parent): 연결된 두 노드 중 상위 노드
            -자식(Child): 연결된 두 노드 중 하위 노드
            -형제(Sibling): 같은 부모 노드를 가지는 노드
            -깊이(Depth): 루트에서 어떤 노드까지의 간선의 수
            -레벨(Level): 트리의 특정 깊이를 가지는 노드 집합
            -높이(Height): 트리에서 가장 큰 레벨의 값
            -크기(Size): 자신을 포함한 자식 노드의 개수
            -차수(Degree): 각 노드가 가진 가지의 수
            -트리의 차수: 트리의 최대 차수
        (3) 트리 특징
            -하나의 노드에서 다른 노드로 이동하는 경로가 유일
            -노드가 N개인 트리의 Edge 수: N-1
            -Acyclic(Cycle X)
            -모든 노드가 서로 연결
            -하나의 Edge를 끊으면 두개의 sub-tree로 분리
        (4) 이진 트리(Binary tree)
            -각 노드는 최대 2개의 자식을 가질 수 있음
            -자식 노드는 좌우를 구분(부모 기준)
        (5) 이진 트리 종류
            -포화 이진 트리(Perfect Binary Tree): 모든 레벨에서 노드들이 꽉 채워져 있는 트리
            -완전 이진 트리(Complete Binary Tree): 마지막 레벨을 제외한 노드들이 꽉 채워져 있는 트리
            -정 이진 트리(Full Binary Tree): 모든 노드가 0개 혹은 2개의 자식 노드를 갖는 트리
            -편향 이진 트리(Skewed Binary Tree): 한쪽으로 기울어진 트리
            -균형 이진 트리(Balanced Binary Tree): 모든 노드의 좌우 서브트리 높이가 1이상 차이나지 않는 트리 -> 탐색속도 빠름
        (6) 이진 트리 특징
            -포화 이진 트리의 높이가 h일때, 노드의 수: 2^(h+1)-1
            -포화(or 완전) 이진트리가 N개일 때, 높이:log N
            -이진 트리의 노드가 N개일 때, 최대 가능 높이: N-1
        (7) 이진 트리 순회(Traversal)
            -모든 노드를 빠트리거나 중복하지 않고 방문하는 연산
            -순회 종류: (DFS)전위 순회, 중위 순회, 후위 순회,(BFS)레벨 순회
                [1] 전위 순회(Preorder Traversal): 현재 노드->왼쪽 노드->오른쪽 노드
                [2] 중위 순회(Inorder Traversal): 왼쪽 노드->현재 노드->오른쪽 노드
                [3] 후위 순회(POstorder Traversal): 왼쪽 노드->오른쪽 노드->현재 노드
                [4] 레벨 순회(Levelorder Traversal):(위쪽 레벨부터)왼쪽 노드->오른쪽 노드
        (8) 이진 트리 구현
            -배열: 레벨 순회 순으로 배열에 구성
            -연결 리스트: 값과 간선을 관리하기 위한 노드로 연결리스트 구성
### 자료구조-8주차
    1. practice: 이진 탐색 트리
        *practcie1: 삽입,삭제를 재귀형태로 구현
        (1) 이진 탐색 트리(Binary Search Tree): 
            -아래 규칙으로 구성된 이진 트리
                -왼쪽 자식 노드의 키 < 부모 노드의 키 < 오른쪽 자식 노드의 키
                -각각의 서브트리도 이진 탐색 트리 유지
                -중복키 허용 X
            -이진 탐색 트리 규칙에 의해 데이터 정렬
            -이진 트리에 비해 탐색 빠름(균형 유지 필요)
                -균형 상태: O(log N)
                -불균형 상태: O(N)
        (2) 탐색
            -찾고자 하는 데이터를 루트 노드부터 시작
            -대소 비교를 통한(데이터 작음->왼, 데이터 큼->오)로 이동
            -찾는 데이터가 없음 -> null
            -어떤 데이터를 찾더라도 최대 트리 높이만큼 탐색이 이뤄짐
        (3) 삽입
            -Root부터 비교 시작(중복 키 발견: 종료)
            -삽입할 키 < 현재 노드의 키 -> 왼
            -삽입할 키 > 현재 노드의 키 -> 오
            -Leaf노드에 도달 후 키 비교하여 작음:왼, 큼:오
        (4) 삭제
            [1] 삭제 노드가 leaf인 경우
                -삭제 대상 노드 삭제
                -부모 노드의 해당 자식 링크 null 변경
            [2] 삭제 대상 노드에 자식 노드 하나 존재하는 경우
                -자식 노드를 삭제 대상 노드의 부모 노드에 연결
                -삭제 대상 노드 제거
            [3] 삭제 대상 노드에 자식 노드 모두 존재하는 경우
                i) 삭제 대상 노드의 왼쪽 서브트리에서 가장 큰 노드 선택
                ii) 삭제 대상 노드의 오른쪽 서브트리에서 가장 작은 노드 선택
                -i) 또는 ii)에서 선택한 노드를 삭제 대상 노드 위치로 올림
                -위로 올리는 과정에서 다른 자식 노드들의 링크 연결 작업
                -삭제 대상 노드 삭제
### 자료구조-9주차
    1. practice: 균형 이진 트리
        (1) 균형 이진 트리: 모든 노드의 좌우 서브트리 높이가 1이상 차이나지 않는 트리
        (2) 이진 탐색 트리의 편향 발생
            (case1: 왼쪽으로 치우침) 삽입 순서: 20 -> 10 -> 30 -> 5
            (case2: 오른쪽으로 치우침) 삽입 순서: 5 -> 10 -> 20 -> 30
        (3) Balanced Binary Search Tree
            -노드의 삽입/삭제가 일어나는 경우 균형을 유지하도록 하는 트리
            -AVL 트리, Red-Black 트리
        (4) AVL Tree
            -노드가 삽입/삭제 될 때, 트리의 균형을 체크하고 유지하는 트리
            -각 노드의 BF를 [-1,0,1]만 가지게 하여 균형 유지
            -BF(Balance Factor): 왼쪽 서브 트리 높이 - 오른쪽 서브 트리 높이
        (5) AVL Tree - 리밸런싱
            -균형이 깨진 경우
                [1] BF가 '+'이면 왼쪽 서브 트리 문제
                [2] BF가 '-'이면 오른쪽 서브츠리 문제
            -회전 연산
                [1] 단순 회전: LL, RR
                [2] 이중 회전: LR, RL
        (6) AVL Tree - 회전
            -노드의 위치를 기준으로 노드가 왼쪽으로 치우쳐져 있다면 LL, 오른쪽이라면 RR
            -왼쪽,오른쪽으로 치우쳐져 있다면 LR, 오른쪽,왼쪽으로 치우쳐져 있다면 RL 회전
            [1] LL(Left Left): 회전 1회, (왼쪽 노드)를 오른쪽 방향으로 회전
            [2] RR(Right Right): 회전 1회, (오른쪽 노드)를 왼쪽 방향으로 회전
            [3] LR(Left Right): 회전 2회, RR회전 다음 LL회전
            [4] RL(Right Left): 회전 2회, LL회전 다음 RR회전
### 자료구조-10주차
    1. practice: Red-Black Tree
        (1) Red-Black Tree
            -조건
                -root 노드와 leaf노드의 색: Black
                -Red색 노드의 자식은 Black(double Black은 불가)
                -모든 leaf 노드에서 root노드까지 가는 경로의 Black 노드 수 같음
            -조건이 깨지는 상황: ReBalancing
        (2) 삽입
            (case1) 노드 삽입 후 double red 발생 1: 부모 노드의 형제노드가 red인 경우
                -ReColoring 진행
                    [1] 삽입한 노드의 부모와 부모 형제 노드를 black으로 변경
                    [2] 부모의 부모 노드를 red로 변경
                    [3] 부모의 부모 노드가 root인지 double red인지에 따라 조건 진행
            (case2) 노드 삽입 후 double red 발생 2: 부모 노드의 형제 노드가 black or Null
                -ReStructuring 진행
                    [1] 조정 대상: 삽입한 노드(cur), 부모 노드(p), 부모의 부모 노드(p.p)
                    [2] 조정 대상 노드들을 오름차순 정렬
                    [3] 가운데 노드를 부모 노드(p)로 선정, black 변경
                    [4] 나머지 두 노드들을 자식노드로 선정, red 변경
        (3) 삭제
            (default) 삭제 대상 노드: black, 그 자리에 오는 노드: red
                -해당 자리로 오는 red -> black 변경
            (case1: 이중 흑색1) 삭제 대상 노드: black, 그 자리에 오는 노드: black
                -이중 흑색 노드의 형제 노드: black, 형제 노드의 양쪽 노드: black인 경우
                    [1] 형제 노드: red 변경
                    [2] 이중 흑색 노드의 검은색 1개를 부모 노드에 전달
                    [3] 부모 노드가 root가 아닌 이중 흑백 노드가 되면 (case) 반복
            (case2: 이중 흑색2) 이중 흑색 노드의 형제 노드가 red인 경우
                [1] 형제 노드: black 변경
                [2] 부모 노드: red 변경
                [3] 부모 노드 기준으로 왼쪽으로 회전
                [4] 그 다음 (case)에 따라 진행
            (case3-1: 이중 흑색3-1) 이중 흑색 노드의 형제 노드: black, 오른쪽 자식: red
                [1] 부모 노드, 형제 노드의 오른쪽 자식 노드: black
                [2] 부모 노드를 기준으로 오른쪽으로 회전
            (case3-2: 이중 흑색3-2) 이중 흑색 노드의 형제 노드: black, 왼쪽 자식: red
                [1] 형제 노드: red
                [2] 형제 노드의 왼쪽 자식 노드: black
                [3] 형제 노드 기준으로 오른쪽 회전
                [4] (case3-1)진행
        (4) Red-Black Tree Vs AVL Tree
            -알고리즘 시간 복잡도: 둘 다 O(logN)
            -균형 수준
                -엄격도: AVL Tree
                -Red-Black Tree: 색으로 구분하는 경우로 인한 회전수 감소
            -실 사용시
                -AVL: Tree 체계 잡힌 후, 탐색 많은 경우
                -Red-Black: 삽입/삭제 빈번한 경우
### 자료구조-11주차
    1. practice: 그래프
        (1) 그래프(Graph)
            -정점,간선으로 이루어진 자료구조(Cyclic): 연결된 정점간의 관계를 표현 할 수 있는 자료구조
            -그래프 용도: 지하철 노선도, 통신 네트워크
        (2) 그래프 구조
            -정점(Vertex): 각 노드
            -인접 정점(Adjacent Vertex): 간선 하나를 두고 바로 연결된 정점
            -간선(Edge): 노드-노드를 연결하는 선(link, branch)
            -정점의 개수(Degree)
                -무방향 그래프에서 하나의 정점에 인접한 정점의 수
                -무방향 그래프 모든 정점 차수의 합 == 그래프 간선의 수*2
            -진입 차수(In-Degree): 방향 그래프에서 외부에서 들어오는 간선의 수
            -진출 차수(Out-Degree): 방향 그래프에서 외부로 나가는 간선의 수
            -경로 길이(Path Length): 경로를 구성하는데 사용된 간선의 수
            -단순 경로(Simple Path): 경로 중에서 반복되는 정점이 없는 경우
            -사이클(Cycle): 단순 경로의 시작 정점과 끝 정점이 같음
        (3) 그래프 종류
            [1] 무방향 그래프
                -간선에 방향 X(양방향 이동 가능)
                -정점 A-B의 간선의 표현: (A,B) = (B,A)
            [2] 방향 그래프
                -간선에 방향 O(해당 방향으로만 이동 가능)
                -정점 A -> B 간선의 표현: <A,B> != <B,A>
            [3] 가중치 그래프: 간선에 값이 있는 그래프(비용)
            [4] 완전 그래프
                -모든 정점이 서로 연결되어 있는 그래프
                -정점이 N개인 경우, 간선의 수: n(n-1)/2
        (4) 그래프 탐색 - DFS
            -깊이 우선 탐색(Depth First Search): 각 노드에 방문했는지 여불르 체크할 배열/스택을 이용하여 구현
        (5) 그래프 탐색 - BFS
            -너비 우선 탐색(Breath First Search): 각 노드에 방문했는지 체크할 때 배열/큐를 이용하여 구현
        (6) 그래프의 구현
            [1] 인접 행렬(Adjacency Matrix): 2차원 배열 이용
                -장점: 간선 정보 확인/업데이트 빠름 O(1)
                -단접: 인접 행렬을 위한 메모리 공간 차지
            [2] 인접 리스트(Adjacency Lsit): 연결리스트 이용
                -장점: 메모리 사용량 상대적 적음, 노드의 추가/삭제 빠름
                -단점: 간선 정보 확인이 상대적 오래걸림
        (7) 인접 행렬 vs 인접 리스트
            -인접 행렬: 노드의 개수 적음, 간선의 수 많은 경우 유리 -> 밀집 그래프
            -인접 리스트: 노드의 개수 많음, 간선의 수 적은 경우 유리 -> 희소 그래프
            -특정 간선 검색/정점의 차수 계산/전체 노드 탐색/메모리  //N:전체 정점의 개수, E:전체 간선의 개수
                -인접 행렬: O(1)/O(N)/O(N^2)/N*N
                -인접 리스트: O(degree(V))/O(degree(V))/O(E)/N+E
                
                