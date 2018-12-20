package kr.co.woobi.imyeon.coffeeapp.models;

public class Account {

    private String  id;
    private String password;
    private  int balance;

    public Account(String id, String password,int balance) {
        this.id = id;
        this.password = password;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
      return String.format("조회한 ID : %S\n 조회한 계좌의 잔액 : %d", id, balance );

    }
}
