package beans;

public class Password {

    private int id;
    private String account;
    private String userAccount;
    private String passwordAccount;

    public Password(int id, String account, String userAccount, String passwordAccount) {
        this.id = id;
        this.account = account;
        this.userAccount = userAccount;
        this.passwordAccount = passwordAccount;
    }

    public Password(String account, String userAccount, String passwordAccount) {
        this.account = account;
        this.userAccount = userAccount;
        this.passwordAccount = passwordAccount;
    }

    public Password() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getPasswordAccount() {
        return passwordAccount;
    }

    public void setPasswordAccount(String passwordAccount) {
        this.passwordAccount = passwordAccount;
    }

}
