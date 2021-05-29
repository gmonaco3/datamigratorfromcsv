package it.prova.datamigratorfromcsv.test;

import it.prova.datamigratorfromcsv.model.Assicurato;
import it.prova.datamigratorfromcsv.model.NotProcessed;
import it.prova.datamigratorfromcsv.service.CSVReaderService;
import it.prova.datamigratorfromcsv.service.MyServiceFactory;
import it.prova.datamigratorfromcsv.service.NuovoDBService;

public class DataMigratorTest {
	public static void main(String[] args) throws Exception {
		NuovoDBService service = MyServiceFactory.getNuovoService();

		for (Assicurato item : CSVReaderService.getAssicuratiValidi()) {
			service.inserisciAssicurato(item);
		}
		for (Assicurato assicuratoItem : CSVReaderService.getAssicuratiNonValidi()) {
			service.inserisciNotProcessed(new NotProcessed(assicuratoItem.getCodiceFiscale(), assicuratoItem.getId()));
		}

	}

}
