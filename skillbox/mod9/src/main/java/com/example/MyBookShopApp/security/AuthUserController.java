package com.example.MyBookShopApp.security;

import com.example.MyBookShopApp.data.service.TokenBlacklistService;
import com.example.MyBookShopApp.errs.NoUserFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class AuthUserController {

    private final BookstoreUserRegister userRegister;
    private final BookstoreUserRepository bookstoreUserRepository;
    private final TokenBlacklistService tokenBlacklistService;

    @Autowired
    public AuthUserController(BookstoreUserRegister userRegister,BookstoreUserRepository bookstoreUserRepository, TokenBlacklistService tokenBlacklistService) {
        this.userRegister = userRegister;
        this.bookstoreUserRepository = bookstoreUserRepository;
        this.tokenBlacklistService = tokenBlacklistService;
    }

    @GetMapping("/signin")
    public String handleSignin() {
        if(userRegister.jwtToken != ""){
            tokenBlacklistService.addToBlacklist(userRegister.jwtToken);
        }
        return "signin";
    }

    @GetMapping("/signup")
    public String handleSignUp(Model model) {
        model.addAttribute("regForm", new RegistrationForm());
        return "signup";
    }

    @PostMapping("/requestContactConfirmation")
    @ResponseBody
    public ContactConfirmationResponse handleRequestContactConfirmation(@RequestBody ContactConfirmationPayload contactConfirmationPayload) throws NoUserFoundException {
        ContactConfirmationResponse response = new ContactConfirmationResponse();
        response.setResult("true");
        return response;
    }

    @PostMapping("/approveContact")
    @ResponseBody
    public ContactConfirmationResponse handleApproveContact(@RequestBody ContactConfirmationPayload payload) {
        ContactConfirmationResponse response = new ContactConfirmationResponse();
        response.setResult("true");
        return response;
    }

    @PostMapping("/reg")
    public String handleUserRegistration(RegistrationForm registrationForm, Model model) {
        userRegister.registerNewUser(registrationForm);
        model.addAttribute("regOk", true);
        return "signin";
    }

    @PostMapping("/login")
    @ResponseBody
    public ContactConfirmationResponse handleLogin(@RequestBody ContactConfirmationPayload payload,
                                                   HttpServletResponse httpServletResponse,
                                                   Model model) throws NoUserFoundException{
        if(payload.getContact().contains("@")){
            BookstoreUser bookstoreUser = bookstoreUserRepository.findBookstoreUserByEmail(payload.getContact());
            if(bookstoreUser != null){
                ContactConfirmationResponse loginResponse = userRegister.jwtLogin(payload);
                if(!tokenBlacklistService.isBlacklisted(loginResponse.getResult())){
                    String userToken = loginResponse.getResult();
                    Cookie cookie = new Cookie("token", userToken);
                    httpServletResponse.addCookie(cookie);
                    model.addAttribute("userToken", userToken);
                    return loginResponse;
                } else{
                    throw new NoUserFoundException("JWT токен истёк.");
                }
            }
            else{
                throw new NoUserFoundException("Пользователя с такими данными не существует1.");
            }
        }
        else if(payload.getContact().contains("+")){
            BookstoreUser bookstoreUser = bookstoreUserRepository.findBookstoreUserByPhone(payload.getContact());
            if(bookstoreUser != null){
                ContactConfirmationResponse response = new ContactConfirmationResponse();
                response.setResult("true");
                return response;
            }
            else{
                throw new NoUserFoundException("Пользователя с такими данными не существует2.");
            }
        } else{
            throw new NoUserFoundException("Пользователя с такими данными не существует3.");
        }
    }

    @GetMapping("/my")
    public String handleMy() {
        return "my";
    }

    @GetMapping("/profile")
    public String handleProfile(Model model, Principal principal) {
        if(principal instanceof UsernamePasswordAuthenticationToken) {
            UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) principal;
            BookstoreUserDetails userDetails = (BookstoreUserDetails) authenticationToken.getPrincipal();
            BookstoreUser user = userDetails.getBookstoreUser();
            String name = user.getName();
            String email = user.getEmail();
            String phone = user.getPhone();
            model.addAttribute("name", name);
            model.addAttribute("email", email);
            model.addAttribute("phone", phone);
        }
        return "profile";
    }

    @GetMapping("/logout")
    public String handleLogout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        SecurityContextHolder.clearContext();
        if (session != null) {
            session.invalidate();
        }

        for (Cookie cookie : request.getCookies()) {
            cookie.setMaxAge(0);
        }

        return "redirect:/";
    }
}
