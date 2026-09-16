package com.PhamKornbluhGroup.jsonParsing;

import com.PhamKornbluhGroup.DTO.RewardsCollectionDTO;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.ValueDeserializer;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

//TODO: Not 100% sure this works. Its existence definitely prevents exceptions, but it might be producing empty data
public class RewardsCollectionDeserializer extends ValueDeserializer<List<RewardsCollectionDTO>> {

    private final static Logger rewardsCollectionDeserializerLogger = LogManager.getLogger(RewardsCollectionDeserializer.class);

    @Override
    public List<RewardsCollectionDTO> deserialize(JsonParser p, DeserializationContext ctxt) {
        rewardsCollectionDeserializerLogger.error("Beginning RewardsCollectionDeserializer deserialize method");

        ObjectMapper mapper = (ObjectMapper) p.objectReadContext();
        JsonNode node = mapper.readTree(p);

        String lastKey = "";
        int lastValue = 0;


        List<RewardsCollectionDTO> list = new ArrayList<>();

        if (node.isArray()) {
            String errorMessage = "rewardsCollection should never be an Array. node is " + node.toPrettyString();
            rewardsCollectionDeserializerLogger.error(errorMessage);
        }
        else if (node.isObject()) {
            rewardsCollectionDeserializerLogger.error("node is an object");

            Set<Map.Entry<String, JsonNode>> setOfRewardTypeAndAmount = node.properties();
            for (Map.Entry<String, JsonNode> nextReward : setOfRewardTypeAndAmount) {
                RewardsCollectionDTO dto = new RewardsCollectionDTO();

                String key = nextReward.getKey();
                int value = nextReward.getValue().asInt();

                dto.setRewardsType(key);
                dto.setRewardsAmount(value);
                list.add(dto);

                String keyAndValue = "Key = " + key + " and value = " + value;

                rewardsCollectionDeserializerLogger.error(keyAndValue);

                lastKey = key;
                lastValue = value;
            }
        }

        String endingLog = "we're at the end now; key = " + lastKey + " and value = " + lastValue;

        rewardsCollectionDeserializerLogger.error(endingLog);
        return list;
    }

}




