package jomily.anv.employees_skills.rest;

public class SkillNotFoundException extends RuntimeException{
	public SkillNotFoundException() {

	}

	public SkillNotFoundException(String message) {
		super(message);
	}

	public SkillNotFoundException(Throwable cause) {
		super(cause);

	}

	public SkillNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public SkillNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}
}
