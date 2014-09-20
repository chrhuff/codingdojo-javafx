package de.cofinpro.codingdojo.server.api;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by tahmed on 19.09.2014.
 */
@Entity
@XmlRootElement(name = "election")
@NamedQueries({@NamedQuery(name = "Election.findAll", query = "SELECT e FROM Election e"
)})
public class Election {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;

    public Election() {
    }

    public Election(String name)
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
        return this.getName();
    }
}
