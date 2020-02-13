
package acme.entities.messages;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import acme.entities.threads.Thread;
import acme.framework.entities.Authenticated;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Message extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@Column(length = 1024)
	@NotBlank
	private String				body;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date				moment;

	@NotBlank
	private String				title;

	private String				tags;

	//-------------------------------------------------

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Authenticated		authenticated;

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Thread				thread;

}
