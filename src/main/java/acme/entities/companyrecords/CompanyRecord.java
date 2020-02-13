
package acme.entities.companyrecords;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(indexes = {
	@Index(columnList = "star")
})
public class CompanyRecord extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				name;

	@NotBlank
	private String				sector;

	@NotBlank
	private String				ceo;

	@NotBlank
	private String				description;

	@NotBlank
	@URL
	private String				webSite;

	@NotBlank
	@Pattern(regexp = "^(\\+[1-9]\\d{0,2}\\s)?(\\(\\d{1,4}\\)\\s)?\\d{6,10}$")
	private String				phone;

	@NotBlank
	@Email
	private String				email;

	private boolean				indication;

	@Range(min = 0, max = 5)
	private Integer				star;
}
