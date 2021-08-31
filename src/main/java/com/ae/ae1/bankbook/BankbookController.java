package com.ae.ae1.bankbook;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bankbook/*")
public class BankbookController {
	//pojo(plain old java object)
	
	@RequestMapping(value = "bankbookList.do", method= RequestMethod.GET)
	public ModelAndView list(Integer [] num, ModelAndView mv) {
		for(Integer i:num) {
			System.out.println(i);
		}
		System.out.println("bankbook List");
		/* ModelAndView mv = new ModelAndView(); */
		mv.setViewName("bankbook/bankbookList");
		return mv;
	}
	
	@RequestMapping("bankbookSelect")
	public void select(@RequestParam(defaultValue = "1", value ="n") Integer num, String name, Model model) {
		System.out.println("value: "+num);
		System.out.println("Name: " + name);
		BankbookDTO bankbookDTO = new BankbookDTO();
		bankbookDTO.setBook_name("BookName");
		model.addAttribute("dto", bankbookDTO);
		model.addAttribute("test", "iu");
		/* return "bankbook/bankbookSelect"; */
	}
	
	@RequestMapping("bankbookInsert.do")
	public String insert(BankbookDTO bankbookDTO) {
		System.out.println(bankbookDTO.getBook_name());
		System.out.println("insert");
		return "redirect: ../";
	}
	
}
