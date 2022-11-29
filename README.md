# JPA 기초

## 목차

1. [SQL 중심적 개발과 문제점](#SQL-중심적-개발과-문제점)
2. [RDB와 객체의 패러다임](#2RDB와-객체의-패러다임)
3. [JPA Entity](#JPA-Entity)

## SQL 중심적 개발과 문제점
* 개발자라면 `RDB`를 사용하여 개발하는 경우가 매우 많다. 
* CRUD의 처리를 위해서 DB 데이터를 기준하여 객체의 필드를 만드는 경우가 많았다.
### JAVA CLASS
```java
public class Board{
    private String board_num;
    private String title;
    private String content;
    private String author;
    ...
}
```
### SQL
```sql
    INSERT INTO BOARD(BOARD_NUM, TITLE, CONTENT, AUTHOR) VALUES 
    SELECT BOARD_NUM, TITLE, CONTENT, AUTHORIZATION FROM BOARD
    비슷한 SELECT 구절이 많은경우
```

만약 테이블이 하나 추가 된다면 그 해당되는 로직을
가진 수백가지 테이블에 엮인 SQL을 모두 바꿔야하는 경우도 생기게 된다.  
> 결국 RDB를 사용한다면 관계형 데이터베이스에 의존적인 
> 개발을 할 수 밖에 없다.


## RDB와 객체의 패러다임
`RDB는 관계를 중요시하여 테이블의 관계가 서로 의존적인 모습을 많이 보인다.`  
> 하지만, 객체지향 프로그래밍은 의존보다 인터페이스를 통하여 다형성 및 확장을 고려한 설계로 많이 사용한다.
### 상속과 연관 관계

##### 1. 객체는 상속을 통해서 참조를 사용할 수 있다.
`.(dot)`을 사용하여 객체에 선언한 다른 객체로 접근한다.
> 반면에 RDB의 경우 PK키와 FK키를 활용하여 JOIN 식을 통하여 참조가 이루어진다.


## JPA Entity
`@ID` 주 식별자를 뜻한다. 보통 PK키를 의미함. 
`@GeneratedValue` 식별자의 시퀀스를 담당한다.
`@Column` DB의 컬럼을 뜻한다. 유니크 및 컬럼명 등등 설정이 가능하다.
`@JoinColumn` 


## JPA 관계

#### 1 : 다

#### 다 : 일

#### 일 : 일

#### 다 : 다






