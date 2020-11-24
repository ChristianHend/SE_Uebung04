package org.hbrs.se.ws20.uebung2;

import java.io.Serializable;

public class MemberInstanz implements Member, Serializable {
    Integer ID;
    public Integer getID(){
        return this.ID;
    }
    public MemberInstanz(Integer ID){
        this.ID = ID;
    }
    @Override
    public String toString(){
        return Integer.toString(ID);
    }
}
