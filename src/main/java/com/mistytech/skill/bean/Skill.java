package com.mistytech.skill.bean;

import java.util.Date;

public class Skill {
	//技能id
    private Integer skillId;
    //技能名称
    private String skillName;
    //间接伤害
    private Integer damageIndirect;
    //直接伤害
    private Integer damageDirect;
    //技能类型
    private Integer skillType;
    //技能稀有度
    private Integer skillRare;
    //创建时间
    private Date createtime;
    //最后修改时间
    private Date updatetime;
    //技能状态(0--禁用，1--可用)
    private Integer skillStatus;

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public Integer getDamageIndirect() {
        return damageIndirect;
    }

    public void setDamageIndirect(Integer damageIndirect) {
        this.damageIndirect = damageIndirect;
    }

    public Integer getDamageDirect() {
        return damageDirect;
    }

    public void setDamageDirect(Integer damageDirect) {
        this.damageDirect = damageDirect;
    }

    public Integer getSkillType() {
        return skillType;
    }

    public void setSkillType(Integer skillType) {
        this.skillType = skillType;
    }

    public Integer getSkillRare() {
        return skillRare;
    }

    public void setSkillRare(Integer skillRare) {
        this.skillRare = skillRare;
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

    public Integer getSkillStatus() {
        return skillStatus;
    }

    public void setSkillStatus(Integer skillStatus) {
        this.skillStatus = skillStatus;
    }

	@Override
	public String toString() {
		return "Skill [skillId=" + skillId + ", skillName=" + skillName + ", damageIndirect=" + damageIndirect
				+ ", damageDirect=" + damageDirect + ", skillType=" + skillType + ", skillRare=" + skillRare
				+ ", createtime=" + createtime + ", updatetime=" + updatetime + ", skillStatus=" + skillStatus + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((skillId == null) ? 0 : skillId.hashCode());
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
		Skill other = (Skill) obj;
		if (skillId == null) {
			if (other.skillId != null)
				return false;
		} else if (!skillId.equals(other.skillId))
			return false;
		return true;
	}
    
}