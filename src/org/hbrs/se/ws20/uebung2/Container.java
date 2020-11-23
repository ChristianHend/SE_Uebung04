package org.hbrs.se.ws20.uebung2;

import java.util.LinkedList;

public class Container{
    LinkedList<Member> objList;
    private static Container single_instance = null;
    private Container(){
        objList = new LinkedList<>();
    }
    public static Container getContainer(){
        if(single_instance == null){
            single_instance = new Container();
        }
        return single_instance;
    }

    public void addMember(Member member)throws ContainerException {
        if(hasMember(member)){
            throw new ContainerException("Das Member-Objekt mit der ID [" + member.getID() +
                    "] ist bereits vorhanden!");
        }
        objList.add(member);
    }
    private boolean hasMember(Member testMember){
        int memberID = testMember.getID();
        for(Member idprüfer : objList){
            if(idprüfer.getID() == memberID){
                return true;
            }
        }
        return false;
    }
    public String deleteMember(Integer id){
        for(Member idprüfer : objList){
            if(idprüfer.getID() == id){
                objList.remove(idprüfer);
                return "Member mit der ID [" + id + "] wurde erfolgreich entfernt.";
            }
        }
        return "Member mit der ID [" + id + "] wurde nicht gefunden.";
    }
    public void dump(){
        for(Member idprüfer : objList){
            System.out.println("Member (ID = [" + idprüfer.toString() + "])");
        }
    }

    public int size(){
        return objList.size();
    }
}
