package B2A3_M2S.mes.repository;

import B2A3_M2S.mes.dto.BOMDTO;
import B2A3_M2S.mes.entity.BOM;
import B2A3_M2S.mes.entity.Item;
import B2A3_M2S.mes.entity.QBOM;
import B2A3_M2S.mes.service.BOMService;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
public class BOMRepositoryTests {

    @Autowired
    BOMRepository bomRepository;

    @Autowired
    BOMService service;

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void test(){
        System.out.println(bomRepository.getClass().getName());

    }

    @Test
    public void testInsertDummies(){

        Item material = new Item();
        material.setItemCd("양배추");

        Item item = new Item();
        item.setItemCd("양배추 추출액");

        BOM bom = BOM.builder()

                .consumption(625L)
                .mItem(material)
                .pItem(item)
                    .build();

        itemRepository.save(material);
        itemRepository.save(item);
        bomRepository.save(bom);


        List<BOMDTO> allBOMs  = service.selectAllBOM();

//        for (BOMDTO bom : allBOMs) {
//            System.out.println("BOM ID: " + bom.getBomNo());
//            System.out.println("Consumption: " + bom.getConsumption());
//            System.out.println("Material: " + bom.getMaterialCd());
//            System.out.println("Product: " + bom.getProductCd());
//            System.out.println("-------------------------");
//        }

    }

    @Test
    public void testInsertDummies1(){

        QBOM qbom = QBOM.bOM;

        double cus = 60;

        BooleanBuilder builder = new BooleanBuilder();


        /*if(null != cus){
            builder.and(qbom.consumption.eq(cus));
        }*/

        Iterable<BOM> allBOMs = bomRepository.findAll(builder);



        for (BOM bom : allBOMs) {
            System.out.println("BOM ID: " + bom.getBomNo());
            System.out.println("Consumption: " + bom.getConsumption());
            System.out.println("Material: " + bom.getMItem().getItemCd());
            System.out.println("Product: " + bom.getPItem().getItemCd());
            System.out.println("-------------------------");
        }

    }
}
