package org.hbrs.se.ws20.uebung2;

import org.hbrs.se.ws20.uebung3.PersistenceException;
import org.hbrs.se.ws20.uebung3.PersistenceStrategyStream;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Container{
    LinkedList<Member> objList;
    private PersistenceStrategyStream ps = new PersistenceStrategyStream();
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
    public void store() throws PersistenceException, IOException {
        ps.save(objList);
    }
    public void load() throws PersistenceException, IOException {
        this.objList = (LinkedList<Member>) ps.load();
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
    //public void dump(){
    //    for(Member idprüfer : objList){
    //        System.out.println("Member (ID = [" + idprüfer.toString() + "])");
    //   }
    //}
    public List<Member> getCurrentList(){
        return objList;
    }

    public int size(){
        return objList.size();
    }
}
