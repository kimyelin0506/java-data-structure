# java-data-structure-practice
  ## 학습 목표 
   - 알고리즘 학습 전 자바로 자료구조, 기초수학 학습하기
   - 이론을 실제 자바로 구현하기
   - 학습과 동시에 git 활용 방법 적응하기

  ## 1주차
    1. git, project setting
        (1) git과 프로젝트 연동
            - 인텔: [Sytem Build: Gradle], [JDK: Oracle 21]로 프로젝트 생성
            - 인텔: Git-Github에 repository 생성
            - cmd: [branch 전환: $ git branch -b {전환할 이름}] 
        (2) 환경 설정 - 자바 인텔 한글깨짐(Gradle) 설정
            - [File]-[Settings]-[File Encodings]-Global, [Project Encoding, Properties Files 설정: UTF-8]
            - [File]-[Settings]-[Build, Exexcution Deplyment]-[Gradle]: 모두 Intellij IDEA 변경

    2. practice
        (1) Set function(java.util.HashSet)
            - 자바에서 집합 사용: HashSet 이용
            - HashSet은 새로운 객체로 결과값을 리턴하는 것이 아니므로 새로운 객체를 리턴하는 MySet 설정
        (2) MySet: 공통-반환을 위한 새로운 객체(파라미터X)를 만들고, 파라미터를 입력받는 생성자를 통해 기능처리(중복X)
            - 교집합(retianAll(MySet b)): 자기 자신의 리스트를 순회하면서 파라미터 값으로 새로 들어오는 리스트 또한 순회하여 같은 값이 있다면 새로운 객체에 담아 반환
            - 합집합(addAll(MySet b)): 자기 자신의 리스트를 순회하며 새로 반환할 객체에 담고, 새로 들어온 객체의 리스트에서 중복되지 않는 값 또한 넣어 반환
            - 차집합(removeAll(MySet b)): 자기 자신의 리스트를 순회하면서 새로 들어온 객체의 리스트도 순회하며 같은 값이 없다면 새로운 객체에 값을 담아 리턴함
## 2주차
    1. practice
        (1) 경우의 수-곱의 법칙과 합의 법칙
            - 곱의 법칙: 사건A 와 사건B 가 동시에 일어날 경우의 수
            - 합의 법칙: 사건A 또는 사건B 가일어날 경우의 수
        (2) 약수: (M % N == 0)일 경우, N은 M의 약수임(0 < N <= M)
        (3) 최대공약수(GCD): A와 B의 공통 약수이면서 가장 큰 수
            - 자신의 수의 절반 이하만 약수임, 예외는 자기 자신
        (4) 최소공배수(LCM): A와 B의 공통 약수이면서 가장 작은 수
            >> LCM = A*B / GCD
## 3주차
    1. practice
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
## 4주차
    1. practice
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
            