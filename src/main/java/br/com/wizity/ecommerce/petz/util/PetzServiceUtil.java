/*
--+
    | Project PETZ API SERVICE - Java Class File : 1.0.0 Data: 12/01/2021
    | Copyright(c) by Wizity Tecnologia LTDA
    |
    | All rights reserved.
    |
    | This software is confidential and proprietary information of
    | Wizity Tecnologia LTDA ("Confidential Information").
    | You shall not disclose such Confidential Information and shall 
    | use it only in accordance with the terms of the license agreement
    | you entered with Wizity Tecnologia LTDA.
 +--
 */
package br.com.wizity.ecommerce.petz.util;

import java.io.File;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Gilson de Andrade Silva
 *
 */
public class PetzServiceUtil {
	
	/**
	 * Set the logger factory. 
	 */
	static Logger logger = LoggerFactory.getLogger(PetzServiceUtil.class);
	
	public static String getDataBaseUsername () {
		
		Scanner scanner = null; 
		
		try {
			
			File file = new File ("/opt/app/petz/secret/database/username/username");
			scanner = new Scanner(file);
			return scanner.nextLine();
			
		} catch (Exception e) {			
			logger.error("Error try getting database username ".concat(e.getMessage()));
		} finally {
			scanner.close();
		}
		
		return null;		
	}
	
	public static String getDataBasePassword () {
		
		Scanner scanner = null; 
		
		try {
			
			File file = new File ("/opt/app/petz/secret/database/password/password");
			scanner = new Scanner(file);
			return scanner.nextLine();
			
		} catch (Exception e) {			
			logger.error("Error try getting database password ".concat(e.getMessage()));
		} finally {
			scanner.close();
		}
		
		return null;		
		
	}

}
