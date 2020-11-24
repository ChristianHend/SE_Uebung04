package org.hbrs.se.ws20.uebung2;

import org.hbrs.se.ws20.uebung3.PersistenceException;

import java.io.IOException;

public class Client {
    Member m1 = new MemberInstanz(111);
    Member m2 = new MemberInstanz(112);
    Member m3 = new MemberInstanz(113);
    Member m4 = new MemberInstanz(114);
    Member m5 = new MemberInstanz(115);

    Container container = Container.getContainer();

    public void containerAdd() throws ContainerException {
        container.addMember(m1);
        container.addMember(m2);
        container.addMember(m3);
        container.addMember(m4);
        container.addMember(m5);
    }

    public void containerDelete() {
        container.deleteMember(m1.getID());
        container.deleteMember(m2.getID());
        container.deleteMember(m3.getID());
        container.deleteMember(m4.getID());
        container.deleteMember(m5.getID());
    }

    public void store() throws IOException, PersistenceException {
        container.store();
    }

    public void load() throws IOException, PersistenceException {
        container.load();
    }
}
