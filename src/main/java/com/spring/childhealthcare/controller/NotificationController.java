package com.spring.childhealthcare.controller;

import com.spring.childhealthcare.common.CommonResponse;
import com.spring.childhealthcare.dto.NotificationDTO;
import com.spring.childhealthcare.service.NotificationService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/health/notification")
@Slf4j
public class NotificationController {
    private final NotificationService notificationService;

    /**
     * Get all notification
     *
     * @return success or fail response of notification creation
     */
    @GetMapping("")
    public ResponseEntity<CommonResponse> getAllNotificationDetails() {
        CommonResponse commonResponse = notificationService.getAllNotificationDetails();
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Get medicine by notification id
     *
     * @param notificationId - required data for get notification by notification id
     * @return success or fail response of get notification by notification id
     */
    @GetMapping("/{notificationId}")
    public ResponseEntity<CommonResponse> getNotificationDetailsByNotificationId(@PathVariable("notificationId") @NotNull Long notificationId) {
        CommonResponse commonResponse = notificationService.getNotificationDetailsByNotificationId(notificationId);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Create notification
     *
     * @param notificationDTO - required data for notification save
     * @return success or fail response of notification save
     */
    @PostMapping("")
    public ResponseEntity<CommonResponse> saveNotification(@Valid @RequestBody NotificationDTO notificationDTO) {
        CommonResponse commonResponse = notificationService.saveNotification(notificationDTO);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Update notification
     *
     * @param notificationDTO - required data for notification update
     * @return success or fail response of notification update
     */
    @PutMapping("")
    public ResponseEntity<CommonResponse> updateNotification(@Valid @RequestBody NotificationDTO notificationDTO) {
        CommonResponse commonResponse = notificationService.updateNotification(notificationDTO);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Delete notification by notification id
     *
     * @param notificationId - required data for delete notification by notification id
     * @return success or fail response of delete notification by notification id
     */
    @DeleteMapping("/{notificationId}")
    public ResponseEntity<CommonResponse> deleteNotificationDetailsByNotificationId(@PathVariable("notificationId") @NotNull Long notificationId) {
        CommonResponse commonResponse = notificationService.deleteNotificationDetailsByNotificationId(notificationId);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }
}
