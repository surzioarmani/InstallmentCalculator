package com.example.installmentcalculator;

import java.io.Serializable;

public class Option implements Serializable {
    int productprice, Installmentmonth, Freemonth, InterestRate, total;

    public Option(){

    }

    public Option(int productprice, int Installmentmonth, int Freemonth, int InterestRate, int total) {

        this.productprice = productprice;
        this.Installmentmonth = Installmentmonth;
        this.Freemonth = Freemonth;
        this.InterestRate = InterestRate;
        this.total = total;
    }

    public int getProductprice(){
            return productprice;
        }

    public  void  setProductprice(int productprice){
            this.productprice = productprice;
    }

    public int getInstallmentmonth(){
        return Installmentmonth;
    }

    public  void  setInstallmentmonth(int Installmentmonth){
        this.Installmentmonth = Installmentmonth;
    }

    public int getFreemonth(){
        return Freemonth;
    }

    public  void  setFreemonth(int Freemonth){
        this.Freemonth = Freemonth;
    }

    public int getInterestRate(){
        return InterestRate;
    }

    public  void  setInterestRate(int InterestRate){
        this.InterestRate = InterestRate;
    }

    public int getTotal(){
        return total;
    }

    public  void  setTotal(int total){
        this.total = total;
    }


}
