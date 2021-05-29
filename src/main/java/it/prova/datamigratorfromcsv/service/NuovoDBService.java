package it.prova.datamigratorfromcsv.service;

import java.sql.Connection;

import it.prova.datamigratorfromcsv.connection.MyConnection;
import it.prova.datamigratorfromcsv.dao.Constants;
import it.prova.datamigratorfromcsv.dao.NuovoDbDAO;
import it.prova.datamigratorfromcsv.model.Assicurato;
import it.prova.datamigratorfromcsv.model.NotProcessed;

public class NuovoDBService {
	private NuovoDbDAO nuovoDbDAO;

	public void setNuovoDAO(NuovoDbDAO nuovoDbDAO) {
		this.nuovoDbDAO = nuovoDbDAO;

	}

	public int inserisciAssicurato(Assicurato input) throws Exception {
		if (input == null)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME,
				Constants.CONNECTION_URL_NUOVO)) {

			// inietto la connection nel dao
			nuovoDbDAO.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = nuovoDbDAO.insertAssicurato(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	public int inserisciNotProcessed(NotProcessed input) throws Exception {
		if (input == null)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME,
				Constants.CONNECTION_URL_NUOVO)) {

			// inietto la connection nel dao
			nuovoDbDAO.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = nuovoDbDAO.insertNotProcessed(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

}
