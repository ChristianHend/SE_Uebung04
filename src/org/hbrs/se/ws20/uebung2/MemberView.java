package org.hbrs.se.ws20.uebung2;

import java.util.List;

public class MemberView {
    public void dump(List<Member> memberList){
        for(Member m : memberList){
            System.out.println("Member (ID = [" + m.toString() + "])");
        }
    }
}
