package com.ae.ae1.bankbook;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/bankbook/*")
public class BankbookController {
	//pojo(plain old java object)
	
	@RequestMapping(value = "bankbookList.do", method= RequestMethod.GET)
	public String list() {
		System.out.println("bankbook List");
		return "bankbook/bankbookList";
	}
	
	@RequestMapping("bankbookSelect.do")
	public String select(int num, String name) {
		System.out.println("value: "+num);
		System.out.println("Name: " + name);
		return "bankbook/bankbookSelect";
	}
	
	
}
