package kr.co.woobi.imyeon.coffeeapp.managers;

import android.os.Bundle;
import android.widget.Spinner;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import kr.co.woobi.imyeon.coffeeapp.models.Account;

public class Bank {

    private static Bank sInstance = new Bank();

    //관리자
    private final String ADMIN_ID = "admin";
    private final String ADMIN_PASSWORD = "admin";

    //고객 계좌 정보
    private List<Account> mAccountList;

    //싱글턴 패턴
    public static Bank newInstance() {
        return sInstance;
    }

    private Bank() {
        this.mAccountList = new ArrayList<>();
    }

    /**
     * 개설
     *
     * @param account 개설 할 계좌 정보
     */
    public void open(Account account) {
        mAccountList.add(account);
    }


    /**
     * 로그인
     *
     * @param id       아이디
     * @param password 패스워드
     * @return 없으면 null , 있으면 해당계좌
     */
    public Account login(String id, String password) {
        for(Account account : mAccountList){
            if(account.getId().equals(id)&& account.getPassword().equals(password)){
                return account;
            }
        }
        return null;
    }


    /**
     * 관리자 권한 확인
     *
     * @param id       아이디
     * @param password 패스워드
     * @return 관리자면 true
     */
    public boolean isAdmin(String id, String password) {
        if(ADMIN_ID.equals(id) && ADMIN_PASSWORD.equals(password)){
            return  true;
        }
        return false;
    }

    /**
     * 전체 계좌 정보를 얻기
     *
     * @return 전체 계좌 정보
     */
    public List<Account> getAccountList() {
        return mAccountList;
    }
}
