package io.munkush.app;

import io.munkush.app.Room;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    private List<Room> roomList = new ArrayList<>();

    {
                roomList.add(new Room(1, true, "1 500 000 swm"));
                roomList.add(new Room(2, true, "1 500 000 swm"));
                roomList.add(new Room(3, true, "1 500 000 swm"));
                roomList.add(new Room(4, true, "1 500 000 swm"));
                roomList.add(new Room(5, true, "1 500 000 swm"));
                roomList.add(new Room(6, true, "1 500 000 swm"));
    }


    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/rooms")
    public String rooms(Model model){
        return getRoomModels(model);
    }

    @GetMapping("/foods")
    public String foods(){
        return "foods";
    }
    @GetMapping("/fitness")
    public String fitness(){
        return "fitness";
    }
    @GetMapping("/roomAct")
    public String roomAct(@RequestParam("roomId") int id, Model model){
        Room room = new Room(id, false, "1 500 000 swm");
        roomList.set(id-1, room);
        model.addAttribute("roomText", String.format("Siz №%s xanani bántledińiz",id));
        return "success";
    }

    @GetMapping("/roomActBreak")
    public String roomActBreak(@RequestParam("roomId") int id, Model model){
        Room room = new Room(id, true, "1 500 000 swm");
        roomList.set(id-1, room);
        return getRoomModels(model);
    }


    private String getRoomModels(Model model) {
        model.addAttribute("room1", roomList.get(0));
        model.addAttribute("room2", roomList.get(1));
        model.addAttribute("room3", roomList.get(2));
        model.addAttribute("room4", roomList.get(3));
        model.addAttribute("room5", roomList.get(4));
        model.addAttribute("room6", roomList.get(5));
        return "rooms";
    }

}
