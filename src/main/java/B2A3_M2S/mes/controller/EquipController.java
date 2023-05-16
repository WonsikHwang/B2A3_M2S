package B2A3_M2S.mes.controller;

import B2A3_M2S.mes.repository.EquipRepository;
import B2A3_M2S.mes.service.EquipService;
import B2A3_M2S.mes.dto.EquipDto;
import B2A3_M2S.mes.entity.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EquipController {
    @Autowired
    EquipRepository equipRepository;

    @Autowired
    EquipService equipService;


    @GetMapping(value = "/equipment")
    public String equipment(Model model) {
        List<Equipment> equipmentList = equipRepository.findAll();
        List<EquipDto> equipDtoList = EquipDto.of(equipmentList);


        /**
         Equipment -> equipDto로 변환 성공
         Dto에 Setter, Getter를 반드시 넣어야함
          **/
//        Equipment equipment = equipRepository.findByEquipCd("A1");
//        EquipDto equipDto = EquipDto.of(equipment);

        model.addAttribute("equipList", equipDtoList);
        return "equipPage";
    }

    @GetMapping(value = "/equipment/search")
    public String searchKeyword(@RequestParam String equipNm, @RequestParam String equipState, Model model) {
        List<Equipment> equipmentList = equipService.findEquipList(equipNm, equipState);
        List<EquipDto> equipDtoList = EquipDto.of(equipmentList);
        // 조회 페이지의 attributeName과 동일한 값으로 넣어 조회
        model.addAttribute("equipList", equipDtoList);

        return "equipPage";
    }
}