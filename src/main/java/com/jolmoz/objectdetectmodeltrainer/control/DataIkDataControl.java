package com.jolmoz.objectdetectmodeltrainer.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jolmoz.objectdetectmodeltrainer.dtos.DataSetDTO;
import com.jolmoz.objectdetectmodeltrainer.dtos.ModelDTO;
import com.jolmoz.objectdetectmodeltrainer.dtos.UserAccessDTO;
import com.jolmoz.objectdetectmodeltrainer.model.DataSet;
import com.jolmoz.objectdetectmodeltrainer.model.Model;
import com.jolmoz.objectdetectmodeltrainer.utils.RestTemplateClient;

@Service
public class DataIkDataControl {
    @Value("${external.user.info.url}")
    String url;

    public ResponseEntity<List<UserAccessDTO>> getAllUsers(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("token", token);
        ParameterizedTypeReference<List<UserAccessDTO>> responseType = new ParameterizedTypeReference<List<UserAccessDTO>>() {
        };

        return RestTemplateClient.consumeRestService(url, headers, "GET", responseType, null);
    }

    public ResponseEntity<List<ModelDTO>> getModelDTOsWithUsers(String token, List<Model> models) {
        List<ModelDTO> modelDTOs = new ArrayList<>();
        ResponseEntity<List<UserAccessDTO>> userAccessDTOsResponse = getAllUsers(token);

        if (!userAccessDTOsResponse.getStatusCode().equals(HttpStatus.OK)) {
            return new ResponseEntity<List<ModelDTO>>(userAccessDTOsResponse.getStatusCode());
        }

        List<UserAccessDTO> userAccessDTOs = userAccessDTOsResponse.getBody();

        for (Model model : models) {
            ModelDTO modelDTO = new ModelDTO(model);
            UserAccessDTO userCreator = getUserAccessDTOById(userAccessDTOs, model.getUserAccessCreatorId());
            UserAccessDTO userModifier = getUserAccessDTOById(userAccessDTOs, model.getUserAccessLastEditorId());
            modelDTO.setUserAccessCreator(userCreator);
            modelDTO.setUserAccessLastEditor(userModifier);

            modelDTOs.add(modelDTO);
        }

        return new ResponseEntity<List<ModelDTO>>(modelDTOs, userAccessDTOsResponse.getStatusCode());
    }

    public ResponseEntity<List<DataSetDTO>> getDataSetDTOsWithUsers(String token, List<DataSet> dataSets) {
        List<DataSetDTO> dataSetDTOs = new ArrayList<>();
        ResponseEntity<List<UserAccessDTO>> userAccessDTOsResponse = getAllUsers(token);

        if (!userAccessDTOsResponse.getStatusCode().equals(HttpStatus.OK)) {
            return new ResponseEntity<List<DataSetDTO>>(userAccessDTOsResponse.getStatusCode());
        }

        List<UserAccessDTO> userAccessDTOs = userAccessDTOsResponse.getBody();

        for (DataSet dataSet : dataSets) {
            DataSetDTO dataSetDTO = new DataSetDTO(dataSet);
            UserAccessDTO userCreator = getUserAccessDTOById(userAccessDTOs, dataSet.getUserAccessCreatorId());
            UserAccessDTO userModifier = getUserAccessDTOById(userAccessDTOs, dataSet.getUserAccessLastEditorId());
            dataSetDTO.setUserAccessCreator(userCreator);
            dataSetDTO.setUserAccessLastEditor(userModifier);

            dataSetDTOs.add(dataSetDTO);
        }

        return new ResponseEntity<List<DataSetDTO>>(dataSetDTOs, userAccessDTOsResponse.getStatusCode());
    }

    public UserAccessDTO getUserAccessDTOById(List<UserAccessDTO> userAccessDTOs, long id) {
        Optional<UserAccessDTO> objetoEncontrado = userAccessDTOs.stream()
                .filter(objeto -> objeto.getId() == id)
                .findFirst();
        if (objetoEncontrado.isPresent()) {
            return objetoEncontrado.get();
        } else {
            return null;
        }
    }
}
