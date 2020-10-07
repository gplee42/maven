package com.gp;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Agent {
    @Id
    @GeneratedValue
    private  Long usrno;
    private  String uname;
    private  String addr;

    public Long getUsrno() {
        return usrno;
    }

    public void setUsrno(Long usrno) {
        this.usrno = usrno;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
