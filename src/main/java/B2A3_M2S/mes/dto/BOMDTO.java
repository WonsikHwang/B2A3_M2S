package B2A3_M2S.mes.dto;

import B2A3_M2S.mes.entity.Item;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BOMDTO {
    private Long bomNo;         // BOM 번호
    private String remark;      // 비고


    private Double consumption;   //소모량



    private Character useYn;    //사용유무



    private Item productCd;     //제품 코드


    private Item materialCd;    //자재 코드

    private LocalDateTime regdate;

    private LocalDateTime moddate;
}