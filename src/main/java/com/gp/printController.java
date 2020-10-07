package com.gp;

import javax.persistence.*;
import java.util.List;

public class printController {
    //EntityManager를 받아서 해당하는 Entity를 통해 DB로 JPQL Query를 날려 관리하는 컨트롤러
    //여기서 하는 관리작업은 SELECT문을 통해 USER테이블을 조회하고 ENTITY에 담아 약간의 가공을 통해 화면에 출력하는 작업
    //다른곳(DispatcherServlet)에서 이 컨트롤러에 요청하면 user(DTO)를 이용해서 요청을 처리하고 결과를 표시할 뷰를 호출
    public void typedQuery() {

        //Entity의 영속성(영구히 저장하는 환경)을 담당하는 세팅파일(persistence.xml)에서 해당세팅(userps)를 불러와 영속성을 관리한다.
        //EntityManagerFactory에서 영속성 환경세팅을 불러와 해당 데이터베이스 접근에 대해 통합관리(그것을 토대로 EntityManager를 관리(매니저가 Entity를 관리할때 쓰레드가 동시에 접근해서문제가 생기지 않도록))
        //EntityTransaction을 통해 전부 처리되던가(commit) 전부 처리되지않도록(rollback) 관리
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("userps");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            String jpql = "SELECT u FROM user u ";                                              //u는 별칭, jpql에서는 별칭이 필요
            TypedQuery<user> query = em.createQuery(jpql, user.class);

            List<user> userList = query.getResultList();
            for( user usr : userList) {    //user 테이블의 정보를 모두 표시
                System.out.println("| "+usr.getUsrno()+" | "+usr.getUname()+" | "+usr.getAddr()+" |");              //원래대로라면 뷰로 데이터를 넘겨줘서 처리하는 부분
            }

//            // ID 값이 1인 Agent SELECT
//            Agent findAgent = em.find(Agent.class, 1L);
//
//            // 정보 출력
//            System.out.println("Id : " + findAgent.getUsrno());
//            System.out.println("Name : " + findAgent.getUname());

            //트랜젝션 커밋 em을 통해서 트랜젝션(원자성)을 관리
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }

}