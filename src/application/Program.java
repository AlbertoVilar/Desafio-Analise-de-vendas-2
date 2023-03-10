package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collector;

import entitie.Sale;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.print("Entre o caminho do arquivo: ");
		String path = sc.next();

		Map<String, Double> sellers = new LinkedHashMap<>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			// List<Sale> list = new ArrayList<>();

			String line = br.readLine();
			System.out.println();
			while (line != null) {

				String[] field = line.split(",");
				Integer month = Integer.parseInt(field[0]);
				Integer year = Integer.parseInt(field[1]);
				String seller = field[2];
				Integer items = Integer.parseInt(field[3]);
				Double total = Double.parseDouble(field[4]);

				Double count = total;

				if (sellers.containsKey(seller)) {
					Double totalSeller = sellers.get(seller);
					sellers.put(seller, count + totalSeller);

				} else {
					sellers.put(seller, count);
				}

				line = br.readLine();

			}
			System.out.println("Total de vendas por vendedor:");
			System.out.println();
			for (String key : sellers.keySet()) {
			System.out.printf("%s %s %.2f\n", key, "= R$", sellers.get(key));
			}

			System.out.println("======================================");
		}

		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();

	}

}
