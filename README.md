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
