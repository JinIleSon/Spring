package kr.co.ch06.repository;

import kr.co.ch06.entity.Child;
import kr.co.ch06.entity.Parent;
import kr.co.ch06.entity.User1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class User1RepositoryTest {

    @Autowired
    private User1Repository user1Repository;

    @Test
    void findUser1ByUserId() {

        User1 user1  = user1Repository.findUser1ByUserId("a101");
        System.out.println(user1);
    }

    @Test
    void findUser1ByUserName() {
        List<User1> list = user1Repository.findUser1ByUserName("a101");
        System.out.println(list);
    }

    @Test
    void findUser1ByUserNameNot() {
    }

    @Test
    void findUser1ByUserIdAndUserName() {
    }

    @Test
    void findUser1ByUserIdOrUserName() {
    }

    @Test
    void findUser1ByAgeGreaterThan() {
    }

    @Test
    void findUser1ByAgeGreaterThanEqual() {
    }

    @Test
    void findUser1ByAgeLessThan() {
    }

    @Test
    void findUser1ByAgeLessThanEqual() {
    }

    @Test
    void findUser1ByAgeBetween() {
    }

    @Test
    void findUser1ByUserNameLike() {
    }

    @Test
    void findUser1ByUserNameContains() {
    }

    @Test
    void findUser1ByUserNameStartsWith() {
    }

    @Test
    void findUser1ByUserNameEndsWith() {
    }

    @Test
    void findUser1ByOrderByUserName() {
    }

    @Test
    void findUser1ByOrderByAgeAsc() {
    }

    @Test
    void findUser1ByOrderByAgeDesc() {
    }

    @Test
    void findUser1ByAgeGreaterThanOrderByAgeDesc() {
    }

    @Test
    void countUser1ByUserId() {
    }

    @Test
    void countUser1ByUserName() {
    }

    @Autowired
    private ParentRepository parentRepository;
    @Autowired
    private ChildRepository childRepository;

    @Test
    void selectParentJoinChild(){
        Parent parent = Parent.builder()
                        .pid("p101")
                        .userName("김유신")
                        .age(34)
                        .build();

        parentRepository.save(parent);

        Child child = Child.builder()
                .cid("c101")
                .pid("p101")
                .userName("김철수")
                .age(12)
                .build();

        childRepository.save(child);

        List<Object[]> objectList = user1Repository.selectParentJoinChild("p101");
        System.out.println(objectList);

        for(Object[] object : objectList){

            Parent selectedParent = (Parent) object[0];
            Child selectedChild = (Child) object[1];

            System.out.println(selectedParent);
            System.out.println(selectedChild);
        }
    }
}