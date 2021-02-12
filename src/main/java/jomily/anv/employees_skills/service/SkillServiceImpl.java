package jomily.anv.employees_skills.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jomily.anv.employees_skills.dao.SkillDAO;
import jomily.anv.employees_skills.entity.Skill;

@Service
public class SkillServiceImpl implements SkillService {

	// inject the SkillDAO
	@Autowired
	private SkillDAO skillDAO;

	@Override
	@Transactional
	public List<Skill> getSkills() {
		return skillDAO.getSkills();
	}

	@Override
	@Transactional
	public void saveSkill(Skill theSkill) {
		skillDAO.saveSkill(theSkill);
	}

	@Override
	@Transactional
	public Skill getSkill(int theId) {
		return skillDAO.getSkill(theId);
	}

	@Override
	@Transactional
	public void deleteSkill(int theId) {
		skillDAO.deleteSkill(theId);
	}

	@Override
	@Transactional
	public List<Skill> getSkills(String name) {

		return skillDAO.getSkills(name);
	}
}
