package bankaccount.entity;


import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "number", nullable = false, unique = true, length = 12)
    private int  numberAccount;

    @Column(name = "cash", nullable = false)
    private int cashAccount;

    public int getId() {
        return id;
    }

    public void setId(int idAccount) {
        this.id = idAccount;
    }

    public int getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(int numberAccount) {
        this.numberAccount = numberAccount;
    }

    public int getCashAccount() {
        return cashAccount;
    }

    public void setCashAccount(int cashAccount) {
        this.cashAccount = cashAccount;
    }
}
