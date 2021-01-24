package com.example.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entities.DonationCamp;
import com.example.demo.entities.Donor;

@Controller
public class DonorClientController {
	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private ModelAndView modelView;
	
	@Autowired
	private Donor donor;
	
	
	
	
	@GetMapping(path="/donors")
	public ModelAndView init() {
		modelView.setViewName("donors");
		Donor[] donorArray= template.getForObject("http://donor-service/api/v1/donors", Donor[].class);
		modelView.addObject("donors",donorArray);
		return modelView;
	}
	
	
	@GetMapping(path="/addDonor")
	public ModelAndView setAddDonorView() {
		modelView.setViewName("addDonor");		
		modelView.addObject("command",donor);
		return modelView;
	}
	
	
	
	@PostMapping(path = "/submit")
	public ModelAndView addDonor(@ModelAttribute("command") Donor donor) {
		
		modelView.setViewName("success");
		Donor addedDonor = this.template.postForObject("http://donor-service/api/v1/donors", donor, Donor.class);
		modelView.addObject("heading","THANK YOU "+addedDonor.getDonorName()+" FOR REGISTERING WITH US.");
		modelView.addObject("content","THANK YOU FOR USING OUR SERVICE ! ");
		
		return modelView;
	}
	
	
	
	@GetMapping(path="/delete")
	public ModelAndView setDeleteDonorView() {
		modelView.setViewName("delete");
		modelView.addObject("command",donor);
		return modelView;
	}
	
	
	@PostMapping(path="/delete")
	public ModelAndView deleteDonor(@ModelAttribute("command") Donor donor) {
		boolean isDonorExist = this.template.getForObject("http://donor-service/api/v1/donors/exist/"+donor.getDonorId(), Boolean.class);
		if(isDonorExist) {
			modelView.setViewName("success");
			this.template.delete("http://donor-service/api/v1/donors/delete/"+donor.getDonorId());
			modelView.addObject("heading","YOU HAVE DEREGISTERED SUCCESSFULLY.");
			modelView.addObject("content","THANK YOU FOR USING OUR SERVICE ! ");
		}
		else {
			modelView.setViewName("failure");
			modelView.addObject("heading","THERE ARE NO SUCH DONOR REGISTERED");
			modelView.addObject("content","CHECK YOUR UID AND TRY AGAIN !");
		}
		
		return modelView;
	}
	
	

	@GetMapping(path="/update")
	public ModelAndView setUpdateDonorView() {
		modelView.setViewName("update");
		modelView.addObject("command",donor);
		return modelView;
	}

	
	@PostMapping(path="/update")
	public ModelAndView updateDonor(@ModelAttribute("command") Donor donor) {
			modelView.setViewName("success");
			this.template.put("http://donor-service/api/v1/donors/update",donor);
			modelView.addObject("heading","YOU HAVE UPDATED YOUR PROFILE SUCCESSFULLY.");
			modelView.addObject("content","THANK YOU FOR USING OUR SERVICE ! ");
	
		
		return modelView;
	}
	
	
	
	@GetMapping(path="/camps")
	public ModelAndView getCampsView() {
		modelView.setViewName("camps");
		DonationCamp[] campObj = this.template.getForObject("http://donor-service/api/v1/camps", DonationCamp[].class);
		modelView.addObject("camps", campObj);
		return modelView;
	}
	
	
	@GetMapping(path="/camps/{campId}")
	public ModelAndView getOneCampView(@PathVariable("campId") int campId) {
		modelView.setViewName("campTemplate");
		Donor[] donorObj = this.template.getForObject("http://donor-service/api/v1/donors/camps/"+campId, Donor[].class);
		DonationCamp campObj = this.template.getForObject("http://donor-service/api/v1/camps/"+campId, DonationCamp.class);
		modelView.addObject("campName",campObj.getName());
		modelView.addObject("donorObj", donorObj);
		return modelView;
	}
	
	
	@GetMapping(path="/camps/register/{campId}")
	public ModelAndView getCampRegistrationView(@PathVariable("campId") int campId) {
		modelView.setViewName("campRegister");
		modelView.addObject("campId",campId);
		modelView.addObject("command", donor);
		return modelView;
	}
	
	
	@PostMapping(path="/camps/register")
	public ModelAndView registerCamp(@ModelAttribute("command") Donor donor) {
		modelView.setViewName("success");
		this.template.put("http://donor-service/api/v1/donors/camps/register", donor);
		modelView.addObject("heading","YOU REGISTERED FOR THIS CAMP SUCCESSFULLY.");
		modelView.addObject("content","THANK YOU FOR USING OUR SERVICE ! ");
		return modelView;
	}
	

}
