package model;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Marco A. Fernández Heras on 9/03/16.
 */
@Entity
@Table(name = "bill")
public class Bill {
    private int id;
    private Date date;
    private String name;
    private String surname;
    private String dni;
    private Set<BillDetail> details = new HashSet<>();

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "date", insertable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname", nullable = false, length = 50)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "dni", nullable = false, length = 50)
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @OneToMany(mappedBy="bill", cascade = {CascadeType.ALL})
    public Set<BillDetail> getDetails() {
        return details;
    }

    public void setDetails(Set<BillDetail> details) {
        this.details = details;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bill bill = (Bill) o;

        if (id != bill.id) return false;
        if (date != null ? !date.equals(bill.date) : bill.date != null) return false;
        if (name != null ? !name.equals(bill.name) : bill.name != null) return false;
        if (surname != null ? !surname.equals(bill.surname) : bill.surname != null) return false;
        if (dni != null ? !dni.equals(bill.dni) : bill.dni != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (dni != null ? dni.hashCode() : 0);
        return result;
    }
}
