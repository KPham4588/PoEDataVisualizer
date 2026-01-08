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
        rewardsCollectionDeserializerLogger.error("Beginnning RewardsCollectionDeserializer deserialize method");

        ObjectMapper mapper = (ObjectMapper) p.getCodec();
        JsonNode node = mapper.readTree(p);

        String lastKey = "";
        int lastValue = 0;


        List<RewardsCollectionDTO> list = new ArrayList<>();

        if (node.isArray()) {
            rewardsCollectionDeserializerLogger.error("node is an array");
            throw new IOException("rewardsCollection should never be an Array. node is " + node.toPrettyString());
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

                rewardsCollectionDeserializerLogger.error("Key = " + key);
                rewardsCollectionDeserializerLogger.error("value = " + value);

                lastKey = key;
                lastValue = value;
            }
        }

        rewardsCollectionDeserializerLogger.error("we're at the end now");
        rewardsCollectionDeserializerLogger.error("Key = " + lastKey);
        rewardsCollectionDeserializerLogger.error("value = " + lastValue);
        return list;
    }

}




