package ru.kassatka.comepay_sdk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by sokolov on 27.07.2018.
 */

public class Complex {

    @SerializedName("Group")
    @Expose
    private String group = "";

    @SerializedName("Device")
    @Expose
    private String Device = "";

    @SerializedName("RequestId")
    @Expose
    private String RequestId = "";

    @SerializedName("Password")
    @Expose
    private int Password = 30;

    @SerializedName("DocumentType")
    @Expose
    private byte DocumentType = 0;

    @SerializedName("Lines")
    @Expose
    private ArrayList<Lines> lines = new ArrayList<>();

    @SerializedName("Cash")
    @Expose
    private int Cash = 1000;

    @SerializedName("CasNonCashh")
    @Expose
    private int NonCash = 0;

    @SerializedName("AdvancePayment")
    @Expose
    private int AdvancePayment = 0;

    @SerializedName("Credit")
    @Expose
    private int Credit = 0;

    @SerializedName("Consideration")
    @Expose
    private int Consideration = 0;

    @SerializedName("TaxMode")
    @Expose
    private int TaxMode = 0;

    @SerializedName("PhoneOrEmail")
    @Expose
    private int PhoneOrEmail = 0;

    @SerializedName("Place")
    @Expose
    private int Place = 0;

    @SerializedName("FullResponse")
    @Expose
    private boolean FullResponse = false;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDevice() {
        return Device;
    }

    public void setDevice(String device) {
        Device = device;
    }

    public String getRequestId() {
        return RequestId;
    }

    public void setRequestId(String requestId) {
        RequestId = requestId;
    }

    public int getPassword() {
        return Password;
    }

    public void setPassword(int password) {
        Password = password;
    }

    public byte getDocumentType() {
        return DocumentType;
    }

    public void setDocumentType(byte documentType) {
        DocumentType = documentType;
    }

    public ArrayList<Lines> getLines() {
        return lines;
    }

    public void setLines(ArrayList<Lines> lines) {
        this.lines = lines;
    }

    public int getCash() {
        return Cash;
    }

    public void setCash(int cash) {
        Cash = cash;
    }

    public int getNonCash() {
        return NonCash;
    }

    public void setNonCash(int nonCash) {
        NonCash = nonCash;
    }

    public int getAdvancePayment() {
        return AdvancePayment;
    }

    public void setAdvancePayment(int advancePayment) {
        AdvancePayment = advancePayment;
    }

    public int getCredit() {
        return Credit;
    }

    public void setCredit(int credit) {
        Credit = credit;
    }

    public int getConsideration() {
        return Consideration;
    }

    public void setConsideration(int consideration) {
        Consideration = consideration;
    }

    public int getTaxMode() {
        return TaxMode;
    }

    public void setTaxMode(int taxMode) {
        TaxMode = taxMode;
    }

    public int getPhoneOrEmail() {
        return PhoneOrEmail;
    }

    public void setPhoneOrEmail(int phoneOrEmail) {
        PhoneOrEmail = phoneOrEmail;
    }

    public int getPlace() {
        return Place;
    }

    public void setPlace(int place) {
        Place = place;
    }

    public boolean isFullResponse() {
        return FullResponse;
    }

    public void setFullResponse(boolean fullResponse) {
        FullResponse = fullResponse;
    }

    private class Lines{

        @SerializedName("Qty")
        @Expose
        private int Qty = 0;

        @SerializedName("Price")
        @Expose
        private int Price = 0;

        @SerializedName("SubTotal")
        @Expose
        private int SubTotal = 0;

        @SerializedName("PayAttribute")
        @Expose
        private byte PayAttribute = 0;

        @SerializedName("LineAttribute")
        @Expose
        private byte LineAttribute = 0;

        @SerializedName("TaxID")
        @Expose
        private byte taxID = 0;

        @SerializedName("AgentModes")
        @Expose
        private byte AgentModes = 0;

        @SerializedName("Description")
        @Expose
        private String Description = "";
    }
}
