package com.hp.main.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hp.main.model.JobPlatform;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model, HttpSession session) {

        // 🔐 Get logged user from session
        Object loggedUser = session.getAttribute("loggedUser");

        // ❗ If user not logged in → redirect to login
        if (loggedUser == null) {
            return "redirect:/login";
        }

        // ✅ Send user to HTML
        model.addAttribute("loggedUser", loggedUser);

        // ✅ Job list with icon field
        List<JobPlatform> jobs = List.of(
                new JobPlatform(
                        "LinkedIn Jobs",
                        "Best platform for networking, referrals and fresher jobs",
                        "https://www.linkedin.com/jobs",
                        "fa-brands fa-linkedin"
                ),
                new JobPlatform(
                        "Naukri.com",
                        "India’s largest job portal with maximum recruiters",
                        "https://www.naukri.com",
                        "fa-solid fa-briefcase"
                ),
                new JobPlatform(
                        "Indeed",
                        "Simple and fast job search with easy apply option",
                        "https://www.indeed.com",
                        "fa-solid fa-magnifying-glass"
                ),
                new JobPlatform(
                        "Internshala",
                        "Best platform for internships and entry-level fresher jobs",
                        "https://internshala.com",
                        "fa-solid fa-user-graduate"
                ),
                new JobPlatform(
                        "Wellfound",
                        "Startup jobs for developers and freshers",
                        "https://wellfound.com",
                        "fa-solid fa-rocket"
                ),
                new JobPlatform(
                        "Freshersworld",
                        "Dedicated job portal specially made for fresh graduates",
                        "https://www.freshersworld.com",
                        "fa-solid fa-users"
                ),
                new JobPlatform(
                        "Foundit",
                        "Jobs and career opportunities for freshers and experienced",
                        "https://www.foundit.in",
                        "fa-solid fa-briefcase"
                )
        );

        model.addAttribute("jobs", jobs);

        return "home";
    }
}
