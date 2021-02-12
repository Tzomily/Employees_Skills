package jomily.anv.employees_skills.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jomily.anv.employees_skills.entity.Employee;
import jomily.anv.employees_skills.entity.Skill;

@Repository
public class SkillDAOImpl implements SkillDAO {
	// inject the session factory
		@Autowired
		private SessionFactory sessionFactory;

		@Override
		public List<Skill> getSkills() {

			Session currentSession = sessionFactory.getCurrentSession();

			// Query to sort by name
			Query<Skill> theQuery = currentSession.createQuery("from Skill order by name", Skill.class);

			List<Skill> skills = theQuery.getResultList();

			return skills;
		}

		@Override
		public void saveSkill(Skill theSkill) {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.saveOrUpdate(theSkill);

		}

		@Override
		public Skill getSkill(int theId) {
			Session currentSession = sessionFactory.getCurrentSession();
			Skill theSkill = currentSession.get(Skill.class, theId);
			return theSkill;
		}

		@Override
		public void deleteSkill(int theId) {
			Session currentSession = sessionFactory.getCurrentSession();

			Query theQuery = currentSession.createQuery("delete from Skill where id=:skillId ");
			theQuery.setParameter("skillId", theId);

			theQuery.executeUpdate();

		}

		@Override
		public List<Skill> getSkills(String name) {
			Session currentSession = sessionFactory.getCurrentSession();

			// Query to sort by last name
			Query<Skill> theQuery = currentSession.createQuery("from Skill where name=:name",Skill.class);
			theQuery.setParameter("name", name);
			List<Skill> theSkills = theQuery.getResultList();

			return theSkills;
		}
}
