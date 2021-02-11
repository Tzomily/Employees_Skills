package jomily.anv.employees_skills.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jomily.anv.employees_skills.entity.Employee;
import jomily.anv.employees_skills.entity.Skill;
import jomily.anv.employees_skills.service.SkillService;

@RestController
@RequestMapping("/api")
public class SkillRestController {

	// autowire the SkillService
	@Autowired
	private SkillService skillService;

	// add mapping for GET /skills
	@GetMapping("/skills")
	public List<Skill> getSkills() {
		return skillService.getSkills();
	}

	// add mapping for GET /skills/{skillId}
	@GetMapping("/skills/{skillId}")
	public Skill getSkill(@PathVariable int skillId) {
		Skill theSkill = skillService.getSkill(skillId);
		return theSkill;
	}

	// add mapping for POST /skills -add a new skill
	@PostMapping("/skills")
	public Skill addSkill(@RequestBody Skill theSkill) {
		// set id to 0 just in case an id is passed... forcing insert instead of update
		theSkill.setId(0);

		skillService.saveSkill(theSkill);
		return theSkill;
	}

	// add mapping for PUT /skills -update skill
	@PutMapping("/skills")
	public Skill updateSkill(@RequestBody Skill theSkill) {
		skillService.saveSkill(theSkill);
		return theSkill;
	}

	// add mapping for DELETE / skills/{skillId}
	@DeleteMapping("/skills/{skillId}")
	public String deleteSkill(@PathVariable int skillId) {
		Skill theSkill = skillService.getSkill(skillId);

		skillService.deleteSkill(skillId);
		return "Deleted Employee id- " + skillId;
	}

}
