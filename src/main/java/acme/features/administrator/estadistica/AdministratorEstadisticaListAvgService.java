
package acme.features.administrator.estadistica;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.estadisticas.Estadistica;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorEstadisticaListAvgService implements AbstractListService<Administrator, Estadistica> {

	@Autowired
	AdministratorEstadisticaRepository repository;


	@Override
	public boolean authorise(final Request<Estadistica> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Estadistica> request, final Estadistica entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "nombre", "valor");

	}

	@Override
	public Collection<Estadistica> findMany(final Request<Estadistica> request) {
		assert request != null;

		Collection<Estadistica> result = this.createAll();
		;
		return result;

	}

	private Collection<Estadistica> createAll() {

		Collection<Estadistica> res = new HashSet<>();
		Estadistica averageNumberOfJobsPerEmployer = new Estadistica();

		averageNumberOfJobsPerEmployer.setNombre("Average number of jobs per employer");
		averageNumberOfJobsPerEmployer.setValor(this.repository.averageNumberOfJobsPerEmployer());
		res.add(averageNumberOfJobsPerEmployer);

		Estadistica averageNumberOfApplicationsPerWorker = new Estadistica();

		averageNumberOfApplicationsPerWorker.setNombre("Average number of applications per worker");
		averageNumberOfApplicationsPerWorker.setValor(this.repository.averageNumberOfApplicationsPerWorker());
		res.add(averageNumberOfApplicationsPerWorker);

		Estadistica averageNumberOfApplicationsPerEmployer = new Estadistica();

		averageNumberOfApplicationsPerEmployer.setNombre("Average number of applications per employer");
		averageNumberOfApplicationsPerEmployer.setValor(this.repository.averageNumberOfApplicationsPerEmployer());

		res.add(averageNumberOfApplicationsPerEmployer);

		return res;
	}
}
