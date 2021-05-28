package nl.bioinf.wekainterface.webcontrol;


import nl.bioinf.wekainterface.model.AlgortihmsInformation;
import nl.bioinf.wekainterface.service.SerializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Bart Engels
 */

@Controller
public class HistoryController {

    @Autowired
    private SerializationService serializationService;

    @GetMapping(value = "/history")
    public String getHistoryPage(Model model){
        String[] strings = {"9","0"};
        ArrayList<Object> algorithmsInformation = new ArrayList<>();
        algorithmsInformation.add(new AlgortihmsInformation("OneR" , strings));
        algorithmsInformation.add(new AlgortihmsInformation("ZeroR" , strings));
        serializationService.serialization(algorithmsInformation);
        model.addAttribute("info" , serializationService.deserialization());

        return "hisotrydummypage";
    }
    }
