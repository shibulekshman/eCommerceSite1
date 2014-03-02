package com.pets.dog.web.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import com.pets.dog.constant.MVCNavigationConstant;
import com.pets.dog.constant.PetDogsApplicationConstant;
import com.pets.dog.service.DogServiceImpl;
import com.pets.dog.util.AdminLoggedIn;
import com.pets.dog.util.Checkout;
import com.pets.dog.util.DogFormComparatorAscendingEmail;
import com.pets.dog.util.DogFormComparatorDescendingEmail;
import com.pets.dog.util.ShoppingCart;
import com.pets.dog.util.UserLoggedIn;
import com.pets.dog.web.model.ContactUsForm;
import com.pets.dog.web.model.DogForm;
import com.pets.dog.web.model.UploadFile;
import com.pets.dog.web.model.UserForm;
import com.pets.dog.web.model.wrapper.DogFormWrapper;
import com.pets.dog.util.PasswordUtil;

/**
 * @author nagendra.yadav
 */
@Controller
@Scope("request")
public class DogController {

	/**
	 * Initiate Logger for this class
	 */
	private static final Log logger = LogFactory.getLog(DogController.class);

	@Autowired
	@Qualifier("DogServiceImpl")
	private DogServiceImpl dogService;
	
	@RequestMapping(value = "startCheckout.htm", method = RequestMethod.POST)
	public String processCheckout(Model model, HttpServletRequest request) {
		
		HttpSession session=request.getSession(true);
		//System.out.println("checkout success");
		
		Checkout checkout=new Checkout();
		checkout.setEmail(request.getParameter("email"));
		System.out.println(request.getParameter("email"));
		Checkout prevCheckout=(Checkout)session.getAttribute("checkout");
		if(prevCheckout!=null){
			session.removeAttribute("checkout");
		}
		session.setAttribute("checkout", checkout);
		
		return "shippingAddress";

	}
	
	@RequestMapping(value = "shipping.htm", method = RequestMethod.POST)
	public String shipping(Model model, HttpServletRequest request) {
		
		HttpSession session=request.getSession(true);
		//System.out.println("checkout success");
		Checkout prevCheckout=(Checkout)session.getAttribute("checkout");
		if(prevCheckout!=null){
			prevCheckout.setFullName(request.getParameter("name"));
			prevCheckout.setAddress1(request.getParameter("addr1"));
			prevCheckout.setAddress2(request.getParameter("addr2"));
			prevCheckout.setCity(request.getParameter("city"));
			prevCheckout.setState(request.getParameter("state"));
			prevCheckout.setZip(request.getParameter("zip"));
			prevCheckout.setCountry(request.getParameter("country"));
			prevCheckout.setMobNumber(request.getParameter("mobileNumber"));

		}
		
		session.setAttribute("checkout", prevCheckout);
		
		return "orderSummary";

	}

	
	@RequestMapping(value = "logOutUser.htm", method = RequestMethod.GET)
	public String userLogout(Model model, HttpServletRequest request) {

		HttpSession session = request.getSession(true);
		UserLoggedIn userLoggedIn = (UserLoggedIn) session
				.getAttribute("userLoggedIn");
		if (userLoggedIn != null) {
			session.removeAttribute("userLoggedIn");
		}

		return "redirect:/home.htm";

	}

	@RequestMapping(value = "adminLogout.htm", method = RequestMethod.GET)
	public String adminLogout(Model model, HttpServletRequest request) {

		HttpSession session = request.getSession(true);
		AdminLoggedIn adminLoggedIn = (AdminLoggedIn) session
				.getAttribute("adminLoggedIn");
		if (adminLoggedIn != null) {
			session.removeAttribute("adminLoggedIn");
		}

		return "redirect:/home.htm";

	}

	@RequestMapping(value = "accessAsAdmin.htm", method = RequestMethod.GET)
	public String accessAsAdmin(Model model, HttpServletRequest request) {

		return MVCNavigationConstant.ACCESS_AS_ADMIN;

	}

	@RequestMapping(value = "accessAsAdminLoggedIn.htm", method = RequestMethod.POST)
	public String accessAsAdminLoggedIn(HttpServletRequest request,
			HttpServletResponse response, Model model) {

		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		boolean doesPasswordMatch = false;

		try {
			doesPasswordMatch = PasswordUtil.check(password,
					dogService.getAdministratorPassword(userName));
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (doesPasswordMatch) {
			// To do add the admin to the session!
			HttpSession session = request.getSession(true);
			AdminLoggedIn adminLoggedIn = (AdminLoggedIn) session
					.getAttribute("adminLoggedIn");
			if (adminLoggedIn == null) {
				adminLoggedIn = new AdminLoggedIn();
				adminLoggedIn.setAdminName(userName);
				session.setAttribute("adminLoggedIn", adminLoggedIn);
			}

			return MVCNavigationConstant.ACCESS_AS_ADMIN_LOGGED_IN;
		}

		return MVCNavigationConstant.ACCESS_AS_ADMIN;

	}

	@RequestMapping(value = "login.htm", method = RequestMethod.POST)
	public String loginUser(HttpServletRequest request,
			HttpServletResponse response) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		boolean doesPasswordMatch = false;
		String savedPassword = null;
		UserForm user = null;
		
		try{
			user = dogService.getUser(email);
			logger.debug(user.getPassword());
			savedPassword = user.getPassword();
		}catch(Exception e) {
			logger.error("Error accssesing the userdetails" + e);
			return "redirect:/home.htm";
		}
		
		
		try {
			doesPasswordMatch = PasswordUtil.check(password, savedPassword);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/home.htm";
		}
		
		if(doesPasswordMatch) {
			// To do add the admin to the session!
			HttpSession session = request.getSession(true);
			UserLoggedIn userLoggedIn = (UserLoggedIn) session
					.getAttribute("userLoggedIn");
			if (userLoggedIn == null) {
				userLoggedIn = new UserLoggedIn();
				userLoggedIn.setEmail(email);
				userLoggedIn.setFirstName(user.getFirstName());
				session.setAttribute("userLoggedIn", userLoggedIn);
			}
		}

		return "redirect:/shoppingPage.htm";
	}

	@RequestMapping(value = "deleteFromCart", method = RequestMethod.GET)
	public String deleteFromCart(Model model, HttpServletRequest request) {
		List<DogForm> dogsInCart = new ArrayList<DogForm>();

		// Getting dogs from the session and send it into the Model
		HttpSession session = request.getSession(true);
		ShoppingCart previousItems = (ShoppingCart) session
				.getAttribute("previousItems");
		Integer dogIdToDelete = Integer.parseInt(request.getParameter("did"));
		if (previousItems.deleteEntry(dogIdToDelete)) {
			session.setAttribute("previousItems", previousItems);
		}
		if (previousItems != null) {
			List<Integer> dogIdsInSession = previousItems
					.getShoppingCartItems();
			for (Integer item : dogIdsInSession) {
				DogForm tempDogForm = dogService.findDogById(item);
				if (tempDogForm != null) {
					dogsInCart.add(dogService.findDogById(item));// issue1: This
																	// could
																	// cause
																	// problems,
																	// What if
																	// the dog
																	// is
																	// already
																	// bought by
																	// someone
																	// else???
					// Tried to fix the earlier issue1 by adding a check for
					// nullness. This means the dog will not be added if the dog
					// is missing from the database.
				}
			}
			model.addAttribute("dogsInCart", dogsInCart);
		}

		return MVCNavigationConstant.SHOPPING_CART;
	}

	@RequestMapping(value = "shoppingCart", method = RequestMethod.GET)
	public String setShoppingCart(Model model, HttpServletRequest request) {
		List<DogForm> dogsInCart = new ArrayList<DogForm>();

		// Getting dogs from the session and send it into the Model
		HttpSession session = request.getSession(true);
		ShoppingCart previousItems = (ShoppingCart) session
				.getAttribute("previousItems");
		if (previousItems != null) {
			List<Integer> dogIdsInSession = previousItems
					.getShoppingCartItems();
			for (Integer item : dogIdsInSession) {
				DogForm tempDogForm = dogService.findDogById(item);
				if (tempDogForm != null) {
					dogsInCart.add(dogService.findDogById(item));// issue1: This
																	// could
																	// cause
																	// problems,
																	// What if
																	// the dog
																	// is
																	// already
																	// bought by
																	// someone
																	// else???
					// Tried to fix the earlier issue1 by adding a check for
					// nullness. This means the dog will not be added if the dog
					// is missing from the database.
				}
			}
			model.addAttribute("dogsInCart", dogsInCart);
		}

		return MVCNavigationConstant.SHOPPING_CART;
	}

	@RequestMapping(value = "jaddToCart", method = RequestMethod.POST)
	public @ResponseBody
	String jaddToCart(@RequestParam(value = "dogId") Integer dogId,
			HttpServletRequest request) {

		// To do add the dog to the shopping cart!
		HttpSession session = request.getSession(true);
		ShoppingCart previousItems = (ShoppingCart) session
				.getAttribute("previousItems");
		if (previousItems == null) {
			previousItems = new ShoppingCart();
		}

		if (!previousItems.checkIdPresent(dogId)) {
			previousItems.addshoppingCartItem(dogId);
			session.setAttribute("previousItems", previousItems);
		} else {
			return "The dog is already in your cart.";
		}

		return "Dog added to your cart.";
	}

	@RequestMapping(value = "jshoppingPage", method = RequestMethod.GET)
	public @ResponseBody
	String jgotToShoppingPage(
			@RequestParam(value = "indexNo", required = false) Integer pageIndex) {
		if (pageIndex == null) {
			if (logger.isWarnEnabled()) {
				logger.warn("pageIndex is null");
			}
			pageIndex = 1;
		}
		// System.out.println("InGet");
		if (logger.isDebugEnabled()) {
			logger.debug("gogogogogogogogogogogogo");
		}
		DogFormWrapper dogFormWrapper = dogService
				.findDogsByPageNumber(pageIndex);
		List<DogForm> dogForms = dogFormWrapper.getDogForms();
		StringBuilder builder = new StringBuilder();
		builder.append(dogForms.size() + ",");
		for (DogForm dogForm : dogForms) {
			builder.append(dogForm.getDid() + ",");
			builder.append(dogForm.getTitle() + ",");
			builder.append(dogForm.getPrice() + ",");
			builder.append(dogForm.getDescription() + ",");
		}
		String string = builder.substring(0, builder.length() - 1);
		return string;
	}

	@RequestMapping(value = "shoppingPage", method = RequestMethod.GET)
	public String gotToShoppingPage(
			@RequestParam(value = "indexNo", required = false) Integer pageIndex,
			Model model) {
		if (pageIndex == null) {
			if (logger.isWarnEnabled()) {
				logger.warn("pageIndex is null");
			}
			pageIndex = 1;
		}
		DogFormWrapper dogFormWrapper = dogService
				.findDogsByPageNumber(pageIndex);
		int totalCount = dogFormWrapper.getTotalCount();
		int totalNumberOfPages = 0;
		if (totalCount % 3 == 0) {
			totalNumberOfPages = totalCount / 3;
		} else {
			totalNumberOfPages = (totalCount / 3)
					+ PetDogsApplicationConstant.ONE;
		}
		System.out.println(totalNumberOfPages);
		model.addAttribute("totalNumberOfPages", totalNumberOfPages);
		model.addAttribute("dogs", dogFormWrapper.getDogForms());
		return MVCNavigationConstant.SHOPPING_PAGE;
	}

	// @RequestMapping(value = "getNoticeBoard", method = RequestMethod.POST)
	private String getNoticeBoard(HttpServletRequest request) {
		ServletContext context = request.getSession().getServletContext();
		String everything = "";
		java.io.InputStream inStream = context
				.getResourceAsStream(PetDogsApplicationConstant.ADMIN_NOTICE_BOARD_FILE);
		// File file = new File("textFiles/notice.txt");
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(inStream));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append('\n');
				line = br.readLine();
			}
			everything = sb.toString();
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return everything;
	}

	@RequestMapping(value = "setNoticeBoard", method = RequestMethod.GET)
	public String setNoticeBoard(Model model) {
		System.out.println("InGet");
		return MVCNavigationConstant.DOG_HOME;
	}

	@RequestMapping(value = "contactUs", method = RequestMethod.GET)
	public String contactUs(Model model) {
		ContactUsForm contactUsForm = new ContactUsForm();
		model.addAttribute("contactUsForm", contactUsForm);
		return MVCNavigationConstant.CONTACT_US;
	}

	@RequestMapping(value = "contactUs", method = RequestMethod.POST)
	public String contactUs(
			@ModelAttribute("contactUsForm") ContactUsForm contactUsForm) {
		dogService.addContactUsDetails(contactUsForm);
		return MVCNavigationConstant.THANK_YOU;
	}

	@RequestMapping(value = "signUp", method = RequestMethod.GET)
	public String signUpRegister(Model model) {
		UserForm userForm = new UserForm();
		model.addAttribute("userForm", userForm);
		return MVCNavigationConstant.SIGN_UP;
	}

	@RequestMapping(value = "signUp", method = RequestMethod.POST)
	public String signUpRegister(@ModelAttribute("userForm") UserForm userForm) {

		try {
			userForm.setPassword(PasswordUtil.getSaltedHash(userForm
					.getPassword()));
			dogService.saveUser(userForm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// redirecting the request to home page by send redirect
		// here we cannot call jsp page directly since we have to show some data
		// from
		// database when this page is loaded
		return "redirect:/home.htm";
	}

	@RequestMapping(value = "sortAscending", method = RequestMethod.GET)
	public String sortAscending(Model model) {
		// Performing the ascending sorting and displaying the dogs
		List<DogForm> dogForms = dogService.findDogs();
		Collections.sort(dogForms, new DogFormComparatorAscendingEmail());
		model.addAttribute("dogs", dogForms);
		return MVCNavigationConstant.ALL_DOGS;
	}

	@RequestMapping(value = "sortDescending", method = RequestMethod.GET)
	public String sortDescending(Model model) {
		// Performing the descending sorting and displaying the dogs
		List<DogForm> dogForms = dogService.findDogs();
		Collections.sort(dogForms, new DogFormComparatorDescendingEmail());
		model.addAttribute("dogs", dogForms);
		return MVCNavigationConstant.ALL_DOGS;
	}

	@RequestMapping(value = "miniEditDogByDid.htm", method = RequestMethod.GET)
	public String miniEditRecord(HttpServletRequest request,
			HttpServletResponse response) {
		String did = request.getParameter("did");
		int didInt = Integer.parseInt(did);
		// System.out.println("In edit! and the id is: " + did);
		DogForm dogForm = dogService.findDogById(didInt);
		request.setAttribute("dog", dogForm);
		return MVCNavigationConstant.MINI_EDITOR;
	}

	@RequestMapping(value = "editDogByDid.htm", method = RequestMethod.GET)
	public String editRecord(HttpServletRequest request,
			HttpServletResponse response) {
		String did = request.getParameter("did");
		int didInt = Integer.parseInt(did);
		// System.out.println("In edit! and the id is: " + did);
		DogForm dogForm = dogService.findDogById(didInt);
		request.setAttribute("dog", dogForm);
		return MVCNavigationConstant.EDIT_DOG;
	}

	/*
	 * @RequestMapping(value = "nextImage.htm", method = RequestMethod.GET)
	 * public String nextImages(Model model,HttpServletRequest request) { String
	 * cni=request.getParameter("cni"); DogFormWrapper dogFormWrapper=
	 * dogService.findCarouselDogs(cni,"nextImage");
	 * model.addAttribute("dogsInCarousel", dogFormWrapper.getDogForms());
	 * List<DogForm> dogForms = dogService.findLatestDogNews(); String
	 * noticeBoardMsg=getNoticeBoard(request); model.addAttribute("dogs",
	 * dogForms); model.addAttribute("noticeBoardMsg", noticeBoardMsg);
	 * if(dogFormWrapper.isIndexChanged()) {
	 * model.addAttribute("cni",Integer.parseInt(cni)+1 );
	 * model.addAttribute("cpi",Integer.parseInt(cni)-3); }else{
	 * model.addAttribute("cni",Integer.parseInt(cni) );
	 * model.addAttribute("cpi",Integer.parseInt(cni)-4); } return
	 * MVCNavigationConstant.DOG_HOME; }
	 */

	/*
	 * @RequestMapping(value = "preImage.htm", method = RequestMethod.GET)
	 * public String preImage(Model model,HttpServletRequest request) {
	 * //cpi=1,2,3,4,5 //=01234 String cpi=request.getParameter("cpi");
	 * DogFormWrapper dogFormWrapper=
	 * dogService.findCarouselDogs(cpi,"preImage");
	 * model.addAttribute("dogsInCarousel", dogFormWrapper.getDogForms());
	 * List<DogForm> dogForms = dogService.findLatestDogNews(); String
	 * noticeBoardMsg=getNoticeBoard(request); model.addAttribute("dogs",
	 * dogForms); model.addAttribute("noticeBoardMsg", noticeBoardMsg);
	 * if(dogFormWrapper.isIndexChanged()) {
	 * model.addAttribute("cni",Integer.parseInt(cpi)+3);
	 * model.addAttribute("cpi",Integer.parseInt(cpi)-1); } else{
	 * model.addAttribute("cni",Integer.parseInt(cpi)+4 );
	 * model.addAttribute("cpi",Integer.parseInt(cpi)); } return
	 * MVCNavigationConstant.DOG_HOME; }
	 */

	@RequestMapping(value = "jnextImage.htm", method = RequestMethod.GET)
	public @ResponseBody
	String jnextImage(Model model, HttpServletRequest request) {
		// cpi=1,2,3,4,5
		// =01234
		String cni = request.getParameter("cni");
		DogFormWrapper dogFormWrapper = dogService.findCarouselDogs(cni,
				"nextImage");
		if (!dogFormWrapper.isIndexChanged()) {
			return "nc";
		}
		DogForm dogForm = null;
		if (dogFormWrapper.getDogForms().size() == 5) {
			dogForm = dogFormWrapper.getDogForms().get(4);
		}
		int did = dogForm != null ? dogForm.getDid() : 0;
		return did + "";
	}

	@RequestMapping(value = "jpreImage.htm", method = RequestMethod.GET)
	public @ResponseBody
	String jpreImage(Model model, HttpServletRequest request) {
		// cpi=1,2,3,4,5
		// =01234
		String cpi = request.getParameter("cpi");
		DogFormWrapper dogFormWrapper = dogService.findCarouselDogs(cpi,
				"preImage");
		if (!dogFormWrapper.isIndexChanged()) {
			return "nc";
		}
		DogForm dogForm = null;
		if (dogFormWrapper.getDogForms().size() == 5) {
			dogForm = dogFormWrapper.getDogForms().get(0);
		}
		int did = dogForm != null ? dogForm.getDid() : 0;
		return did + "";
	}

	// when it;s loaded first time
	@RequestMapping(value = "home.htm", method = RequestMethod.GET)
	public String dogHome(Model model, HttpServletRequest request) {
		DogFormWrapper dogFormWrapper = dogService.findCarouselDogs("0",
				"firstTime");
		model.addAttribute("dogsInCarousel", dogFormWrapper.getDogForms());
		List<DogForm> dogForms = dogService.findLatestDogNews();
		String noticeBoardMsg = getNoticeBoard(request);
		noticeBoardMsg = noticeBoardMsg.trim();
		model.addAttribute("dogs", dogForms);
		model.addAttribute("noticeBoardMsg", noticeBoardMsg);
		model.addAttribute("cni", 4);
		model.addAttribute("cpi", 0);
		return MVCNavigationConstant.DOG_HOME;
	}

	@RequestMapping(value = "uploadDog", method = RequestMethod.GET)
	public String uploadDog(Model model) {
		// creating an object of DogForm and adding into them into the model
		// object
		DogForm dogForm = new DogForm();
		model.addAttribute("dogForm", dogForm);
		return MVCNavigationConstant.ADD_DOG;
	}

	@RequestMapping(value = "uploadDog", method = RequestMethod.POST)
	public String uploadDog(@ModelAttribute("dogForm") DogForm dogForm) {
		dogService.addDog(dogForm);
		return MVCNavigationConstant.MANAGE_DOG;
	}

	@RequestMapping(value = "dogs", method = RequestMethod.GET)
	public String dogs(Model model) {
		List<DogForm> dogForms = dogService.findDogs();
		model.addAttribute("dogs", dogForms);
		return MVCNavigationConstant.ALL_DOGS;
	}

	@RequestMapping(value = "deleteDogByDid.htm", method = RequestMethod.GET)
	public String deleteDog(HttpServletRequest request) {
		String did = request.getParameter("did");
		dogService.deleteDogByDid(Integer.parseInt(did));
		return "redirect:/dogs.htm";
	}

	@RequestMapping(value = "loadImageBydid.htm", method = RequestMethod.GET)
	public void loadImageById(HttpServletRequest request,
			HttpServletResponse response) {
		String did = request.getParameter("did");
		byte[] byteArray = dogService.findDogImageByDid(Integer.parseInt(did));
		response.setContentType("image/jpeg");
		try {
			ServletOutputStream out = response.getOutputStream();
			if (byteArray != null)
				out.write(byteArray);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "fileUploadTest", method = RequestMethod.POST)
	public String uploadDog(@ModelAttribute("uploadFile") UploadFile uploadFile) {
		if(dogService.addFile(uploadFile)) {
			return MVCNavigationConstant.THANK_YOU;
		}
		return MVCNavigationConstant.CONTACT_US;
	}


	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// to actually be able to convert Multipart instance to byte[]
		// we have to register a custom editor
		binder.registerCustomEditor(byte[].class,
				new ByteArrayMultipartFileEditor());
		// now Spring knows how to handle multipart object and convert them
	}

}
