package lk.ijse.gdse.greenshadowbackend.controller;

import lk.ijse.gdse68.greenshadowbackend.customerObj.CropErrorResponse;
import lk.ijse.gdse68.greenshadowbackend.customerObj.CropResponse;
import lk.ijse.gdse68.greenshadowbackend.dto.CropDTO;
import lk.ijse.gdse68.greenshadowbackend.exception.CropNotFoundException;
import lk.ijse.gdse68.greenshadowbackend.exception.DataPersistFailedException;
import lk.ijse.gdse68.greenshadowbackend.service.CropService;
import lk.ijse.gdse68.greenshadowbackend.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:63342")
@RestController
@RequestMapping("api/v1/crop") //rest full ekk -end point ek
@RequiredArgsConstructor
public class CropController {
    @Autowired
    private final CropService cropService;

    Logger logger = LoggerFactory.getLogger(CropController.class);
    //TODO: CRUD Implement
    //TODO:SAVE
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> saveCrop(
            @RequestPart("cropCode") String cropCode,
            @RequestPart("cropCommonName") String cropCommonName,
            @RequestPart("cropScientificName") String cropScientificName,
            @RequestPart("cropImage") MultipartFile cropImage,
            @RequestPart("category") String category,
            @RequestPart("cropSeason") String cropSeason,
            @RequestPart("fieldCode") String fieldCode ){
        try {
            String[] base64Images = AppUtil.toBase64Images(cropImage);
            CropDTO cropDTO = new CropDTO();
            cropDTO.setCropCode(cropCode);
            cropDTO.setCropCommonName(cropCommonName);
            cropDTO.setCropScientificName(cropScientificName);
            cropDTO.setCropImage(cropImage);
            cropDTO.setCategory(category);
            cropDTO.setCropSeason(cropSeason);
            cropDTO.setFieldCode(fieldCode);
            cropService.saveCrop(cropDTO);
            logger.info("Crop Details Save Successfully!!");
            return new ResponseEntity<>("Crop Details Save Successfully!!",HttpStatus.OK);
        }catch (DataPersistFailedException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //TODO:Update
    @PatchMapping(value = "/{cropCode}")
    public ResponseEntity<String> updateField(
            @RequestPart("updateCropCommonName") String updateCropCommonName,
            @RequestPart("updateCropScientificName") String updateCropScientificName,
            @RequestPart("updateCropImage") MultipartFile updateCropImage,
            @RequestPart("updateCategory") String updateCategory,
            @RequestPart("updateCropSeason") String updateCropSeason,
            @RequestPart("updateFieldCode") String updateFieldCode,
            @RequestPart("cropCode") String cropCode){
        try {
            String[] base64Images = AppUtil.toBase64Images(updateCropImage);
            CropDTO cropDTO = new CropDTO();
            cropDTO.setCropCode(cropCode);
            cropDTO.setCropCommonName(updateCropCommonName);
            cropDTO.setCropScientificName(updateCropScientificName);
            cropDTO.setCropImage(updateCropImage);
            cropDTO.setCategory(updateCategory);
            cropDTO.setCropSeason(updateCropSeason);
            cropDTO.setFieldCode(updateFieldCode);
            cropService.updateCrop(cropCode,cropDTO);
            logger.info("Crop details Update Successfully!!");
            return new ResponseEntity<>("Crop Details Update Successfully!!",HttpStatus.OK);

        } catch ( ClassNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //TODO:Delete
    @DeleteMapping(value = "/{cropCode}")
    public ResponseEntity<String> deleteCrop(@PathVariable ("cropCode") String cropCode){
        try {
            cropService.deleteCrop(cropCode);
            logger.info("Crop details Delete Successfully!!");
            return new ResponseEntity<>("Crop Details Delete Successfully!!",HttpStatus.OK);
        }catch (CropNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>("Crop not found!!",HttpStatus.NOT_FOUND);
        }
    }

    //TODO:Select id
    @GetMapping(value = "/{cropCode}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CropResponse> getSelectedCrop(@PathVariable ("cropCode") String cropCode){
        CropResponse cropResponse = cropService.getSelectedCrop(cropCode);
        if (cropResponse instanceof CropDTO){
            return new ResponseEntity<>(cropResponse,HttpStatus.OK);
        }else if (cropResponse instanceof CropErrorResponse){
            return new ResponseEntity<>(cropResponse,HttpStatus.NOT_FOUND);
        }
        logger.error("Error fetching crop: ");
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //TODO:GetAll
    @GetMapping
    public ResponseEntity<List<CropDTO>> getAllCrop(){
        List<CropDTO> cropDTOS = cropService.getAllCrop();
        if (!cropDTOS.isEmpty()){
            return new ResponseEntity<>(cropDTOS,HttpStatus.OK);
        }else {
            logger.error("Get All crop!!");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    //TODO: Search name
    @GetMapping("/search")
    public ResponseEntity<List<CropResponse>> searchCropByCropCommonName(@RequestParam String cropCommonName ){
        List<CropResponse> cropResponses = cropService.getCropByCropCommonName(cropCommonName);
        if (cropResponses.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ArrayList<>());
        }
        return ResponseEntity.ok(cropResponses);
    }
}
