package com.ae.ae1.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bankbook/*")
public class BankbookController {
	
	@Autowired
	private BankbookService bankbookService;
	
	@RequestMapping("bankbookList")
	public ModelAndView list(ModelAndView mv) {
		
		List<BankbookDTO> ar = bankbookService.getList();
		mv.addObject("list", ar);
		mv.setViewName("bankbook/bankbookList");
		
		return mv;
	}
	
	@RequestMapping("bankbookSelect")
	public void select(BankbookDTO bankbookDTO, Model model) {
		bankbookDTO = bankbookService.getSelect(bankbookDTO);
		
	
		model.addAttribute("test", "iu");
		model.addAttribute("dtov", bankbookDTO);
		
	}
	
	@RequestMapping(value="bankbookInsert", method = RequestMethod.GET)
	public void insert() {
	
	}
	
	@RequestMapping(value="bankbookInsert", method = RequestMethod.POST)
	public String insert(BankbookDTO bankbookDTO) {
		int result = bankbookService.setInsert(bankbookDTO);
		
		return "redirect: ./bankbookList";
	}
	
	@RequestMapping("bankbookDelete")
	public String delete(Long book_num) {
		int result = bankbookService.setDelete(book_num);
		
		return "redirect:./bankbookList";
	}
}
