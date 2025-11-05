package com.PhamKornbluhGroup.jsonParsing;

import com.PhamKornbluhGroup.DTO.CrucibleDTO;
import com.PhamKornbluhGroup.DTO.CrucibleNodeDTO;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class CrucibleDTODeserializer extends StdDeserializer<CrucibleDTO> {

    public CrucibleDTODeserializer() {
        super(CrucibleDTO.class);
    }

    @Override
    public CrucibleDTO deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        ObjectMapper mapper = (ObjectMapper) parser.getCodec();
        JsonNode root = mapper.readTree(parser);


        //p This will hold all nodes
        ArrayList<CrucibleNodeDTO> nodesList = new ArrayList<>();

        //p Iterate through all nodes 1 at a time
        JsonNode nodes = root.get("nodes");
        Iterator<Map.Entry<String, JsonNode>> nodesIterator = nodes.fields();
        while (nodesIterator.hasNext()) {
            Map.Entry<String, JsonNode> entry = nodesIterator.next();

            //p Convert the node value (dictionary) to CrucibleNodeDTO
            CrucibleNodeDTO node = mapper.treeToValue(entry.getValue(), CrucibleNodeDTO.class);

            //p Store the node key as crucibleNodeIndex per documentation
            node.setCrucibleNodeIndex(entry.getKey());

            //p Add to nodeList
            nodesList.add(node);
        }

        //p Set values and return
        CrucibleDTO crucible = new CrucibleDTO();
        crucible.setLayout(root.get("layout").asText());
        crucible.setNodes(nodesList);
        return crucible;
    }
}
