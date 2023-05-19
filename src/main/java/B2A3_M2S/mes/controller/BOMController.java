package B2A3_M2S.mes.controller;

import B2A3_M2S.mes.dto.BOMDTO;
import B2A3_M2S.mes.dto.ItemDto;
import B2A3_M2S.mes.service.BOMService;
import B2A3_M2S.mes.service.ItemService;
import com.google.gson.Gson;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/bom")
public class BOMController {

    @Autowired
    BOMService service;

    @Autowired
    ItemService itemService;
    private Object predicate;


    @GetMapping("/main")
    public String home(){

        return "main";
    }

//    @GetMapping("/test")
//    public String test(Model model){
//        List<BOMDTO> BOM = service.selectAllBOM();
//        model.addAttribute( "BOM" ,  BOM) ;
//        System.out.println(BOM);
//
//        return "BOM";
//    }


    @GetMapping("/test")
    /*public String test1(Model model
                    , @RequestParam("product")String product
                    , @RequestParam("material")String material
                    , @RequestParam("startRegDate")String startRegDate
                    , @RequestParam("endRegDate")String endRegDate){
        List<BOMDTO> BOM = service.selectAllBOM(product, material , endRegDate , startRegDate);*/
    public String test1(Model model, BOMDTO dto){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+dto);
        List<BOMDTO> BOM = service.selectAllBOM(dto);
        model.addAttribute( "BOM" ,  BOM) ;
        System.out.println(BOM);

        return "BOM";
    }

    @GetMapping("/ItemAutoComplete")
    @ResponseBody
    public String ItemAutoComplete(String text){
        Gson gson = new Gson();
        String itemList =  gson.toJson(itemService.getItemList(text));

        return itemList;
    }

}