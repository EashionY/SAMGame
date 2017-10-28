package com.mistytech.equipment.bean;

import java.util.Date;

/**
 * @author Pay
 *
 */
public class Equipment {
    private Integer id;

    private String eqName;

    private String defense;//基础防御

    private String resistance;//属性抗性

    private Integer resistanceType;//抗性类型(2-全元素，3-冰，4-火，5-电，6-奥术)

    private Integer eqRare;//稀有度

    private Date createtime;

    private Date updatetime;

    private Integer eqStatus;

    private String imgurl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEqName() {
        return eqName;
    }

    public void setEqName(String eqName) {
        this.eqName = eqName;
    }

    public String getDefense() {
        return defense;
    }

    public void setDefense(String defense) {
        this.defense = defense;
    }

    public String getResistance() {
        return resistance;
    }

    public void setResistance(String resistance) {
        this.resistance = resistance;
    }

    public Integer getResistanceType() {
        return resistanceType;
    }

    public void setResistanceType(Integer resistanceType) {
        this.resistanceType = resistanceType;
    }

    public Integer getEqRare() {
        return eqRare;
    }

    public void setEqRare(Integer eqRare) {
        this.eqRare = eqRare;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getEqStatus() {
        return eqStatus;
    }

    public void setEqStatus(Integer eqStatus) {
        this.eqStatus = eqStatus;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

	@Override
	public String toString() {
		return "Equipment [id=" + id + ", eqName=" + eqName + ", defense=" + defense + ", resistance=" + resistance
				+ ", resistanceType=" + resistanceType + ", eqRare=" + eqRare + ", createtime=" + createtime
				+ ", updatetime=" + updatetime + ", eqStatus=" + eqStatus + ", imgurl=" + imgurl + "]";
	}
    
}