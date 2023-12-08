package bridge.bms32back.business.bridges.dto;

import lombok.Data;

@Data
public class BridgeSearchDto {

    private String bridgeName;
    private Integer bridgeNumber;
    private Integer bridgeTypeId;
    private Integer countyId;
    private Integer materialTypeId;
    private Integer bridgeLengthStart;
    private Integer bridgeLengthEnd;
    private Integer bridgeWidthStart;
    private Integer bridgeWidthEnd;
    private Integer conditionIndexStart;
    private Integer conditionIndexEnd;
}
