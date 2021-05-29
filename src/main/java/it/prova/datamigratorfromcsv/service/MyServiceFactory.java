package it.prova.datamigratorfromcsv.service;

import it.prova.datamigratorfromcsv.dao.NuovoDbDAO;

public class MyServiceFactory {

	public static NuovoDBService getNuovoService() {
		NuovoDBService nuovoDbService = new NuovoDBService();
		nuovoDbService.setNuovoDAO(new NuovoDbDAO());
		return nuovoDbService;
	}

}
