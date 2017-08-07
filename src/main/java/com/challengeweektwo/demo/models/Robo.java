package com.challengeweektwo.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Robo{
        @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    @NotNull
    private String organisation;
    private String startDate;
    private String endDate;
    private int diffDays;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        if(endDate!= null){
           this.endDate=endDate;
        }
        if (endDate==null){
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            endDate = dateFormat.format(date);
        }

    }
    public void setDiffDays(int diffDays)  {

        this.diffDays=diffDays;
    }


    public int getDiffDays() throws ParseException {

            String format = "dd/MM/yyyy";
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date dateObj1 = sdf.parse(startDate);
            Date dateObj2 = sdf.parse(endDate);
            long diff = dateObj2.getTime() - dateObj1.getTime();
            diffDays = (int) (diff / (24 * 1000 * 60 * 60));
            int diffDaysinYear = diffDays / 365;

            return diffDaysinYear;
    }




    

}
