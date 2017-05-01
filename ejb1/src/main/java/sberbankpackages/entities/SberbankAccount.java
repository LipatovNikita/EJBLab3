package sberbankpackages.entities;


import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class SberbankAccount {


    @OneToOne(fetch = FetchType.LAZY, mappedBy = "sberbankAccount")
    @JoinColumn(name = "client_id")
    private SberbankClient owner;
}
