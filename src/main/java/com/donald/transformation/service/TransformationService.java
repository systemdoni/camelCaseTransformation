package com.donald.transformation.service;

import com.donald.transformation.model.SnakeCaseItems;
import com.donald.transformation.model.CamelCaseItems;

public interface TransformationService {

    /**
     *
     * Checks if items contain letters only, otherwise throws IllegalArgumentException
     *
     * @param snakeCaseItems The model that contains the list of items to be checked
     * @throws IllegalArgumentException if there are items that contain more than letters
     */
    void validateLettersOnly(SnakeCaseItems snakeCaseItems) throws IllegalArgumentException;

    SnakeCaseItems eliminateDuplicateItems(SnakeCaseItems snakeCaseItems);

    /**
     *
     * Transforms the items by changing them from snake_case to camelCase
     *
     * @param snakeCaseItems The model that contains the list of items
     * @return CamelCaseItems model that contains the transformed items
     */
    CamelCaseItems transformItems(SnakeCaseItems snakeCaseItems);

}
