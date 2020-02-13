
package acme.entities.estadisticas;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Estadistica implements Serializable {

	public static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				nombre;

	@NotBlank
	private Double				valor;

}
