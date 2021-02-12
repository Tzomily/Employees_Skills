package jomily.anv.employees_skills.service;

import java.util.List;

import jomily.anv.employees_skills.entity.Skill;

public interface SkillService {
	public List<Skill> getSkills();

	public void saveSkill(Skill theSkill);

	public Skill getSkill(int theId);
	
	public List<Skill> getSkills(String name);

	public void deleteSkill(int theId);
}
