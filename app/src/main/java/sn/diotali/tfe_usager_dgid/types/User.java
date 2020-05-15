package sn.diotali.tfe_usager_dgid.types;

import sn.diotali.tfe_usager_dgid.services.ServiceResult;
import sn.diotali.tfe_usager_dgid.utils.DiotaliUtils;

public class User extends ServiceResult {

    private String  matricule;
    private String  phone;

    private String  centre;
    private String  bureau;

    private String login;
    private String password;
    private String role;
    private String firstName;
    private String lastName;
    private String address;

    private String userNumber;

    private Integer balance;

    private String token;
    private String terminalNumber;

    private int status;
    private String message;

    public User(){
        super();
        this.terminalNumber = DiotaliUtils.getSerialNumber();
    }

    public User(int status, String message){
        super(status,message);
        this.terminalNumber = DiotaliUtils.getSerialNumber();
    }

    public User(String login, String password) {
        super();
        this.login = login;
        this.password = password;
        this.terminalNumber = DiotaliUtils.getSerialNumber();
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCentre() {
        return centre;
    }

    public void setCentre(String centre) {
        this.centre = centre;
    }

    public String getBureau() {
        return bureau;
    }

    public void setBureau(String bureau) {
        this.bureau = bureau;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "User{" +
                "matricule='" + matricule + '\'' +
                ", phone='" + phone + '\'' +
                ", centre='" + centre + '\'' +
                ", bureau='" + bureau + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", userNumber='" + userNumber + '\'' +
                ", balance=" + balance +
                ", token='" + token + '\'' +
                ", terminalNumber='" + terminalNumber + '\'' +
                ", status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
