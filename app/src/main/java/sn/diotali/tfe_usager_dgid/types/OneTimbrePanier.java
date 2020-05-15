package sn.diotali.tfe_usager_dgid.types;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;


@JsonIgnoreProperties(ignoreUnknown = true)
public class OneTimbrePanier implements Serializable {

    private String type;

    private String libelle;

    private int prixU;

    private int quantite;

    private String numero;

    private String numeroTransaction;

    @JsonFormat( pattern = "dd/MM/yyyy HH:mm:ss")
    private Date transactionDate =  new Date();
    @JsonFormat( pattern = "dd/MM/yyyy HH:mm:ss")
    private Date expirationDate;

    public OneTimbrePanier() {
    }

    public OneTimbrePanier(String numero, String numeroTransaction, Date transactionDate, Date expirationDate) {
        this.numero = numero;
        this.numeroTransaction = numeroTransaction;
        this.transactionDate = transactionDate;
        this.expirationDate = expirationDate;
    }

    public OneTimbrePanier(String type, String libelle, int prixU, Date transactionDate) {
        this.type = type;
        this.libelle = libelle;
        this.prixU = prixU;
        this.transactionDate = transactionDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getPrixU() {
        return prixU;
    }

    public void setPrixU(int prixU) {
        this.prixU = prixU;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
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

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "OneTimbrePanier{" +
                "type='" + type + '\'' +
                ", libelle='" + libelle + '\'' +
                ", prixU=" + prixU +
                ", quantite=" + quantite +
                ", numero='" + numero + '\'' +
                ", numeroTransaction='" + numeroTransaction + '\'' +
                ", transactionDate=" + transactionDate +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
