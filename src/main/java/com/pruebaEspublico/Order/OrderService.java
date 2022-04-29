package com.pruebaEspublico.Order;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

@Service
public class OrderService {
	
	private static final String UPLOAD_OK = "The file has been successfully uploaded";
	private static final String[] countParameters = new String[] {"Region", "Country", "Item Type", "Sales Channel", "Order Priority"};
	private String[] headers = new String[] { 
			"Region", "Country", "Item Type", "Sales Channel", "Order Priority", "Order Date", 
			"Order ID", "Ship Date", "Units Sold", "Unit Price", "Unit Cost", "Total Revenue", "Total Cost", "Total Profit" };
	private static final CellProcessor[] processors = new CellProcessor[] { 
			null, null,	null, null,	null,
			new ParseDate("MM/dd/yyyy"), 
			new ParseInt(),
			new ParseDate("MM/dd/yyyy"), 
			new ParseInt(),
			new Optional(new ParseDouble()),
			new Optional(new ParseDouble()),
			new Optional(new ParseDouble()),
			new Optional(new ParseDouble()),
			new Optional(new ParseDouble()) };
	
	@Autowired
	private OrderRepository orderRepository;
	
	public String treatmentCSVDocument(String csvPath) throws Exception {
		
		List<Order> lorder = uploadCSVData(csvPath);
		lorder.sort(Comparator.comparing(Order::getOrderID));
		generateCSVFile(lorder);
		
		return UPLOAD_OK;
	}
	
	public List<Order> uploadCSVData(String csvPath) throws Exception {
		if (csvPath == null || csvPath.isBlank()) { throw new IllegalArgumentException("Path is not valid"); }
		
		ICsvBeanReader beanReader = new CsvBeanReader(new FileReader(csvPath), CsvPreference.STANDARD_PREFERENCE);
		
		String[] headers = beanReader.getHeader(true);
		headers = removeWhiteSpacesFromHeaders(headers);
		
		Order order = new Order();
		List<Order> lorder = new ArrayList<Order>();
		while ((order = beanReader.read(Order.class, headers, processors)) != null) {
			lorder.add(order);
			orderRepository.save(order);
		}
		
		return lorder;
	}
	
	public void generateCSVFile(List<Order> lorders) throws Exception {
		if(lorders == null || lorders.isEmpty()) {throw new IllegalArgumentException("No order data found"); }
		
		ICsvBeanWriter beanWriter = new CsvBeanWriter(new FileWriter("./src/main/resources/csv/RegistroOrdenado.csv"), CsvPreference.STANDARD_PREFERENCE);
		
		beanWriter.writeHeader(headers);
		headers = removeWhiteSpacesFromHeaders(headers);
		for(Order order : lorders) {
			beanWriter.write(order, headers);
		}
		
		try {
	        beanWriter.close();
	      } catch (IOException e) {
	        e.printStackTrace();
	      }
	}
	
	public Map<String, Map<String, String>> getOrderSummary() {
		 
		Map<String, Map<String, String>> summary = new HashMap<String, Map<String,String>>();
		 
		for(String param : countParameters) {
			summary.put(param, summaryByParameter(param.replaceAll("\\s","_")));
		}
		 
		return summary;
	}
	
	public Map<String, String> summaryByParameter(String parameter) {
		if (parameter == null || parameter.isBlank()) { throw new IllegalArgumentException("Parameter is not valid"); }
 
		Map<String, String> resultMap = new HashMap<String, String>();
		List<Map<String, Object>> mapList = orderRepository.findByParameter(parameter);
 
		for(Map<String, Object> m : mapList) {
			List<Object> list = new ArrayList<Object>();
	 
			list = m.values().stream().collect(Collectors.toList());

			resultMap.put(list.get(0).toString(), list.get(1).toString());
		}
		 
		return resultMap;
	}
	
	 private String[] removeWhiteSpacesFromHeaders(String[] defaultheaders) {
		 Stream<String> stream = Arrays.stream(defaultheaders);
		 String[] headers = stream.map(str -> str.replaceAll("\\s",""))
		         .toArray(size -> new String[size]);
		 return headers;
	 }

}
