package com.a3_2.Controller;


import com.sun.istack.internal.Nullable;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static start.ClientStart.closeConection;
import static start.ClientStart.makeConnection;
import static start.ClientStart.sendMessage;


@RestController
public class DVDController {

    public DVDController() {
       // System.out.println("?>>?HFHF>FH?F?FH?F?HF?HFH?FH?FH?FH?FH?FH?FHF?H???::&*(:&*(:&*(&*(:*&");
    }

//    @RequestMapping("hello")
//    public String home(){
//        return "templates/hello";
//   }

//    @RequestMapping("/")
//    public String home(/*HttpServletRequest request*/){
//        System.out.println("-----------------------------------------");
//        return "templates/index";
//    }
//    @RequestMapping(value = "/index", method = RequestMethod.GET)
//    public String mainPage2(ModelMap modelMap){
//        modelMap.addAttribute("message", "Hello Spring MVC Framework!");
//        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
//        return "templates/index";
//    }

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
//        ModelAndView mav = new ModelAndView("templates/index.html");
//        //mav.addObject("login", new Login());
//        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
//        return mav;
//    }






    @PostMapping(value = "index")
    public  /*ModelAndView*/ void addDVD(@RequestParam(name ="title"/*,required=false*/) String title,
                        @RequestParam(name ="year"/*,required=false*/) String year,
                        @RequestParam(name = "price"/*,required=false*/)String price) throws Exception {


        //DigitalVideoDisc dvd  = new DigitalVideoDisc(title, year,price);
        //DigitalVideoDisc dvd2  = new DigitalVideoDisc("second", 2014,7.7);
        String messageToSend = "";
         messageToSend = "?" + title + "#" + year + "#" + price;
       // messageToSend = "?" + "title" + "#" + "1008" + "#" + "22";
        //String messageToSend2 = "?" + dvd2.getTitle() + "#" + dvd2.getYear() + "#" + dvd2.getPrice();
        //ModelAndView mav = null;
        //mav = new ModelAndView("static/index");
       // ClientStart producer = new ClientStart();
        //producer.mainFc();
        //ClientStartC consummer = new ClientStartC();
        if(messageToSend.equals("")){
            System.out.println("NUUUUUUUUUUL");
            messageToSend = "aa";
        }
        System.out.println("DDDDDDDDDD  " + messageToSend);

        makeConnection();
        sendMessage(messageToSend);
        closeConection();

       // mav.addObject("listOfFlights", flightServiceI.listFlight());
       // return mav;


       // ModelAndView mav = new ModelAndView("templates/index.html");

//return  mav;

    }
}
