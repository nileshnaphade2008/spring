package com.nilesh.poc.laundry.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nilesh.poc.laundry.dao.IAdminDao;
import com.nilesh.poc.laundry.pojos.ClothsCategory;
import com.nilesh.poc.laundry.pojos.TypeOfWash;

@ControllerAdvice
@RequestMapping("/admin")
public class AdminController {
	private final static Logger LOG = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private IAdminDao dao;

	public AdminController() {
	}

	// Redirect to cloth category page
	@GetMapping("/clothscat")
	public String showClothsCat(ClothsCategory c, Model map,HttpServletRequest request) {
		LOG.info("AdminController  :: showClothsCat :: In");
		HttpSession session = request.getSession();
		if(null!=session && null==session.getAttribute("user_dtls"))
		{
			LOG.info("AdminController  :: showClothsCat :: session is null ");
			map.addAttribute("error","User session has been expired,Login again !!");
			return "/user/login";

		}
		ClothsCategory c1 = new ClothsCategory();
		map.addAttribute("clocat", c1);
		return "/admin/clothscat";
	}

	// Add or Update the cloth category
	//While update to get the cloth-id to update the respective request
	@PostMapping("/clothscat")
	public String processClothsCategory(@Valid ClothsCategory c, BindingResult result, RedirectAttributes flashMap,
			HttpServletRequest request)

	{
		LOG.info("AdminController  :: processClothsCategory :: start");
		HttpSession session = request.getSession();
		if(null!=session && null==session.getAttribute("user_dtls"))
		{
			LOG.info("AdminController  :: processClothsCategory :: session is null ");
			flashMap.addAttribute("error","User session has been expired,Login again !!");
			return "/user/login";
		}
		try {
			String id = request.getParameter("cloth_id");
			LOG.info("AdminController  :: processClothsCategory :: cloth_id : " + id);
			if (null != id && !"".equals(id.trim())) {
				c.setCloth_id(Integer.valueOf(id.trim()));

				String msg = dao.updateClothCategory(c);
				flashMap.addFlashAttribute("mesg", msg);

			} else {
				flashMap.addFlashAttribute("mesg", dao.addClothCategory(c));
			}
		} catch (Exception exept) {
			LOG.error("AdminController  :: processClothsCategory :: Exception while calling updateClothCategory  : "
					+ exept.getMessage());
			flashMap.addFlashAttribute("mesg", "Exception while processing cloth category!!");
		}
		LOG.info("AdminController  :: processClothsCategory :: start");
		return "/admin/clothscat";
	}
  // Redirect to type of Wash page
	@GetMapping("/typewash")
	public String addTypeOfCloth(TypeOfWash t, Model map,HttpServletRequest request) {
		LOG.info("AdminController  :: addTypeOfCloth :: In");
		HttpSession session = request.getSession();
		if(null!=session && null==session.getAttribute("user_dtls"))
		{
			LOG.info("AdminController  :: addTypeOfCloth :: session is null ");
			map.addAttribute("error","User session has been expired,Login again !!");
			return "/user/login";
		}
		TypeOfWash t1 = new TypeOfWash();
		map.addAttribute("wash", t1);
		return "/admin/typewash";
	}
    // Add or update the type of wash and while update to get the tid to update the respective request
	@PostMapping("/typewash")
	public String processAddWashTypeForm(@Valid TypeOfWash t, BindingResult result, RedirectAttributes flashMap,
			HttpServletRequest request) {
		LOG.info("AdminController  :: processAddWashTypeForm :: start");
		HttpSession session = request.getSession();
		if(null!=session && null==session.getAttribute("user_dtls"))
		{
			LOG.info("AdminController  :: processAddWashTypeForm :: session is null ");
			flashMap.addAttribute("error","User session has been expired,Login again !!");
			return "/user/login";
		}
		try {
		String tid = request.getParameter("tid");
		LOG.info("AdminController  :: processAddWashTypeForm :: tid : "+tid);
		if (null != tid && !"".equals(tid.trim())) {
			t.setTid(Integer.valueOf(tid.trim()));
			flashMap.addFlashAttribute("mesg", dao.updateTypeOfWash(t));

		} else {
			flashMap.addFlashAttribute("mesg", dao.addTypeOfWash(t));
		}
		} catch (Exception exept) {
			LOG.error("AdminController  :: processAddWashTypeForm :: Exception while calling processAddWashTypeForm  : "
					+ exept.getMessage());
			flashMap.addFlashAttribute("mesg", "Exception while processing type of wash request!!");
		}
		LOG.info("AdminController  :: processAddWashTypeForm :: end");
		return "redirect:/admin/clothscat";
	}
  // To show the list of cloths
	@GetMapping("/listofcloth")
	public String showListofCloths(Model map,HttpServletRequest request) {
		LOG.info("AdminController  :: showListofCloths :: Start : ");
		HttpSession session = request.getSession();
		if(null!=session && null==session.getAttribute("user_dtls"))
		{
			LOG.info("AdminController  :: showListofCloths :: session is null ");
			map.addAttribute("error","User session has been expired,Login again !!");
			return "/user/login";
		}
		try {
		map.addAttribute("cloths_list", dao.listClothsCategory());
		}catch (Exception exept) {
			LOG.error("AdminController  :: showListofCloths :: Exception while calling showListofCloths  : "
					+ exept.getMessage());
			map.addAttribute("mesg", "Exception while processing list of cloths request!!");
		}
		LOG.info("AdminController  :: showListofCloths :: end : ");
		return "/admin/listofcloth";
	}
    // To show the list of wash
	@GetMapping("/listofwash")
	public String showListofWash(Model map,HttpServletRequest request) {
		LOG.info("AdminController  :: showListofWash :: Start : ");
		HttpSession session = request.getSession();
		if(null!=session && null==session.getAttribute("user_dtls"))
		{
			LOG.info("AdminController  :: showListofWash :: session is null ");
			map.addAttribute("error","User session has been expired,Login again !!");
			return "/user/login";
		}
		try {
		List<TypeOfWash> array = new ArrayList<TypeOfWash>();
		array = dao.listTypeOfWash();
		map.addAttribute("wash_list", array);
		}catch (Exception exept) {
			LOG.error("AdminController  :: showListofCloths :: Exception while calling showListofWash  : "
					+ exept.getMessage());
			map.addAttribute("mesg", "Exception while processing list of wash request!!");
		}
		LOG.info("AdminController  :: showListofWash :: end : ");
		return "/admin/listofwash";
	}
   // To delete the cloths base of of cloth id
	@GetMapping("/deletecloths")
	public String deleteCloths(@RequestParam int cloth_id, RedirectAttributes flashMap,HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(null!=session && null==session.getAttribute("user_dtls"))
		{
			LOG.info("AdminController  :: deleteCloths :: session is null ");
			flashMap.addAttribute("error","User session has been expired,Login again !!");
			return "/user/login";
		}
		LOG.info("AdminController  :: deleteCloths :: Start : ");
		LOG.info("AdminController  :: deleteCloths :: in Delete cloths category :" + cloth_id);
		try {
		String result = dao.deleteCloths(cloth_id);
		LOG.info("Cloth id is deleted :: " + result);
		}catch (Exception exept) {
			LOG.error("AdminController  :: deleteCloths :: Exception while calling deleteCloths  : "
					+ exept.getMessage());
			flashMap.addAttribute("mesg", "Exception while processing delete cloths request!!");
		}
		LOG.info("AdminController  :: deleteCloths :: end : ");
		return "redirect:/admin/listofcloth";

	}
   // Update the cloth request base of cloth id
	@GetMapping("/updatecloths")
	public String updateCloths(@RequestParam int cloth_id, RedirectAttributes flashMap, Model map,HttpServletRequest request) {
		LOG.info("AdminController  :: updateCloths :: Start : ");
		HttpSession session = request.getSession();
		if(null!=session && null==session.getAttribute("user_dtls"))
		{
			LOG.info("AdminController  :: updateCloths :: session is null ");
			flashMap.addAttribute("error","User session has been expired,Login again !!");
			return "/user/login";
		}
		LOG.info("In Update cloths category" + cloth_id);
		try {
		ClothsCategory clothCatg = dao.getClothsCategory(cloth_id);
		map.addAttribute("cloth_id", clothCatg.getCloth_id());
		map.addAttribute("cloth_type", clothCatg.getCloth_type());
		map.addAttribute("gender", clothCatg.getGender());
		map.addAttribute(clothCatg);
		}catch (Exception exept) {
			LOG.error("AdminController  :: updateCloths :: Exception while calling updateCloths  : "
					+ exept.getMessage());
			flashMap.addAttribute("mesg", "Exception while processing updateCloths cloths request!!");
		}
		LOG.info("AdminController  :: updateCloths :: end : ");
		return "/admin/clothscat";

	}
    // To delete the respective wash request base on tid
	@GetMapping("/deleteWash")
	public String deleteWash(@RequestParam int tid, RedirectAttributes flashMap,HttpServletRequest request) {
		LOG.info("AdminController  :: deleteWash :: Start : ");
		HttpSession session = request.getSession();
		if(null!=session && null==session.getAttribute("user_dtls"))
		{
			LOG.info("AdminController  :: deleteWash :: session is null ");
			flashMap.addAttribute("error","User session has been expired,Login again !!");
			return "/user/login";
		}
		LOG.info("In Delete Wash category" + tid);
		try {
		String result = dao.deleteWash(tid);
		LOG.info("Wash id is deleted :: " + result);
		}catch (Exception exept) {
			LOG.error("AdminController  :: deleteWash :: Exception while calling deleteWash  : "
					+ exept.getMessage());
			flashMap.addAttribute("mesg", "Exception while processing deleteWash wash request!!");
		}
		LOG.info("AdminController  :: deleteWash :: end : ");
		return "redirect:/admin/listofwash";

	}

	@GetMapping("/updateWash")
	public String updateWash(@RequestParam int tid, RedirectAttributes flashMap, Model map,HttpServletRequest request) {
		LOG.info("AdminController  :: updateWash :: Start : ");
		HttpSession session = request.getSession();
		if(null!=session && null==session.getAttribute("user_dtls"))
		{
			LOG.info("AdminController  :: updateWash :: session is null ");
			flashMap.addAttribute("error","User session has been expired,Login again !!");
			return "/user/login";
		}
		LOG.info("In Update Wash" + tid);
		try {
		TypeOfWash typeOfWash = dao.getWashRecord(tid);
		map.addAttribute("tid", typeOfWash.getTid());
		map.addAttribute("type_of_wash", typeOfWash.getType_of_wash());
		map.addAttribute("rate", typeOfWash.getRate());
		map.addAttribute(typeOfWash);
		}catch (Exception exept) {
			LOG.error("AdminController  :: updateWash :: Exception while calling updateWash  : "
					+ exept.getMessage());
			flashMap.addAttribute("mesg", "Exception while processing updateWash wash request!!");
		}
		LOG.info("AdminController  :: updateWash :: end : ");
		return "/admin/typewash";

	}
}