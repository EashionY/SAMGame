package com.mistytech.skill.bean;

import java.util.Date;

public class Skill {
	//����id
    private Integer skillId;
    //��������
    private String skillName;
    //����˺�
    private Integer damageIndirect;
    //ֱ���˺�
    private Integer damageDirect;
    //��������
    private Integer skillType;
    //����ϡ�ж�
    private Integer skillRare;
    //����ʱ��
    private Date createtime;
    //����޸�ʱ��
    private Date updatetime;
    //����״̬(0--���ã�1--����)
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