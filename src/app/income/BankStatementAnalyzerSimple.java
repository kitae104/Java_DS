package app.income;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BankStatementAnalyzerSimple {

	private static final String RESOURCES = "resources/";
	public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");	
	
	public static void main(String[] args) throws IOException {
		final Path path = Paths.get(RESOURCES + "bank-data-simple.csv");
		final List<String> lines = Files.readAllLines(path);
		double total = 0; 
		for (final String line : lines) {
			final String[] columns = line.split(",");					// 콤마로 구분
			final double amount  = Double.parseDouble(columns[1]);	// 금액 부분 
			total += amount;
		}
		
		System.out.println("The total for all transactions is " + total);
		
		total = 0; 
		for (final String line : lines) {
			final String[] columns = line.split(",");								// 콤마로 구분
			final LocalDate date = LocalDate.parse(columns[0], DATE_FORMATTER);	// 날자 정보 추출 
			if(date.getMonth() == Month.JANUARY) {
				final double amount  = Double.parseDouble(columns[1]);			// 금액 부분 
				total += amount;
			}
		}
		
		System.out.println("The total for all transactions in January is " + total);
	}

}
