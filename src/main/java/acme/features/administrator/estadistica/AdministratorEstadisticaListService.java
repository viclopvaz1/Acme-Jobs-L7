
package acme.features.administrator.estadistica;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.estadisticas.Estadistica;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.datatypes.Money;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorEstadisticaListService implements AbstractListService<Administrator, Estadistica> {

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
		//this.repository.deleteAll();

		Estadistica announce = new Estadistica();

		announce.setNombre("Total number of  announcement");
		announce.setValor(this.repository.findAnnoun());

		res.add(announce);

		Estadistica cr = new Estadistica();
		cr.setNombre("Total number of company Record");
		cr.setValor(this.repository.findCompanyRecord());

		res.add(cr);

		Estadistica inve = new Estadistica();
		inve.setNombre("Total number of Investor Record");
		inve.setValor(this.repository.findInvestorRecord());

		res.add(inve);

		List<Money> todosM = this.repository.maxOffer();
		List<Double> todos = todosM.stream().map(x -> x.getAmount()).collect(Collectors.toList());
		List<Money> minM = this.repository.minOffer();
		List<Double> min = minM.stream().map(x -> x.getAmount()).collect(Collectors.toList());
		todos.addAll(min);
		Integer c = todos.size();
		Double minV = todos.stream().sorted().findFirst().orElse(null);
		List<Double> maxV2 = todos.stream().sorted().collect(Collectors.toList());
		Double maxV = maxV2.get(maxV2.size() - 1);
		Double suma = todos.stream().mapToDouble(x -> x).sum();
		Double r = 0.;

		for (Double x : todos) {
			Double z = suma / x;
			Double v = (x - z) * (x - z);
			r = r + v;
		}
		Double t = r / (c - 1);

		t = Math.sqrt(t);
		Estadistica maxO = new Estadistica();
		maxO.setNombre("Maximum of reward's Offer");
		maxO.setValor(maxV);

		res.add(maxO);

		Estadistica minO = new Estadistica();
		minO.setNombre("Minimum of reward's Offer");
		minO.setValor(minV);

		res.add(minO);

		List<Money> todosRM = this.repository.findRequest();
		List<Double> todosR = todosRM.stream().map(x -> x.getAmount()).collect(Collectors.toList());
		Double minVR = todosR.stream().sorted().findFirst().orElse(null);
		List<Double> maxVR2 = todosR.stream().sorted().collect(Collectors.toList());
		Double maxVR = maxVR2.get(maxVR2.size() - 1);
		Double sumaR = todosR.stream().mapToDouble(x -> x).sum();

		Estadistica minR = new Estadistica();
		minR.setNombre("Minimum of reward's Request");
		minR.setValor(minVR);

		res.add(minR);

		Estadistica maxR = new Estadistica();
		maxR.setNombre("Maximum of reward's Request");
		maxR.setValor(maxVR);

		res.add(maxR);
		Double s = 0.;
		if (todosR.size() != 0) {
			s = sumaR / todosR.size();
		}
		Estadistica avgR = new Estadistica();
		avgR.setNombre("Average of reward's Request");
		avgR.setValor(s);

		res.add(avgR);

		Integer c2 = todosR.size();
		Double r2 = 0.;

		for (Double x : todos) {
			Double z2 = suma / x;
			Double v2 = (x - z2) * (x - z2);
			r2 = r2 + v2;
		}
		Double t2 = r2 / (c2 - 1);

		t2 = Math.sqrt(t2);

		if (c2 == 0) {
			t2 = 0.;
		}

		Estadistica sdR = new Estadistica();
		sdR.setNombre("Standard derivation of reward's Request");
		sdR.setValor(t2);

		res.add(sdR);

		if (c == 0) {
			t = 0.;
		}
		Estadistica sdO = new Estadistica();
		sdO.setNombre("Standard derivation of reward's Offers");
		sdO.setValor(t);

		res.add(sdO);
		Estadistica avgO = new Estadistica();
		avgO.setNombre("Average of reward's Offers");
		avgO.setValor(suma / c);

		res.add(avgO);
		return res;

	}
}
