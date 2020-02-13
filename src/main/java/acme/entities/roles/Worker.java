
package acme.entities.roles;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import acme.framework.entities.UserRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Worker extends UserRole {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	private String				qualificationsRecord;

	@NotBlank
	private String				skillsRecord;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

	//	@OneToMany(mappedBy = "worker")
	//	private Application			application;

}
