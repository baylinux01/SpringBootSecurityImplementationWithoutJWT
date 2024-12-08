package baylinux01.webApiDeneme3.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import baylinux01.webApiDeneme3.entities.AppUser;
import baylinux01.webApiDeneme3.services.AppUserService;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
@RequestMapping("/appUser")
public class AppUserController {
	
	AppUserService appUserService;

	@Autowired
	public AppUserController(AppUserService appUserService) {
		super();
		this.appUserService = appUserService;
	}
	
	@GetMapping("/getAppUserByUsername")
	public AppUser getAppUserByUsername(String username)
	{
		return appUserService.getAppUserByUsername(username);
	}
	
	@GetMapping("/getAppUserById")
	public AppUser getAppUserById(long id)
	{
		return appUserService.getAppUserById(id);
	}
	
	@GetMapping("/getAllAppUsers")
	public List<AppUser> getAllAppUsers()
	{
		return appUserService.getAllAppUsers();
	}
	@PostMapping("/createAppUser")
	public String createAppUser(HttpServletRequest req, String username,String password)
	{
//		String username=req.getParameter("username");
//		String password=req.getParameter("password");
		return appUserService.createAppUser(username,password);
		
	}
	
	@PostMapping("/login")
	public AppUser login(@RequestParam("username") String username
			,@RequestParam("password") String password) 
					throws NoSuchAlgorithmException
	{
		return appUserService.login(username,password);
	}
	
	@PutMapping("/updateAppUserPassword")
	public String updateAppUserPassword( HttpServletRequest request
			,@RequestParam("newPassword") String newPassword)
	{
		return appUserService.updateAppUserPassword(request,newPassword);
	}
	@PutMapping("/updateAppUserUsername")
	public String updateAppUserUsername( HttpServletRequest request
			,@RequestParam("newUsername") String newUsername)
	{
		return appUserService.updateAppUserUsername(request,newUsername);
	}
	
	
	
	
	
	

}
