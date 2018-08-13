package com.kortov.springsecurity.controller;

import com.kortov.springsecurity.user.CrmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    @Autowired
    private UserDetailsManager userDetailsManager;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/showRegistrationForm")
    public String showMyLoginPage(Model theModel) {
        theModel.addAttribute("crmUser", new CrmUser());
        return "registration-form";
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(
            @Valid @ModelAttribute("crmUser") CrmUser theCrmUser,
            BindingResult theBindingResult,
            Model theModel) {

        if (theBindingResult.hasErrors()) {
            theModel.addAttribute("crmUser", new CrmUser());
            theModel.addAttribute("registrationError",
                    "User name/password can not be empty.");
            return "registration-form";
        }

        String encodedPassword = passwordEncoder.encode(theCrmUser.getPassword());
        encodedPassword = "{bcrypt}" + encodedPassword;
        List<GrantedAuthority> authorities =
                AuthorityUtils.createAuthorityList("ROLE_EMPLOYEE");
        User tempUser = new User(theCrmUser.getUserName(), encodedPassword, authorities);
        userDetailsManager.createUser(tempUser);
        return "registration-confirmation";
    }

    private boolean doesUserExist(String userName) {
        boolean exists = userDetailsManager.userExists(userName);
        return exists;
    }
}