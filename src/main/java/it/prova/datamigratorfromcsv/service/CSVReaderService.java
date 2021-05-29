package it.prova.datamigratorfromcsv.service;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import it.prova.datamigratorfromcsv.model.Assicurato;

public class CSVReaderService {
	private static final String FILE_NAME = "C:/Users/Giaco/Desktop/assiucratoCSV.csv";
	private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

	public static List<Assicurato> readCsv() throws IOException, CsvException, ParseException {
		List<Assicurato> assicurati = new ArrayList<>();
		CSVParser csvParser = new CSVParserBuilder().withSeparator(',').withIgnoreQuotations(true).build();

		try (CSVReader reader = new CSVReaderBuilder(new FileReader(FILE_NAME)).withCSVParser(csvParser)
				.withSkipLines(1).build()) {
			// estraggo il contenuto del file csv:
			List<String[]> assicuratiCsv = reader.readAll();

			// deserializzo il contenuto

			for (String[] assiucuratoCsv : assicuratiCsv) {
				Assicurato assicurato = new Assicurato();
				assicurato.setId(Long.parseLong(assiucuratoCsv[0]));
				assicurato.setNome(assiucuratoCsv[1]);
				assicurato.setCognome(assiucuratoCsv[2]);
				assicurato.setDataNascita(FORMATTER.parse(assiucuratoCsv[4]));
				assicurato.setCodiceFiscale(assiucuratoCsv[3]);
				assicurato.setTotaleSinistri(Integer.parseInt(assiucuratoCsv[5]));

				assicurati.add(assicurato);
			}
		}
		return assicurati;
	}

	public static List<Assicurato> getAssicuratiValidi() throws IOException, CsvException, ParseException {
		return CSVReaderService.readCsv().stream().filter(elem -> elem.getTotaleSinistri() < 10)
				.filter(elem -> elem.getCodiceFiscale().length() == 16).collect(Collectors.toList());

	}

	public static List<Assicurato> getAssicuratiNonValidi() throws IOException, CsvException, ParseException {
		List<Assicurato> assicuratiRifiutati = CSVReaderService.readCsv();
		assicuratiRifiutati.removeAll(getAssicuratiValidi());
		return assicuratiRifiutati;
	}

}
