package com.example.epharma_inf1030_h22_g3.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity()
public class Medicament extends Auditable{

    private Long catnumber;

    @NonNull
    @PrimaryKey
    private Long drugnumber;
    private String dci;
    private String dosage;
    private String form;
    private String reference;
    private boolean cases;
    private boolean posts;
    private boolean centers;
    private boolean eps1;
    private boolean eps2;
    private boolean eps3;
    private String createdBy;
    private String lastUpdatedBy;
    private boolean status;
//    private String imageKey;

    public Medicament() {
    }

    public Long getCatnumber() {
        return catnumber;
    }

    public void setCatnumber(Long catnumber) {
        this.catnumber = catnumber;
    }

    public Long getDrugnumber() {
        return drugnumber;
    }

    public void setDrugnumber(Long drugnumber) {
        this.drugnumber = drugnumber;
    }

    public String getDci() {
        return dci;
    }

    public void setDci(String dci) {
        this.dci = dci;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public boolean isCases() {
        return cases;
    }

    public void setCases(boolean cases) {
        this.cases = cases;
    }

    public boolean isPosts() {
        return posts;
    }

    public void setPosts(boolean posts) {
        this.posts = posts;
    }

    public boolean isCenters() {
        return centers;
    }

    public void setCenters(boolean centers) {
        this.centers = centers;
    }

    public boolean isEps1() {
        return eps1;
    }

    public void setEps1(boolean eps1) {
        this.eps1 = eps1;
    }

    public boolean isEps2() {
        return eps2;
    }

    public void setEps2(boolean eps2) {
        this.eps2 = eps2;
    }

    public boolean isEps3() {
        return eps3;
    }

    public void setEps3(boolean eps3) {
        this.eps3 = eps3;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
