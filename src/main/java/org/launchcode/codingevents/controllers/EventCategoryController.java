package org.launchcode.codingevents.controllers;


import org.launchcode.codingevents.data.EventRepository;
import org.launchcode.codingevents.models.Event;
import org.launchcode.codingevents.models.EventType;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("eventCategories")
public class EventCategoryController {

    private EventRepository eventCategoryRepository;

    @GetMapping
    public String displayAllEvents (Model model){
        model.addAttribute("title","All Categories");
        model.addAttribute("categories", eventCategoryRepository.findAll());
        return "eventCategories/index";
    }

    @GetMapping("create")
    public String renderCreateEventCategoryForm (@ModelAttribute  Model model, Event newEvent){
        model.addAttribute("title","Create Category");
        eventCategoryRepository.save(newEvent);
//        model.addAttribute("types", EventType.values());
        return "eventCategories/create";
    }

    @PostMapping("create")
    public String processCreateEventCategoryForm (@ModelAttribute @Valid Event newEvent,
                                                  Errors errors, Model model){
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Event");
            return "events/create";
        }
        eventCategoryRepository.save(newEvent);
        return "redirect:";
    }
}
