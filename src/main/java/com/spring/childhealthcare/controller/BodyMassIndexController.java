package com.spring.childhealthcare.controller;

import com.spring.childhealthcare.common.CommonResponse;
import com.spring.childhealthcare.dto.BodyMassIndexDTO;
import com.spring.childhealthcare.service.BodyMassIndexService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/health/bodyMassIndex")
@Slf4j
public class BodyMassIndexController {
    private BodyMassIndexService bodyMassIndexService;

    /**
     * Get all bodyMassIndex
     *
     * @return success or fail response of bodyMassIndex creation
     */
    @GetMapping("")
    public ResponseEntity<CommonResponse> getAllBodyMassIndexDetails() {
        CommonResponse commonResponse = bodyMassIndexService.getAllBodyMassIndexDetails();
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Get bodyMassIndex by id
     *
     * @param bodyMassIndexId - required data for get bodyMassIndex by id
     * @return success or fail response of get bodyMassIndex by id
     */
    @GetMapping("/{bodyMassIndexId}")
    public ResponseEntity<CommonResponse> getBodyMassIndexDetailsById(@PathVariable("bodyMassIndexId") @NotNull Long bodyMassIndexId) {
        CommonResponse commonResponse = bodyMassIndexService.getBodyMassIndexDetailsById(bodyMassIndexId);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Create bodyMassIndex
     *
     * @param bodyMassIndexDTO - required data for bodyMassIndex save
     * @return success or fail response of bodyMassIndex save
     */
    @PostMapping("")
    public ResponseEntity<CommonResponse> saveBodyMassIndex(@Valid @RequestBody BodyMassIndexDTO bodyMassIndexDTO) {
        CommonResponse commonResponse = bodyMassIndexService.saveBodyMassIndex(bodyMassIndexDTO);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Update bodyMassIndex
     *
     * @param bodyMassIndexDTO - required data for bodyMassIndex update
     * @return success or fail response of bodyMassIndex update
     */
    @PutMapping("")
    public ResponseEntity<CommonResponse> updateBodyMassIndex(@Valid @RequestBody BodyMassIndexDTO bodyMassIndexDTO) {
        CommonResponse commonResponse = bodyMassIndexService.updateBodyMassIndex(bodyMassIndexDTO);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Delete bodyMassIndex by id
     *
     * @param bodyMassIndexId - required data for delete bodyMassIndex by id
     * @return success or fail response of delete bodyMassIndex by id
     */
    @DeleteMapping("/{bodyMassIndexId}")
    public ResponseEntity<CommonResponse> deleteBodyMassIndexDetailsById(@PathVariable("bodyMassIndexId") @NotNull Long bodyMassIndexId) {
        CommonResponse commonResponse = bodyMassIndexService.deleteBodyMassIndexDetailsById(bodyMassIndexId);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }
    
}
