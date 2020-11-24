package org.hbrs.se.ws20.uebung3;
import java.io.*;
import java.util.List;

public class PersistenceStrategyStream<Member> implements PersistenceStrategy<Member> {
    @Override
    public void openConnection() throws PersistenceException {

    }

    @Override
    public void closeConnection() throws PersistenceException {

    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<Member> member) throws PersistenceException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("MemberStore.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(member);
            System.out.println("Member wurden erfolgreich in MemberStore.txt gespeichert.");
        }
        catch(IOException e){
            throw new PersistenceException(PersistenceException.ExceptionType.SaveFailure, "IOException wurde geworfen.");
        }
    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     */
    public List<Member> load() throws PersistenceException  {
        // Some Coding hints ;-)
        // ObjectInputStream ois = null;
        // FileInputStream fis = null;
        // List<...> newListe =  null;
        //
        // Initiating the Stream (can also be moved to method openConnection()... ;-)
        // fis = new FileInputStream( " a location to a file" );
        // ois = new ObjectInputStream(fis);

        // Reading and extracting the list (try .. catch ommitted here)
        // Object obj = ois.readObject();

        // if (obj instanceof List<?>) {
        //       newListe = (List) obj;
        // return newListe

        // and finally close the streams (guess where this could be...?)
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("MemberStore.txt");
            ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            System.out.println("Member wurden erfolgreich von MemberStore.txt gelesen.");
            List<Member> returnList = null;
            if(obj instanceof List<?>){
                returnList = (List<Member>) obj;
            }
            return returnList;
        }
        catch(ClassNotFoundException e){
            throw new PersistenceException(PersistenceException.ExceptionType.LoadFailure, "ClassNotFoundException wurde geworfen.");
        }
        catch(IOException e){
            throw new PersistenceException(PersistenceException.ExceptionType.LoadFailure, "IOException wurde geworfen.");
        }
    }
}