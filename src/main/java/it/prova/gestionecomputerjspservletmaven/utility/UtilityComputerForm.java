package it.prova.gestionecomputerjspservletmaven.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionecomputerjspservletmaven.model.Computer;


//nel nome della classe vi è Articolo in quanto è una classe specifica
public class UtilityComputerForm {

	public static Computer createComputerFromParams(String marcaInputParam, String modelloInputParam,
			String prezzoInputStringParam, String dataRilascioStringParam) {

		Computer result = new Computer(marcaInputParam, modelloInputParam);

		if (NumberUtils.isCreatable(prezzoInputStringParam)) {
			result.setPrezzo(Integer.parseInt(prezzoInputStringParam));
		}
		result.setDataRilascio(parseDateRilascioFromString(dataRilascioStringParam));

		return result;
	}

	public static boolean validateComputerBean(Computer computerToBeValidated) {
		// prima controlliamo che non siano vuoti i parametri
		if (StringUtils.isBlank(computerToBeValidated.getMarca())
				|| StringUtils.isBlank(computerToBeValidated.getModello())
				|| computerToBeValidated.getPrezzo() == null 
				|| computerToBeValidated.getPrezzo() < 1
				|| computerToBeValidated.getDataRilascio() == null) {
			return false;
		}
		return true;
	}

	public static Date parseDateRilascioFromString(String dataRilascioStringParam) {
		if (StringUtils.isBlank(dataRilascioStringParam))
			return null;

		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dataRilascioStringParam);
		} catch (ParseException e) {
			return null;
		}
	}


}
