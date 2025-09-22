package kr.co.ch06.repository;

import kr.co.ch06.DTO.User1DTO;
import kr.co.ch06.entity.User1;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface User1Repository extends JpaRepository<User1, String> { // <엔티티, 해당 엔티티의 @ID 속성 자료형

    // 사용자 쿼리 메서드 정의
    //public User1 findUser1ById(String userId); // 테이블(User)WHERE(By)속성(Id)
    //public List<User1> findUser1ByUserUserName(String userUserName); // select * from user1 where userUserName;


    public User1 findUser1ByUserId(String userId);
    public List<User1> findUser1ByUserName(String userName);
    public List<User1> findUser1ByUserNameNot(String userName);

    public User1 findUser1ByUserIdAndUserName(String userId, String userName); // where userId and userName
    public List<User1> findUser1ByUserIdOrUserName(String userId, String userName); // where userId or userName

    public List<User1> findUser1ByAgeGreaterThan(int age); // where age > ?
    public List<User1> findUser1ByAgeGreaterThanEqual(int age); // where age >= ?
    public List<User1> findUser1ByAgeLessThan(int age);
    public List<User1> findUser1ByAgeLessThanEqual(int age);
    public List<User1> findUser1ByAgeBetween(int low, int high);

    public List<User1> findUser1ByUserNameLike(String userName); // where userName like ?
    public List<User1> findUser1ByUserNameContains(String userName);
    public List<User1> findUser1ByUserNameStartsWith(String userName);
    public List<User1> findUser1ByUserNameEndsWith(String userName);

    public List<User1> findUser1ByOrderByUserName();
    public List<User1> findUser1ByOrderByAgeAsc(); // order by age asc
    public List<User1> findUser1ByOrderByAgeDesc(); // order by age desc
    public List<User1> findUser1ByAgeGreaterThanOrderByAgeDesc(int age);

    public int countUser1ByUserId(String userId); // count
    public int countUser1ByUserName(String userName); // count

    // 쿼리 내가 작성하는 방법
    // JPQL( JPA SQL ) 실습. 함수명은 내 마음대로 가능
    @Query("SELECT u1 FROM User1 as u1 WHERE u1.age < 30") // User1은 엔티티
    public List<User1> selectUser1UnderAge30();

    @Query("SELECT u1 FROM User1 as u1 WHERE u1.userName =?1") // User1은 엔티티. ?1은 첫 번째 인자
    public List<User1> selectUser1WhereName(String userName);

    @Query("SELECT u1 FROM User1 as u1 WHERE u1.birth = :birth") // User1은 엔티티. ?1은 첫 번째 인자
    public List<User1> selectUser1WhereBirth(@Param("birth") String birth);

    @Query("SELECT u1.userId, u1.userName, u1.age FROM User1 as u1 WHERE u1.userId = :userId") // User1은 엔티티. ?1은 첫 번째 인자
    public List<User1> selectUser1WhereId(@Param("userId") String userId);

    @Query("SELECT p, c From Parent as p " +
            "JOIN Child as c on  p.pid = c.pid " +
            "where p.pid = :pid")
    public List<Object[]> selectParentJoinChild(@Param("pid") String pid);
}
