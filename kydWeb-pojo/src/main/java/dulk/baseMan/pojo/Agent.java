package dulk.baseMan.pojo;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class Agent   {
   private int id;

   private String agentName;

   private String telephone;

   private String mobile;

   private String address;

   private String qqNumber;

   private float   yearSales;

   private String industry;

   private int personnelQuantity;

   private String intentionProvince;

   private String intentionCity;

   private String intentionDistrict;

   private String leaveMessage;

    public int getId() {
        return id;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAddress() {
        return address;
    }

    public String getQqNumber() {
        return qqNumber;
    }

    public float  getYearSales() {
        return yearSales;
    }

    public String getIndustry() {
        return industry;
    }

    public int getPersonnelQuantity() {
        return personnelQuantity;
    }

    public String getIntentionProvince() {
        return intentionProvince;
    }

    public String getIntentionCity() {
        return intentionCity;
    }

    public String getIntentionDistrict() {
        return intentionDistrict;
    }

    public String getLeaveMessage() {
        return leaveMessage;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setQqNumber(String qqNumber) {
        this.qqNumber = qqNumber;
    }

    public void setYearSales(float  yearSales) {
        this.yearSales = yearSales;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public void setPersonnelQuantity(int personnelQuantity) {
        this.personnelQuantity = personnelQuantity;
    }

    public void setIntentionProvince(String intentionProvince) {
        this.intentionProvince = intentionProvince;
    }

    public void setIntentionCity(String intentionCity) {
        this.intentionCity = intentionCity;
    }

    public void setIntentionDistrict(String intentionDistrict) {
        this.intentionDistrict = intentionDistrict;
    }

    public void setLeaveMessage(String leaveMessage) {
        this.leaveMessage = leaveMessage;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }
}
