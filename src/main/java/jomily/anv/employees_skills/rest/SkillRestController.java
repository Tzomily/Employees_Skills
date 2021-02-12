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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jomily.anv.employees_skills.entity.Skill;
import jomily.anv.employees_skills.service.SkillService;

@RestController
@RequestMapping("/api/skills")
public class SkillRestController {

	@Autowired
	private SkillService skillService;

	// add mapping for GET /skills
	@GetMapping
	public List<Skill> getSkills(@RequestParam (required = false) String name) {
		if (name==null) {
			return skillService.getSkills();
		}
		List<Skill> theEmployees = skillService.getSkills(name);

		if (theEmployees == null) {
			throw new EmployeeNotFoundException("Employees not found - ");
		}
		return theEmployees;

		
	}

	// add mapping for GET /skills/{skillId}
	@GetMapping("/{skillId}")
	public Skill getSkill(@PathVariable int skillId) {
		Skill theSkill = skillService.getSkill(skillId);

		if (theSkill == null) {
			throw new SkillNotFoundException("Skill id not found - " + skillId);
		}
		return theSkill;
	}

	// add mapping for POST /skills -add a new skill
	@PostMapping
	public Skill addSkill(@RequestBody Skill theSkill) {
		// set id to 0 just in case an id is passed... forcing insert instead of update
		theSkill.setId(0);

		skillService.saveSkill(theSkill);
		return theSkill;
	}

	// add mapping for PUT /skills -update skill
	@PutMapping
	public Skill updateSkill(@RequestBody Skill theSkill) {
		skillService.saveSkill(theSkill);
		return theSkill;
	}

	// add mapping for DELETE / skills/{skillId}
	@DeleteMapping("/{skillId}")
	public String deleteSkill(@PathVariable int skillId) {
		Skill theSkill = skillService.getSkill(skillId);

		if (theSkill == null) {
			throw new SkillNotFoundException("Skill id not found - " + skillId);
		}
		skillService.deleteSkill(skillId);
		return "Deleted Employee id- " + skillId;
	}

}
