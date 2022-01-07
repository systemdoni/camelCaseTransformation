package com.donald.transformation.service.impl;

import com.donald.transformation.model.SnakeCaseItems;
import com.donald.transformation.model.CamelCaseItems;
import com.donald.transformation.service.TransformationService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
public class TransformationServiceImpl implements TransformationService {

    @Override
    public void validateLettersOnly(SnakeCaseItems snakeCaseItems) {
        for (String item : snakeCaseItems.getItems())
            if(!item.matches("[a-zA-Z_]+"))
                throw new IllegalArgumentException("Items should contain only letters and underscore");
    }

    @Override
    public SnakeCaseItems eliminateDuplicateItems(SnakeCaseItems snakeCaseItems) {
        // I used a set for this solution, but this can also be solved with a linear search
        // where we check for each item, if it has other instances in the rest of the list and remove them.
        Set<String> nonDuplicateItems = new LinkedHashSet<>(snakeCaseItems.getItems());
        snakeCaseItems.getItems().clear();
        snakeCaseItems.getItems().addAll(nonDuplicateItems);
        return snakeCaseItems;
    }

    @Override
    public CamelCaseItems transformItems(SnakeCaseItems snakeCaseItems) {
        List<String> items = snakeCaseItems.getItems();
        List<String> transformedItems = new LinkedList<>();
        for (String item : items) {
            if (item.contains("_")) {
                StringBuilder transformedItem = new StringBuilder();

                char[] itemChars = item.toCharArray();

                for (int i = 0; i < itemChars.length; i++) {
                    if (itemChars[i] == '_' && i + 1 < itemChars.length) {
                        i++;
                        transformedItem.append(Character.toUpperCase(itemChars[i]));
                    } else
                        transformedItem.append(itemChars[i]);
                }

                transformedItems.add(transformedItem.toString());
            } else {
                transformedItems.add(item);
            }

        }

        return mapSnakeCaseToCamelCaseItem(snakeCaseItems,transformedItems);
    }

    private CamelCaseItems mapSnakeCaseToCamelCaseItem(SnakeCaseItems snakeCaseItems, List<String> transformedItems){
        CamelCaseItems camelCaseItems = new CamelCaseItems();
        camelCaseItems.setName(snakeCaseItems.getName());
        camelCaseItems.setItems(transformedItems);
        camelCaseItems.setTimestamp(System.currentTimeMillis());
        return camelCaseItems;
    }
}
