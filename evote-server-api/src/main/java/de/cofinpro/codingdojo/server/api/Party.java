package de.cofinpro.codingdojo.server.api;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by tahmed on 19.09.2014.
 */
@Entity
@XmlRootElement(name = "party")
@NamedQueries({
        @NamedQuery(name = "Party.findAll", query = "SELECT p FROM Party p"),
        @NamedQuery(name = "Party.findByElectionApprovalStatus", query = "SELECT p FROM Party p WHERE EXISTS (SELECT a FROM Approval a WHERE a.party = p AND a.election = :election AND a.status = :approvalStatus)")
})
public class Party {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;

    public Party() {
    }

    public Party(String name)
    {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
