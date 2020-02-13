
package acme.entities.descriptors;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Descriptor extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				description;

	//	@NotNull
	//	@Valid
	//	@OneToMany() //mappedBy = "descriptor")
	//	private Collection<Duty>	mandatoryDuties;

}
