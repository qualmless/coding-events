package org.launchcode.codingevents.controllers;

<<<<<<< Updated upstream
import org.launchcode.codingevents.data.EventData;
=======
>>>>>>> Stashed changes
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping("events")
public class EventController {

<<<<<<< Updated upstream
=======
    private static List<Event> events = new ArrayList<>();

>>>>>>> Stashed changes
    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Events");
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }

    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        return "events/create";
    }

    @PostMapping("create")
<<<<<<< Updated upstream
    public String processCreateEventForm(@ModelAttribute Event newEvent) {
        EventData.add(newEvent);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title","Delete Events");
        model.addAttribute("events",EventData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventForm(@RequestParam(required = false) int[] eventIds){
        if (eventIds !=null) {
            for (int id : eventIds){
                EventData.remove(id);
            }
        }
=======
    public String processCreateEventForm(@RequestParam String eventName, @RequestParam String eventDescription) {
        events.add(new Event(eventName,eventDescription));
>>>>>>> Stashed changes
        return "redirect:";
    }

    @GetMapping("edit")
    public String displayEditForm(Model model, @PathVariable int eventId) {
        // controller code will go here
        model.addAttribute("title","Edit Events");
        model.addAttribute("Edit Event ${event.name} (id=${id})",EventData.getById(eventId));
        return "events/edit/{eventId}";
    }

    @PostMapping("edit")
    public String processEditForm(int eventId, String name, String description) {
        // controller code will go here

        return "redirect:";
    }
}
