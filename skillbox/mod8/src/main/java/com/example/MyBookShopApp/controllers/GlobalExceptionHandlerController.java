package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.errs.EmptySearchException;
<<<<<<< HEAD
=======
import com.example.MyBookShopApp.errs.NoUserFoundException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
>>>>>>> test
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.logging.Logger;

@ControllerAdvice
public class GlobalExceptionHandlerController {

    @ExceptionHandler(EmptySearchException.class)
    public String handleEmptySearchException(EmptySearchException e, RedirectAttributes redirectAttributes){
        Logger.getLogger(this.getClass().getSimpleName()).warning(e.getLocalizedMessage());
        redirectAttributes.addFlashAttribute("searchError",e);
        return "redirect:/";
    }
<<<<<<< HEAD
=======

    @ExceptionHandler(NoUserFoundException.class)
    public String handleNoUserFoundException(NoUserFoundException e, RedirectAttributes redirectAttributes){
        Logger.getLogger(this.getClass().getSimpleName()).warning(e.getLocalizedMessage());
        redirectAttributes.addFlashAttribute("userFoundError",e);
        return "redirect:/signin";
    }
>>>>>>> test
}
