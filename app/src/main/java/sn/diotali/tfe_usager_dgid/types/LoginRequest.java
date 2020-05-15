package sn.diotali.tfe_usager_dgid.types;

import sn.diotali.tfe_usager_dgid.services.MethodParams;
import sn.diotali.tfe_usager_dgid.utils.DiotaliUtils;

public class LoginRequest  extends MethodParams {

    private String login;
    private String password;
    private String terminalNumber;



    public LoginRequest(String login, String password){
        super();
        this.login = login;
        this.password = password;
        this.terminalNumber = DiotaliUtils.getSerialNumber();
    }

    public LoginRequest(){
        super();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTerminalNumber() {
        return terminalNumber;
    }

    public void setTerminalNumber(String terminalNumber) {
        this.terminalNumber = terminalNumber;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", terminalNumber='" + terminalNumber + '\'' +
                '}';
    }
}
