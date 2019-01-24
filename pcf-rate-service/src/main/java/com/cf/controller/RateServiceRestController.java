package com.cf.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cf.rs.dto.GetRate;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RefreshScope
@RestController
public class RateServiceRestController {
	
	
	@Value("${forex.url}")
    private String forexUrl;
	
	@Value("${forex.base.currency}")
    private String baseCurrency;
	
	@RequestMapping(path = "/getrate/{symbols}", method = RequestMethod.GET)
	public String getRate(@PathVariable String symbols) {
		 final String uri = forexUrl+"?base="+baseCurrency+"&symbols="+symbols;
		 System.out.println("===== uri ============>  "+uri);
		 
		    RestTemplate restTemplate = new RestTemplate();
		    String result = restTemplate.getForObject(uri, String.class);
		    ObjectMapper mapper = new ObjectMapper();
		    GetRate fx;
			try {
				fx = mapper.readValue(result, GetRate.class);
				 System.out.println("==========================>  "+fx.toString());
			} catch (JsonParseException e) {
				System.err.println("Error in json to object parsing  -->"+e);
				e.printStackTrace();
			} catch (JsonMappingException e) {
				System.err.println("Error in json mapping  -->"+e);
				e.printStackTrace();
			} catch (IOException e) {
				System.err.println("Error in IO -->"+e);
				e.printStackTrace();
			} catch (Exception e) {
				System.err.println("Other exepection -->"+e);
				e.printStackTrace();
			}
		    /*FxRate fx= new FxRate();
		    fx.setBaseCurrency(result);
		    */
		   
		    
		   
		return result;
	}
}
