package com.mistytech.role.bean;

import java.util.Date;

public class Role {
	
    private Integer roleId;

    private Integer bloodVol;//血量

    private String phyDefense;//物理防御

    private String iceResistance;//冰抗

    private String fireResistance;//火抗

    private String thunderResistance;//闪电抗性

    private String arcaneResistance;//奥术抗性

    private Integer roleType;//角色类型（1--剑士，2--魔法师）

    private Date createtime;

    private Integer roleStatus;//角色状态（1--可用，0--弃用）

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getBloodVol() {
        return bloodVol;
    }

    public void setBloodVol(Integer bloodVol) {
        this.bloodVol = bloodVol;
    }

    public String getPhyDefense() {
        return phyDefense;
    }

    public void setPhyDefense(String phyDefense) {
        this.phyDefense = phyDefense;
    }

    public String getIceResistance() {
        return iceResistance;
    }

    public void setIceResistance(String iceResistance) {
        this.iceResistance = iceResistance;
    }

    public String getFireResistance() {
        return fireResistance;
    }

    public void setFireResistance(String fireResistance) {
        this.fireResistance = fireResistance;
    }

    public String getThunderResistance() {
        return thunderResistance;
    }

    public void setThunderResistance(String thunderResistance) {
        this.thunderResistance = thunderResistance;
    }

    public String getArcaneResistance() {
        return arcaneResistance;
    }

    public void setArcaneResistance(String arcaneResistance) {
        this.arcaneResistance = arcaneResistance;
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(Integer roleStatus) {
        this.roleStatus = roleStatus;
    }

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", bloodVol=" + bloodVol + ", phyDefense=" + phyDefense + ", iceResistance="
				+ iceResistance + ", fireResistance=" + fireResistance + ", thunderResistance=" + thunderResistance
				+ ", arcaneResistance=" + arcaneResistance + ", roleType=" + roleType + ", createtime=" + createtime
				+ ", roleStatus=" + roleStatus + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		return true;
	}
    
}