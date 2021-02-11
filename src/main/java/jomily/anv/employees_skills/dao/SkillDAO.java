package jomily.anv.employees_skills.dao;

import java.util.List;

import jomily.anv.employees_skills.entity.Skill;

public interface SkillDAO {
	public List<Skill> getSkills();

	public void saveSkill(Skill theSkill);

	public Skill getSkill(int theId);

	public void deleteSkill(int theId);
}
