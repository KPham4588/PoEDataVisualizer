package com.PhamKornbluhGroup.jsonParsing;

import com.PhamKornbluhGroup.DTO.RewardsCollectionDTO;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.*;

//TODO: Not 100% sure this works. Its existence definitely prevents exceptions, but it might be producing empty data
public class RewardsCollectionDeserializer extends JsonDeserializer<List<RewardsCollectionDTO>> {

    private final static Logger rewardsCollectionDeserializerLogger = LogManager.getLogger(RewardsCollectionDeserializer.class);

    @Override
    public List<RewardsCollectionDTO> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String lastKey = "";
        JsonNode lastValueAsNode;
        int lastValue = 0;


        ObjectMapper mapper = (ObjectMapper) p.getCodec();
        JsonNode node = mapper.readTree(p);

        lastValueAsNode = node;

        List<RewardsCollectionDTO> list = new ArrayList<>();

        if (node.isArray()) {
            rewardsCollectionDeserializerLogger.error("node is an array");
            for (JsonNode child : node) {
                Set<Map.Entry<String, JsonNode>> setOfRewardTypeAndAmount = child.properties();
                for (Map.Entry<String, JsonNode> nextReward : setOfRewardTypeAndAmount) {
                    RewardsCollectionDTO dto = new RewardsCollectionDTO();

                    String key = nextReward.getKey();
                    JsonNode valueAsNode = nextReward.getValue();

                    //b Attempt #1 -- See if Get(key) works
                    int value = valueAsNode.get(key).asInt();

                    //b Attempt #2 -- See if asInt works
//                    int value = valueAsNode.asInt();

                    //b Attempt #3 -- See if get(0) works
//                    int value = valueAsNode.get(0).asInt();

                    dto.setRewardsType(key);
                    dto.setRewardsAmount(value);
                    list.add(dto);



                    rewardsCollectionDeserializerLogger.error("Key = " + key);
                    rewardsCollectionDeserializerLogger.error("valueAsNode = " + valueAsNode);
                    rewardsCollectionDeserializerLogger.error("value = " + value);
                    lastKey = key;
                    lastValueAsNode = valueAsNode;
                    lastValue = value;

                }
            }
        }
        else if (node.isObject()) {
            rewardsCollectionDeserializerLogger.error("node is an object");
            for (JsonNode child : node) {
                Set<Map.Entry<String, JsonNode>> setOfRewardTypeAndAmount = child.properties();
                for (Map.Entry<String, JsonNode> nextReward : setOfRewardTypeAndAmount) {
                    RewardsCollectionDTO dto = new RewardsCollectionDTO();

                    String key = nextReward.getKey();
                    JsonNode valueAsNode = nextReward.getValue();

                    //b Attempt #1 -- See if Get(key) works
                    int value = valueAsNode.get(key).asInt();

                    //b Attempt #2 -- See if asInt works
//                    int value = valueAsNode.asInt();

                    //b Attempt #3 -- See if get(0) works
//                    int value = valueAsNode.get(0).asInt();

                    dto.setRewardsType(key);
                    dto.setRewardsAmount(value);
                    list.add(dto);

                    rewardsCollectionDeserializerLogger.error("Key = " + key);
                    rewardsCollectionDeserializerLogger.error("valueAsNode = " + valueAsNode);
                    rewardsCollectionDeserializerLogger.error("value = " + value);

                    lastKey = key;
                    lastValueAsNode = valueAsNode;
                    lastValue = value;
                }
            }
        }

        rewardsCollectionDeserializerLogger.error("we're at the end now");
        rewardsCollectionDeserializerLogger.error("Key = " + lastKey);
        rewardsCollectionDeserializerLogger.error("valueAsNode = " + lastValueAsNode);
        rewardsCollectionDeserializerLogger.error("value = " + lastValue);
        return list;
    }

}




