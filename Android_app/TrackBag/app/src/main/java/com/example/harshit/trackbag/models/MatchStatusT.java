package com.example.harshit.trackbag.models;

/**
 * Created by harshit on 14/10/17.
 */

public class MatchStatusT {
   private String baggage_pnr;
    private  String pass_pnr;

    public String getBaggage_pnr() {
        return baggage_pnr;
    }

    public String getPass_pnr() {
        return pass_pnr;
    }

    public void setBaggage_pnr(String baggage_pnr) {
        this.baggage_pnr = baggage_pnr;
    }

    public void setPass_pnr(String pass_pnr) {
        this.pass_pnr = pass_pnr;
    }
}
