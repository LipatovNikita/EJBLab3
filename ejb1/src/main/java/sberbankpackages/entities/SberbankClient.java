package sberbankpackages.entities;

import javax.persistence.*;

@Entity
@Table(name = "sberbankClient")
public class SberbankClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client", unique = true, nullable = false)
    private int id;

    @Column(name = "firstName_client", nullable = false)
    private String firstName;

    @Column(name = "lastName_client", nullable = false)
    private String lastName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private SberbankAccount sberbankAccount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public SberbankAccount getSberbankAccount() {
        return sberbankAccount;
    }

    public void setSberbankAccount(SberbankAccount sberbankAccount) {
        this.sberbankAccount = sberbankAccount;
    }
}
