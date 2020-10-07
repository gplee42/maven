package com.gp;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Setter
@Getter
@Entity
public class user {
    @Id                                     //@Id 어노테이션으로 지정한 맴버 변수가 영속성 컨텍스트에 식별자 값으로 저장(기본키)
    @GeneratedValue
    private  Long usrno;
    private  String uname;
    private  String addr;

}
