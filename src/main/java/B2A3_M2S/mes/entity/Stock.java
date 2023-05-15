package B2A3_M2S.mes.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity(name = "stock")
@Table(name = "stock")
public class Stock extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockNo;   //재고 번호

    private String lotNo;

    private String location;    //위치

    private Long qty;   //수량

    private String remark;  //비고


    //외래키

    @ManyToOne
    @JoinColumn(name = "item_cd")
    private Item item;

}