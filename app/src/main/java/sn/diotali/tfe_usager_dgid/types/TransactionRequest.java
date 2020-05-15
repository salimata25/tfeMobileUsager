package sn.diotali.tfe_usager_dgid.types;

import java.util.ArrayList;
import java.util.List;

import sn.diotali.tfe_usager_dgid.services.MethodParams;

public class TransactionRequest extends MethodParams {

    private String token;
    private String terminalNumber;

    private String transactionType;
    private String paymentType;

    private Quittance infoQuittance;
    List<Timbre> panierTimbres;

    public TransactionRequest() {
        super();
        this.panierTimbres = new ArrayList<>();
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTerminalNumber() {
        return terminalNumber;
    }

    public void setTerminalNumber(String terminalNumber) {
        this.terminalNumber = terminalNumber;
    }


    public Quittance getInfoQuittance() {
        return infoQuittance;
    }

    public void setInfoQuittance(Quittance infoQuittance) {
        this.infoQuittance = infoQuittance;
    }

    public List<Timbre> getPanierTimbres() {
        return panierTimbres;
    }

    public void setPanierTimbres(List<Timbre> panierTimbres) {
        this.panierTimbres = panierTimbres;
    }

    @Override
    public String toString() {
        return "TransactionRequest{" +
                "token='" + token + '\'' +
                ", terminalNumber='" + terminalNumber + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", infoQuittance=" + infoQuittance +
                ", panierTimbres=" + panierTimbres +
                '}';
    }
}

