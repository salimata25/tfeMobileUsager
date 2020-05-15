package sn.diotali.tfe_usager_dgid.types;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quittance implements Serializable {
    private String firstName;
    private String lastName;
    private String phone;
    private String nin;
    private String address;
    private String numero;
    private String numeroTransaction;

    @JsonFormat( pattern = "dd/MM/yyyy HH:mm:ss")
    private Date dateCreation =  new Date();
    @JsonFormat( pattern = "dd/MM/yyyy HH:mm:ss")
    private Date dateExpiration;

    public Quittance() { }

    public Quittance(String firstName, String lastName, String phone, String nin, String numero,  String numeroTransaction) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.nin = nin;

        this.numero = numero;
        this.numeroTransaction = numeroTransaction;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNin() {
        return nin;
    }

    public void setNin(String nin) {
        this.nin = nin;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumeroTransaction() {
        return numeroTransaction;
    }

    public void setNumeroTransaction(String numeroTransaction) {
        this.numeroTransaction = numeroTransaction;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    @Override
    public String toString() {
        return "Quittance{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", nin='" + nin + '\'' +
                ", address='" + address + '\'' +
                ", numero='" + numero + '\'' +
                ", numeroTransaction='" + numeroTransaction + '\'' +
                '}';
    }
}
