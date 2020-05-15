package sn.diotali.tfe_usager_dgid.types;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

import sn.diotali.tfe_usager_dgid.services.ServiceResult;

public class TransactionResponse extends ServiceResult {

    List<OneTimbrePanier> respTimbres;

    private String numero = "-1";
    private String numeroTransaction = "-1";

    @JsonFormat( pattern = "dd/MM/yyyy HH:mm:ss")
    private Date transactionDate =  new Date();
    @JsonFormat( pattern = "dd/MM/yyyy HH:mm:ss")
    private Date expirationDate;

    private String codeVendeur;
    @JsonFormat( pattern = "dd/MM/yyyy")
    private Date dateAchat;

    private int status;
    private String message;

    public TransactionResponse() {
        super();
    }

    public TransactionResponse(int status, String message) {
        super(status, message);
    }

    public String getNumeroTransaction() {
        return numeroTransaction;
    }

    public void setNumeroTransaction(String numeroTransaction) {
        this.numeroTransaction = numeroTransaction;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

    public List<OneTimbrePanier> getRespTimbres() {
        return respTimbres;
    }

    public void setRespTimbres(List<OneTimbrePanier> respTimbres) {
        this.respTimbres = respTimbres;
    }

    public String getCodeVendeur() {
        return codeVendeur;
    }

    public void setCodeVendeur(String codeVendeur) {
        this.codeVendeur = codeVendeur;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    @Override
    public String toString() {
        return "TransactionResponse{" +
                "respTimbres=" + respTimbres +
                ", numero='" + numero + '\'' +
                ", numeroTransaction='" + numeroTransaction + '\'' +
                ", transactionDate=" + transactionDate +
                ", expirationDate=" + expirationDate +
                ", codeVendeur='" + codeVendeur + '\'' +
                ", dateAchat=" + dateAchat +
                ", status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}

